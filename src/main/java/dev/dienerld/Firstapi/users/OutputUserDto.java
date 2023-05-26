package dev.dienerld.Firstapi.users;

import java.util.ArrayList;

public record OutputUserDto(String name, String lastName, ArrayList<String> tasks) {

    public OutputUserDto(User user) {
        this(user.getName(), user.getLastName(), user.getTasks());
    }
}
