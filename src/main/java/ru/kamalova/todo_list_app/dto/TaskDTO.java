    package ru.kamalova.todo_list_app.dto;

    import lombok.Getter;
    import lombok.Setter;

    @Setter
    @Getter
    public class TaskDTO {

        private Long id;
        private String title;
        private boolean done;

        // Безаргументный конструктор
        public TaskDTO() {
        }

        // Конструктор с аргументами
        public TaskDTO(Long id, String title, boolean done) {
            this.id = id;
            this.title = title;
            this.done = done;
        }
    }