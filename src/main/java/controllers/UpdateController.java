package controllers;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/update")
public class UpdateController extends HttpServlet {
    private UserDao dao = UserDaoImpl.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userId = request.getParameter("id");
        if (Objects.equals(userId, null))
            request.getRequestDispatcher("/list").forward(request, response);
        else {
            Long id = Long.parseLong(userId);
            User user = dao.findUserById(id);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/list").forward(request, response);
        }
    }
}
