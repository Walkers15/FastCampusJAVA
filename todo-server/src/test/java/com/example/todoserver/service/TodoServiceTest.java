package com.example.todoserver.service;

import com.example.todoserver.model.TodoModel;
import com.example.todoserver.model.TodoRequest;
import com.example.todoserver.service.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoService todoService;

    @Test
    void add() {
        when(this.todoRepository.save(any(TodoModel.class))).then(AdditionalAnswers.returnsFirstArg());

        TodoRequest expected = new TodoRequest();
        expected.setTitle("Test Title!");

        TodoModel actual = this.todoService.add(expected);

        assertEquals(actual.getTitle(), expected.getTitle());
    }

    @Test
    void searchById() {
        TodoModel entity = new TodoModel();
        entity.setId(1L);
        entity.setTitle("test");
        entity.setOrder(0L);
        entity.setCompleted(false);
        Optional<TodoModel> optional = Optional.of(entity);
        given(this.todoRepository.findById(anyLong())).willReturn(optional);

        TodoModel actual = this.todoService.searchById(1L);

        TodoModel expected = optional.get();

        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getTitle(), actual.getTitle());
        assertEquals(expected.getCompleted(), actual.getCompleted());
        assertEquals(expected.getOrder(), actual.getOrder());
    }

    @Test
    public void searchByIdFailed() {
        given(this.todoRepository.findById(anyLong())).willReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> this.todoService.searchById(1L));
    }
}