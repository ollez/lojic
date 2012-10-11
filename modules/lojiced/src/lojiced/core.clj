(ns lojiced.core
  (:require [seesaw.core :as sc]
            [seesaw.rsyntax :as rsyntax]
            [org.dipert.swingrepl.main :as repl]
            [seesaw.bind :as sbind])
  (:import [org.fife.ui.rsyntaxtextarea SyntaxConstants]
           [org.fife.ui.rtextarea RTextScrollPane]))

(def ^:dynamic editor-content (atom ""))

(defn prompt [] (printf "%s=>" (ns-name *ns*)))

(add-watch editor-content nil (fn [_ _ _ content]
                                (println content)
                                (try
                                  (load-string content)
                                  (catch Exception e (println e)))))

(defn editor
  []
  (rsyntax/text-area :rows 20
                     :columns 60
                     ;;:anti-aliasing-enabled true
                     :syntax :clojure))

(defn main
  []
  (let [text-area (editor)
        editor-pane (RTextScrollPane. text-area true)]
    (reset! editor-content ";;ok")
    (sc/text! text-area @editor-content)
    (sbind/bind text-area editor-content)
    (sc/invoke-later
     (sc/scroll! text-area :to [:line 200])
     
     (-> (sc/frame :content
                   (sc/border-panel
                    :north (sc/horizontal-panel
                            :items [(sc/button :text "load in repl")])
                    :center (sc/top-bottom-split editor-pane (repl/make-repl-jframe {:prompt prompt}) :divider-location 2/3)))
         sc/pack!
         sc/show!))))
