package com.jandy.todolist.service;

import com.jandy.todolist.domain.entity.Todolist;
import com.jandy.todolist.dto.TodolistDto;
import com.jandy.todolist.repository.TodolistRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodolistService {

    private TodolistRepository todolistRepository;

    public TodolistService(TodolistRepository todolistRepository) {
        this.todolistRepository = todolistRepository;
    }

    @Transactional
    public Long saveList(TodolistDto todolistDto) {
        return todolistRepository.save(todolistDto.toEntitiy()).getId();
    }



    // 조회
    @Transactional
    public List<TodolistDto> getTodolist() {
        List<Todolist> TodolistList = todolistRepository.findAll();
        List<TodolistDto> TodolistArrayList = new ArrayList<>();

        for (Todolist todolist : TodolistList) {
            TodolistDto todolistDto = TodolistDto.builder()
                    .id(todolist.getId())
                    .action(todolist.getAction())
                    .title(todolist.getTitle())
                    .description(todolist.getDescription())
                    .createdDate(todolist.getCreatedDate())
                    .completeDate(todolist.getCompleteDate())
                    .build();

            TodolistArrayList.add(todolistDto);
        }

        return TodolistArrayList;

    }

    // 삭제
    @Transactional
    public void deleteList(Long id) {
        todolistRepository.deleteById(id);
    }
}
