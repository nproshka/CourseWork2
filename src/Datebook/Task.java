package Datebook;

import java.time.LocalDate;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Task {

    public static final AtomicInteger COUNTER = new AtomicInteger(1);

    private String name;
    private String description;
    private String type;
    private final LocalDate createDate;
    private final String frequency;
    private final int id;

    public Task(String name, String description, String type, LocalDate createDate, String frequency) {
        setName(name);
        setDescription(description);
        setType(type);

        if (createDate == null) {
            this.createDate = LocalDate.now();
        } else {
            this.createDate = createDate;
        }

        if (frequency == null || frequency.isEmpty() || frequency.isBlank()) {
            throw new IllegalArgumentException("Пожалуйста, введите переодичность задачи!");
        }
        this.frequency = frequency;


        this.id = COUNTER.getAndIncrement();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Пожалуйста, введите название задачи корректно");
        } else {
            this.name = name;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.isEmpty() || description.isBlank()) {
            throw new IllegalArgumentException("Пожалуйста, введите описание задачи корректно");
        } else {
            this.description = description;
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type == null || type.isEmpty() || type.isBlank()) {
            throw new IllegalArgumentException("Пожалуйста, введите тип задачи корректно");
        } else {
            this.type = type;
        }
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public int getId() {
        return id;
    }

    public String getFrequency() {
        return frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return name + ". " + description + ". Тип задачи - " + type + ". Дата задачи - " + createDate + ". Задача - " + frequency + "\n";
    }
}
