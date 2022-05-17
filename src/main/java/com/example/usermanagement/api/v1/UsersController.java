package com.example.usermanagement.api.v1;

import com.example.usermanagement.api.v1.handler.GetUsersHandler;
import com.example.usermanagement.api.v1.proto.MessageProto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UsersController {

  private final GetUsersHandler getUsersHandler;

  @Autowired
  public UsersController(
    GetUsersHandler getUsersHandler
  ) {
    this.getUsersHandler = getUsersHandler;
  }

  @RequestMapping(
    method = RequestMethod.GET,
    produces = {MediaType.APPLICATION_JSON_VALUE}
  )
  public MessageProto.GetUsers.Response getUsers() {
    return getUsersHandler.getUsers();
  }
}
