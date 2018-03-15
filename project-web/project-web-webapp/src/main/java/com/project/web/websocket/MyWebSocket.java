package com.project.web.websocket;


import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;

/**
 * websocket.
 * Created by sun on 2017/6/8.
 */
@ServerEndpoint(value = "/websocket", configurator = GetHttpSessionConfigurator.class)
@Component
public class MyWebSocket {
  private static int onlineCount = 0;
  private Session session;
  private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<>();

  /**
   * 建立websocket链接.
   * @param session session
   * @param config config
   * @throws IOException IOException
   */
  @OnOpen
  public void onOpen(Session session, EndpointConfig config) throws IOException {
    this.session = session;
    System.out.println(session.getId());
    webSocketSet.add(this);
    addOnlineCount();
    System.out.println("有新链接加入!当前在线人数为" + getOnlineCount());
  }

  /**
   * 关闭websocket链接.
   */

  @OnClose
  public void onClose() {
    webSocketSet.remove(this);
    subOnlineCount();
    System.out.println("有一链接关闭!当前在线人数为" + getOnlineCount());
  }

  @OnMessage
  public void onMessage(String message, Session session) throws IOException {
    sendMessage(message);
  }

  public void sendMessage(String message) throws IOException {
    this.session.getBasicRemote().sendText(message);
  }

  public static synchronized int getOnlineCount() {
    return MyWebSocket.onlineCount;
  }

  public static synchronized void addOnlineCount() {
    MyWebSocket.onlineCount++;
  }

  public static synchronized void subOnlineCount() {
    MyWebSocket.onlineCount--;
  }
}
