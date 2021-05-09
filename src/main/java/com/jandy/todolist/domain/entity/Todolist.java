package com.jandy.todolist.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Todolist {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length=30, nullable=false)
    private String action;

    @Column(length=100,nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @Column(nullable = false)
    private String completeDate;

    @Builder
    public Todolist(Long id, String action, String title, String description, LocalDateTime createdDate, String completeDate) {
        this.id = id;
        this.action = action;
        this.title = title;
        this.description = description;
        this.createdDate = createdDate;
        this.completeDate = completeDate;
    }
}

