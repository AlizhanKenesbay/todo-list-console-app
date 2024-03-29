import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TodoListApp todoListApp = new TodoListApp();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    \nВыберите действие:
                    1. Добавить задачу
                    2. Вывести список задач
                    3. Удалить задачу
                    4. Изменить задачу
                    0. Выход""");
            int userChoice = getUserChoice(scanner);
            if (userChoice == 0) return;
            processUserChoice(userChoice, todoListApp, scanner);
        }
    }

    private static int getUserChoice(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Неправильный ввод, повторите попытку!");
            }
        }
    }

    private static void processUserChoice(int userChoice, TodoListApp todoListApp, Scanner scanner) {
        switch (userChoice) {
            case 1 -> addTask(todoListApp, scanner);
            case 2 -> displayTaskList(todoListApp);
            case 3 -> removeTask(todoListApp, scanner);
            case 4 -> editTask(todoListApp, scanner);
            default -> System.out.println("Неправильный ввод");
        }
    }

    private static void addTask(TodoListApp todoListApp, Scanner scanner) {
        System.out.print("Введите задачу для планирования: ");
        String userTask = scanner.nextLine();
        todoListApp.addTask(userTask);
    }

    private static void displayTaskList(TodoListApp todoListApp) {
        try {
            todoListApp.displayList();
        } catch (EmptyTodoListException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void removeTask(TodoListApp todoListApp, Scanner scanner) {
        try {
            todoListApp.displayList();
            System.out.print("Введите номер задачи для удаления из списка (0 - вернуться): ");
            int userTaskToRemove = Integer.parseInt(scanner.nextLine());
            if (userTaskToRemove == 0) return;
            todoListApp.removeTask(userTaskToRemove);
        } catch (NumberFormatException ex) {
            System.out.println("Неправильный ввод, повторите попытку!\n");
            removeTask(todoListApp, scanner);
        } catch (EmptyTodoListException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void editTask(TodoListApp todoListApp, Scanner scanner) {
        try {
            todoListApp.displayList();
            System.out.print("Введите номер задачи, которую вы хотите изменить: ");
            int userTaskToEdit = Integer.parseInt(scanner.nextLine());
            System.out.print("Edit mode: ");
            String editedTask = scanner.nextLine();
            todoListApp.editTask(userTaskToEdit, editedTask);
        } catch (NumberFormatException ex) {
            System.out.println("Неправильный ввод, повторите попытку!\n");
            editTask(todoListApp, scanner);
        } catch (EmptyTodoListException ex) {
            System.out.println(ex.getMessage());
        }
    }
}