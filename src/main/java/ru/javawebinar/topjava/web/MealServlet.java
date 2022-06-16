package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.RepositoryMeal;
import ru.javawebinar.topjava.service.ServiceMealTo;
import ru.javawebinar.topjava.util.MealClassData;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {

//        private static final Logger log = getLogger(MealServlet.class);


    private RepositoryMeal repository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); //для корректной работы иницилизирую репозиторий
        // и пустой конструктор для объекта
        repository = new ServiceMealTo();
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id"); // параметр запроса когда нажимаю адд то заполняеться айди

        Meal meal = new Meal(id.isEmpty() ? null : Integer.valueOf(id),
                LocalDateTime.parse(request.getParameter("dateTime")),
                request.getParameter("description"),
                Integer.valueOf(request.getParameter("calories")));


        repository.save(meal);
        response.sendRedirect("mealList"); //опять зашел в метод в метод доГет для отображения данных
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String action = request.getParameter("action");// параметр запроса то есть request
            if (action == null) {
                request.setAttribute("m", MealsUtil.filteredByHtml(new ArrayList<>(repository.getAllMealTo()), 2000));// ссылка на объект как модель в спринге
                request.getRequestDispatcher("mealList.jsp").forward(request, response);// какую страницу показать пользователю для преобразования html страницы в вид с данными
            } else if (action.equals("delete")) {
                int id = getId(request);//ссылка на id
                repository.delete(id);
                response.sendRedirect("mealList"); //опять зашел в метод в метод доГет для отображения данных
            } else {

     final Meal meal = action.equals("create") ? new Meal(LocalDateTime.now(), "", 1000) : repository.getIdMealTo(getId(request));
   request.setAttribute("meal", meal);// только объект ссылка
                request.getRequestDispatcher("mealEdit.jsp").forward(request, response);// какую страницу показать пользователю

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }
}
