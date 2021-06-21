package com.sr.core.websocket;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * @author lkj
 * @date 2021/5/13
 */
@ServerEndpoint("/websocket")
@Component
public class MyWebSocket {

    @OnOpen
    public void onOpen(Session session) throws IOException {
        System.out.println("websocket已连接" + session);
        session.getBasicRemote().sendText("欢迎登录系统");
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("websocket已经关闭" + session);
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("收到客户端发来的消息 -->" + message);
        session.getBasicRemote().sendText("已经收到");
    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }
}
