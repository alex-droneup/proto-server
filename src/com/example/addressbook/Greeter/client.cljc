;;;----------------------------------------------------------------------------------
;;; Generated by protoc-gen-clojure.  DO NOT EDIT
;;;
;;; GRPC com.example.addressbook.Greeter Client Implementation
;;;----------------------------------------------------------------------------------
(ns com.example.addressbook.Greeter.client
  (:require [com.example.addressbook :refer :all]
            [clojure.core.async :as async]
            [protojure.grpc.client.utils :refer [send-unary-params invoke-unary]]
            [promesa.core :as p]
            [protojure.grpc.client.api :as grpc]))

;-----------------------------------------------------------------------------
; GRPC Client Implementation
;-----------------------------------------------------------------------------

(def Greeter-service-name "com.example.addressbook.Greeter")

(defn Hello
  ([client params] (Hello client {} params))
  ([client metadata params]
  (let [input (async/chan 1)
        output (async/chan 1)
        desc {:service "com.example.addressbook.Greeter"
              :method  "Hello"
              :input   {:f com.example.addressbook/new-Person :ch input}
              :output  {:f com.example.addressbook/pb->HelloResponse :ch output}
              :metadata metadata}]
    (-> (send-unary-params input params)
        (p/then (fn [_] (invoke-unary client desc output)))))))

