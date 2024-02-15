import {Link, useNavigate} from "react-router-dom";
import {useState} from "react";
import axios from "axios";

const SignInForm = () => {


    const navigate = useNavigate()
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [showPassword, setShowPassword] = useState(false);
    const [isLoggedIn, setIsLoggedIn] = useState(false)
    const [errorMessage, setErrorMessage] = useState("")


    const handleSubmit = async (e) => {
        e.preventDefault()
        try {

            const response = await axios.post("/api/login", {email, password})

            if (response.data) {
                setIsLoggedIn(true); // Set isLoggedIn state to true upon successful login
                navigate('/');
            } else {
                setIsLoggedIn(false); // Set isLoggedIn state to false if login fails
            }
        } catch (error) {
            setIsLoggedIn(false); // Set isLoggedIn state to false if login fails
            setErrorMessage('Incorrect Email or Password')
        }

        // Add your sign-in logic here
        // Clear the form fields after submission
        setEmail("");
        setPassword("");
    };

    const toggleShowPassword = () => {
        setShowPassword(!showPassword);
    }
//Creating form for user to log in to app

    return (
        <>
            <div className="container mx-auto mt-16 p-8 bg-white rounded-md shadow-md max-w-md">
                <h2 className="text-2xl font-semibold mb-8 text-center text-black">
                    Sign In
                </h2>
                <form>
                    <div className="mb-4">
                        <label htmlFor="email" className="block text-gray-700 font-medium">
                            Email
                        </label>
                        <input
                            type="email"
                            name="email"
                            value={email}
                            onChange={e => setEmail(e.target.value)}
                            className="w-full px-4 py-2 border rounded-md focus:outline-none focus:border-blue-500 text-black"
                            placeholder="Enter your email"
                            required
                        />
                    </div>
                    <div className="mb-4 text-black">
                        <label
                            htmlFor="password"
                            className="block text-gray-700 font-medium"
                        >
                            Password
                        </label>
                        <input
                            className="w-full px-4 py-2 border rounded-md focus:outline-none focus:border-blue-500 text-black"
                            type={showPassword ? "text" : "password"}
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            placeholder="Enter your password"
                            required
                        />
                        <div className="flex items-center justify-center space-x-2 mt-4">
                            <input
                                type="checkbox"
                                className="cursor-pointer"
                                checked={showPassword}
                                onChange={toggleShowPassword}
                            />
                            <span>
            {showPassword ? "Hide" : "Show"} password
          </span>
                        </div>
                    </div>
                    {errorMessage ? (<p className="text-red-500 text-center mb-2">{errorMessage}</p>) : !errorMessage}
                    <button
                        onClick={handleSubmit}
                        type="submit"
                        className="bg-[#ff5616] text-white px-6 mt-2
            py-2 rounded-md hover:bg-[#113724]
            transition duration-300 w-full"
                    >
                        Sign in
                    </button>
                    <div className="flex flex-col items-center text-black mt-4">
                        <div>
                            <p>
                                Forgot Password?{" "}
                                <span className="hover:underline cursor-pointer text-blue-500">
                  <Link to="/resetpassword">Reset Password</Link>
                </span>
                            </p>
                        </div>
                        <div className="mt-4">
                            <p>
                                Not Registered?{" "}
                                <span className="hover:underline cursor-pointer text-blue-500">
                  <Link to="/createuser">Create account</Link>
                </span>
                            </p>
                        </div>
                    </div>
                </form>
            </div>
        </>
    )
};

export default SignInForm;