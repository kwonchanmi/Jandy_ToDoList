package com.jandy.todolist.dto;

import com.jandy.todolist.domain.entity.Todolist;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TodolistDto {

    private Long id;
    private String action;
    private String title;
    private String description;
    private LocalDateTime createdDate;
    private String completeDate;

    public Todolist toEntitiy() {
        Todolist build = Todolist.builder()
                .id(id)
                .action(action)
                .title(title)
                .description(description)
                .createdDate(createdDate)
                .completeDate(completeDate)
                .build();

        return build;
    }

    @Builder
    public TodolistDto(Long id, String action, String title, String description, LocalDateTime createdDate, String completeDate) {
        this.id = id;
        this.action = action;
        this.title = title;
        this.description = description;
        this.createdDate = createdDate;
        this.completeDate = completeDate;
    }
}
