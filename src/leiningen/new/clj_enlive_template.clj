(ns leiningen.new.clj-enlive-template
    (:require [clojure.java.io :as io])
    (:use leiningen.new.templates))

(def render (renderer "clj_enlive_template"))

(defn clj-enlive-template
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (sanitize name)}]
    (->files data
             ["project.clj" (render "project.clj" data)]
             ["README.md" (render "README.md" data)]
             ["resources/public/css/reset.css" (render "reset.css" data)]
             ["resources/public/css/default.css" (render "default.css" data)]
             ["src/{{sanitized}}/views/common.clj" (render "common.clj" data)]
             ["src/{{sanitized}}/views/login.clj" (render "login.clj" data)]
             ["src/{{sanitized}}/server.clj" (render "server.clj" data)]
             ["src/{{sanitized}}/views/layout/main.html" (render "main.html" data)]
             ["src/{{sanitized}}/views/_login.html" (render "_login.html" data)]
             )))