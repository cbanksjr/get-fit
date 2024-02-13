/** @format */

import Header from "../components/Header";
import Footer from "../components/Footer";
import ContactForm from "../components/ContactForm";

//creating const for contact section
const ContactSection = () => {
  return (
    <>
      <Header />
      <section className="py-16 bg-black-100 p-6">
        <div className="container mx-auto">
          <h2 className="text-3xl text-center font-semibold mb-8">Contact Us</h2>
          <div className="grid grid-cols-1 md:grid-cols-2 gap-8">
            <div className="md:col-start-2">
              <ContactForm />
            </div>
            <div className="flex items-center mt-6 mb-10 text-center md:col-start-1 row-start-1 md:text-start">
              <p className="text-white-500">
                Feel free to reach out to us via the contact form with any
                ideas, suggestions or complaints.
              </p>
            </div>
          </div>
        </div>
      </section>
      <Footer />
    </>
  );
};

export default ContactSection;
