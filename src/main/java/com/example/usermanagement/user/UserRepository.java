package com.example.usermanagement.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
  @Query(
    "" +
    "SELECT u " +
    "FROM User u " +
    "WHERE u.email = :email"
  )
  Optional<User> findByEmail(@Param("email") String email);
}
