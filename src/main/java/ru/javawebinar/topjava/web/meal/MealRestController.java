package ru.javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.to.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;
import ru.javawebinar.topjava.web.SecurityUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static ru.javawebinar.topjava.util.ValidationUtil.assureIdConsistent;
import static ru.javawebinar.topjava.util.ValidationUtil.checkNew;

@Controller
public class MealRestController {

    private final MealService service;

    public MealRestController(MealService service) {
        this.service = service;
    }

    public Meal get(Integer id){
        int userId= SecurityUtil.authUserId();
        return service.get(id,userId);
    }
    public void delete(Integer id){
        int userId= SecurityUtil.authUserId();
       service.delete(id,userId);
    }

    public List<MealTo> getAll() {
        int userId = SecurityUtil.authUserId();
        return MealsUtil.getTos(service.getAll(userId), SecurityUtil.authUserCaloriesPerDay());
    }
    public Meal create(Meal meal){
        int userId= SecurityUtil.authUserId();
       checkNew(meal);
        return service.create(meal,userId);
    }
    public void update(Meal meal,int id){
        int userId= SecurityUtil.authUserId();
        assureIdConsistent(meal,id);
      service.update(meal,userId);
    }
    public List<MealTo> isBetweenHalfOpen(@Nullable LocalDate startDate, @Nullable LocalTime start,
                                                 @Nullable LocalDate endDate, @Nullable LocalTime end) {
        int userId= SecurityUtil.authUserId();
        List<Meal> mealList=service.isBetweenHalfOpen(startDate,endDate,userId);
        return MealsUtil.getFilteredTos(mealList, SecurityUtil.authUserCaloriesPerDay(),start,end);
//        return (start == null || value.compareTo(start)>=0)&&(end==null || value.compareTo(end)<0);
    }



}