import Footer from "../components/Footer";
import axios from "axios";
import Header from "../components/Header";
import { useState } from "react";
import WorkoutCard from "../components/WorkoutCard";

//creating const for workout page
const Workouts = () => {
  const [cardioWorkout, setCardioWorkout] = useState([]);
  const [olympicWorkouts, setOlympicWorkout] = useState([]);
  const [plyometricsWorkout, setPlyometricsWorkout] = useState([]);
  const [powerLift, setPowerLiftWorkout] = useState([]);
  const [stretchingWorkout, setStretchingWorkout] = useState([]);

//clicker button toggle open and toggle close
  const [cardioWorkoutTabOpen, setCardioWorkoutTabOpen] = useState(false);
  const [olympicWorkoutTabOpen, setOlympicWorkoutTabOpen] = useState(false);
  const [plyometricsWorkoutTabOpen, setPlyometricsWorkoutTabOpen] =useState(false);
  const [powerLiftTabOpen, setPowerLiftTabOpen] = useState(false);
  const [stretchingWorkoutTabOpen, setStretchingWorkoutTabOpen] =useState(false);



    const toggleCardioWorkoutTab = () => {
      setCardioWorkoutTabOpen(!cardioWorkoutTabOpen);
    };

    const closeCardioWorkoutTab = () => {
      setCardioWorkoutTabOpen(false);
    };

    const toggleOlympicWorkoutTab = () => {
      setOlympicWorkoutTabOpen(!olympicWorkoutTabOpen);
    };

    const closeOlympicWorkoutTab = () => {
      setOlympicWorkoutTabOpen(false);
    };


    const togglePlyometricsWorkoutTab = () => {
      setPlyometricsWorkoutTabOpen(!plyometricsWorkoutTabOpen);
    };

    const closePlyometricsWorkoutTab = () => {
      setPlyometricsWorkoutTabOpen(false);
    };


  const togglePowerLiftTab = () => {
    setPowerLiftTabOpen(!powerLiftTabOpen);
  };

  const closePowerLiftTab = () => {
    setPowerLiftTabOpen(false);
  };


  const toggleStretchingWorkoutTab = () => {
    setStretchingWorkoutTabOpen(!stretchingWorkoutTabOpen);
  };

  const closeStretchingWorkoutTab = () => {
    setStretchingWorkoutTabOpen(false);
  };

  const getCardio = async () => {
    await axios
      .get("/api/exercises/type/cardio")
      .then((response) => setCardioWorkout(response.data))
      .catch((error) => console.error(error));

      toggleCardioWorkoutTab();
  };

  const getOlympicLift = async () => {
    await axios
      .get("/api/exercises/type/olympic-lift")
      .then((response) => setOlympicWorkout(response.data))
      .catch((error) => console.error(error));

      toggleOlympicWorkoutTab();
  };

  const getplyometrics = async () => {
    await axios
      .get("/api/exercises/type/plyometrics")
      .then((response) => setPlyometricsWorkout(response.data))
      .catch((error) => console.error(error));

      togglePlyometricsWorkoutTab();
  };

  const getPowerLift = async () => {
    await axios
      .get("/api/exercises/type/powerlifting")
      .then((response) => setPowerLiftWorkout(response.data))
      .catch((error) => console.error(error));

      togglePowerLiftTab();
  };

  const getStretching = async () => {
    await axios
      .get("/api/exercises/type/stretching")
      .then((response) => setStretchingWorkout(response.data))
      .catch((error) => console.error(error));

  toggleStretchingWorkoutTab();
  };

  return (
    <>
      {" "}
      {/**Adding header to page */}
      <Header />
      <h1 className="text-4xl mt-20 text-center">Workouts available</h1>
      <div className="mt-10">
        <ul className="flex-col space-y space-y-4 font-medium text-gray-500 dark:text-gray-400 md:me-4 mb-4 md:mb-0">
          <li
            onClick={() => {
              getCardio();
              closeCardioWorkoutTab();
            }}
            className="inline-flex justify-center px-4 py-3 text-white bg-[#ff5616] rounded-lg active w-full hover:bg-[#113724] cursor-pointer"
          >
            cardio
          </li>
          {cardioWorkoutTabOpen && (
            <li>
              {cardioWorkout.map((element) => (
                <div key={element.id}>
                  <section className="flex flex-col justify-center items-center space-x-8 py-2">
                    <WorkoutCard
                    name = {element.name}
                    equipment = {element.equipment}
                    difficulty={element.difficulty}
                    instructions={element.instructions}
                     />
                  </section>
                </div>
              ))}
            </li>
          )}

          <li
            onClick={() => {
              getOlympicLift();
              closeOlympicWorkoutTab();
            }}
            className="inline-flex justify-center px-4 py-3 text-white bg-[#ff5616] rounded-lg active w-full hover:bg-[#113724] cursor-pointer"
          >
            olympic lifting
          </li>
          {olympicWorkoutTabOpen && (
            <li>
              {olympicWorkouts.map((element) => (
                <div key={element.id}>
                  <section className="flex flex-col justify-center items-center  py-2">
                  <WorkoutCard
                    name = {element.name}
                    equipment = {element.equipment}
                    difficulty={element.difficulty}
                    instructions={element.instructions}
                     />
                  </section>
                </div>
              ))}
            </li>
          )}

          <li
            onClick={() => {
              getplyometrics();
              closePlyometricsWorkoutTab();
            }}
            className="inline-flex justify-center px-4 py-3 text-white bg-[#ff5616] rounded-lg active w-full hover:bg-[#113724] cursor-pointer"
          >
            plyometrics
          </li>
          {plyometricsWorkoutTabOpen && (
            <li>
              {plyometricsWorkout.map((element) => (
                <div key={element.id}>
                  <section className="flex flex-col justify-center items-center space-x-8 py-2">
                  <WorkoutCard
                    name = {element.name}
                    equipment = {element.equipment}
                    difficulty={element.difficulty}
                    instructions={element.instructions}
                     />
                  </section>
                </div>
              ))}
            </li>
          )}
          <li
            onClick={() => {
              getPowerLift();
              closePowerLiftTab();
            }}
            className="inline-flex justify-center px-4 py-3 text-white bg-[#ff5616] rounded-lg active w-full hover:bg-[#113724] cursor-pointer"
          >
            powerlifting
          </li>
          {powerLiftTabOpen && (
            <li>
              {powerLift.map((element) => (
                <div key={element.id}>
                  <section className="flex flex-col justify-center items-center space-x-8 py-2">
                  <WorkoutCard
                    name = {element.name}
                    equipment = {element.equipment}
                    difficulty={element.difficulty}
                    instructions={element.instructions}
                     />
                  </section>
                </div>
              ))}
            </li>
          )}

          <li
            onClick={() => {
              getStretching();
              closeStretchingWorkoutTab();
            }}
            className="inline-flex justify-center px-4 py-3 text-white bg-[#ff5616] rounded-lg active w-full hover:bg-[#113724] cursor-pointer"
          >
            stretching
          </li>
          {stretchingWorkoutTabOpen && (
            <li>
              {stretchingWorkout.map((element) => (
                <div key={element.id}>
                  <section className="flex flex-col justify-center items-center space-x-8 py-2">
                  <WorkoutCard
                    name = {element.name}
                    equipment = {element.equipment}
                    difficulty={element.difficulty}
                    instructions={element.instructions}
                     />
                  </section>
                </div>
              ))}
            </li>
          )}

          
        </ul>
      </div>
      <Footer />
    </>
  );
};

export default Workouts;
