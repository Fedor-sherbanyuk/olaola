package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.repository.RepositoryMeal;
import ru.javawebinar.topjava.util.MapManyClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ServiceMealTo implements RepositoryMeal {

    private MapManyClass mapManyClass = new MapManyClass();
    private Map<AtomicInteger,MealTo> atomicIntegerMealToMap=mapManyClass.initMealToMap();



    @Override
    public void addMealTo(MealTo mealTo) {

        atomicIntegerMealToMap.put(new AtomicInteger(atomicIntegerMealToMap.size() + 1), mealTo);
        mapManyClass.setMealToMap(atomicIntegerMealToMap);
    }

    @Override
    public void delete(int mealToId) throws Exception {
        if (atomicIntegerMealToMap.containsKey(new AtomicInteger(mealToId))) {
            atomicIntegerMealToMap.remove(new AtomicInteger(mealToId));
        } else {

            throw new Exception("НЕТ КЛЮЧА!!!!!!");
        }
    }

    @Override
    public void updateMealTo(MealTo mealTo) {
        if (atomicIntegerMealToMap.containsKey(new AtomicInteger(mealTo.getId()))) {
            atomicIntegerMealToMap.remove(new AtomicInteger(mealTo.getId()));
            atomicIntegerMealToMap.put(new AtomicInteger(mealTo.getId()), mealTo);
        } else {
            atomicIntegerMealToMap.put(new AtomicInteger(mealTo.getId()), mealTo);
        }
    }

    @Override
    public List<MealTo> getAllMealTo() {

        return new ArrayList<>(atomicIntegerMealToMap.values());
    }

    @Override
    public MealTo getMealToById(int mealToId) throws Exception {
        MealTo mealTo = null;
        if (atomicIntegerMealToMap.containsKey(new AtomicInteger(mealToId))) {
            return mealTo = atomicIntegerMealToMap.get(new AtomicInteger(mealToId));
        } else {
            throw new Exception("НЕТ КЛЮЧА!!!!!!");
        }
    }


}