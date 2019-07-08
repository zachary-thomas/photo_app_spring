package com.photoapp.api.users.PhotoAppApiUsers.shared;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {

  private static final long serialVersionUID = 4123138472433856111L;
  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private String userId;
  private String encryptedPassword;
}
