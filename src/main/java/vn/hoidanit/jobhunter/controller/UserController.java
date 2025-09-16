package vn.hoidanit.jobhunter.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties.Http;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.service.UserService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // @GetMapping("users/create")
    @PostMapping("/users")
    public ResponseEntity<User> createNewUser(@RequestBody User postManUser) {
        User createdUser = this.userService.handleCreateUser(postManUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        this.userService.handleDeleteUser(id);
        return "Delete user with ID: " + id;
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") long id) {
        return this.userService.handleGetUserById(id);
    }

    @GetMapping("/users")
    public List<User> getAllUser() {
        return this.userService.handleGetAllUser();
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        return this.userService.handleUpdateUser(user);
    }
}
