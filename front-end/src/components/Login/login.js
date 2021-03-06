import React from "react";
import {withRouter} from "react-router";
import {ACCESS_TOKEN} from "../../constants";

const Login = (props) => {

    const validate = (e) => {
        e.preventDefault();

        let mail = document.getElementById("address");
        let pass = document.getElementById("password");
        let message = document.getElementById("message");

        message.hidden = !(mail.value === "" || pass.value.length <= 6);

        let request = {
            usernameOrEmail: mail.value,
            password: pass.value
        };
        props.onLogin(request)
            .then((response) => {
                localStorage.setItem(ACCESS_TOKEN, response.data.accessToken);
                props.getUser();
                props.history.push('turniri');
            });
    };

    return (
        <form onSubmit={validate}>
            <div className="col-sm-4 ml-auto mr-auto border rounded p-5 mt-5 bg-dark text-primary"
                 style={{opacity: "0.9"}}>
                <label htmlFor="address">Email:</label>
                <input id="address" className="form-control text-center" autoFocus type="text"
                       placeholder="example@example.com"/>
                <br/>
                <label htmlFor="password">Лозинка:</label>
                <input id="password" className="form-control text-center" type="password" placeholder="******"/>
                <hr/>
                <div id="message" hidden>
                    <p className="text-danger"><b>Невалидни внесени податоци</b></p>
                </div>
                <br/>
                <div className="col-sm-8 ml-auto mr-auto">
                    <button type={'submit'} className="btn btn-primary btn-block">Логирај се</button>
                </div>
            </div>
        </form>
    )
};

export default withRouter(Login)