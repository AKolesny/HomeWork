package org.example.messenger.servlets;

import org.example.messenger.core.dto.User;
import org.example.messenger.service.Statistic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "StatisticServlet", urlPatterns = "/ui/admin/statistics")
public class StatisticServlet extends HttpServlet {

    private static final String ADMIN = "admin";

    private final Statistic statistic;

    public StatisticServlet() {
        this.statistic = Statistic.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if(ADMIN.equals(user.getRole())){
            req.setAttribute("activeUser", statistic.getCountActiveUser());
            req.setAttribute("countMessages", statistic.getCountMessages());
            req.setAttribute("countUsers", statistic.getCountUsers());
        } else {
            resp.sendError(400, "Нет доступа!");
        }

        req.getRequestDispatcher("/statistic.jsp").forward(req, resp);

    }
}
