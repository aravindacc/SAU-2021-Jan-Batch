import React,{useState,useEffect} from 'react';
import AddTodo from './addTodo';
import TodoItem from './TodoItem';
import Footer from './Footer';
import './style.css';

function TodoList() {
    const [todos,setTodos]=useState([]);
    const [length,setLength]=useState(0);
    
    const newAdd=(item)=>{
        if(item.text.length<=0 || /^\s*$/.test(item.text)){
            return;
        }
        const newTodos=[...todos,item];
        setTodos(newTodos);
    }
useEffect(()=>{
    var len=0;
    var comp=[];
    comp=[...todos].filter(todo=>todo.isComplete===true);
    len=todos.length-comp.length
    console.log(len);
    setLength(len);
},[todos])

    const completeTodo=id=>{
        let completed=todos.map(todo=>{
            if(todo.id===id){
                todo.isComplete=!todo.isComplete;
            }
            return todo;
        })
        completed=completed.sort((a,b)=>a.isComplete-b.isComplete);
        setTodos(completed);
    }

    const deleteTodo=id=>{
        let deleted=[...todos].filter(todo=> todo.id!==id);
        setTodos(deleted);
    }
    return (
        <div className="todo-app">
            <header>ToDo App</header>
            <AddTodo newadd={newAdd}/>
            {(todos.map((todo)=> <TodoItem todo={todo} key={todo.id} completed={completeTodo} deleted={deleteTodo}/>))}
            <Footer numTodos={length}/>
        </div>
    )
}

export default TodoList;
