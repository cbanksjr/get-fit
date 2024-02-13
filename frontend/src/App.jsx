/* eslint-disable react/jsx-no-undef */
/* eslint-disable no-unused-vars */
import "./App.css";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import LandingPage from "./pages/LandingPage";
import HomePage from "./pages/HomePage";
import About from "./pages/About";
import Workouts from "./pages/Workouts";
import Nutrition from "./pages/Nutrition";
import Contact from "./pages/Contact";
import Login from "./pages/Login";
import CreateUser from "./pages/CreateUser";
import ResetPassword from "./pages/ResetPassword";
import User from "./pages/User";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<LandingPage />} />
        <Route path="/home" element={<HomePage />} />
        <Route path="/about" element={<About />} />
        <Route path="/nutrition" element={<Nutrition />} />
        <Route path="/workouts" element={<Workouts />} />
        <Route path="/contact" element={<Contact />} />
        <Route path="/login" element={<Login />} />
        <Route path="/resetpassword" element={<ResetPassword />} />
        <Route path="/user" element={<User />} />
        <Route path="/createuser" element={<CreateUser />} />
        <Route path="/user" element={<User />} />
      </Routes>
    </Router>
  );
}

export default App;
