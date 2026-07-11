import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { register } from "../services/AuthService";
import "../styles/Register.css";

function Register() {
  const navigate = useNavigate();

  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleRegister = async (e) => {
    e.preventDefault();

    try {
      await register(username, password);

      alert("Registration Successful!");

      navigate("/");
    } catch (error) {
      console.error(error);

      if (error.response) {
        alert(error.response.data || "Registration Failed");
      } else {
        alert("Unable to connect to the server.");
      }
    }
  };

  return (
    <div className="register-container">
      <div className="register-card">

        <h2 className="register-title">Create Account</h2>

        <form onSubmit={handleRegister}>

          <div className="form-group">
            <label>Username</label>

            <input
              type="text"
              className="form-control"
              placeholder="Enter Username"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
              required
            />
          </div>

          <div className="form-group">
            <label>Password</label>

            <input
              type="password"
              className="form-control"
              placeholder="Enter Password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>

          <button className="register-btn" type="submit">
            Register
          </button>

        </form>

        <p className="login-text">
          Already have an account? <Link to="/">Login</Link>
        </p>

      </div>
    </div>
  );
}

export default Register;