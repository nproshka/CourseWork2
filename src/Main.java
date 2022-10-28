import Datebook.Task;
import Datebook.TaskManager;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = Integer.parseInt(scanner.nextLine());
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            break;
                        case 2:
                            deleteTask(scanner);
                            break;
                        case 3:
                            getTasksOnSelectedDay(scanner);
                            break;
                        case 4:
                            TaskManager.getDatebookInfo();
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static void inputTask(Scanner scanner) {
        System.out.print("Введите название задачи: ");
        String taskName = scanner.nextLine();

        System.out.print("Введите описание задачи: ");
        String taskDescription = scanner.nextLine();

        System.out.println("Выберите тип задачи: ");
        printMenu2();
        int menu1 = Integer.parseInt(scanner.nextLine());
        String taskType = "Не выбрано";
        switch (menu1) {
            case 1:
                taskType = "Рабочая";
                break;
            case 2:
                taskType = "Личная";
                break;
        }

        System.out.println("Выберите переодичность задачи: ");
        printMenu3();
        int menu2 = Integer.parseInt(scanner.nextLine());
        String taskFrequency = "Не выбрано";
        switch (menu2) {
            case 1:
                taskFrequency = "Однократная";
                break;
            case 2:
                taskFrequency = "Ежедневная";
                break;
            case 3:
                taskFrequency = "Еженедельная";
                break;
            case 4:
                taskFrequency = "Ежемесячная";
                break;
            case 5:
                taskFrequency = "Ежегодная";
                break;
        }

        TaskManager.addNewTask(taskName, taskDescription, taskType, taskFrequency);
    }
    private static void deleteTask(Scanner scanner) {
        System.out.print("Введите id задачи, которую хотите удалить: ");
        TaskManager.removeTask(Integer.parseInt(scanner.nextLine()));

    }
    private static void getTasksOnSelectedDay(Scanner scanner) {
        System.out.print("Введите год: ");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.print("Введите месяц: ");
        int month = Integer.parseInt(scanner.nextLine());

        System.out.print("Введите день: ");
        int day = Integer.parseInt(scanner.nextLine());

        LocalDate date = LocalDate.of(year, month, day);

        TaskManager.getTasksOnDay(date);

    }

    private static void printMenu() {
        System.out.println(
                """
                        1. Добавить задачу
                        2. Удалить задачу
                        3. Получить задачи на указанный день
                        4. Выход
                        """
        );
    }
    private static void printMenu2() {
        System.out.print(
                """
                        1. Рабочая
                        2. Личная
                        """
        );
    }
    private static void printMenu3() {
        System.out.print(
                """
                        1. Однократная
                        2. Ежедневная
                        3. Еженедельная
                        4. Ежемесячная
                        5. Ежегодная
                        """
        );
    }
}