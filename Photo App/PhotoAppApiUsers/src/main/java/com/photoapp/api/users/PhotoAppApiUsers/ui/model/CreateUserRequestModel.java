package com.photoapp.api.users.PhotoAppApiUsers.ui.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CreateUserRequestModel {

  @NotNull(message = "First name can't be null")
  @Size(min=2, message = "First name must be more than 2 characters.")
  private String firstName;

  @NotNull(message = "Last name can't be null")
  @Size(min=2, message = "Last name must be more than 2 characters.")
  private String lastName;

  @NotNull(message = "Password can't be null")
  @Size(min = 8, max = 16, message = "Password must be between 8 and 16 characters.")
  private String password;

  @NotNull(message = "Must provide an email")
  @Email
  private String email;
}
