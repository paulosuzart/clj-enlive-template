(ns {{name}}.views.common
  (:require [net.cgrand.enlive-html :as h]))

(defn show-errors [msgs]
	(h/clone-for [i msgs]
		[:span.error]
		(h/content i)))


(h/deftemplate lay "{{name}}/views/layout/main.html"
	[content]

	[:#wrapper]
	(h/content content))

(defn do-layout [content]
	(lay content))

