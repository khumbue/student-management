package com.ultech.controller;

import com.ultech.model.ApiResponse;
import com.ultech.model.User;
import com.ultech.model.UserDto;
import com.ultech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /*@RequestMapping(value = "/file", method = RequestMethod.POST, consumes = "multipart/form-data")
    public @ResponseBody
    ResponseEntity<String> saveUser(@RequestParam("file") MultipartFile file, @RequestPart("info") UserDto user) {
//        return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.", userService.save(user));
        user.setFile(file);
        userService.save(user);
        return ResponseEntity.ok("User saved successfully.");
    }*/

//    @PostMapping("/file")
//    @RequestMapping(value = "/file", method = RequestMethod.POST, consumes = "multipart/form-data")
//    public ApiResponse<User> saveUser(@RequestPart("uploadFile") MultipartFile file, @RequestPart("user") UserDto user){
//        user.setFile(file);
//        return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.",userService.save(user));
//    }

    @GetMapping
    public ApiResponse<List<User>> listUser() {
        return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.", userService.findAll());
    }

    @GetMapping("/{id}")
    public ApiResponse<User> getOne(@PathVariable int id) {
        return new ApiResponse<>(HttpStatus.OK.value(), "User fetched successfully.", userService.findById(id));
    }

    @PutMapping("/{id}")
    public ApiResponse<UserDto> update(@RequestBody UserDto userDto) {
        return new ApiResponse<>(HttpStatus.OK.value(), "User updated successfully.", userService.update(userDto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable int id) {
        userService.delete(id);
        return new ApiResponse<>(HttpStatus.OK.value(), "User fetched successfully.", null);
    }

    @PostMapping("/file")
    public ApiResponse<User> multiUploadFileModel(@ModelAttribute UserDto user) {

        System.out.println("Multiple file upload! With UploadModel");

        try {
            return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.", userService.save(user));

        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse<User>(HttpStatus.OK.value(), e.getMessage(), null);
        }

    }
}
