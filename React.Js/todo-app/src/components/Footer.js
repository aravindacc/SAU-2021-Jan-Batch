import React from 'react';
import './style.css';

function Footer(props) {
    return (
        <div className="footer">
            <h1>You have {props.numTodos} Todos Pending...</h1>
        </div>
    )
}

export default Footer;
