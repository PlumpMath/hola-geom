(ns hola_geom.sintriang
  (:require [quil.core :as q]
            [quil.helpers.drawing :as d]
            [quil.helpers.seqs :as s]
            [quil.helpers.calc :as c]
            [thi.ng.geom.types :as t]
            [thi.ng.geom.rect :as r]
            [thi.ng.geom.core :as g]
            [thi.ng.geom.line :as l]
            [thi.ng.geom.triangle :as tr]
            [thi.ng.geom.core.utils :as u]
            [thi.ng.geom.core.vector :as v]
            [thi.ng.math.core :as m]
            [plumbing.core :as p]
            [plumbing.graph :as gr]))

#_(defn sin-line []
  "Dibuja un ciclo completo de la función seno entre los puntos a y b"
  (let [xs (s/range-incl 0 360 1)
        ys (repeat 360 100)
        line-args (d/line-join-points xs ys)]
    (map #(apply l/line2 %) line-args)))


;; (def xs (s/range-incl 0 360 1))
;; (def ys (repeat 360 100))
;; (def line-args (d/line-join-points xs ys))


;; (dorun ( map #(apply l/line2 %) (d/line-join-points   xs ys) ))



;; (def lines (sin-line))






;; ****************************************
;;        Funciones de geom a quil
;; ****************************************

#_(p/defnk line [points]
  (let [[[a b][c d]] points]
    (q/line a b c d)))






;; ****************************************
;;                Sketch
;; ****************************************

#_(defn setup []
  (q/color-mode :hsb 360 100 100)
  (q/smooth))



#_(defn draw []
  (q/background 160 80 100)
  (q/stroke 360)
  (q/stroke-weight 2)
  (q/no-fill)

  (q/line  0 100 500 100)
;(dorun (map line lines))
  )

#_(q/defsketch sintriang
  :size [700 700]
  :setup setup
  :draw draw)
