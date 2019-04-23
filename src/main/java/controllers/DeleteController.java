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

@WebServlet("/delete")
public class DeleteController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userId = request.getParameter("id");
        if (Objects.equals(userId, null)) {
            request.getRequestDispatcher("/list").forward(request, response);
        }
        else {
            Long id = Long.parseLong(userId);
            UserDao dao = UserDaoImpl.getInstance();
            dao.deleteUser(id);
            response.sendRedirect(request.getContextPath() + "/list");
        }
    }
}
