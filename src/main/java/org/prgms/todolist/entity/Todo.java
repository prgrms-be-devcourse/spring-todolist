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
    protected LocalDate created;

    @Column(name = "TODO_DONE")
    protected boolean done = false;

    public Todo(String content) {
        this.content = content;
        this.created = LocalDate.now();
    }

    public Todo(String content, LocalDate created) {
        this.content = content;
        this.created = created;
    }

    public Todo() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
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

    public static class Create extends Todo {

    }

    public static class Read extends Todo {
        private Read() {}
        private Read(String content, LocalDate created, boolean done) {
            this.content = content;
            this.created = created;
            this.done = done;
        }

        public Read getInstance() {
            return new Read(content, created, done);
        }
    }
}
