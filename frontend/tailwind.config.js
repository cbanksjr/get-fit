/* eslint-disable no-undef */
/** @type {import('tailwindcss').Config} */
export default {
  content: ["./index.html", "./src/**/*.{js,ts,jsx,tsx}", 'node_modules/flowbite-react/lib/esm/**/*.js'],
  theme: {
    extend: {
      backgroundImage: {
        'workout': "url('/jonathan-borba-H6wTktsFxik-unsplash.jpg')",
      },
    },
    fontFamily: {
      Changa: ["Changa"],
    },
  },
  plugins: [require('flowbite/plugin')],
};
