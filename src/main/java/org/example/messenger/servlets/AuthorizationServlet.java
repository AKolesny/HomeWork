package org.example.messenger.servlets;

import org.example.messenger.service.StorageUsers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AuthorizationServlet", urlPatterns = "/api/login")
public class AuthorizationServlet extends HttpServlet {

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";

    private final StorageUsers storageUsers;

    public AuthorizationServlet() {
        this.storageUsers = StorageUsers.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);

        try {
            storageUsers.AuthorizationUser(login, password);

            HttpSession session = req.getSession();
            session.setAttribute("user", storageUsers.getUser(login));
        } catch (IllegalArgumentException e) {
            resp.sendError(400, e.getMessage());
        }
    }
}
