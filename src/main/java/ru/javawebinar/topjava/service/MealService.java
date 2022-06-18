package ru.javawebinar.topjava.service;

import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.MealRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import static ru.javawebinar.topjava.util.DateTimeUtil.getEndInclusive;
import static ru.javawebinar.topjava.util.DateTimeUtil.getStartInclusive;
import static ru.javawebinar.topjava.util.ValidationUtil.checkNotFoundWithId;
@Service
public class MealService {

    private final MealRepository repository;

    public MealService(MealRepository repository) {
        this.repository = repository;
    }

    public Meal get(int id, Integer userid) {
        return checkNotFoundWithId(repository.get(id,userid),id);
    }
    public void delete(int id, Integer userid) {
         checkNotFoundWithId(repository.delete(id,userid),id);
    }

    public List<Meal> isBetweenHalfOpen(LocalDate localDateStart, LocalDate localDateEnd, Integer userid) {
        return repository.isBetweenHalfOpen(getStartInclusive(localDateStart),getEndInclusive(localDateEnd),userid);   }

    public List<Meal> getAll(Integer userid) {
        return repository.getAll(userid);
    }
    public void update(Meal meal, Integer userid) {
        checkNotFoundWithId(repository.save(meal,userid), meal.getId());
    }


    public Meal create(Meal meal, int userId) {

            return repository.save(meal,userId);
        }
    }
