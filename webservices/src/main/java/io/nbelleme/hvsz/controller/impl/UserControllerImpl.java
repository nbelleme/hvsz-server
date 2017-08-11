package io.nbelleme.hvsz.controller.impl;

import io.nbelleme.hvsz.controller.api.UserController;
import io.nbelleme.hvsz.services.api.UserService;
import io.nbelleme.hvsz.user.internal.User;
import io.nbelleme.hvsz.mapper.UserMapper;
import io.nbelleme.hvsz.user.transfer.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * Created by nbelleme on 28/07/2017.
 */
@RestController
@RequestMapping("/api/user")
final class UserControllerImpl implements UserController {

  private UserService userService;

  /**
   * Constructor.
   *
   * @param userService userService
   */
  UserControllerImpl(UserService userService) {
    Objects.requireNonNull(userService);

    this.userService = userService;
  }

  @Override
  @PostMapping("/create")
  public UserDTO create() {
    User user = userService.create("username", "password");
    return UserMapper.toDTO(user);
  }

  @Override
  @GetMapping("/get/{id}")
  public UserDTO get(@PathVariable("id") String id) {
    Objects.requireNonNull(id);

    User user = userService.get(id);
    return UserMapper.toDTO(user);
  }


}