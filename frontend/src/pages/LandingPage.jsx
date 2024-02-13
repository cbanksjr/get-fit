/** @format */
"use client";

import { Button } from "flowbite-react";

import { Link } from "react-router-dom";
import logo from "/gymlogo.jpeg";

const LandingPage = () => {
  return (
    <>
      <div className="flex justify-center mt-40 animate-pulse">
        {/**Adding logo for landing page */}
        <img
          className="rounded-[50%] w-[500px] h-[500px]"
          src={logo}
          alt="cut butt logo"
        />
      </div>
      <div className="flex justify-center mt-20">
        <Link to="/login">
          <Button className="px-6 py-3 font-bold text-gray-900 group bg-gradient-to-br from-orange-500 to-orange-400 group-hover:from-pink-500 group-hover:to-orange-400 hover:text-white dark:text-white focus:ring-4 focus:outline-none focus:ring-pink-200 dark:focus:ring-pink-800">
            Login
          </Button>
        </Link>
      </div>
    </>
  );
};

export default LandingPage;
