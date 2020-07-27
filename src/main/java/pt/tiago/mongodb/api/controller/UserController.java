package pt.tiago.mongodb.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.tiago.mongodb.api.model.User;
import pt.tiago.mongodb.api.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

@RestController
@RequestMapping("/api")
public class UserController {

    final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/users/")
    public ResponseEntity<Collection<User>> getUsers() {
        return ResponseEntity.ok(this.userRepository.findAll());
    }

    @PutMapping("/users/")
    public ResponseEntity<User> insertUpdateUser(@RequestBody User user) {
        return ResponseEntity.ok(this.userRepository.save(user));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        return ResponseEntity.ok(this.userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found")));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity deleteUser(@PathVariable String id) {
        this.userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
