package com.photoapp.api.users.PhotoAppApiUsers.data;

import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<UserEntity, Long> {
  // allows easy implementation of easy to use methods
  UserEntity findByEmail(String email);
}
