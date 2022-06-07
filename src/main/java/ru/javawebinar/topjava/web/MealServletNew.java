package ru.javawebinar.topjava.web;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.repository.RepositoryMeal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class MealServletNew extends HttpServlet {

    private final RepositoryMeal repositoryMealTo;
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/MealsTo.jsp";
    private static String LIST_MEALTO = "/listMealTo.jsp";


    public MealServletNew(RepositoryMeal repositoryMealTo) {
        this.repositoryMealTo = repositoryMealTo;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int mealToId = Integer.parseInt(request.getParameter("mealId"));
                repositoryMealTo.getMealToById(mealToId);

            forward = LIST_MEALTO;
            request.setAttribute("mealsTo", repositoryMealTo.getAllMealTo());
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int mealToId = Integer.parseInt(request.getParameter("mealsToId"));
            MealTo mealTo = repositoryMealTo.getMealToById(mealToId);
            request.setAttribute("mealsTo", mealTo);
        } else if (action.equalsIgnoreCase("listMealTo")){
            forward = LIST_MEALTO;
            request.setAttribute("mealsTo", repositoryMealTo.getAllMealTo());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MealTo mealTo = null
        mealTo.getDateTime()
        mealTo.setLastName(request.getParameter("lastName"));
        try {
            Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("dob"));
            user.setDob(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setEmail(request.getParameter("email"));
        String userid = request.getParameter("userid");
        if(userid == null || userid.isEmpty())
        {
           repositoryMealTo.addMeal(meal);
        }
        else
        {
            user.setUserid(Integer.parseInt(userid));
            dao.updateUser(user);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_MEALTO);
        request.setAttribute("users", repositoryMealTo.getAllMealTo());
        view.forward(request, response);
    }
}
}
