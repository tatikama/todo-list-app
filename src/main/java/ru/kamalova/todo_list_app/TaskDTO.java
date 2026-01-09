    package ru.kamalova.todo_list_app;

    import lombok.Getter;
    import lombok.Setter;

    @Setter
    @Getter
    public class TaskDTO {

        // Геттеры и сеттеры
        private Long id;
        private String title;
        private boolean completed;

        // Конструктор (можно и без него, если устраивает умолчание)
        public TaskDTO() {}

    }
