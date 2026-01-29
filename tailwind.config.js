/** @type {import('tailwindcss').Config} */
module.exports = {
    content: [
        "./src/**/*.{cljs,clj,cljc}",
        "./resources/public/*.html"
    ],
    theme: {
        extend: {
            colors: {
                'mf-blue': '#002f6c',      // Mattress Firm Blue
                'mf-red': '#e31837',       // Mattress Firm Red
                'mf-light-blue': '#0070c0',
                'mf-gray': '#f4f4f4'
            },
            fontFamily: {
                'sans': ['Inter', 'Roboto', 'sans-serif'],
            }
        },
    },
    plugins: [],
}
