import "./login.css"

const Login = () => {
    return (
        <div className="login">
            <div className="loginTitle">
            <img src="./images/splashart-lol1.png" alt="Splashart-lol1" />
                <h2>LOGIN</h2>
            </div>
            <div className="loginCred">
                <h3>EMAIL</h3>
                <input type="email" required/>
                <h3>PASSWORD</h3>
                <input type="password"/>
                <label htmlFor=""><input type="checkbox" className="check"/> Remember Me</label>
                <button>LOGIN</button>
            </div>
        </div>
    )
}

export default Login;