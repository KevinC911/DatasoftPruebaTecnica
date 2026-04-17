import { useState } from "react"
import { useNavigate } from "react-router";

function Login() {
    const navigate = useNavigate();
    const [username, setUsername] = useState<string>("")
    const [passwd, setPasswd] = useState<string>("")
    const [error, setError] = useState<boolean>(false);
    const [errorMsg, setErrorMsg] = useState<string>("");
    const API_URL = import.meta.env.VITE_API_URL;

    const handleSubmit = async (e: any) => {
        e.preventDefault()
        const response = await fetch(`${API_URL}/auth/login`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                username,
                passwd
            })
        })

        if (!response.ok) {
            setError(true);
            const errorMsg = await response.text();
            setErrorMsg(errorMsg);
        } else {
            setError(false);
            const token = await response.text();
            localStorage.setItem('token', token);
            navigate("/library/books");
        }
    }
    
    return (
        <div className="login-div">
            <section className="login-section">
                <h1 className="login-title">Iniciar Sesión</h1>
                <form className="login-form" onSubmit={handleSubmit}>
                    <input type="text" placeholder="Usuario" className={error ? "login-input error" : "login-input"} value={username} onChange={(e) => setUsername(e.target.value)}/>
                    <input type="password" placeholder="Contraseña" className={error ? "login-input error" : "login-input"} value={passwd} onChange={(e) => setPasswd(e.target.value)}/>
                    {error && <p className="login-error">{errorMsg}</p>}
                    <h3 className="login-forgot-password">¿Olvidaste tu contraseña?</h3>
                    <button type="submit" className="login-button">Iniciar Sesión</button>
                </form>
            </section>
        </div>
    )
}

export default Login;