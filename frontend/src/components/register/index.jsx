import "./register.css"

const Register = () => {
    return(
        <div className="register">
            <div className="registerTitle">
            <img src="./images/splashart-lol1.png" alt="Splashart-lol1" />
                <h2>SIGN UP</h2>
            </div>
            <div className="registerCred">
                <h3>USERNAME</h3>
                <input type="text" required/>
                <h3>EMAIL</h3>
                <input type="email" required/>
                <h3>PASSWORD</h3>
                <input type="password" required/>
                <h3>CONFIRM PASSWORD</h3>
                <input type="password" required/>
                <label htmlFor=""><input type="checkbox" className="check"/> 
                    i accept the <a href="">TERMS & CONDITIONS</a></label>
                <button type="submit">LOGIN</button>
            </div>
        </div>
    )
}

export default Register;