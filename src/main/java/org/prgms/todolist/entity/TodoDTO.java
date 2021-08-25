package org.prgms.todolist.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public abstract class TodoDTO {

    public static class Create {
        private String content;
        private String status;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    public static class Read {
        @JsonProperty("id")
        private final long id;
        @JsonProperty("content")
        private final String content;
        @JsonProperty("updatedAt")
        private final LocalDate updatedAt;
        @JsonProperty("status")
        private final String status;

        public long getId() {
            return id;
        }

        public String getContent() {
            return content;
        }

        public LocalDate getUpdatedAt() {
            return updatedAt;
        }

        public String getStatus() {
            return status;
        }

        public Read(Todo todo) {
            this.id = todo.id;
            this.content = todo.content;
            this.updatedAt = todo.updatedAt;
            this.status = todo.done ? Todo.DONE : Todo.NOT_DONE;
        }
    }

    public static class Update {
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
