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
import java.util.Optional;

@WebServlet("/delete")
public class DeleteController extends HttpServlet {
    private UserDao dao=UserDaoImpl.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long targetId =Long.parseLong(request.getParameter("id"));
        Optional<User> user=dao.deleteUser(targetId);
        if (!user.isPresent()) {
            request.getRequestDispatcher("/list").forward(request, response);
        }
        else {
            response.sendRedirect(request.getContextPath() + "/list");
        }
    }
}
