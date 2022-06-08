package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.repository.RepositoryMeal;
import ru.javawebinar.topjava.service.ServiceMealTo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MealServletNew extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(MealServletNew.class);
    private final RepositoryMeal repositoryMealTo = new ServiceMealTo();
    private static String INSERT_OR_EDIT = "/mealTo.jsp";
    private static String LIST_MEALTO = "/listMealTo.jsp";


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String forward = "";
            String action = request.getParameter("action");

            if (action.equalsIgnoreCase("delete")) {
                int mealToId = Integer.parseInt(request.getParameter("mealToId"));
                repositoryMealTo.delete(mealToId);
                forward = LIST_MEALTO;
                request.setAttribute("mealTos", repositoryMealTo.getAllMealTo());
                repositoryMealTo.getAllMealTo().forEach(System.out::println);
            } else if (action.equalsIgnoreCase("edit")) {
                forward = INSERT_OR_EDIT;
                int mealToId = Integer.parseInt(request.getParameter("mealsToId"));
                MealTo mealTo = repositoryMealTo.getMealToById(mealToId);
                request.setAttribute("mealTo", mealTo);
                System.out.println(mealTo);
            } else if (action.equalsIgnoreCase("listMealTo")) {
                forward = LIST_MEALTO;
                request.setAttribute("mealTos", repositoryMealTo.getAllMealTo());
                repositoryMealTo.getAllMealTo().forEach(System.out::println);
            } else {
                forward = INSERT_OR_EDIT;
            }

            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MealTo mealTo = null;
        mealTo.setDescription(request.getParameter("description"));
        mealTo.setCalories(Integer.parseInt(request.getParameter("calories")));
        mealTo.setExcess(Boolean.parseBoolean(request.getParameter("excess")));

        try {
            LocalDateTime dateTime = LocalDateTime.parse(request.getParameter("dateTime"));
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yy HH:mm");
            String text = dtf.format(dateTime);
            mealTo.setDateTime(LocalDateTime.parse(text));

        } catch (Exception e) {
            e.printStackTrace();

            String mealToid = request.getParameter("mealToid");
            if (mealToid == null || mealToid.isEmpty()) {

                repositoryMealTo.addMealTo(mealTo);
            } else {
                mealTo.setId(Integer.parseInt(mealToid));
                repositoryMealTo.updateMealTo(mealTo);
            }
            RequestDispatcher view = request.getRequestDispatcher(LIST_MEALTO);
            request.setAttribute("mealTos", repositoryMealTo.getAllMealTo());
            view.forward(request, response);
        }
    }
}

