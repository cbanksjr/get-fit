import "./App.css";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import HomePage from "./pages/HomePage";
import Workouts from "./pages/Workouts";
import Contact from "./pages/Contact";
import SignIn from "./pages/SignIn.jsx";
import CreateUser from "./pages/CreateUser";
import ResetPassword from "./pages/ResetPassword";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/workouts" element={<Workouts />} />
        <Route path="/contact" element={<Contact />} />
        <Route path="/login" element={<SignIn />} />
        <Route path="/resetpassword" element={<ResetPassword />} />
        <Route path="/createuser" element={<CreateUser />} />
      </Routes>
    </Router>
  );
}

export default App;
