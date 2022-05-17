package com.example.usermanagement.api.v1.handler;

import com.example.usermanagement.api.v1.proto.MessageProto;
import com.example.usermanagement.user.User;

import java.util.List;
import java.util.stream.Collectors;

final class HandlerUtil {
  private HandlerUtil() {}

  static MessageProto.User buildResponseUser(User user) {
    return MessageProto.User
        .newBuilder()
        .setId(user.getId())
        .setEmail(user.getEmail())
        .setFirstName(user.getFirstName())
        .setLastName(user.getLastName())
        .setCreationDate(user.getCreationDate().toInstant().toString())
        .setUpdateDate(user.getUpdateDate().toInstant().toString())
        .build();
  }

  static List<MessageProto.User> buildResponseUsers(List<User> users) {
    return users.stream().map(HandlerUtil::buildResponseUser).collect(Collectors.toList());
  }
}
