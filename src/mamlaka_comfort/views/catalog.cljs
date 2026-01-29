(ns mamlaka-comfort.views.catalog
  (:require [re-frame.core :as rf]))

(defn product-card [{:keys [id name description image price-range badges category]}]
  [:div.bg-white.card-shadow.flex.flex-col
   [:div.relative.h-64.overflow-hidden
    [:img.w-full.h-full.object-cover {:src image :alt name}]
    [:div.absolute.top-4.left-4.flex.flex-col.gap-2
     (for [badge badges]
       ^{:key badge}
       [:span.bg-mf-red.text-white.text-xs.font-bold.px-2.py-1.rounded badge])]]
   [:div.p-6.flex-grow.flex.flex-col
    [:span.text-xs.text-gray-500.uppercase.tracking-widest category]
    [:h3.text-xl.font-bold.text-mf-blue.mt-1 name]
    [:p.text-gray-600.text-sm.mt-2.line-clamp-2 description]
    [:div.mt-4
     [:span.text-sm.text-gray-500 "From"]
     [:div.text-2xl.font-black.text-gray-900 (first (clojure.string/split price-range #" - "))]]
    [:div.mt-6.grid.grid-cols-2.gap-4
     [:a.btn-primary.text-sm.text-center.py-2 {:href (str "#/product/" id)} "Details"]
     [:button {:class "bg-green-600 text-white text-sm font-bold py-2 rounded hover:bg-green-700"
               :on-click #(js/window.open (str "https://wa.me/254700000000?text=I'm interested in " name))} "Inquire"]]]])

(defn view []
  (let [products @(rf/subscribe [:products])
        loading? @(rf/subscribe [:loading?])]
    [:section.container.mx-auto.px-4.py-12
     [:div.flex.justify-between.items-end.mb-12
      [:div
       [:h1.text-4xl.font-black.text-mf-blue "Premium Catalog"]
       [:p.text-gray-600 "Browse our selection of quality beddings"]]
      [:div.flex.gap-4
       [:select.border.p-2.rounded.text-sm
        [:option "All Sizes"]
        [:option "3x6"]
        [:option "4x6"]
        [:option "5x6"]
        [:option "6x6"]]
       [:select.border.p-2.rounded.text-sm
        [:option "Sort By: Featured"]
        [:option "Price: Low to High"]
        [:option "Price: High to Low"]]]]
     
     (if loading?
       [:div.text-center.py-20 "Loading products..."]
       [:div {:class "grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-8"}
        (for [p products]
          ^{:key (:id p)}
          [product-card p])])]))
