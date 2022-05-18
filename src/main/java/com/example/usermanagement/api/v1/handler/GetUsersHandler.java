package com.example.usermanagement.api.v1.handler;

import com.example.usermanagement.api.v1.proto.MessageProto;
import com.example.usermanagement.user.User;
import com.example.usermanagement.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

  public MessageProto.GetUsers.Response getUsers(int offset, int limit) {
    Page<User> pageUsers = userService.getUsers(offset, limit);
    return buildResponse(pageUsers.getContent(), pageUsers.getTotalElements());
  }

  private MessageProto.GetUsers.Response buildResponse(List<User> users, long totalCount) {
    return MessageProto.GetUsers.Response
        .newBuilder()
        .addAllUsers(HandlerUtil.buildResponseUsers(users))
        .setTotalCount(totalCount)
        .build();
  }
}
