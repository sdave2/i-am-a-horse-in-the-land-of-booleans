(ns i-am-a-horse-in-the-land-of-booleans
  (:refer-clojure :exclude [boolean]))

(defn boolean [x]
  (case x
    nil false
    false false
    true))

(defn abs [x]
  (if (> x 0)
    x
    (* -1 x)))

(defn divides? [divisor n]
  (= 0 (mod n divisor)))

(defn fizzbuzz [n]
  (let [fizz ["" "" "fizz"]
        buzz ["" "" "" "" "buzz"]
        map-fn (fn [& a]
                 (if (some clojure.string/blank? a)
                   (apply str a)
                   "gotcha!"))]
    (->> (cycle buzz)
         (map map-fn (cycle fizz))
         (take n)
         last)))

(defn teen? [age]
  (<= 13 age 19))

(defn not-teen? [age]
  ((complement teen?) age))

(defn generic-doublificate [x]
  (cond
    (number? x) (* 2 x)
    (empty? x) nil
    (or (list? x) (vector? x)) (-> x count (* 2))
    :else true))

(defn leap-year? [year]
  (cond-> false
    (= 0 (mod year 4)) not
    (= 0 (mod year 100)) not
    (= 0 (mod year 400)) not))

                                        ; '_______'
