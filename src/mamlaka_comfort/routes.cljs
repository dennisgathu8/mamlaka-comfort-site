(ns mamlaka-comfort.routes
  (:require [re-frame.core :as rf]
            [reitit.frontend :as rf-router]
            [reitit.frontend.easy :as rfe]
            [reitit.coercion.spec :as rss]))

(def routes
  ["/"
   ["" {:name :home
        :controllers [{:start (fn [_] (rf/dispatch [:set-active-page :home]))}]}]
   ["catalog" {:name :catalog
               :controllers [{:start (fn [_] (rf/dispatch [:set-active-page :catalog]))}]}]
   ["product/:id" {:name :product-detail
                   :parameters {:path {:id string?}}
                   :controllers [{:start (fn [params] 
                                           (rf/dispatch [:set-active-page :product-detail])
                                           (rf/dispatch [:set-active-product (get-in params [:path :id])]))}]}]
   ["contact" {:name :contact
               :controllers [{:start (fn [_] (rf/dispatch [:set-active-page :contact]))}]}]])

(rf/reg-event-db
 :set-active-page
 (fn [db [_ page]]
   (assoc db :active-page page)))

(rf/reg-event-db
 :set-active-product
 (fn [db [_ id]]
   (assoc db :active-product-id id)))

(defn init-routes! []
  (rfe/start!
   (rf-router/router routes {:data {:coercion rss/coercion}})
   (fn [m] (rf/dispatch [:set-route m]))
   {:use-fragment false}))

(rf/reg-event-db
 :set-route
 (fn [db [_ m]]
   (assoc db :current-route m)))
