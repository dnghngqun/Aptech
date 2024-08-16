import React,{Component} from "react";

class Registration extends Component{
    render(){
        return (
            <div>
                <h1>This is Registration Form</h1>
                <h2>Test</h2>
                <Title_body></Title_body>
                <Form_body></Form_body>
            </div>
        );
    }
}

class Title_body extends React.Component{
    render(){
        return (
            <div>
                <h1>FPT Aptech</h1>
            </div>
        );
    }
}

class Form_body extends React.Component{
    render(){
        return (
            <div>
                Name: <input type ="text"/>
                Email: <input type="email"/>
                Password: <input type ="password"/>
                <input type="submit"/>
            </div>
        );
    }
}

export default Registration;