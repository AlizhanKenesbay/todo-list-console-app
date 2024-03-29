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
                    0. Выход""");
            String userInput = scanner.nextLine();
            int userChoice;
            try {
                userChoice = Integer.parseInt(userInput);
            } catch (NumberFormatException ex) {
                System.out.println("Неправильный ввод, повторите попытку!");
                continue;
            }

            switch (userChoice) {
                case 1 -> {
                    System.out.print("Введите задачу для планирования: ");
                    String userTask = scanner.nextLine();
                    todoListApp.addTask(userTask);
                }
                case 2 -> {
                    try {
                        todoListApp.displayList();
                    } catch (EmptyTodoListException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                case 3 -> {
                    try {
                        todoListApp.displayList();
                    } catch (EmptyTodoListException ex) {
                        System.out.println(ex.getMessage());
                    }
                    System.out.print("Введите номер задачи для удаления из списка: ");
                    int userTaskToRemove;
                    try {
                        userTaskToRemove = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException ex) {
                        System.out.println("Неправильный ввод, повторите попытку!");
                        continue;
                    }
                    todoListApp.removeTask(userTaskToRemove);
                }
                case 0 -> {
                    return;
                }
                default -> System.out.println("Неправильный ввод");
            }
        }
    }
}