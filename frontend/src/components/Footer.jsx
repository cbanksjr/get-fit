/**
 * eslint-disable no-unused-vars
 *
 * @format
 */
import { Link } from "react-router-dom";

const Footer = () => {
  return (
    <footer className="bg-white rounded-lg shadow m-4 dark:bg-gray-800">
      <div className="w-full mx-auto max-w-screen-xl p-4 md:flex md:items-center md:justify-between">
        <span className="2xl:text-2xl text-sm text-gray-500 sm:text-center dark:text-gray-400">
          <p>© {new Date().getFullYear()} Get Fit™ All Rights Reserved.</p>
        </span>
        <ul className="flex flex-wrap justify-center items-center mt-3 2xl:text-2xl text-sm font-medium text-gray-500 dark:text-gray-400 sm:mt-0">
          <li>
            <Link to="/contact" className="hover:underline">
              Contact
            </Link>
          </li>
        </ul>
      </div>
    </footer>
  );
};

export default Footer;
