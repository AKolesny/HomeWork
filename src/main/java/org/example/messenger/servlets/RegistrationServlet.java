package org.example.messenger.servlets;

import org.example.messenger.service.SaveUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/api/user")
public class RegistrationServlet extends HttpServlet {

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String LAST_NAME = "lastName";
    private static final String FIRST_NAME = "firstName";
    private static final String MIDDLE_NAME = "middleName";
    private static final String BIRTHDAY = "birthday";

    private final SaveUser user;

    public RegistrationServlet() {
        this.user = new SaveUser();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);
        String lastName = req.getParameter(LAST_NAME);
        String firstName = req.getParameter(FIRST_NAME);
        String middleName = req.getParameter(MIDDLE_NAME);
        String birthday = req.getParameter(BIRTHDAY);

        PrintWriter writer = resp.getWriter();

        try {
            user.save(login, password, lastName, firstName, middleName, birthday);
            writer.write("<p> Регестрация прошла успешна! </p>");
        } catch (IllegalArgumentException e) {
            resp.sendError(400, e.getMessage());
        }
    }
}
