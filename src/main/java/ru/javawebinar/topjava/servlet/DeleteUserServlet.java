package ru.javawebinar.topjava.servlet;


import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DeleteUserServlet extends HttpServlet {

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

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        if (Utils.idIsNumber(req)) {
            resp.sendRedirect(req.getContextPath() + "/");

        } else {
           Integer id=Integer.parseInt(req.getParameter("id"));
            meal.remove(meal.get(id));

            resp.sendRedirect(req.getContextPath() + "/");
        }
    }

}