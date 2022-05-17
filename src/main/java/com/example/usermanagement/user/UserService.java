package com.example.usermanagement.user;

import com.example.usermanagement.exceptions.NotFoundException;
import com.example.usermanagement.utils.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User createUser(String email, String firstName, String lastName) {
    Preconditions.checkNotNull(email);
    Preconditions.checkNotNull(firstName);
    Preconditions.checkNotNull(lastName);
    return userRepository.save(new User(email, firstName, lastName));
  }

  @Override
  public User updateUser(User user, String email, String firstName, String lastName) {
    Preconditions.checkNotNull(email);
    Preconditions.checkNotNull(firstName);
    Preconditions.checkNotNull(lastName);
    user.setEmail(email);
    user.setFirstName(firstName);
    user.setLastName(lastName);
    return userRepository.save(user);
  }

  @Override
  public Optional<User> getUserById(long id) {
    User user = userRepository.findById(id).orElse(null);
    return user != null ? Optional.of(user) : Optional.empty();
  }

  @Override
  public User getUserByIdOrThrow(long id) throws NotFoundException {
    return getUserById(id)
      .orElseThrow(() -> new NotFoundException("User not found: " + id));
  }

  @Override
  public User getUserByEmailOrThrow(String email) throws NotFoundException {
    return userRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("User not found: " + email));
  }

  @Override
  public List<User> getUsers() {
    return (List<User>) userRepository.findAll();
  }

  @Override
  public void deleteUserOrThrow(long id) throws NotFoundException {
    User user = getUserByIdOrThrow(id);
    userRepository.delete(user);
  }
}
