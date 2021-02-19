package com.bootcamp.springboot.Controller;

import com.bootcamp.springboot.Model.ToDo;
import com.bootcamp.springboot.Service.ToDoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/todo")
public class ToDoController {

    @Autowired
    private ToDoServiceImpl toDoService;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("todoList", toDoService.getAllTodo());
        return "todo-index";
    }

    @GetMapping("/add-to-do-form")
    public String addToDoForm(Model model) {
        ToDo addTodo = new ToDo();
        model.addAttribute("todo", addTodo);
        return "todo-add";
    }

    @PostMapping("/add-to-do")
    public String addToDo(@ModelAttribute("todo") ToDo toDo) {
        toDoService.addToDo(toDo);
        return "redirect:/todo/";
    }

    @GetMapping("/update-to-do-form/{id}")
    public String updateToDoForm(@PathVariable(value = "id") Long id, Model model) {
        ToDo toDo = toDoService.getToDoById(id);
        model.addAttribute("todo", toDo);
        return "todo-update";
    }

    @GetMapping("/delete-to-do/{id}")
    public String deleteToDo(@PathVariable(value = "id") Long id) {
//        toDoService.deleteToDoById(id);
        ToDo toDo = toDoService.getToDoById(id);
        toDo.setDeleted(true);
        toDoService.addToDo(toDo);
        return "redirect:/todo/";
    }
}