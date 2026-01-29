(ns mamlaka-comfort.server
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [reitit.ring :as ring]
            [reitit.ring.middleware.parameters :refer [parameters-middleware]]
            [reitit.ring.middleware.muuntaja :refer [format-middleware]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.util.http-response :as response]
            [mamlaka-comfort.api :as api]
            [clojure.java.io :as io]))

(defn index-handler [_]
  (response/content-type
   (response/ok (slurp (io/resource "public/index.html")))
   "text/html"))

(def app
  (ring/ring-handler
   (ring/router
    [["/" {:get index-handler}]
     ["/api"
      ["/products" {:get (fn [_] (response/ok (read-string (slurp (io/resource "data/products.edn")))))}]
      ["/inquiry" {:post api/handle-inquiry}]]
     ["/*" (ring/create-resource-handler {:root "public"})]]
    {:data {:middleware [parameters-middleware
                         format-middleware]}})
   (ring/routes
    (ring/create-resource-handler {:root "public"})
    (ring/create-default-handler
     {:not-found (fn [_] (response/not-found "Not Found"))}))))

(defn -main [& _args]
  (let [port (Integer/parseInt (or (System/getenv "PORT") "3000"))]
    (println "Server starting on http://localhost:" port)
    (run-jetty app {:port port :join? false})))
