package com.hebeu.miniprogram.security;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

public class WebSessionContext {
    private static WebSessionContext instance;
    private HashMap<String,HttpSession> sessionMap;

    private WebSessionContext() {
        sessionMap = new HashMap<String, HttpSession>();
    }

    public static WebSessionContext getInstance() {
        if (instance == null) {
            instance = new WebSessionContext();
        }
        return instance;
    }

    public synchronized void addSession(HttpSession session) {
        if (session != null) {
            sessionMap.put(session.getId(), session);
        }
    }

    public synchronized void delSession(HttpSession session) {
        if (session != null) {
            sessionMap.remove(session.getId());
        }
    }

    public synchronized HttpSession getSession(String sessionID) {
        if (sessionID == null) {
            return null;
        }
        return sessionMap.get(sessionID);
    }

}
