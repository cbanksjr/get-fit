/** @format */

import Header from "../components/Header";
import AboutCard from "../components/AboutCard";
import craigPhoto from "../assets/craig.jpg";
import jordanPhoto from "../assets/jordan.jpg";
import kokiPhoto from "../assets/koki.jpg";
import jacobPhoto from "../assets/Jacob.jpeg";
import tyPhoto from "../assets/ty.jpeg";
import linkedin from "/src/assets/LinkedIn-Wordmark-White-Dark-Background-Logo.wine.svg"
import Footer from "../components/Footer";

const kokiLink = 'https://www.linkedin.com/in/koki-goudy-745b37126/'
const craigLink = 'https://www.linkedin.com/in/craig-banks-jr-7a9126106/'
const tyLink = 'https://www.linkedin.com/in/tydarius-chanthavong-72b552299/'
const jakeLink = 'https://www.linkedin.com/in/jacob-merendino-aa3178128/'
const jordanLink = 'https://www.linkedin.com/in/jordan-wade-b0b7949a/'

//creating function for About page
function About() {
  return (
    <>
      {/**Adding Header to page for navbar */}
      <Header />
      <h1 className="text-center mt-10 text-2xl font-extrabold">The Squad</h1>
      <section className="lg:grid grid-rows-3 place-content-center gap-6">
        <div className="row-start-1">
          <AboutCard 
          image={kokiPhoto} 
          name="Koki" 
          linkedImage={linkedin}
          profileLink={kokiLink}
          />
        </div>
        <div className="row-start-1">
          <AboutCard 
          image={craigPhoto} 
          name="Craig"
          linkedImage={linkedin}
          profileLink={craigLink} />
        </div>
        <div className="row-start-1">
          <AboutCard 
          image={tyPhoto} 
          name="Ty" 
          linkedImage={linkedin}
          profileLink={tyLink}
          />
        </div>
        <div className="row-start-2">
          <AboutCard 
          image={jacobPhoto} 
          name="Jake" 
          linkedImage={linkedin}
          profileLink={jakeLink}
          />
        </div>
        <div className="row-start-2">
          <AboutCard 
          image={jordanPhoto} 
          name="Jordan" 
          linkedImage={linkedin}
          profileLink={jordanLink}
          />
        </div>
      </section>
      <Footer />
    </>
  );
}

export default About;
