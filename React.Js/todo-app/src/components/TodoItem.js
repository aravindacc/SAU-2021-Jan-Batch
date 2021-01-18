import React from 'react';
import {MdDeleteForever} from 'react-icons/md';
import './style.css';

function TodoItem(props) {
    return (
        <div className={props.todo.isComplete?'todo-complete':'todo'}>
            <div onClick={()=>props.completed(props.todo.id)} className="clickable">{props.todo.text}</div>
            <div className="icons">
            <MdDeleteForever className="delete-icon" onClick={()=>props.deleted(props.todo.id)}/>
        </div>
        </div>
    )
}

export default TodoItem;
