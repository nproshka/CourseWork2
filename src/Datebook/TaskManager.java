package Datebook;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class TaskManager {

    static Task task1 = new Task("Планёрка", "Собрание по рабочим вопросам в ЧТ", "Рабочая", LocalDate.ofYearDay(2022, 300), "Еженедельная");
    static Task task2 = new Task("Подготовить рабочее место", "Подготовка рабочего места для начала работы", "Рабочая", LocalDate.ofYearDay(2022, 270), "Ежедневная");
    static Task task3 = new Task("Бухгалтерский отчет", "Бухгалтерский отчёт о приходах и расхода", "Рабочая", LocalDate.ofYearDay(2022, 243), "Ежемесячная");
    static Task task4 = new Task("Генеральная уборка", "Генеральная уборка в квартире, а также возможная перестановка по необходимости", "Личная", LocalDate.ofYearDay(2022, 1), "Ежегодная");

//    Создал, чтобы в списке уже были какие-то задачи для примера работы методов, но задачи, конечно же, создаются через Scanner

    static Map<Integer, Task> dateBook = new HashMap<>(Map.ofEntries(Map.entry(task1.getId(), task1), Map.entry(task2.getId(), task2), Map.entry(task3.getId(), task3), Map.entry(task4.getId(), task4)));

    public static void addNewTask(String name, String description, String type, String frequency, LocalDate createDate) throws IllegalArgumentException {
        try {
            Task temp = new Task(name, description, type, createDate, frequency);
            dateBook.put(temp.getId(), temp);
            System.out.println(temp);
        } catch (IllegalArgumentException e) {
            System.out.println("ДАННЫЕ НЕКОРЕКТНЫ!");
            System.out.println();
//            Почему-то через e.getMassage() не выводились сообщения об ошибки, которые я написал в классе Task
        }
    }

    public static void removeTask(int id) {
        dateBook.remove(id);
    }

    public static void getDatebookInfo() {
        System.out.println("На текущий момент в ежедневнике записаны следующие задачи: \n");
        for (Map.Entry<Integer, Task> entry : dateBook.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }
    }

//    public static LocalDate getNextTaskDay(Task task) {
//
//        LocalDate date = task.getCreateDate();
//
//        if (task.getFrequency().equals("Еженедельная")) {
//            while (date.isBefore(LocalDate.now())) {
//                date = date.plusDays(7);
//            }
//        } else if (task.getFrequency().equals("Ежедневная")) {
//            while (date.isBefore(LocalDate.now())) {
//                date = date.plusDays(1);
//            }
//        } else if (task.getFrequency().equals("Ежемесячная")) {
//            while (date.isBefore(LocalDate.now())) {
//                date = date.plusMonths(1);
//            }
//        } else if (task.getFrequency().equals("Ежегодная")) {
//            while (date.isBefore(LocalDate.now())) {
//                date = date.plusYears(1);
//            }
//        }
//        return date;
////        System.out.println("Следующий день выполнения задачи - " + date);
//    }
//
//    public static void getTasksOnDay(LocalDate date) {
//        System.out.println(date + " делаем следующие задачи:");
//        for (Map.Entry<Integer, Task> entry : dateBook.entrySet()) {
//            if (getNextTaskDay(entry.getValue()).equals(date)) {
//                System.out.println(entry.getValue().getName());
//            }
//        }
//    }
    public static void getTasksOnDay(LocalDate date) {
        System.out.println(date + " делаем следующие задачи:");
        for (Map.Entry<Integer, Task> entry : dateBook.entrySet()) {
            if (entry.getValue().getFrequency().equals("Ежедневная")) {
                if (date.equals(entry.getValue().getCreateDate()) || date.isAfter(entry.getValue().getCreateDate())) {
                    System.out.println(entry.getValue().getName());
                }
            }
            if (entry.getValue().getFrequency().equals("Еженедельная")) {
                if (date.getDayOfWeek().equals(entry.getValue().getCreateDate().getDayOfWeek()) && (date.equals(entry.getValue().getCreateDate()) || date.isAfter(entry.getValue().getCreateDate()))) {
                    System.out.println(entry.getValue().getName());
                }
            }
            if (entry.getValue().getFrequency().equals("Ежемесячная")) {
                if (date.getDayOfMonth() == entry.getValue().getCreateDate().getDayOfMonth() && (date.equals(entry.getValue().getCreateDate()) || date.isAfter(entry.getValue().getCreateDate()))) {
                    System.out.println(entry.getValue().getName());
                }
            }
            if (entry.getValue().getFrequency().equals("Ежегодная")) {
                if (date.getMonth().equals(entry.getValue().getCreateDate().getMonth()) && date.getDayOfMonth() == entry.getValue().getCreateDate().getDayOfMonth()) {
                    System.out.println(entry.getValue().getName());
                }
            }
            }
        }
    }
