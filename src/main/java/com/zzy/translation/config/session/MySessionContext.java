package com.zzy.translation.config.session;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

public class MySessionContext {
    private static MySessionContext mySessionContext;
    private HashMap<String, HttpSession> sessionMap;
    private MySessionContext(){
        sessionMap = new HashMap<>();
    }

    public static MySessionContext getInstance(){
        if (mySessionContext == null){
            mySessionContext = new MySessionContext();
        }
        return mySessionContext;
    }

    public synchronized void addSession(HttpSession session){
        if(session != null){
            sessionMap.put(session.getId(), session);
        }
    }

    public synchronized void delSession(HttpSession session){
        if (session != null){
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
