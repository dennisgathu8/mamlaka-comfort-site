(ns mamlaka-comfort.api
  (:require [ring.util.http-response :as response]
            [com.draines.postal.core :as postal]
            [clojure.string :as str]))

(defn validate-inquiry [{:keys [name phone product]}]
  (cond
    (str/blank? name) "Name is required"
    (str/blank? phone) "Phone number is required"
    (not (re-matches #"^(\+254|0)[17]\d{8}$" phone)) "Please enter a valid Kenyan phone number"
    (str/blank? product) "Product interest is required"
    :else nil))

(defn handle-inquiry [{:keys [params]}]
  (if-let [error (validate-inquiry params)]
    (response/bad-request {:error error})
    (let [smtp-user (System/getenv "SMTP_USER")
          smtp-pass (System/getenv "SMTP_PASS")
          owner-email (or (System/getenv "OWNER_EMAIL") "info@mamlaka.com")]
      ;; Use Postal to send email (only if configured)
      (when (and smtp-user smtp-pass)
        (postal/send-message {:host "smtp.gmail.com" :user smtp-user :pass smtp-pass :ssl :true}
                             {:from "info@mamlaka.com"
                              :to owner-email
                              :subject (str "New Inquiry: " (:product params))
                              :body (str "Name: " (:name params) "\n"
                                         "Phone: " (:phone params) "\n"
                                         "Email: " (:email params) "\n"
                                         "Product: " (:product params) "\n"
                                         "Message: " (:message params))}))
      (response/ok {:message "Inquiry sent successfully. We will contact you soon!"}))))
