import './Login.css';

const Login = () => {
    return (
        <div className="fullLogin">
            <p>Login Screen</p>
            <div className="forms">
                <form>
                <label>
                    Name:
                    <input type="text" name="username" />
                </label>
                </form>
                <form>
                <label>
                    Name:
                    <input type="text" name="password" />
                </label>
                </form>
            </div>
            <div className="buttons">
                <button className="loginButton">
                    Login
                </button>
                <button className="createAccountButton">
                    <p>Don't have an account? Create one</p>
                </button>
            </div>
        </div>
    );
}

export default Login;