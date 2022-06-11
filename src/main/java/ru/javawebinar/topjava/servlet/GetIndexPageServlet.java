package ru.javawebinar.topjava.servlet;



import ru.javawebinar.topjava.model.MealTo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GetIndexPageServlet extends HttpServlet {

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("meal", meal.values());
        req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req, resp);
    }
}
