package ru.javawebinar.topjava.servlet;


import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UpdateUserServlet extends HttpServlet {

    private Map<Integer, MealTo> meal;

    @Override
    public void init() throws ServletException {

        final Object meal = getServletContext().getAttribute("meal");

        if (meal == null || !(meal instanceof ConcurrentHashMap)) {

            throw new IllegalStateException("You're repo does not initialize!");
        } else {

            this.meal = (ConcurrentHashMap<Integer, MealTo>) meal;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");


            String description = request.getParameter("description");
            String calories = (request.getParameter("calories"));
            String excess = (request.getParameter("excess"));
            LocalDateTime dateTime = LocalDateTime.parse(request.getParameter("dateTime"));
//            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yy HH:mm");
//            String date = dtf.format(dateTime);
//            LocalDateTime localDateTime = (LocalDateTime.parse(date));
            String id = request.getParameter("id");
           MealTo mealTo=meal.get(Integer.parseInt(id));
           mealTo.setDateTime(dateTime);
           mealTo.setExcess(Boolean.parseBoolean(excess));
           mealTo.setCalories(Integer.parseInt(calories));
           mealTo.setDescription(description);
            resp.sendRedirect(request.getContextPath() + "/");

 }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        final String id = req.getParameter("id");

        if (Utils.idIsInvalid(id, meal)) {
            resp.sendRedirect(req.getContextPath() + "/");
            return;
        }

        final MealTo mealTo = meal.get(Integer.parseInt(id));
        req.setAttribute("mealTo", mealTo);

        req.getRequestDispatcher("/WEB-INF/view/update.jsp")
                .forward(req, resp);
    }
}
