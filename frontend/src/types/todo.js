export class Todo {
    id;
    content;
    status;
    updatedAt;
    isEdit

    constructor({id, content, status, updatedAt}) {
        this.id = id;
        this.content = content;
        this.status = status;
        this.updatedAt = updatedAt;
        this.isEdit = false;
    }

    isComplete() {
        return this.status === 'COMPLETE'
    }

    isActive() {
        return this.status === 'ACTIVE'
    }
}