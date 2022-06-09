package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.repository.RepositoryMeal;
import ru.javawebinar.topjava.service.ServiceMealTo;
import ru.javawebinar.topjava.util.MapManyClass;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class MealServletNew extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(MealServletNew.class);
    private final ServiceMealTo repositoryMealTo = new ServiceMealTo();
    private final static String INSERT_OR_EDIT = "/mealTo.jsp";
    private final static String index = "/WEB-INF/view/index.jsp";
    private MapManyClass mapManyClass = new MapManyClass();
    private Map<AtomicInteger, MealTo> atomicIntegerMealToMap1;
    private List<MealTo> atomicIntegerMealToMap;
    @Override
    public void init() throws ServletException {
       atomicIntegerMealToMap1 = mapManyClass.initMealToMap();
        atomicIntegerMealToMap=new CopyOnWriteArrayList<>();
        for (Map.Entry<AtomicInteger, MealTo> o :atomicIntegerMealToMap1.entrySet() ){
            atomicIntegerMealToMap.add(o.getValue());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("atomicIntegerMealToMap", atomicIntegerMealToMap);
        request.getRequestDispatcher(index).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        try {
        if (!requestIsValid(request)) {
            doGet(request, resp);
        }
        MealTo mealTo = null;
        String description=(request.getParameter("description"));
        String calories= (request.getParameter("calories"));
        String excess =(request.getParameter("excess"));


            LocalDateTime dateTime = LocalDateTime.parse(request.getParameter("dateTime"));
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yy HH:mm");
            String date = dtf.format(dateTime);
        LocalDateTime localDateTime=(LocalDateTime.parse(date));



            String mealToid = request.getParameter("mealToid");
            if (mealToid == null || mealToid.isEmpty()) {

                atomicIntegerMealToMap1.put(new AtomicInteger(atomicIntegerMealToMap1.size() + 1), new MealTo(
                        localDateTime,description,Integer.parseInt(calories),Boolean.parseBoolean(excess)
                ));
                for (Map.Entry<AtomicInteger, MealTo> o :atomicIntegerMealToMap1.entrySet() ){
                    if(!atomicIntegerMealToMap.contains(o)){
                        atomicIntegerMealToMap.add(o.getValue());
                    }

                }

            } else {
                Integer id = (Integer.parseInt(mealToid));
                atomicIntegerMealToMap1.put(new AtomicInteger(id), mealTo);
                for (Map.Entry<AtomicInteger, MealTo> o :atomicIntegerMealToMap1.entrySet() ){
                    if(!atomicIntegerMealToMap.contains(o)){
                        atomicIntegerMealToMap.add(o.getValue());
                    }

                }

            }
            doGet(request, resp);
        }catch (Exception x){

        }
    }
    private boolean requestIsValid(final HttpServletRequest request) {
        MealTo mealTo = null;
        mealTo.setDescription(request.getParameter("description"));
        mealTo.setCalories(Integer.parseInt(request.getParameter("calories")));
        mealTo.setExcess(Boolean.parseBoolean(request.getParameter("excess")));

        try {
            LocalDateTime dateTime = LocalDateTime.parse(request.getParameter("dateTime"));
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yy HH:mm");
            String text = dtf.format(dateTime);
            mealTo.setDateTime(LocalDateTime.parse(text));

        } catch (Exception e) {
            e.printStackTrace();
        }

            String mealToid = request.getParameter("mealToid");
            return mealTo.getDateTime() != null && mealTo.getCalories() >= 0 &&
                    mealTo.getDescription() != null;
        }
    }

    //        try {
//            String forward ="";
//            String action = request.getParameter("action");
//
//            if (action.equalsIgnoreCase("delete")) {
//                int mealToId = Integer.parseInt(request.getParameter("mealToId"));
//                repositoryMealTo.delete(mealToId);
//                forward = LIST_MEALTO;
//                request.setAttribute("mealTos", repositoryMealTo.getAllMealTo());
//                repositoryMealTo.getAllMealTo().forEach(System.out::println);
//            } else if (action.equalsIgnoreCase("edit")) {
//                forward = INSERT_OR_EDIT;
//                int mealToId = Integer.parseInt(request.getParameter("mealsToId"));
//                MealTo mealTo = repositoryMealTo.getMealToById(mealToId);
//                request.setAttribute("mealTo", mealTo);
//                System.out.println(mealTo);
//            } else if (action.equalsIgnoreCase("listMealTo")) {
//                forward = LIST_MEALTO;
//                request.setAttribute("mealTos", repositoryMealTo.getAllMealTo());
//                repositoryMealTo.getAllMealTo().forEach(System.out::println);
//            } else {
//                forward = INSERT_OR_EDIT;
//            }
//
//            RequestDispatcher view = request.getRequestDispatcher(forward);
//            view.forward(request, response);
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        MealTo mealTo = null;
//        mealTo.setDescription(request.getParameter("description"));
//        mealTo.setCalories(Integer.parseInt(request.getParameter("calories")));
//        mealTo.setExcess(Boolean.parseBoolean(request.getParameter("excess")));
//
//        try {
//            LocalDateTime dateTime = LocalDateTime.parse(request.getParameter("dateTime"));
//            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yy HH:mm");
//            String text = dtf.format(dateTime);
//            mealTo.setDateTime(LocalDateTime.parse(text));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//
//            String mealToid = request.getParameter("mealToid");
//            if (mealToid == null || mealToid.isEmpty()) {
//
//                repositoryMealTo.addMealTo(mealTo);
//            } else {
//                mealTo.setId(Integer.parseInt(mealToid));
//                repositoryMealTo.updateMealTo(mealTo);
//            }
//            RequestDispatcher view = request.getRequestDispatcher(LIST_MEALTO);
//            request.setAttribute("mealTos", repositoryMealTo.getAllMealTo());
//            view.forward(request, response);
//        }
//    }


