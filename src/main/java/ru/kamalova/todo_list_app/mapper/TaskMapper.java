package ru.kamalova.todo_list_app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.kamalova.todo_list_app.model.Task;
import ru.kamalova.todo_list_app.dto.TaskDTO;
import ru.kamalova.todo_list_app.dto.CreateTaskDTO;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDTO toDto(Task task);

    @Mapping(source = "title", target = "title")
    Task fromDto(CreateTaskDTO dto);
}