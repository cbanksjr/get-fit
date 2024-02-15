import PropTypes from "prop-types";


const AboutCard = ({name, image, linkedImage, profileLink}) => {

  return (
    <section className="flex justify-center mt-24">
        <div className="flex flex-col items-center text-black bg-white border-solid border-2 border-orange-600 rounded-lg w-72 h-96 shadow-lg shadow-orange-400/80">
            <img className="rounded-[50%] w-48 h-48 my-4" src={image} alt="about-image" />
            <h3>{name}</h3>
            <a href={profileLink} target="_blank" rel="noreferrer"><img className="mt-6 h-10 w-52 rounded-xl cursor-pointer" src={linkedImage} alt="LinkedIn Profile" /></a>
        </div>
    </section>
  );
};

AboutCard.propTypes ={
    name: PropTypes.string,
    image: PropTypes.string,
    linkedImage: PropTypes.string,
    profileLink: PropTypes.string,
}

export default AboutCard;
