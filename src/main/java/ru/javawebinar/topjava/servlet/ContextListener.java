package ru.javawebinar.topjava.servlet;


import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MapManyClass;
import ru.javawebinar.topjava.util.Utils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebListener
public class ContextListener implements ServletContextListener {

    private Map<Integer, MealTo> meal;
    private MapManyClass mapManyClass = new MapManyClass();

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        final ServletContext servletContext =
                servletContextEvent.getServletContext();

        meal = new ConcurrentHashMap<>();

        servletContext.setAttribute("meal", meal);

//        final MealTo user = Utils.createStubUser(1, "Первый", 10);
        this.meal.putAll(mapManyClass.initMealToMap());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //Close recourse.
        meal = null;
    }
}