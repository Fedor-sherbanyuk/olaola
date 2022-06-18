package ru.javawebinar.topjava.repository.inmemory;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.MealsUtil;
import ru.javawebinar.topjava.web.Util;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static ru.javawebinar.topjava.repository.inmemory.InMemoryUserRepository.ADMIN_ID;
import static ru.javawebinar.topjava.repository.inmemory.InMemoryUserRepository.USER_ID;
@Repository
public class InMemoryMealRepository implements MealRepository {


    private final Map<Integer, Map<Integer,Meal>> repository = new ConcurrentHashMap<>();
    private final AtomicInteger counter = new AtomicInteger(0);

    {
        MealsUtil.meals.forEach(meal -> save(meal,USER_ID));
        save(new Meal(LocalDateTime.of(2015, Month.JUNE, 1, 14, 0), "Админ ланч", 510), ADMIN_ID);
        save(new Meal(LocalDateTime.of(2015, Month.JUNE, 1, 21, 0), "Админ ланч", 150), ADMIN_ID);
    }

    @Override
    public Meal save(Meal meal, Integer userid) {
        Map<Integer,Meal> mealMaps=repository.computeIfAbsent(userid,ConcurrentHashMap::new);
        if (meal.isNew()) {
            meal.setId(counter.incrementAndGet());
            mealMaps.put(meal.getId(),meal);
            return meal;
        }
        // handle case: update, but not present in storage
        return mealMaps.computeIfPresent(meal.getId(), (id, oldMeal) -> meal);
    }

    @Override
    public boolean delete(int id, Integer userid) {

        Map<Integer,Meal> mealMaps=repository.get(userid);

        for (Map.Entry<Integer, Meal> o : mealMaps.entrySet()) {
            if (o.getValue().getUserId().equals(userid)) {
                return mealMaps.remove(id) != null;
            }
        }
        return mealMaps.remove(id) == null;
    }
    @Override
    public Meal get(int id, Integer userid) {
        Map<Integer,Meal> mealMaps=repository.get(userid);
        return mealMaps==null?null:mealMaps.get(id);

    }

    @Override
    public List<Meal> getAll(Integer userid) {
        return getAllFilter(userid,meal -> true);
//        Map<Integer,Meal> mealMaps=repository.get(userid);
//       return CollectionUtils.isEmpty(mealMaps) ? Collections.emptyList():
//               mealMaps.values().stream().sorted(Comparator.comparing(Meal::getDate).reversed())
//                               .collect(Collectors.toList());
    }
    public List<Meal> getAllFilter(Integer userid, Predicate<Meal> filter) {
        Map<Integer,Meal> mealMaps=repository.get(userid);
        return CollectionUtils.isEmpty(mealMaps) ? Collections.emptyList():
                mealMaps.values().stream().filter(filter).
                        sorted(Comparator.comparing(Meal::getDate).reversed())
                        .collect(Collectors.toList());
    }
    @Override
    public List<Meal> isBetweenHalfOpen(LocalDateTime localDateStart, LocalDateTime localDateEnd, Integer userid) {
        return getAllFilter(userid,meal -> Util.isBetweenHalfOpen(meal.getDateTime(),localDateStart,
                localDateEnd));



//        Map<Integer,Meal> mealMaps=repository.get(userid);
//        return CollectionUtils.isEmpty(mealMaps) ? Collections.emptyList():
//                mealMaps.values().stream().filter(meal -> Util.isBetweenHalfOpen(meal.getDateTime(),localDateStart,
//                                localDateEnd)).sorted(Comparator.comparing(Meal::getDate).reversed())
//                        .collect(Collectors.toList());
    }
}




