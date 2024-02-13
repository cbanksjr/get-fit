/**
 * eslint-disable react/no-unescaped-entities
 *
 * @format
 */

/* eslint-disable react/prop-types */
/* eslint-disable no-unused-vars */
import { useState } from "react"
import { useNavigate } from "react-router-dom";
import axios from 'axios'

const CreateUser = () => {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [userName, setUserName] = useState("");
  const [password, setPassword] = useState("");
  const [showPassword, setShowPassword] = useState(false);
  const navigate = useNavigate();

  const toggleShowPassword = () => {
    setShowPassword(!showPassword);
  }

  const handleSubmit = async (e) => {
    e.preventDefault();
    // Create a user object
    await axios
        .post('/api/users/newuser', {
          firstName,
          lastName,
          email,
          userName,
          password
        })
        .then((response) => console.log(response.data))
        .then(navigate('/login'))
        .catch((error) => console.error(error))

    // Clear the form fields
    setFirstName("");
    setLastName("");
    setEmail("");
    setUserName("");
    setPassword("");
  };

  return (
    <>
      {/**Creating and styling cards for each member*/}
      <div className="flex flex-col items-center">
        <h1 className="text-center mt-20 text-4xl">Join Us Today!</h1>
        <img
          src="/create.jpg"
          className="mt-6 rounded-[50%]  p-3 h-[250px]"
        ></img>
        <div className="mt-10">
          <form
            className="flex flex-col space-y-2 items-center "
            onSubmit={handleSubmit}
          >
            <label>First Name: </label>
            <input
              className="text-black"
              type="text"
              value={firstName}
              onChange={(e) => setFirstName(e.target.value)}
              placeholder="First Name"
              required
            />
            <label>Last Name: </label>
            <input
              className="text-black"
              type="text"
              value={lastName}
              onChange={(e) => setLastName(e.target.value)}
              placeholder="Last Name"
              required
            />
            <label>Email: </label>
            <input
              className="text-black"
              type="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              placeholder="Email"
              required
            />
            <label id="user-stuff">Username: </label>
            <input
              className="text-black"
              type="text"
              value={userName}
              onChange={(e) => setUserName(e.target.value)}
              placeholder="Create Username"
              required
            />
            <label id="pass-stuff">Password: </label>
            <input
              className="text-black"
              type={showPassword ? "text" : "password"}
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              placeholder="Create Password"
              required
            />
             <input 
            type="checkbox"
            className="cursor-pointer"
            checked={showPassword}
            onChange={toggleShowPassword}
          />
          <span>
            {showPassword ? "Hide" : "Show"} password
          </span>
            <div className="pt-10">
              <button
                onClick={handleSubmit}
                className="bg-[#4a3868] px-7 py-3 rounded-lg"
              >
                Submit
              </button>
            </div>
          </form>
        </div>
      </div>
    </>
  );
};

export default CreateUser;
