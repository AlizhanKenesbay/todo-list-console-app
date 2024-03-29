import java.util.ArrayList;
import java.util.List;

public class TodoListApp {
    private List<String> todoList = new ArrayList<>();

    public TodoListApp() {

    }

    public void addTask(String taskToAdd) {
        todoList.add(taskToAdd);
    }

    public void displayList() throws EmptyTodoListException{
        if (!todoList.isEmpty()) {
            System.out.println("Ваш список задач:");
            for (int i = 0; i < todoList.size(); i++) {
                System.out.println(STR."\{i + 1}. \{todoList.get(i)}");
            }
        } else {
            throw new EmptyTodoListException("Список дел пуст...");
        }
    }

    public void removeTask(int taskToRemove) {
        try {
            todoList.remove(taskToRemove - 1);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Ошибка! Выбранная задача отсутствует в списке");
        }
    }
}