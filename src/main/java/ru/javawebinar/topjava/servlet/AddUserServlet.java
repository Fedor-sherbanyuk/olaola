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
import java.util.concurrent.atomic.AtomicInteger;

public class AddUserServlet extends HttpServlet {

    private Map<Integer, MealTo> meal;

    private AtomicInteger id;

    @Override
    public void init() throws ServletException {

        final Object meal = getServletContext().getAttribute("meal");

        if (meal == null || !(meal instanceof ConcurrentHashMap)) {

            throw new IllegalStateException("You're repo does not initialize!");
        } else {

            this.meal = (ConcurrentHashMap<Integer, MealTo>) meal;
        }

        id = new AtomicInteger(2);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        if (Utils.requestIsValid(request)) {

            final   String description = request.getParameter("description");
            final String calories = (request.getParameter("calories"));
            final  String excess = (request.getParameter("excess"));
            final   LocalDateTime dateTime = LocalDateTime.parse(request.getParameter("dateTime"));
//            final  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yy HH:mm");
//            final  String date = dtf.format(dateTime);
//            final  LocalDateTime localDateTime = (LocalDateTime.parse(date));
//            String id = request.getParameter("id");
            final int id = this.id.getAndIncrement();
           final MealTo mealTo=new MealTo();
            mealTo.setId(id);
            mealTo.setDescription(description);
            mealTo.setCalories(Integer.parseInt(calories));
            mealTo.setExcess(Boolean.parseBoolean(excess));
            mealTo.setDateTime(dateTime);
            meal.put(id, mealTo);
        }
        resp.sendRedirect(request.getContextPath() + "/");

        }


    }

