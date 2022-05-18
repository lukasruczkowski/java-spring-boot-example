package com.example.usermanagement.api.v1.handler;

import com.example.usermanagement.api.v1.proto.MessageProto;
import com.example.usermanagement.exceptions.InvalidRequestException;
import com.example.usermanagement.user.User;
import com.example.usermanagement.user.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional(rollbackOn = Throwable.class)
public class CreateUserHandler {

  private static final Logger LOGGER = LogManager.getLogger(CreateUserHandler.class);

  private final UserService userService;

  @Autowired
  public CreateUserHandler(UserService userService) {
    this.userService = userService;
  }

  public MessageProto.CreateUser.Response createUser(MessageProto.CreateUser.Request request)
    throws InvalidRequestException {
    User user = userService.createUser(request.getEmail(), request.getFirstName(), request.getLastName());
    LOGGER.info(String.format("User created %s", user));
    return buildResponse(user);
  }

  private MessageProto.CreateUser.Response buildResponse(User user) {
    return MessageProto.CreateUser.Response
        .newBuilder()
        .setUser(HandlerUtil.buildResponseUser(user))
        .build();
  }
}
