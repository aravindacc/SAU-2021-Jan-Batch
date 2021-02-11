import './App.css';
import TodoList from './components/todoList';
import React,{Component} from 'react';

class App extends Component{
  render(){
    return (
          <div className="App">
            <TodoList className="todo-app"/>
          </div>
        );
  }
}

export default App;
