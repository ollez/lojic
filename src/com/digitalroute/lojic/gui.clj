(ns com.digitalroute.lojic.gui
	(:require [clooj.core :as cc]))

(defn initialize
	[agent-ui]
	(try
		(println (cc/make-rsyntax-text-area))
		(catch _ e
			(println e))))
	
(defn display-config
	[agent-ui storable-cfg]
	(println "display config - " agent-ui storable-cfg))
	
(defn collect-config
	[agent-ui]
	(println "collect config"))

(defn validate-input
	[agent-ui storable-cfg]
	(println "validate input"))

(defn action-performed
	[agent-ui event]
	(println "action performed"))

(fn [fn-name]
	"the fn that bootstraps the agent"
	(case fn-name
		"initialize" initialize
		"display-config" display-config
		"collect-config" collect-config
		"validate-input" validate-input
		"action-performed" action-performed))