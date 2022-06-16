package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;

import java.util.Collection;
import java.util.List;

public interface RepositoryMeal {


    Meal save(Meal meal);

    void delete(int mealId) throws Exception;

    Meal  getIdMealTo(int mealId);

    Collection<Meal> getAllMealTo();

//  MealTo getMealToById(int mealToId) throws Exception;


}
