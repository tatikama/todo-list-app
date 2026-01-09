    package ru.kamalova.todo_list_app;

    import lombok.Getter;
    import lombok.Setter;

    @Setter
    @Getter
    public class CreateTaskDTO {

        // Геттеры и сеттеры
        private String title;

        // Конструктор (можно и без него, если устраивает умолчание)
        public CreateTaskDTO() {}

    }
