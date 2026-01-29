(ns mamlaka-comfort.views.home
  (:require [re-frame.core :as rf]))

(defn hero []
  [:section.relative.bg-mf-gray.overflow-hidden
   [:div {:class "container mx-auto px-4 py-20 flex flex-col md:flex-row items-center"}
    [:div {:class "md:w-1/2 z-10"}
     [:h1 {:class "text-5xl md:text-7xl font-black text-mf-blue leading-tight mb-6"}
      "WAKE UP " [:span.text-mf-red "REPLENISHED"]]
     [:p.text-xl.text-gray-700.mb-8.max-w-lg
      "Experience premium comfort with MaMlaka Beddings. Quality mattresses, duvets, and sheets delivered to your doorstep in Nairobi."]
     [:div.flex.gap-4
      [:a.btn-primary {:href "#catalog"} "Shop the Sale"]
      [:a {:class "border-2 border-mf-blue text-mf-blue px-6 py-3 rounded font-bold hover:bg-mf-blue hover:text-white transition-all"
           :href "#contact"} "Visit Our Shop"]]]
    [:div {:class "md:w-1/2 mt-12 md:mt-0"}
     [:img.rounded-lg.shadow-2xl.rotate-3
      {:src "https://images.unsplash.com/photo-1540518614846-7eded433c457?auto=format&fit=crop&q=80&w=800"
       :alt "Premium Bedding"}]]]
   [:div {:class "absolute bottom-0 right-0 bg-mf-red text-white px-8 py-4 font-bold text-lg hidden md:block"}
    "Special Offers on All Mattresses!"]])

(defn category-card [name img]
  [:a.group.relative.h-64.overflow-hidden.rounded-lg.card-shadow
   {:href "#catalog"}
   [:img {:class "w-full h-full object-cover group-hover:scale-105 transition-transform duration-500"
          :src img :alt name}]
   [:div {:class "absolute inset-0 bg-black bg-opacity-20 group-hover:bg-opacity-40 transition-all"}]
   [:div.absolute.bottom-6.left-6
    [:h3.text-2xl.font-bold.text-white name]
    [:span.text-white.text-sm.underline "Explore Now"]]])

(defn view []
  [:div
   [hero]
   [:section.container.mx-auto.px-4.py-16
    [:h2.text-3xl.font-bold.text-center.mb-12 "Shop by Category"]
    [:div {:class "grid grid-cols-1 md:grid-cols-3 gap-8"}
     [category-card "Mattresses" "https://images.unsplash.com/photo-1505691938895-1758d7eaa511?auto=format&fit=crop&q=80&w=600"]
     [category-card "Duvets" "https://images.unsplash.com/photo-1584132967334-10e028bd69f7?auto=format&fit=crop&q=80&w=600"]
     [category-card "Sheets" "https://images.unsplash.com/photo-1522771739844-6a9f6d5f14af?auto=format&fit=crop&q=80&w=600"]]]
   
   [:section.bg-mf-blue.text-white.py-16
    [:div.container.mx-auto.px-4.text-center
     [:h2.text-4xl.font-bold.mb-4 "Visit Our Showroom Today"]
     [:p.text-xl.mb-8 "Located along Kamae Road, Kahawa West. See and feel the quality yourself."]
     [:a.btn-secondary {:href "https://wa.me/254700000000"} "Chat on WhatsApp"]]]])
