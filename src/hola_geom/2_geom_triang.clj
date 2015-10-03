(ns hola_geom.2_geom_triang
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
            [plumbing.graph :as gr]

            ))

(defn sin-line []
  "Dibuja un ciclo completo de la función seno entre los puntos a y b"
  (let [xs (s/range-incl 0 360 1)
        ys (repeat 360 100)
        line-args (d/line-join-points xs ys)] ;; Buscar como sustituir d/line-join-points
    (map #(apply l/line2 %) line-args)))


;(def xs (s/range-incl 0 360 1))
;(def ys (repeat 360 100))
;(def line-args (d/line-join-points xs ys))


;(dorun ( map #(apply l/line2 %) (d/line-join-points   xs ys) ))



(def lines (sin-line))

(l/line2 500 600 700 800  )
(def linestrip (l/linestrip2 [500 500] [600 600] [700 500]))



;; ****************************************
;;        Funciones de geom a quil
;; ****************************************

(p/defnk line [points]
  (let [[[a b][c d]] points]
    (q/line a b c d)))

(p/defnk vertex-shape [points]
  (let [pts (s/seq->stream points)]
    (q/begin-shape)
   ;(q/vertex 500 500)
   ;(q/vertex 600 600)
   ;(q/vertex 700 500)


   ; (dorun (map #(apply q/vertex points)))
    (q/end-shape)))


  ( map #(reduce v/vec2 %)  [[1 1][2 2][3 3]])

(def a  (s/seq->stream (:points (l/linestrip2 [500 500] [600 600] [700 500]))))
(a)




;; ****************************************
;;                Sketch
;; ****************************************

(defn setup []
  (q/color-mode :hsb 360 100 100)
  (q/smooth))



(defn draw []
  (q/background 160 80 100)
  (q/stroke 360)
  (q/stroke-weight 2)
  (q/no-fill)

  (dorun (map line lines))
  (vertex-shape linestrip)


  )

(q/defsketch geom
  :size [700 700]
  :setup setup
  :draw draw)
