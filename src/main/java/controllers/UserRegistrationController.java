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

@WebServlet("/register")
public class UserRegistrationController extends HttpServlet {
    private UserDao dao = UserDaoImpl.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/list").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String userId = request.getParameter("id");
        String name = request.getParameter("name");
        Integer age = Integer.valueOf(request.getParameter("age"));
        Integer salary = Integer.valueOf(request.getParameter("salary"));

        User user = new User()
                .setName(name)
                .setAge(age)
                .setSalary(salary);

        if (Objects.equals(userId, null))
            dao.saveUser(user);
        else {
            Long id = Long.parseLong(userId);
            user.setId(id);
            dao.updateUser(user);
        }
        response.sendRedirect(request.getContextPath() + "/list");
    }
}
