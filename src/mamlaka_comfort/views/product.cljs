(ns mamlaka-comfort.views.product
  (:require [re-frame.core :as rf]
            [reagent.core :as r]))

(defn inquiry-form [product-name]
  (let [form-data (r/atom {:name "" :phone "" :message (str "I am interested in " product-name)})
        status (r/atom nil)]
    (fn []
      [:div.bg-mf-gray.p-8.rounded-lg
       [:h3.text-2xl.font-bold.mb-6 "Inquire About This Product"]
       (when @status
         [:div.mb-4.p-4.rounded.text-sm
          {:class (if (= (:type @status) :success) "bg-green-100 text-green-800" "bg-red-100 text-red-800")}
          (:message @status)])
       [:div.space-y-4
        [:div
         [:label.block.text-sm.font-bold.mb-1 "Full Name *"]
         [:input.w-full.p-2.border.rounded
          {:type "text" :value (:name @form-data)
           :on-change #(swap! form-data assoc :name (-> % .-target .-value))}]]
        [:div
         [:label.block.text-sm.font-bold.mb-1 "Phone Number *"]
         [:input.w-full.p-2.border.rounded
          {:type "tel" :placeholder "07XX XXX XXX" :value (:phone @form-data)
           :on-change #(swap! form-data assoc :phone (-> % .-target .-value))}]]
        [:div
         [:label.block.text-sm.font-bold.mb-1 "Message"]
         [:textarea.w-full.p-2.border.rounded.h-24
          {:value (:message @form-data)
           :on-change #(swap! form-data assoc :message (-> % .-target .-value))}]]
        [:button.w-full.btn-primary.mt-4
         {:on-click (fn []
                      (if (or (empty? (:name @form-data)) (empty? (:phone @form-data)))
                        (reset! status {:type :error :message "Please fill in all required fields."})
                        (let [text (str "Hello MaMlaka Comfort, I am " (:name @form-data) 
                                        " and I'm interested in " product-name 
                                        ". My phone is " (:phone @form-data) 
                                        ". " (:message @form-data))
                              encoded-text (js/encodeURIComponent text)]
                          (reset! status {:type :success :message "Opening WhatsApp/Email for your inquiry..."})
                          (js/window.open (str "https://wa.me/254700000000?text=" encoded-text))
                          )))}
         "Submit via WhatsApp"]
        [:a.w-full.block.text-center.mt-4.text-sm.text-mf-blue.underline
         {:href (str "mailto:info@mamlaka.com?subject=Inquiry: " product-name 
                     "&body=Hello, I am interested in " product-name ". Name: " (:name @form-data) ", Phone: " (:phone @form-data))}
         "Or Send Email Instead"]]])))

(defn view []
  (let [id @(rf/subscribe [:active-product-id])
        products @(rf/subscribe [:products])
        product (first (filter #(= (:id %) id) products))]
    (if-not product
      [:div.text-center.py-20 "Product not found."]
      [:section.container.mx-auto.px-4.py-12
      [:div {:class "flex flex-col lg:flex-row gap-16"}
       [:div {:class "lg:w-1/2"}
        [:img.w-full.rounded-xl.shadow-lg {:src (:image product) :alt (:name product)}]
        [:div.grid.grid-cols-4.gap-4.mt-4
         (repeat 4 [:div.h-24.bg-gray-100.rounded.cursor-pointer])]]
       
       [:div {:class "lg:w-1/2"}
         [:nav.text-sm.text-gray-500.mb-4
          [:a {:href "#catalog"} "Catalog"] " / " (:category product)]
         [:h1.text-4xl.font-black.text-mf-blue.mb-2 (:name product)]
         [:div.flex.items-center.gap-2.mb-6
          [:span.bg-mf-red.text-white.text-xs.font-bold.px-2.py-1.rounded "Featured"]
          [:span.text-mf-blue.font-bold "★★★★★ 5.0"]]
         
         [:div.text-3xl.font-black.text-gray-900.mb-8 (:price-range product)]
         
         [:div.mb-8
          [:h4.font-bold.mb-3 "Available Sizes"]
          [:div.flex.gap-3
           (for [sz (:sizes product)]
             ^{:key sz}
             [:span {:class "px-4 py-2 border-2 border-gray-200 rounded text-sm font-bold hover:border-mf-blue cursor-pointer"} sz])]]
         
         [:p.text-gray-700.text-lg.leading-relaxed.mb-12 (:description product)]
         
         [inquiry-form (:name product)]]]])))
