package com.project.web.websocket;

import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;

/**
 * .
 * Created by sun on 2017/6/8.
 */
public class GetHttpSessionConfigurator extends Configurator {

  @Override
  public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
  /*  HttpSession httpSession = (HttpSession) request.getHttpSession();
    sec.getUserProperties().put(HttpSession.class.getName(), httpSession);*/
  }
}
