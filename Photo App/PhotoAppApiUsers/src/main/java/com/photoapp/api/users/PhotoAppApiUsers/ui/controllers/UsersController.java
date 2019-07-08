package com.photoapp.api.users.PhotoAppApiUsers.ui.controllers;

import com.photoapp.api.users.PhotoAppApiUsers.data.UserEntity;
import com.photoapp.api.users.PhotoAppApiUsers.service.UsersService;
import com.photoapp.api.users.PhotoAppApiUsers.shared.UserDto;
import com.photoapp.api.users.PhotoAppApiUsers.ui.model.CreateUserRequestModel;
import com.photoapp.api.users.PhotoAppApiUsers.ui.model.CreateUserResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersController {

  @Autowired
  UsersService usersService;

  // Access local service port
  @Autowired
  private Environment env;

  @GetMapping("/status/check")
  public String status() {
    return "Users Working" + env.getProperty("local.server.port");
  }

  @PostMapping(consumes = {
      MediaType.APPLICATION_XML_VALUE,
      MediaType.APPLICATION_JSON_VALUE
  }, produces = {
      MediaType.APPLICATION_JSON_VALUE,
      MediaType.APPLICATION_XML_VALUE})
  public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel userDetails) {

    ModelMapper modelMapper = new ModelMapper();
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT); // Field names must match source and destination object, set it strict

    UserDto userDto = modelMapper.map(userDetails, UserDto.class);
    UserDto createdUser = usersService.createUser(userDto);

    CreateUserResponseModel returnValue = modelMapper.map(createdUser, CreateUserResponseModel.class);

    return new ResponseEntity<>(returnValue, HttpStatus.CREATED);
  }


}
