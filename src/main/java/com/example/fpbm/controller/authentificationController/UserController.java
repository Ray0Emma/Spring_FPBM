package com.example.fpbm.controller.authentificationController;

import com.example.fpbm.authentification.UserService;
import com.example.fpbm.entities.Role;
import com.example.fpbm.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping()
    public ResponseEntity<List<User>>getAllUsers(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @PostMapping()
    public ResponseEntity<User>saveUser(@RequestBody User user){
        return ResponseEntity.ok().body(userService.saveUser(user));
    }
    @PostMapping("/role")
    public ResponseEntity<Role>saveRole(@RequestBody Role role){
        return ResponseEntity.ok().body(userService.saveRole(role));
    }
    @PostMapping("/roleToUser/{username}/{roleName}")
    public ResponseEntity<?>addRoleToUser(@PathVariable(name = "username") String username, @PathVariable(name = "roleName") String roleName){
        userService.addRoleToUser(username,roleName);
        return ResponseEntity.ok().build();
    }
}
