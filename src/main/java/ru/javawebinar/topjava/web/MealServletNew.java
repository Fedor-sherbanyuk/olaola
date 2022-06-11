package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.service.ServiceMealTo;
import ru.javawebinar.topjava.util.MapManyClass;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MealServletNew extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(MealServletNew.class);
    private final ServiceMealTo repositoryMealTo = new ServiceMealTo();
    private final static String INSERT_OR_EDIT = "/meals.jsp";
    private final static String update = "/update.jsp";
    private MapManyClass mapManyClass = new MapManyClass();
    private Map<Integer, MealTo> meals;
//  private List<MealTo> meals;
//    private MealTo meals;

    @Override
    public void init() throws ServletException {
        meals = mapManyClass.initMealToMap();
//        meals = new CopyOnWriteArrayList<>();
//        for (Map.Entry<AtomicInteger, MealTo> o : atomicIntegerMealToMap1.entrySet()) {
//            meals.add(o.getValue());
//          //  meals =  new MealTo(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500,false);
//     }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Enter do MealTo");

        String action = request.getParameter("action");
        request.setAttribute("meals", meals);
        switch (action == null ? "info" : action) {
            case "update":
                request.getRequestDispatcher(update).forward(request, response);
                break;
            case "info":
            default:
                request.getRequestDispatcher(INSERT_OR_EDIT).forward(request, response);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Enter doPost");

        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if ("submit".equals(action)) {
            String description = request.getParameter("description");
            String calories = (request.getParameter("calories"));
            String excess = (request.getParameter("excess"));
            LocalDateTime dateTime = LocalDateTime.parse(request.getParameter("dateTime"));
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yy HH:mm");
            String date = dtf.format(dateTime);
            LocalDateTime localDateTime = (LocalDateTime.parse(date));
            String id = request.getParameter("id");

            if (id == null || id.isEmpty()) {
//Integer idNew=Integer.parseInt(id);
                meals.put((meals.size()+Integer.parseInt(id)), new MealTo(localDateTime,
                        description, Integer.parseInt(calories), Boolean.parseBoolean(excess)));
//                meals=  new MealTo(
//                        localDateTime, description, Integer.parseInt(calories), Boolean.parseBoolean(excess)
//                );
//
            }     else {
                int idNew = (Integer.parseInt(id));

                for (Map.Entry<Integer, MealTo> o : meals.entrySet()) {
                    meals.put((Integer.parseInt(id)), new MealTo(localDateTime,
                            description, Integer.parseInt(calories), Boolean.parseBoolean(excess)));
                }
//                    if (!meals.contains(o)) {
//                        meals.add(o.getValue());
//                    }
                }

//            }

            request.setAttribute("meals", meals);
            request.getRequestDispatcher(INSERT_OR_EDIT).forward(request, response);
        }

    }
}
//    private boolean requestIsValid(final HttpServletRequest request) {
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
//        }
//
//            String mealToid = request.getParameter("mealToid");
//            return mealTo.getDateTime() != null && mealTo.getCalories() >= 0 &&
//                    mealTo.getDescription() != null;
//        }


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


