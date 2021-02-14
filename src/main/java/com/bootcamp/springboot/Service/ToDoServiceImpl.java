package com.bootcamp.springboot.Service;

import com.bootcamp.springboot.Model.ToDo;
import com.bootcamp.springboot.Repository.IToDoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoServiceImpl implements IToDoService{

    @Autowired
    private IToDoJpaRepository IToDoJpaRepository;

    @Override
    public List<ToDo> getAllTodo() {
        return IToDoJpaRepository.findAll();
    }

    @Override
    public void addToDo(ToDo toDo) {
        IToDoJpaRepository.save(toDo);
    }

    @Override
    public ToDo getToDoById(Long id) {
        Optional<ToDo> optionalToDo = IToDoJpaRepository.findById(id);
        ToDo toDo;
        if (optionalToDo.isPresent()) {
            toDo = optionalToDo.get();
        } else {
            throw new RuntimeException("To Do not found for id: " + id);
        }
        return toDo;
    }

    @Override
    public void deleteToDoById(Long id) {
        IToDoJpaRepository.deleteById(id);
    }
}
