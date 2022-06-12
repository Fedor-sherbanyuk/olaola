package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.repository.RepositoryMeal;
import ru.javawebinar.topjava.service.ServiceMealTo;
import ru.javawebinar.topjava.util.MealClassData;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet{

        private static final Logger log = getLogger(MealServlet.class);

//        @Override
//        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            log.debug("redirect to meals");
//            MealClassData mealClassData = new MealClassData();
//            List<MealTo> mealTolist = MealsUtil.filteredByHtml(mealClassData.getMeals(), mealClassData.getCalories());
//    HttpSession httpSession = request.getSession();
//            httpSession.setAttribute("mealsTo", mealTolist);
//            mealTolist.forEach(System.out::println);
//
//            response.sendRedirect("meals.jsp");
//
//        }

//public class MealServlet extends HttpServlet {
//    private static final Logger log = LoggerFactory.getLogger(MealServlet.class);

    private RepositoryMeal repository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        repository = new ServiceMealTo();
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");

        Meal meal = new Meal(id.isEmpty() ? null : Integer.valueOf(id),
                LocalDateTime.parse(request.getParameter("dateTime")),
                request.getParameter("description"),
                Integer.parseInt(request.getParameter("calories")));

        log.info(meal.isNew() ? "Create {}" : "Update {}", meal);
        repository.addMealTo(meal);
        response.sendRedirect("meals");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String action = request.getParameter("action");
        MealClassData mealClassData = new MealClassData();
        if (action==null){
     request.setAttribute("mealsTo", MealsUtil.filteredByHtml(mealClassData.getMeals(), mealClassData.getCalories()));
     request.getRequestDispatcher("meals.jsp").forward(request,response);
        }
        else if (action.equals("delete")){
            int id = getId(request);

            try {
                repository.delete(id);
                response.sendRedirect("meals");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        }else {

            final Meal meal=action.equals("create")?new Meal(LocalDateTime.now(),"",1000):
                    repository.updateMealTo(getId(request));
            request.setAttribute("meal",meal);
            request.getRequestDispatcher("mealEdit.jsp").forward(request,response);

       }

    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }
}
