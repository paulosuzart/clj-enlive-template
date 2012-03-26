(ns {{name}}.views.login
  (:require [net.cgrand.enlive-html :as h]
  			[noir.validation :as v])
  (:use [noir.core :only [defpage render noir-routes]]
  		[noir.response :only [redirect]]
        [{{name}}.views.common :only [show-errors do-layout]]))


(defn valid? 
	"Validates the form content."
	[{:keys [username password]}]

	;; you may internationalize these messages.
	(v/rule (v/min-length? username 5)
		[:username "Ooops. At least 5 chars for username."])

	(v/rule (v/min-length? password 3)
		[:password "Password should have at least 3 chars."])

	(not (and (v/errors? :username :password))))


;; Snippet used at `/login`. Display the login form. 
;; `errors` are passed as argument because 
;; `noir.validation/get-errors` can not be called from inside
;; enlive template. The vars gets ubound.
(h/defsnippet _login "{{name}}/views/_login.html"  [:#login_form]
	[username password & [errors]]

	[:div#errors]
	(show-errors errors)
	
	[:input#username]    
	(h/set-attr :value username)
	
	[:input#password]
	(h/set-attr :value password))


(defpage "/login" {:as login}
	(time (do-layout (_login (:username login) 
							 (:password login) 
							 (:error login)))))

(defpage [:post "/login"] {:as login}
	(if (valid? login)
		(do-layout (format "Yeah!! Welcome %s" (:username login)))
		(render "/login" (assoc login :error (v/get-errors)))))

;; I know you'll forget to browse to /login. 
;; This route will do the job ;).
(defpage "/" {}
	(redirect "/login"))