package test.service;

import repository.TodolistRepository;
import repository.TodolistRepositoryImpl;
import servivce.TodolistService;
import servivce.TodolistServiceImpl;

public class TodolistServiceTest {
    public static void main(String[] args) {
        testRemoveTodoList();
    }

    public static void testShowTodolist() {
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);

        todolistService.showTodolist();
    }

    public static void testAddTodolist() {
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);

        todolistService.addTodolist("Belajar Java Dasar");
        todolistService.addTodolist("Belajar Java OOP");
        todolistService.addTodolist("Belajar Java Standard Classes");

        todolistService.showTodolist();
    }

    public static void  testRemoveTodoList() {
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);

        todolistService.addTodolist("Belajar Java Dasar");
        todolistService.addTodolist("Belajar Java OOP");
        todolistService.addTodolist("Belajar Java Standard Classes");

        todolistService.showTodolist();

        todolistService.removeTodolist(5);

        todolistService.removeTodolist(2);
        todolistService.showTodolist();

        todolistService.removeTodolist(2);
        todolistService.showTodolist();

        todolistService.removeTodolist(2);
        todolistService.showTodolist();

        todolistService.removeTodolist(1);
        todolistService.showTodolist();
    }
}
