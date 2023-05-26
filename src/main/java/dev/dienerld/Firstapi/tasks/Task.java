package dev.dienerld.Firstapi.tasks;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Task {
    private String name;
    private boolean done;

    public Task(CreateTaskDto dto) {
        name = dto.name();
        done = false;
    }
}
