import {http} from './http'
import {Todo} from "@/types/todo";

export const createTodo = async (param) => {
    const {data} = await http.post('/todos', param)

    return new Todo(data);
}

export const fetchTodo = async (id) => {
    const {data} = await http.get(`/todos/${id}`)

    return new Todo(data);
}

export const fetchTodos = async (status) => {
    const {data} = await http.get(`/todos?status=${status}`)

    return data.map(response => new Todo(response))
}

export const updateTodo = async (id, param) => {
    const {data} = await http.put(`/todos/${id}`, param)

    return new Todo(data);
}

export const deleteTodo = async (id) => {
    await http.delete(`/todos/${id}`);
}

export const changeStatus = async (id, status) => {
    const {data} = await http.patch(`/todos/${id}/${status}`)

    return new Todo(data);
}