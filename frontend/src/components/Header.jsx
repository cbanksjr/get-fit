/**
 * eslint-disable no-unused-vars
 *
 * @format
 */
import axios from "axios";
import {  useState } from "react";
import { Link, useNavigate } from "react-router-dom";

function Header() {
  const navigate = useNavigate();
  const [isMenuOpen, setIsMenuOpen] = useState(false);

  const handleLogout = async () => {
    await axios
      .get("/api/logout")
      .then((response) => response.data)
      .then(navigate("/"))
      .catch((error) => console.error(error));

    setIsMenuOpen(false);
  };

  const toggleMenu = () => {
    setIsMenuOpen(!isMenuOpen);
  };

  return (
    <div className="lg:container lg:mx-auto">
      <header className="flex justify-between items-center px-5">
        <div className="md:hidden">
          <button
            onClick={toggleMenu}
            className="text-white focus:outline-none"
          >
            {isMenuOpen ? (
              <svg
                className="w-6 h-6"
                fill="none"
                stroke="currentColor"
                viewBox="0 0 24 24"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path
                  strokeLinecap="round"
                  strokeLinejoin="round"
                  strokeWidth="2"
                  d="M6 18L18 6M6 6l12 12"
                />
              </svg>
            ) : (
              <svg
                className="w-6 h-6"
                fill="none"
                stroke="currentColor"
                viewBox="0 0 24 24"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path
                  strokeLinecap="round"
                  strokeLinejoin="round"
                  strokeWidth="2"
                  d="M4 6h16M4 12h16m-7 6h7"
                />
              </svg>
            )}
          </button>
        </div>

        <div className="hidden md:flex items-center md:mt-5">
          <img
            className="ml-3 w-[50px] h-[50px] rounded-[50%] mr-5 lg:w-[70px] lg:h-[70px] 2xl:w-[100px] 2xl:h-[100px]"
            src="/gymlogo.jpeg"
            alt="cut butt logo"
          />
          <p className="hidden md:contents text-lg 2xl:text-3xl">GloboGym</p>
        </div>
        <nav className={`flex items-center mt-3 md:flex 2xl:text-3xl ${isMenuOpen ? 'flex' : 'hidden'}`}>
          <ul className="text-md md:flex 2xl:text-3xl">
            <li className="text-white no-underline list-none px-3 lg:px-5">
              <Link to="/home">Home</Link>
            </li>
            <li className="text-white no-underline list-none px-3 lg:px-5">
              <Link to="/workouts">Workouts</Link>
            </li>
            <li className="text-white no-underline list-none px-3 lg:px-5">
              <Link to="/Nutrition">Nutrition</Link>
            </li>
          </ul>
        </nav>
        <button
          onClick={handleLogout}
          className="2xl:text-2xl mr-3 mt-6 relative inline-flex items-center justify-center p-0.5 mb-2 me-2 overflow-hidden text-sm font-medium text-gray-900 rounded-lg group bg-gradient-to-br from-orange-500 to-orange-400 group-hover:from-pink-500 group-hover:to-orange-400 hover:text-white dark:text-white focus:ring-4 focus:outline-none focus:ring-pink-100 dark:focus:ring-pink-800"
        >
          <span className="relative px-4 py-1.5 transition-all ease-in duration-75 bg-white dark:bg-gray-900 rounded-md group-hover:bg-opacity-0">
            Logout
          </span>
        </button>
      </header>
    </div>
  );
}

export default Header;
