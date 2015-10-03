(ns hola_geom.graphics
  (:require [clojure.java.javadoc :as doc]))

(def frame (java.awt.Frame.))

;; El punto despues de la clase java.awt.Frame es un idiomatic form
;; de crear una nueva instancia de esa clase. La special form sería "new"

#_(for [meth (.getMethods java.awt.Frame)
      :let [name (.getName meth)]
      :when (re-find #"Vis" name) ;; :when nos permite filtrar los métodos al enseñarnos
                                  ;; solo los que tienen "Vis" en su nombre.
      ]
  name)

;; (.isVisible frame)

;; Para aplicar un método a una instancia, como frame, se añade un punto delante: .isVisible
;; isVisible viene por defecto como "false"

(.setVisible frame true)

;; Para cambiarle el tamaño a 200x200

;; (.setSize frame (java.awt.Dimension. 250 250))

;; Con getGraphics creamos un contexto gráfico en el que poder dibujar
(def gfx (.getGraphics frame))

;; gfx es uan instancia de la clase Graphics
;(class gfx)

;; A la cual le podemos aplicar el método fillRect

;; (.setColor gfx (java.awt.Color. 255 0 0))
;; (.fillRect gfx 100 100 50 75)


;; XORing
;; 0001 (decimal 1)
;; 0010 (decimal 2)
;; ____
;; 0011 (decimal 3)



#_(defn xors [max-x max-y]
  (for [x (range 0 max-x 1) y (range 0 max-y 1)]
  [x y (bit-xor x y)]))


;(defn clear [g] (.clearRect g 0 0 256 256))


(defn f-values [f xs ys]
  (for [x (range xs) y (range ys)]
    [x y (rem (f x y) 256)]))


(defn draw-rules [fr gr f xs ys]
  (clear gr)
  (.setSize fr (java.awt.Dimension. xs ys))
  (doseq [[x y v] (f-values f xs ys)]
    (.setColor gfx (java.awt.Color. v v v))
    (.fillRect gfx x y 1 1)))

(defn draw-rules2 [fr gr f xs ys]
  (clear gr)
  (.setSize fr (java.awt.Dimension. xs ys))
  (doseq [[x y v] (f-values f xs ys)]
    (cond
     (<= (+ x y) (- xs 1)) (.setColor gfx (java.awt.Color. v v v ))
     (> (+ x y) (- xs 1)) (.setColor gfx (java.awt.Color. (- 255 v) (- 255 v) (- 255 v))))
    (.fillRect gfx x y 1 1)))


(draw-rules frame gfx #(* (Math/sin %) (Math/cos %2)) 256 256)

(draw-rules2 frame gfx bit-xor 256 256)

(#(* 256 (+ (Math/sin %) (Math/cos %2))) 0 256)


#_((def mx 15)
(def my 15)

(defn xorsb [max-x max-y]
  (let [array (for [x (range max-x) y (range max-y)]
                (bit-xor x y))]
    (partition max-x array)
       ))


(defn array-file [nf array]
  (nth array nf))

(array-file 0 (xorsb mx my))


(prn (array-file 0 (xorsb mx my)))
(prn (array-file 1 (xorsb mx my)))
(prn (array-file 2 (xorsb mx my)))
(prn (array-file 3 (xorsb mx my)))
(prn (array-file 4 (xorsb mx my)))
(prn (array-file 5 (xorsb mx my)))
(prn (array-file 6 (xorsb mx my)))
(prn (array-file 7 (xorsb mx my)))
(prn (array-file 8 (xorsb mx my)))
(prn (array-file 9 (xorsb mx my)))
(prn (array-file 10 (xorsb mx my)))
(prn (array-file 11 (xorsb mx my)))
(prn (array-file 12 (xorsb mx my)))
(prn (array-file 13 (xorsb mx my)))
(prn (array-file 14 (xorsb mx my))))


















