/* eslint-disable react/prop-types */
/** @format */

const WorkoutCard = ({ name, instructions, difficulty, equipment }) => {
  return (
    <div className="flex flex-col items-center text-black bg-white border-solid border-2 border-orange-600 rounded-lg p-8 md:p-20 w-auto shadow-lg shadow-orange-400/80">
      <h1 className="pb-5">{name}</h1>
      <div className="space-y-5">
        <p><span className="pr-3">Equipment:</span>{equipment}</p>
        <p><span className="pr-3">Difficulty:</span>{difficulty}</p>
        <p><span className="pr-3">Execution:</span>{instructions}</p>
      </div>
    </div>
  );
};

export default WorkoutCard;
