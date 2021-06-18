package com.example.UserManagementSpringBoot.controller;

import com.example.UserManagementSpringBoot.model.User;
import com.example.UserManagementSpringBoot.model.dto.UserDto;
import com.example.UserManagementSpringBoot.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value = "User Management", description = "User management system Spring boot JPA")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value="Add User")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Successful"),
                    @ApiResponse(code = 400, message = "Bad request")
            }
    )
    @PostMapping("/user")
    public ResponseEntity<String> addUser(@RequestBody UserDto userDto){
        if(userService.addUser(userDto)){
            return ResponseEntity.ok().body("User successfully created");
        };
        return ResponseEntity.badRequest().body("User not created");
    }

    @ApiOperation(value="Update User")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Successful"),
                    @ApiResponse(code = 400, message = "Bad request")
            }
    )
    @PutMapping("/user")
    public ResponseEntity<String> updateUser(@RequestBody UserDto userDto){
        if (userService.updateUser(userDto)){
            return ResponseEntity.ok().body("User successfully updated");
        };
        return ResponseEntity.badRequest().body("User not found");
    }

    @ApiOperation(value="Delete User")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Successful"),
                    @ApiResponse(code = 400, message = "Bad request")
            }
    )
    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id){
        if (userService.deleteUser(id)){
            return ResponseEntity.ok().body("User successfully deleted");
        };
        return ResponseEntity.badRequest().body("User not found");
    }

    @ApiOperation(value="Get All User")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Successful"),
                    @ApiResponse(code = 400, message = "Bad request")
            }
    )
    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @ApiOperation(value="Get User By Id")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Successful"),
                    @ApiResponse(code = 400, message = "Bad request")
            }
    )
    @GetMapping("/user/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") int id){
        if (userService.getUserById(id)!=null) {
            return ResponseEntity.ok().body(userService.getUserById(id));
        }
        return ResponseEntity.badRequest().build();
    }
}
