(ns mamlaka-comfort.app
  (:require [reagent.dom :as rdom]
            [re-frame.core :as rf]
            [mamlaka-comfort.routes :as routes]
            [mamlaka-comfort.views.main :as views]
            [ajax.core :as ajax :refer [GET]]))

(rf/reg-event-db
 :initialize-db
 (fn [_ _]
   {:active-page :home
    :products []
    :loading? true}))

(rf/reg-event-fx
 :fetch-products
 (fn [{:keys [db]} _]
   {:http-xhrio {:method          :get
                 :uri             "/data/products.edn"
                 :response-format (ajax.edn-response-format)
                 :on-success      [:fetch-products-success]
                 :on-failure      [:fetch-products-failure]}}))

(rf/reg-event-db
 :fetch-products-success
 (fn [db [_ products]]
   (assoc db :products products :loading? false)))

(rf/reg-sub
 :active-page
 (fn [db _]
   (:active-page db)))

(rf/reg-sub
 :products
 (fn [db _]
   (:products db)))

(defn ^:dev/after-load reload []
  (rdom/render [views/main-view] (.getElementById js/document "app")))

(defn init []
  (rf/dispatch-sync [:initialize-db])
  (routes/init-routes!)
  (reload))
