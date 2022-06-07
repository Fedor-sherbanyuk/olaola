package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;

import java.util.List;

public interface RepositoryMeal {


    void addMealTo(MealTo mealTo);

    void delete(int mealToId) throws Exception;

    void updateMealTo(MealTo meal);

    List<MealTo> getAllMealTo();

    MealTo getMealToById(int mealToId) throws Exception;


}
