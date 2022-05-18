package com.example.usermanagement.api.v1;

import com.example.usermanagement.api.v1.handler.CreateUserHandler;
import com.example.usermanagement.api.v1.handler.GetUsersHandler;
import com.example.usermanagement.api.v1.proto.MessageProto;
import com.example.usermanagement.exceptions.InvalidRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
public class UsersController {

  private static final String MEDIA_TYPE_JSON = MediaType.APPLICATION_JSON_VALUE;
  private static final String MEDIA_TYPE_PROTOBUF = "application/x-protobuf";

  private final GetUsersHandler getUsersHandler;
  private final CreateUserHandler createUserHandler;

  @Autowired
  public UsersController(
    GetUsersHandler getUsersHandler,
    CreateUserHandler createUserHandler
  ) {
    this.getUsersHandler = getUsersHandler;
    this.createUserHandler = createUserHandler;
  }

  @RequestMapping(
    method = RequestMethod.GET,
    produces = { MEDIA_TYPE_JSON, MEDIA_TYPE_PROTOBUF }
  )
  public MessageProto.GetUsers.Response getUsers(
    @RequestParam(value = "offset", defaultValue = "0") int offset,
    @RequestParam(value = "limit", defaultValue = "25") int limit
  ) {
    return getUsersHandler.getUsers(offset, limit);
  }

  @RequestMapping(
      method = RequestMethod.POST,
      produces = { MEDIA_TYPE_JSON, MEDIA_TYPE_PROTOBUF }
  )
  public MessageProto.CreateUser.Response createUser(@RequestBody MessageProto.CreateUser.Request request)
    throws InvalidRequestException {
    return createUserHandler.createUser(request);
  }
}
