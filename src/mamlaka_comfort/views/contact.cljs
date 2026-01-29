(ns mamlaka-comfort.views.contact
  (:require [reagent.core :as r]))

(defn contact-info []
  [:div.space-y-8
   [:div
    [:h2.text-3xl.font-black.text-mf-blue.mb-4 "MaMlaka Comfort Beddings"]
    [:p.text-gray-600.leading-relaxed
     "We are a family-owned bedding shop dedicated to bringing you the highest quality sleep solutions. Our physical store in Kahawa West allows you to test our mattresses and feel the texture of our premium linens before you buy."]]
   
   [:div.space-y-4
    [:div.flex.items-start.gap-4
     [:span.text-mf-red.font-bold "📍"]
     [:div
      [:h4.font-bold "Our Location"]
      [:p.text-gray-600 "Kamae Road, Kahawa West, Nairobi"]]]
    
    [:div.flex.items-start.gap-4
     [:span.text-mf-red.font-bold "📞"]
     [:div
      [:h4.font-bold "Phone / WhatsApp"]
      [:p.text-gray-600 "+254 7XX XXX XXX"]]]
    
    [:div.flex.items-start.gap-4
     [:span.text-mf-red.font-bold "✉️"]
     [:div
      [:h4.font-bold "Email"]
      [:p.text-gray-600 "info@mamlaka.com"]]]]])

(defn view []
  [:section.container.mx-auto.px-4.py-16
   [:div {:class "flex flex-col lg:flex-row gap-16"}
    [:div {:class "lg:w-1/2"}
     [contact-info]]
    
    [:div {:class "lg:w-1/2"}
     [:div.h-96.bg-gray-100.rounded-xl.shadow-inner.flex.items-center.justify-center.border-2.border-dashed.border-gray-300
      [:div.text-center
       [:span.text-4xl "🗺️"]
       [:h3.font-bold.mt-2 "Google Maps Integration"]
       [:p.text-sm.text-gray-500 "Kamae Road, Kahawa West"]]]]]])
