import React,{useState,useEffect} from 'react';
import './style.css';


function AddTodo(props) {
    const [input,setInput]=useState('');
    
    useEffect(()=>{
        setInput(input);
    },[input]);

    const handleChange=(e)=>{
        setInput(e.target.value);
    }
    const capitalise=(input)=>{
        if(input.length>0){
            const words = input.split(" ");
            for (let i = 0; i < words.length; i++) {
                words[i] = words[i][0].toUpperCase() + words[i].substr(1);
            }
            return words.join(" ");
        }
        return '';
    }

    const handleSubmit=(e)=>{
        e.preventDefault();
        props.newadd({
            text:capitalise(input),
            isComplete: false,
            id: Date.now(),//Math.floor(Math.random()*5000),
        });
        setInput('');
    }
    
    return (
        <div className="wrapper">
            <form className="addTodo" onSubmit={handleSubmit}>
                <input type="text" placeholder="Add the Todo" value={input} className="input" onChange={handleChange}/>
                <button className="button">
                    <i className="fas fa-plus-square"></i>
                </button>
            </form>
        </div>
    )
}

export default AddTodo;
