(ns mamlaka-comfort.views.main
  (:require [re-frame.core :as rf]
            [mamlaka-comfort.views.home :as home]
            [mamlaka-comfort.views.catalog :as catalog]
            [mamlaka-comfort.views.product :as product]
            [mamlaka-comfort.views.contact :as contact]))

(defn header []
  (let [nav-links [{:name "Home" :route :home}
                   {:name "Shop" :route :catalog}
                   {:name "Contact" :route :contact}]]
    [:header.bg-white.shadow-sm.sticky.top-0.z-50
     [:div.bg-mf-blue.text-white.text-center.py-2.text-sm.font-medium
      "Quality Beddings at Affordable Prices - Free Delivery in Kahawa West!"]
     [:nav.container.mx-auto.px-4.py-4.flex.justify-between.items-center
      [:a.flex.items-center.gap-2 {:href "/"}
       [:span.font-black.text-2xl.text-mf-blue "MaMlaka"]
       [:span.bg-mf-red.text-white.text-xs.px-1.rounded "Comfort"]]
      
       [:div {:class "hidden md:flex gap-8 font-semibold text-gray-700"}
        (for [{label :name route :route} nav-links]
          ^{:key label}
          [:a {:class "hover:text-mf-blue" :href (str "#/" (cljs.core/name route))} label])]
      
      [:div.flex.items-center.gap-4
       [:a {:class "bg-mf-red text-white px-4 py-2 rounded-full text-sm font-bold hover:bg-opacity-90 transition-all"
            :href "tel:+254700000000"} "Call Us"]]]]))

(defn footer []
  [:footer.bg-gray-900.text-white.pt-16.pb-8
   [:div {:class "container mx-auto px-4 grid grid-cols-1 md:grid-cols-4 gap-12"}
    [:div
     [:h3.text-xl.font-bold.mb-4 "MaMlaka Comfort"]
     [:p.text-gray-400 "Providing the best sleep solutions in Nairobi. Quality assurance and customer comfort are our priorities."]]
    [:div
     [:h3.text-xl.font-bold.mb-4 "Quick Links"]
     [:ul.space-y-2.text-gray-400
      [:li [:a {:href "#/"} "Home"]]
      [:li [:a {:href "#/catalog"} "Shop Beddings"]]
      [:li [:a {:href "#/contact"} "Visit Us"]]]]
    [:div
     [:h3.text-xl.font-bold.mb-4 "Our Shop"]
     [:p.text-gray-400 "Kamae Road, Kahawa West"]
     [:p.text-gray-400 "Nairobi, Kenya"]
     [:p.text-gray-400 "Hours: Mon-Sat 8am - 7pm"]]
    [:div
     [:h3.text-xl.font-bold.mb-4 "Contact Info"]
     [:p.text-gray-400 "Phone: +254 7XX XXX XXX"]
     [:p.text-gray-400 "WhatsApp: +254 7XX XXX XXX"]
     [:p.text-gray-400 "Email: info@mamlaka.com"]]]
   [:div.border-t.border-gray-800.mt-12.pt-8.text-center.text-gray-500.text-sm
    "© 2026 MaMlaka Comfort Beddings. All rights reserved."]])

(defn main-view []
  (let [active-page @(rf/subscribe [:active-page])]
    [:div.min-h-screen.flex.flex-col
     [header]
     [:main.flex-grow
      (try
        (case active-page
          :home [home/view]
          :catalog [catalog/view]
          :product-detail [product/view]
          :contact [contact/view]
          [:div "Page not found"])
        (catch :default e
          (js/console.error "Error rendering page:" e)
          [:div.container.mx-auto.px-4.py-20.text-center
           [:h2.text-2xl.font-bold.text-mf-blue "Something went wrong"]
           [:p.text-gray-600.mt-2 "Please try refreshing the page."]]))]
     [footer]]))
