package com.jandy.todolist.repository;

import com.jandy.todolist.domain.entity.Todolist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodolistRepository extends JpaRepository<Todolist,Long> {
}

