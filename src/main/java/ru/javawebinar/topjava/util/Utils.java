package ru.javawebinar.topjava.util;


import ru.javawebinar.topjava.model.MealTo;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * Author : Pavel Ravvich.
 * Created : 15.10.17.
 * <p>
 * Utils
 */
public class Utils {

    public static boolean idIsNumber(HttpServletRequest request) {
        final String id = request.getParameter("id");
        return id != null &&
                (id.length() > 0) &&
                id.matches("[+]?\\d+");
    }

    public static boolean requestIsValid(HttpServletRequest request) {
            String description = request.getParameter("description");
            String calories = (request.getParameter("calories"));
            String excess = (request.getParameter("excess"));
            LocalDateTime dateTime = LocalDateTime.parse(request.getParameter("dateTime"));
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yy HH:mm");
            String date = dtf.format(dateTime);
            LocalDateTime localDateTime = (LocalDateTime.parse(date));
//            String id = request.getParameter("id");
//&& id.length()>=0&&id!=null
        return description != null && description.length() > 0 &&
                calories != null && calories.length() > 0 &&
                calories.matches("[+]?\\d+") &&
                date !=null&&date.length()>0&&excess.length()>0&&excess!=null;


    }

    public static MealTo createStubUser(final int id,
                                        final LocalDateTime dateTime,
                                        final String description,
                                        final Integer calories,
                                        final Boolean excess) {

        MealTo mealTo = new MealTo();
        mealTo.setId(id);
        mealTo.setDateTime(dateTime);
        mealTo.setDescription(description);
        mealTo.setCalories(calories);
        mealTo.setExcess(excess);
        return mealTo;
    }

    public static boolean idIsInvalid(final String id, Map<Integer, MealTo> repo) {
        return !(id != null &&
                id.matches("[+]?\\d+") &&
                repo.get(Integer.parseInt(id)) != null);
    }
}
