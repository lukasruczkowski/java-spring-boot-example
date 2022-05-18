package com.example.usermanagement.user;

import com.example.usermanagement.exceptions.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface IUserService {
  User createUser(String email, String firstName, String lastName);
  User updateUser(User user, String email, String firstName, String lastName);
  Optional<User> getUserById(long id);
  User getUserByIdOrThrow(long id) throws NotFoundException;
  User getUserByEmailOrThrow(String email) throws NotFoundException;
  Page<User> getUsers(int offset, int limit);
  void deleteUserOrThrow(long id) throws NotFoundException;
}
