package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

// TODO add userId
public interface MealRepository {

    // null if updated meal does not belong to userId
    Meal save(Meal meal,Integer userid);

    // false if meal does not belong to userId
    boolean delete(int id, Integer userid);

    // null if meal does not belong to userId
    Meal get(int id, Integer userid);

    List<Meal> isBetweenHalfOpen(LocalDateTime localDateStart,LocalDateTime localDateEnd, Integer userid);

    // ORDERED dateTime desc
    List<Meal> getAll(Integer userid);




}