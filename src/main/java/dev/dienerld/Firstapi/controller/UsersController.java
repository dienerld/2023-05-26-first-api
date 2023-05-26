package dev.dienerld.Firstapi.controller;

import dev.dienerld.Firstapi.tasks.CreateTaskDto;
import dev.dienerld.Firstapi.tasks.Task;
import dev.dienerld.Firstapi.users.OutputUserDto;
import dev.dienerld.Firstapi.users.UpdateUserDto;
import dev.dienerld.Firstapi.users.User;
import dev.dienerld.Firstapi.users.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    static List<User> users = new ArrayList<>();

//    GET POST PUT DELETE

    @GetMapping
    public List<OutputUserDto> getUsers() {
        return users.stream().map(OutputUserDto::new).toList();
    }

    // Data transfer object
    @PostMapping
    public OutputUserDto postUsers(@RequestBody UserDto dto) {
        var user = new User(dto);
        users.add(user);
        return new OutputUserDto(user);
    }

    @PutMapping("/{name}")
    public OutputUserDto updateUsers(@RequestBody UpdateUserDto dto, @PathVariable String name) {
        var optionalUser = users.stream()
                .filter(u -> u.getName().equalsIgnoreCase(name))
                .findFirst();
        if (optionalUser.isEmpty()) {
            return null;
        }
        var user = optionalUser.get();
        user.updateUser(dto);

        return new OutputUserDto(user);
    }

    @DeleteMapping("/{name}")
    public String deleteUser(@PathVariable String name) {
        var excluded = users.removeIf(u -> u.getName().equalsIgnoreCase(name));
        if (!excluded) {
            return "User not found";
        }
        return "User deleted";
    }

    @PostMapping("/{name}")
    public void addTask(@PathVariable String name, @RequestBody CreateTaskDto taskDto) {
        var optionalUser = users.stream()
                .filter(u -> u.getName().equalsIgnoreCase(name))
                .findFirst();
        if (optionalUser.isEmpty()) return;

        var user = optionalUser.get();
        var task = new Task(taskDto);

        user.addTask(task);
    }

}
