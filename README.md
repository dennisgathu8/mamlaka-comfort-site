# Mamlaka Comfort - Kamae Beddings

A premium, inquiry-only e-commerce platform for **Kamae Beddings**, designed to provide a luxury mattress shopping experience.

🚀 **Live Demo**: [https://dennisgathu8.github.io/mamlaka-comfort-site/](https://dennisgathu8.github.io/mamlaka-comfort-site/)

## ✨ Features

- **Luxury Product Catalog**: A visually stunning showcase of mattresses, duvets, and sheets.
- **Dynamic Routing**: Instant, client-side navigation between home, catalog, and product details.
- **Inquiry System**: Integrated WhatsApp and Email inquiry forms with pre-filled product details.
- **Mobile-First Responsive UI**: Sleek, glassmorphic design optimized for Nairobi's mobile shoppers.
- **SEO & Performance**: Semantic HTML and `:advanced` ClojureScript compilation for lightning-fast speeds.

## 🛠 Tech Stack

- **Language**: [ClojureScript](https://clojurescript.org/)
- **Build Tool**: [shadow-cljs](https://github.com/thheller/shadow-cljs)
- **UI Framework**: [Reagent](https://reagent-project.github.io/) / [re-frame](https://day8.github.io/re-frame/re-frame/)
- **Routing**: [Reitit](https://github.com/metosin/reitit)
- **Styling**: [Tailwind CSS](https://tailwindcss.com/)
- **Hosting**: [GitHub Pages](https://pages.github.com/)

## 📦 Development

### Prerequisites
- [Java SDK](https://www.oracle.com/java/technologies/downloads/) (17+)
- [Node.js & npm](https://nodejs.org/)

### Setup
1. Clone the repository and install dependencies:
   ```bash
   npm install
   ```
2. Start the development server:
   ```bash
   npx shadow-cljs watch app
   ```
   The application will be live at `http://localhost:8280`.

## 🏗 Project Structure

```text
.
├── resources/
│   └── public/             # index.html, CSS, & compiled JS
│       └── data/           # Product data (EDN)
├── src/
│   └── mamlaka_comfort/    # ClojureScript source
│       ├── app.cljs        # App entry point
│       ├── routes.cljs     # Routing logic
│       └── views/          # Reagent UI components
├── shadow-cljs.edn         # Shadow-cljs config & deps
└── tailwind.config.js      # CSS configuration
```

## 🚀 Deployment

The site is automatically deployed to GitHub Pages via GitHub Actions on every push to `main`.

---
Built with ❤️ for **Kamae Beddings**.
