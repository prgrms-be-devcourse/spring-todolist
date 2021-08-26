package org.prgms.todolist.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Todo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TODO_ID")
    protected long id;

    @Column(name = "TODO_CONTENT")
    protected String content;

    @Column(name = "CREATED_DATE")
    protected LocalDate updatedAt;

    @Column(name = "TODO_DONE")
    protected boolean done = false;

    public static final String NOT_DONE = "ACTIVE";
    public static final String DONE = "COMPLETE";

    public enum Updatable {
        content, done
    }

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

    @Override
    public String toString() {
        return String.format("[TODO #%d] %s / %s", id, content, updatedAt);
    }
}
