package ru.kamalova.todo_list_app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.kamalova.todo_list_app.Task;
import ru.kamalova.todo_list_app.TaskDTO;
import ru.kamalova.todo_list_app.CreateTaskDTO;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    // Преобразование из Task в TaskDTO
    TaskDTO toDto(Task task);

    // Преобразование из CreateTaskDTO в Task
    @Mapping(source = "title", target = "title")
    Task fromDto(CreateTaskDTO dto);
}