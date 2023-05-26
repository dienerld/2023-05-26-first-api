package dev.dienerld.Firstapi.controller;

import dev.dienerld.Firstapi.users.OutputUserDto;
import dev.dienerld.Firstapi.users.User;
import dev.dienerld.Firstapi.users.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UsersController {

    static ArrayList<User> users = new ArrayList<>();

//    GET POST PUT DELETE

    @GetMapping
    public ArrayList<User> getUsers() {
        return users;
    }


    // Data transfer object
    @PostMapping
    public OutputUserDto postUsers(@RequestBody UserDto dto) {

        var user = new User(dto);
        users.add(user);

        return new OutputUserDto(user);
    }

    @PutMapping
    public OutputUserDto updateUsers(@RequestBody UserDto dto) {
        var user = users.get(0);

        user.updateUser(dto);

        return new OutputUserDto(user);
    }

}
