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

            String description = request.getParameter("description");
            String calories = (request.getParameter("calories"));
            String excess = (request.getParameter("excess"));
            LocalDateTime dateTime = LocalDateTime.parse(request.getParameter("dateTime"));
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yy HH:mm");
            String date = dtf.format(dateTime);
            LocalDateTime localDateTime = (LocalDateTime.parse(date));
//            String id = request.getParameter("id");
            final int id = this.id.getAndIncrement();
            meal.put(id, new MealTo(localDateTime,
            description, Integer.parseInt(calories), Boolean.parseBoolean(excess)));
        }
        resp.sendRedirect(request.getContextPath() + "/");

        }


    }

