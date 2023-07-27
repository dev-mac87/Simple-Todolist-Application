import repository.TodolistRepository;
import repository.TodolistRepositoryImpl;
import servivce.TodolistService;
import servivce.TodolistServiceImpl;
import view.TodolistView;

public class SimpleTodoListAppV2 {
    public static void main(String[] args) {
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
        TodolistView todolistView = new TodolistView(todolistService);

        todolistView.showTodolist();
    }
}
