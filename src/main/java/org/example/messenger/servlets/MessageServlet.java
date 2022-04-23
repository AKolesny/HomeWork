package org.example.messenger.servlets;

import org.example.messenger.core.dto.Message;
import org.example.messenger.core.dto.User;
import org.example.messenger.service.SaveMessage;
import org.example.messenger.service.StorageMessages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "MessageServlet", urlPatterns = "/api/message")
public class MessageServlet extends HttpServlet {

    private static final String TO_USER = "user";
    private static final String FROM_USER = "user";
    private static final String TEXT = "text";

    private final SaveMessage saveMessage;
    private final StorageMessages storageMessages;

    public MessageServlet() {
        this.saveMessage = new SaveMessage();
        this.storageMessages = StorageMessages.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        User user = (User) req.getSession().getAttribute(FROM_USER);

        try {
            if (user == null) {
                throw new IllegalArgumentException("Вы не авторизовались!");
            }
        } catch (IllegalArgumentException e) {
            resp.sendError(400, e.getMessage());
            return;
        }

        PrintWriter writer = resp.getWriter();

        List<Message> messages = storageMessages.getMessages(user.getLogin());
        if (messages == null) {
            writer.write("<p> У вас нету сообщений </p>");
        } else {
            for (Message message : messages) {
                writer.write("<p>" + message.toString() +  "</p><br>");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String toUser = req.getParameter(TO_USER);
        String text = req.getParameter(TEXT);
        User fromUser = (User) req.getSession().getAttribute(FROM_USER);

        try {
            if (fromUser == null) {
                throw new IllegalArgumentException("Вы не авторизовались!");
            }

            saveMessage.save(fromUser.getLogin(), toUser, text);
        } catch (IllegalArgumentException e) {
            resp.sendError(400, e.getMessage());
        }
    }
}
