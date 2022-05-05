package org.example.messenger.servlets.listeners;

import org.example.messenger.service.Statistic;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class CountActiveUser implements HttpSessionAttributeListener {

    private static final Statistic statistic = Statistic.getInstance();

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        if ("user".equals(event.getName())) {
            statistic.addActiveUser();
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        if ("user".equals(event.getName())) {
            statistic.depActiveUser();
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {

    }
}
