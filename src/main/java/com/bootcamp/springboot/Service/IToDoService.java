package com.bootcamp.springboot.Service;

import com.bootcamp.springboot.Model.ToDo;

import java.util.List;

public interface IToDoService {
    List<ToDo> getAllTodo();
    void addToDo(ToDo toDo);
    ToDo getToDoById(Long id);
    void deleteToDoById(Long id);
}
