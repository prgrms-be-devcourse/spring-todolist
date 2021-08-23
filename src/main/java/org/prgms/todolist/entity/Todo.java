package org.prgms.todolist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Todo {

    @Id
    @Column(name = "TODO_ID")
    protected long id;

    @Column(name = "TODO_CONTENT")
    protected String content;

    @Column(name = "CREATED_DATE")
    protected LocalDate updatedAt;

    @Column(name = "TODO_DONE")
    protected boolean done = false;

    public Todo(String content) {
        this.content = content;
        this.updatedAt = LocalDate.now();
    }

    public Todo(String content, LocalDate updatedAt) {
        this.content = content;
        this.updatedAt = updatedAt;
    }

    public Todo() {}

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void updateContent(String content) {
        this.content = content;
        updatedAt = LocalDate.now();
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void toggle() {
        done = !done;
    }

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

    // TODO: are you sure it is out of persistence context?
    public static class Read extends Todo {
        private Read() {}
        private Read(String content, LocalDate created, boolean done) {
            this.content = content;
            this.updatedAt = created;
            this.done = done;
        }

        public Read getInstance() {
            return new Read(content, updatedAt, done);
        }
    }

    public static class Update {
        String content;
    }
}
