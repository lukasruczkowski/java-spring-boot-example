package com.example.usermanagement.api.v1.handler;

import com.example.usermanagement.api.v1.proto.MessageProto;
import com.example.usermanagement.user.User;
import com.example.usermanagement.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional(rollbackOn = Throwable.class)
public class GetUsersHandler {

  private final UserService userService;

  @Autowired
  public GetUsersHandler(UserService userService) {
    this.userService = userService;
  }

  public MessageProto.GetUsers.Response getUsers() {
    return buildResponse(userService.getUsers());
  }

  private MessageProto.GetUsers.Response buildResponse(List<User> users) {
    return MessageProto.GetUsers.Response
        .newBuilder()
        .addAllUsers(HandlerUtil.buildResponseUsers(users))
        .build();
  }
}
