package dev.dienerld.Firstapi.users;

import dev.dienerld.Firstapi.tasks.Task;

import java.util.ArrayList;

public record OutputUserDto(String name, String lastName, ArrayList<Task> tasks) {

    public OutputUserDto(User user) {
        this(user.getName(), user.getLastName(), user.getTasks());
    }
}
