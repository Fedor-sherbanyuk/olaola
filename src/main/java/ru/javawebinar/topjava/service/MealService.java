package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import static ru.javawebinar.topjava.util.ValidationUtil.checkNotFoundWithId;

public class MealService {

    private final MealRepository repository;

    public MealService(MealRepository repository) {
        this.repository = repository;
    }

    public Meal get(int id, Integer userid) {
        return checkNotFoundWithId(repository.get(id,userid),id);
    }
    public void delete(int id, Integer userid) {
         checkNotFoundWithId(repository.get(id,userid),id);
    }

    public List<Meal> isBetweenHalfOpen(LocalDateTime localDateStart, LocalDateTime localDateEnd, Integer userid) {
        return repository.isBetweenHalfOpen(localDateStart,localDateEnd,userid);
    }

    public Collection<Meal> getAll(Integer userid) {
        return repository.getAll(userid);
    }
    public void update(Meal meal, Integer userid) {
        checkNotFoundWithId(repository.save(meal,userid), meal.getId());
    }





}