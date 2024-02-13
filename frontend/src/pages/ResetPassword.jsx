/**
 * eslint-disable no-unused-vars
 *
 * @format
 */

import { useState } from "react";
import axios from "axios";
//Creating const for user email and password fields
const ResetPassword = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [showPassword, setShowPassword] = useState(false);
  const [errorMessage, setErrorMessage] = useState("");


  const handleSubmit = async (e) => {
    e.preventDefault();

    
    if(password != confirmPassword){
      return;
    }
    try {
      const response = await axios
        .put("/api/users/update", { email, password })
        if(email != response.data.email){
          return;
        }
      } catch (error) {
        console.error("Error updating user: " + error);
        setErrorMessage('Incorrect Email or Passwords do not match')
    }
    setEmail("")
    setPassword("")
    setConfirmPassword("")
  };

  const toggleShowPassword = () => {
    setShowPassword(!showPassword);
  }

  return (
    <>
      {/**Creating labels*/}
      <div className="flex flex-col justify-center items-center">
        <h2 className="text-2xl text-center mt-20 2xl:col-start-2">
          Reset Password
        </h2>
        <div className="xl:flex justify-center">
          <img
            src="/password.avif"
            alt="cobras"
            className="h-auto w-[200px] mt-10 rounded-md 2xl:col-start-1 xl:w-[400px]"
          ></img>
        </div>
        <form
          className="mt-10 space-y-2 flex flex-col justify-center items-center 2xl:col-start-2"
          onSubmit={handleSubmit}
        >
          <label className="flex">Account Email:</label>
          <input
            className="text-black rounded-md"
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            placeholder="Enter your email"
            required
          />

          <label className="flex">New Password:</label>
          <input
            className="text-black rounded-md"
            type={showPassword ? "text" : "password"}
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            placeholder="Enter new password"
            required
          />

          <label>Confirm Password:</label>
          <input
            className="text-black rounded-md"
            type={showPassword ? "text" : "password"}
            value={confirmPassword}
            onChange={(e) => setConfirmPassword(e.target.value)}
            placeholder="Re-enter new password"
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
          {errorMessage ? (
            <p className="text-red-500 mt-2">{errorMessage}</p>
          ) : (
            !errorMessage
          )}
          <div>
            <button
              type="submit"
              className="bg-purple-700 rounded-lg p-3  mt-10 2xl:col-start-2"
            >
              Reset Password
            </button>
          </div>
        </form>
      </div>
    </>
  );
};

export default ResetPassword;