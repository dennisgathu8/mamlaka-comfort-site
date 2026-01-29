# Mamlaka Comfort - Kamae Beddings

![Mamlaka Comfort Logo](resources/public/img/logo.png) <!-- Note: Replace with actual path if different -->

A premium, inquiry-only e-commerce platform for **Kamae Beddings**, designed to provide a luxury mattress shopping experience. This application is built with a high-performance Clojure/ClojureScript stack, focusing on visual excellence, SEO, and seamless user inquiries.

## 🚀 Features

- **Luxury Product Catalog**: A visually stunning showcase of mattresses and bedding accessories.
- **Dynamic Product Filtering**: Effortlessly find the perfect mattress by size, type, or comfort level.
- **Inquiry Management**: Streamlined "Request a Quote" system for high-intent customer inquiries.
- **Mobile-First Design**: Fully responsive, glassmorphic UI optimized for all devices.
- **SEO Optimized**: Built with semantic HTML, meta descriptions, and optimized asset loading.
- **Robust Tech Stack**: Leveraging the power of Functional Programming for reliability and speed.

## 🛠 Tech Stack

### Frontend
- **Language**: [ClojureScript](https://clojurescript.org/)
- **Build Tool**: [shadow-cljs](https://github.com/thheller/shadow-cljs)
- **UI Framework**: [Reagent](https://reagent-project.github.io/) (React wrapper)
- **State Management**: [re-frame](https://day8.github.io/re-frame/re-frame/)
- **Routing**: [Reitit](https://github.com/metosin/reitit)
- **Styling**: [Tailwind CSS](https://tailwindcss.com/)

### Backend
- **Language**: [Clojure](https://clojure.org/)
- **Server**: [Ring](https://github.com/ring-clojure/ring) with [Jetty](https://eclipse.dev/jetty/)
- **Email/Inquiries**: [Postal](https://github.com/dlowe/postal)
- **Templating**: [Selmer](https://github.com/yogthos/Selmer)

## 📦 Getting Started

### Prerequisites
- [Java SDK](https://www.oracle.com/java/technologies/downloads/) (version 11 or higher)
- [Clojure CLI](https://clojure.org/guides/install_clojure)
- [Node.js & npm](https://nodejs.org/)

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/dennisgathu8/mamlaka-comfort-site.git
   cd mamlaka-comfort-site
   ```
2. Install dependencies:
   ```bash
   npm install
   ```

### Development
Start the shadow-cljs server and watch for changes:
```bash
npx shadow-cljs watch app
```
The application will be available at `http://localhost:8280`.

### Production Build
To create a production-ready bundle:
```bash
# Build the ClojureScript app
npx shadow-cljs release app

# Run the backend server
clj -M -m mamlaka-comfort.server
```

## 🏗 Project Structure

```text
.
├── resources/              # Static assets & public files
│   ├── public/             # index.html, CSS, JS bundles
│   └── data/               # Product data (EDN)
├── src/
│   └── mamlaka_comfort/    # Source code
│       ├── app.cljs        # Frontend entry point
│       ├── routes.cljs     # Application routing
│       ├── api.clj         # Backend API & handlers
│       └── views/          # Reagent components & pages
├── deps.edn                # Clojure dependencies
├── shadow-cljs.edn         # Shadow-cljs configuration
└── tailwind.config.js      # Tailwind CSS configuration
```

## 🔒 Security & Performance
- **Data Integrity**: Using Clojure's immutable data structures for predictable state management.
- **Sanitized Inputs**: All inquiry forms are validated and sanitized server-side.
- **Asset Optimization**: Purged CSS and minified JS bundles for lightning-fast load times.

---

Built with ❤️ for **Kamae Beddings**.
