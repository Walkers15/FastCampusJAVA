package com.example.todoserver.service.repository;

import com.example.todoserver.model.TodoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoModel, Long> {

}
