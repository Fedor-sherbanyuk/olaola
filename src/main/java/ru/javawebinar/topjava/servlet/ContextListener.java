package ru.javawebinar.topjava.servlet;


import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MapManyClass;
import ru.javawebinar.topjava.util.Utils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebListener
public class ContextListener implements ServletContextListener {


    private Map<Integer, MealTo> meal;
    private MapManyClass mapManyClass = new MapManyClass();

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        ServletContext servletContext =
                servletContextEvent.getServletContext();


        meal = new ConcurrentHashMap<>();

        servletContext.setAttribute("meal", meal);
        final MealTo mealTo = Utils.createStubUser(1, LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0),
                "Завтрак",500,false);
        this.meal.put(mealTo.getId(), mealTo);
//        this.meal.putAll(mapManyClass.initMealToMap());
//        for (Map.Entry<Integer, MealTo> o :mea.entrySet()) {
//            MealTo mealTo=Utils.createStubUser(o.getValue().getId(),o.getValue().getDateTime(),o.getValue().getDescription(),
//                    o.getValue().getCalories(),o.getValue().isExcess());
//            this.meal.put(mealTo.getId(),mealTo);
//        }



    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //Close recourse.
        meal = null;
    }
}