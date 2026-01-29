(ns mamlaka-comfort.routes
  (:require [re-frame.core :as rf]
            [reitit.frontend :as rf-router]
            [reitit.frontend.easy :as rfe]
            [reitit.coercion.spec :as rss]))

(def routes
  ["/"
   ["" {:name :home}]
   ["catalog" {:name :catalog}]
   ["product/:id" {:name :product-detail
                   :parameters {:path {:id string?}}}]
   ["contact" {:name :contact}]])

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
   {:use-fragment true}))

(rf/reg-event-db
 :set-route
 (fn [db [_ m]]
   (let [page (get-in m [:data :name])
         id (get-in m [:path-params :id])]
     (cond-> (assoc db :current-route m)
       page (assoc :active-page page)
       id (assoc :active-product-id id)))))
