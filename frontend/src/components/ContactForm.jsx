import { useState } from "react";
import axios from "axios";

const ContactForm = () => {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [message, setMessage] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    await axios
      .post("/api/contact", {
        name,
        email,
        message,
      })
      .then((response) => response.data)
      .catch((error) => console.error(error));

    setName("");
    setEmail("");
    setMessage("");
  };

  return (
    <>
      {/**Creating and styling form for contact page */}
      <form>
        <div className="mb-4">
          <label htmlFor="name" className="block text-white-500 font-medium">
            Your Name
          </label>
          <input
            type="text"
            name="name"
            value={name}
            onChange={(e) => setName(e.target.value)}
            className="w-full px-4 py-2 border rounded-md focus:outline-none focus:border-blue-50 text-black"
            placeholder="John Doe"
          />
        </div>
        <div className="mb-4">
          <label htmlFor="email" className="block text-white-500 font-medium">
            Your Email
          </label>
          <input
            type="email"
            name="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            className="w-full px-4 py-2 border rounded-md focus:outline-none focus:border-blue-500 text-black"
            placeholder="john.doe@example.com"
          />
        </div>
        <div className="mb-4">
          <label htmlFor="message" className="block text-white-500 font-medium">
            Message
          </label>
          <textarea
            name="message"
            value={message}
            onChange={(e) => setMessage(e.target.value)}
            rows="4"
            className="w-full px-4 py-2 border rounded-md focus:outline-none focus:border-blue-500 text-black"
            placeholder="Your message here..."
          ></textarea>
        </div>
        <div className="flex justify-center">
          <button
            onClick={handleSubmit}
            type="submit"
            className="bg-[#ff5616] text-white px-8 py-3 rounded-md hover:bg-[#113724] transition duration-300"
          >
            Send Message
          </button>
        </div>
      </form>
    </>
  );
};

export default ContactForm;
