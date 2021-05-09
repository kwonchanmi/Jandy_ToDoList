package com.jandy.todolist.controller;

import com.jandy.todolist.dto.TodolistDto;
import com.jandy.todolist.service.TodolistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class Todolistcontroller {


    private TodolistService todolistService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    public Todolistcontroller(TodolistService todolistService) {
        this.todolistService = todolistService;
    }

    @GetMapping(value = "/")
    public String home(Model model) {
        List<TodolistDto> TodolistDtoList = todolistService.getTodolist();
        model.addAttribute("list", TodolistDtoList);
        return "home";
    }

    @PostMapping("/post")
    public String write(TodolistDto todolistDto) {
        todolistService.saveList(todolistDto);
        return "redirect:/";
    }

    // 삭제
    @PostMapping("/post/{id}")
    public String delete(@PathVariable("id") Long id){
        todolistService.deleteList(id);
        logger.warn(String.valueOf(id));
        return "redirect:/";
    }


}

