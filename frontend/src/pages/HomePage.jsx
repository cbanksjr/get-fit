/** @format */
"use client";
import Header from "../components/Header";
import Footer from "../components/Footer";

//Creating a function for Homepage
function HomePage() {
  return (
    <>
      <main className="bg-workout bg-cover bg-center h-[700px] w-[100%] lg:h-[1500px]">
        <Header />
        <section className="flex justify-center mt-36 lg:mt-48">
          <div className="flex flex-col justify-end mt-20 font-semibold text-2xl text-center lg:mt-72 lg:text-6xl">
            <h1>The only app you need to get cut!</h1>
            <div className="mt-20"></div>
          </div>
        </section>
      </main>

      <section className="bg-white dark:bg-gray-900 bg-[url('https://flowbite.s3.amazonaws.com/docs/jumbotron/hero-pattern.svg')] dark:bg-[url('https://flowbite.s3.amazonaws.com/docs/jumbotron/hero-pattern-dark.svg')]">
        <div className="py-8 px-4 mx-auto max-w-screen-xl text-center lg:py-16 z-10 relative">
          <h1 className="mb-4 text-4xl font-extrabold tracking-tight leading-none text-gray-900 md:text-5xl lg:text-6xl dark:text-white">
            We Get Cut, We Get Butt
          </h1>

          <p className="mb-8 text-lg font-normal text-gray-500 lg:text-xl sm:px-16 lg:px-48 dark:text-gray-200">
            Here at Globo Gym we designed our platform to offer the most premium
            experience to help get you Right!!!
          </p>
        </div>
      </section>

      <div className="bg-white dark:bg-gray-900 bg-[url('https://flowbite.s3.amazonaws.com/docs/jumbotron/hero-pattern.svg')] dark:bg-[url('https://flowbite.s3.amazonaws.com/docs/jumbotron/hero-pattern-dark.svg')] grid gap-4">
        <div className="flex flex-col justify-center items-center lg:grid grid-cols-5 gap-4 m-6">
          <div className="flex flex-col justify-center items-center text-black mb-6 lg:mb-0">
            <img
              className="h-[275px] w-[375px] rounded-lg"
              src="/kako.jpeg"
              alt=""
            />
            <p className="text-center text-xl mt-4">Upper Body</p>
          </div>
          <div className="flex flex-col justify-center items-center text-black mb-6 lg:mb-0">
            <img
              className="h-[275px] w-[375px] rounded-lg"
              src="/butt.jpeg"
              alt=""
            />
            <p className="text-center text-xl mt-4">Lower Body</p>
          </div>
          <div className="flex flex-col justify-center items-center text-black mb-6 lg:mb-0">
            <img
              className="h-[275px] w-[375px] rounded-lg"
              src="abs.jpeg"
              alt=""
            />
            <p className="text-center text-xl mt-4">Abdominal</p>
          </div>
          <div className="flex flex-col justify-center items-center text-black mb-6 lg:mb-0">
            <img
              className="h-[275px] w-[375px] rounded-lg"
              src="run.jpeg"
              alt=""
            />
            <p className="text-center text-xl mt-4">Cardio</p>
          </div>
          <div className="flex flex-col justify-center items-center text-black mb-6 lg:mb-0">
            <img
              className="h-[275px] w-[375px] rounded-lg"
              src="st.jpeg"
              alt=""
            />
            <p className="text-center text-xl mt-4">Stretching</p>
          </div>
        </div>
      </div>
      <Footer />
    </>
  );
}

export default HomePage;
