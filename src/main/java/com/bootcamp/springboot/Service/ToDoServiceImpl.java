package com.bootcamp.springboot.Service;

import com.bootcamp.springboot.Model.ToDo;
import com.bootcamp.springboot.Repository.IToDoJpaRepository;
import com.bootcamp.springboot.Service.Interface.IToDoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ToDoServiceImpl implements IToDoService {

    private final IToDoJpaRepository iToDoJpaRepository;

    public ToDoServiceImpl(IToDoJpaRepository iToDoJpaRepository) {
        this.iToDoJpaRepository = iToDoJpaRepository;
    }

    @Override
    public List<ToDo> getAllTodo() {
        return iToDoJpaRepository.findAll().stream().filter(toDo -> !toDo.isDeleted()).collect(Collectors.toList());
    }

    @Override
    public void addToDo(ToDo toDo) {
        iToDoJpaRepository.save(toDo);
    }

    @Override
    public ToDo getToDoById(Long id) {
        Optional<ToDo> optionalToDo = iToDoJpaRepository.findById(id);
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
        iToDoJpaRepository.deleteById(id);
    }
}
