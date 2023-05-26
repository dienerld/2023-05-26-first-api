package dev.dienerld.Firstapi.users;


import dev.dienerld.Firstapi.tasks.Task;
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
    private ArrayList<Task> tasks;

    public User(UserDto dto) {
        this.name = dto.name();
        this.lastName = dto.lastName();
        this.tasks = new ArrayList<>();
    }

    public void updateUser(UpdateUserDto dto) {
        if (dto.lastName() != null) this.lastName = dto.lastName();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
}
