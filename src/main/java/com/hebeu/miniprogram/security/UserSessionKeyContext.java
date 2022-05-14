package com.hebeu.miniprogram.security;

import java.util.HashMap;

public class UserSessionKeyContext {
    private static UserSessionKeyContext instance;
    private HashMap<String,String> sessionKeyMap;

    private UserSessionKeyContext(){
        sessionKeyMap=new HashMap<String,String>();
    }

    public static UserSessionKeyContext getInstance(){
        if (instance==null)
            instance=new UserSessionKeyContext();
        return instance;
    }

    public synchronized void addSessionKey(String openId,String sessionKey){
        if (sessionKey!=null)
            sessionKeyMap.put(openId,sessionKey);

    }

    public synchronized String getSessionKey(String openId){
        if (openId==null)
            return null;
        return sessionKeyMap.get(openId);
    }

    public synchronized void delSessionKey(String openId){
        if (openId!=null)
            sessionKeyMap.remove(openId);
    }
}
