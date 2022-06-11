package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.repository.RepositoryMeal;
import ru.javawebinar.topjava.util.MapManyClass;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ServiceMealTo implements RepositoryMeal {

    private MapManyClass mapManyClass = new MapManyClass();
    private Map<Integer, MealTo> atomicIntegerMealToMap = mapManyClass.initMealToMap();




    @Override
    public void addMealTo(MealTo mealTo) {
        atomicIntegerMealToMap.put(new Integer(atomicIntegerMealToMap.size() + 1), mealTo);
        mapManyClass.setMealToMap(atomicIntegerMealToMap);
    }

    @Override
    public void delete(int mealToId) throws Exception {

        if (atomicIntegerMealToMap.containsKey(new Integer(mealToId))) {
            atomicIntegerMealToMap.remove(new Integer(mealToId));
        } else {

            throw new Exception("НЕТ КЛЮЧА!!!!!!");
        }
    }

    @Override
    public void updateMealTo(MealTo mealTo) {


        if (atomicIntegerMealToMap.containsKey(new Integer(mealTo.getId()))) {
            atomicIntegerMealToMap.remove(new Integer(mealTo.getId()));
            atomicIntegerMealToMap.put(new Integer(mealTo.getId()), mealTo);
        } else {
            atomicIntegerMealToMap.put(new Integer(mealTo.getId()), mealTo);
        }
    }

    @Override
    public List<MealTo> getAllMealTo() {

        return new ArrayList<>(atomicIntegerMealToMap.values());
    }

    @Override
    public MealTo getMealToById(int mealToId) throws Exception {

        MealTo mealTo = null;

        if (atomicIntegerMealToMap.containsKey(new Integer(mealToId))) {
            return mealTo = atomicIntegerMealToMap.get(new Integer(mealToId));
        } else {
            throw new Exception("НЕТ КЛЮЧА!!!!!!");
        }

    }
}

//    private Connection connection;

//        try {
//            PreparedStatement preparedStatement = connection
//                    .prepareStatement("insert into mealTos(dateTime,description,calories,excess) values (?, ?, ?, ? )");
//            // Parameters start with 1
//
//            preparedStatement.setDate(1, Date.valueOf(mealTo.getDateTime().toLocalDate()));
//            preparedStatement.setString(2, mealTo.getDescription());
//            preparedStatement.setString(3, String.valueOf(mealTo.getCalories()));
//            preparedStatement.setString(4, String.valueOf(mealTo.isExcess()));
//            preparedStatement.executeUpdate();
//
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        try {
//            PreparedStatement preparedStatement = connection
//                    .prepareStatement("delete from mealTos where mealToId=?");
//            // Parameters start with 1
//            preparedStatement.setInt(1, mealToId);
//            preparedStatement.executeUpdate();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        try {
//            PreparedStatement preparedStatement = connection
//                    .prepareStatement("update mealTos set dateTime=?, description=?, calories=?, excess=?" +
//                            "where id=?");
//            // Parameters start with 1
//            preparedStatement.setDate(1, Date.valueOf(mealTo.getDateTime().toLocalDate()));
//            preparedStatement.setString(2, mealTo.getDescription());
//            preparedStatement.setString(3, String.valueOf(mealTo.getCalories()));
//            preparedStatement.setString(4, String.valueOf(mealTo.isExcess()));
//            preparedStatement.setInt(5, mealTo.getId());
//            preparedStatement.executeUpdate();
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


//        List<MealTo> mealTos = new ArrayList<MealTo>();
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery("select * from mealTos");
//            while (rs.next()) {
//                MealTo mealTo = null;
//                mealTo.setId(rs.getInt("id"));
//                mealTo.setDescription(rs.getString("description"));
//                mealTo.setCalories(Integer.parseInt(rs.getString("calories")));
//
//                mealTo.setDateTime(LocalDateTime.parse(String.valueOf(rs.getDate("dateTime"))));
//                mealTo.setExcess(Boolean.parseBoolean(rs.getString("excess")));
//                mealTos.add(mealTo);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return mealTos;
//    }


//        try {
//            PreparedStatement preparedStatement = connection.
//                    prepareStatement("select * from mealTos where mealToId=?");
//            preparedStatement.setInt(1, mealToId);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            if (rs.next()) {
//                mealTo.setId(rs.getInt("id"));
//                mealTo.setDescription(rs.getString("description"));
//                mealTo.setCalories(Integer.parseInt(rs.getString("calories")));
//
//                mealTo.setDateTime(LocalDateTime.parse(String.valueOf(rs.getDate("dateTime"))));
//                mealTo.setExcess(Boolean.parseBoolean(rs.getString("excess")));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }