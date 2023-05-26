package dev.dienerld.Firstapi.users;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String lastName;
    private ArrayList<String> tasks;

    public User(UserDto dto) {
        this.name = dto.name();
        this.lastName = dto.lastName();
        this.tasks = new ArrayList<>();
    }

    public void updateUser(UserDto dto) {
        this.name = dto.name();
        this.lastName = dto.lastName();
    }
}
