package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class MapManyClass {
    private final int calories = 2000;
    private Map<Integer, Meal> mealMap = new ConcurrentHashMap<>();
    private Map<Integer, MealTo> mealToMap = new ConcurrentHashMap<>();

    private Map<Integer, Meal> init() {
        mealMap.put(1, new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500));
        mealMap.put(2, new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000));
        mealMap.put(3, new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500));
        mealMap.put(4, new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100));
        mealMap.put(5, new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000));
        mealMap.put(6, new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500));
        mealMap.put(7, new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410));

        return mealMap;
    }

    public int getCalories() {
        return calories;
    }

    public Map<Integer, Meal> getMealMap() {
        return mealMap;
    }

    public void setMealMap(Map<Integer, Meal> mealMap) {
        this.mealMap = mealMap;
    }
    private static MealTo createTo(Meal meal, boolean excess) {
        return new MealTo(meal.getDateTime(), meal.getDescription(), meal.getCalories(), excess);
    }
    public  static List<MealTo>filteredByHtml(List<Meal> meals,int caloriesPerDay){
        Map<LocalDate, Integer> caloriesSumByDate = meals.stream()
                .collect(
                        Collectors.groupingBy(Meal::getDate, Collectors.summingInt(Meal::getCalories))
                );

        return meals.stream()
                .map(meal -> createTo(meal, caloriesSumByDate.get(meal.getDate()) > caloriesPerDay))
                .collect(Collectors.toList());
    }
    public Map<Integer,MealTo> initMealToMap() {
       mealMap= new MapManyClass().init();
        List<Meal> mealList= new ArrayList<>(mealMap.values());
        List<MealTo> mealToList= filteredByHtml(mealList,calories);
        Map<Integer, MealTo> mealToMap = new ConcurrentHashMap<>();


        for (int i = 0; i < mealToList.size(); i++) {
            mealToMap.put(i,mealToList.get(i));
        }
       return mealToMap;
    }

    public Map<Integer, MealTo> getMealToMap() {
        return mealToMap;
    }

    public void setMealToMap(Map<Integer, MealTo> mealToMap) {
        this.mealToMap = mealToMap;
    }
}
