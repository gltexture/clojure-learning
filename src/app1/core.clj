(ns app1.core
  (:require [clojure.set :as set]))
(require '[clojure.string :as string])

(defn chapter1 []
  (do
    (println (= (= (+ 1 1) 2) true))
    (println (= 2 (+ 1 1)))
    (println (= (+ 3 4) 7 (+ 2 5)))
    (println (= true (= 2 2/1)))
    (println (= false (= 2 2.0)))
    (println (= true (== 2.0 2)))
    (println (= true (not (= 1 nil))))
    (println (= false (= "hello" :hello 'hello)))
    (println (= :hello (keyword "hello")))
    (println (= 'hello (symbol "hello")))
    (println (= nil nil))
    (println (not= :fill-in-the-blank :other))
    ))

;; (chapter1)

(defn chapter2 []
  (do
    (println (= (name :hello) "hello"))
    (println (= "world" (str 'world)))
    (println (= "Coolright?" (str "Cool" "right?")))
    (println (= \C (get "Characters" 0)))

    (println "===============")

    (println (= 11 (count "Hello World")))
    (println (= false (= \c "c")))
    (println (= false (= \c 'c)))
    (println (= "World" (subs "Hello World" 6 11)))
    (println (= "123" (string/join '(1 2 3))))

    (println "===============")

    (println (= "1, 2, 3" (string/join ", " '(1 2 3))))
    (println (= ["1" "2" "3"] (string/split-lines "1\n2\n3")))
    (println (= "olleh" (string/reverse "hello")))
    (println (= 0 (string/index-of "hello world" "hello")))

    (println "===============")

    (println (= 13 (string/last-index-of "hello world, hello" "hello")))
    (println (= nil (string/index-of "hello world" "bob")))
    (println (= "hello world" (string/trim "  \nhello world \t \n")))
    (println (= true (char? \c)))

    (println "===============")

    (println (= false (char? "a")))
    (println (= false (string? \b)))
    (println (= true (string? "test")))
    (println (= true (string/blank? "")))

    (println "===============")

    (println (= true (string/blank? " \n \t  ")))
    (println (= false (string/blank? "hello?\nare you out there?")))
    ))

(defn chapter3 []
  (do
    (println (= '(1 2 3 4 5) (list 1 2 3 4 5)))
    (println (= 1 (first '(1 2 3 4 5))))
    (println (= '(2 3 4 5) (rest '(1 2 3 4 5))))
    (println (= 3 (count '(dracula dooku chocula))))
    (println (= 0 (count '())))
    (println (= '() (rest '(100))))
    (println (= '(:a :b :c :d :e) (cons :a '(:b :c :d :e))))
    (println (= '(:e :a :b :c :d) (conj '(:a :b :c :d) :e)))
    (println (= :a (peek '(:a :b :c :d :e))))
    (println (= '(:b :c :d :e) (pop '(:a :b :c :d :e))))
    (println (= "No dice!" (try
            (pop '())
            (catch IllegalStateException e
              "No dice!"))))
    (println (= '() (try
            (rest '())
            (catch IllegalStateException e
              "No dice!"))))
    ))

;; (chapter3)

(defn chapter4 []
  (do
    (println (= 1 (count [42])))
    (println (= [1] (vec '(1))))
    (println (= [nil nil] (vector nil nil)))
    (println (= [1 2] (vec '(1 2))))
    (println (= [111 222 333] (conj [111 222] 333)))
    (println (= :peanut (first [:peanut :butter :and :jelly])))
    (println (= :jelly (last [:peanut :butter :and :jelly])))
    (println (= :jelly (nth [:peanut :butter :and :jelly] 3)))
    (println (= [:butter :and] (subvec [:peanut :butter :and :jelly] 1 3)))
    (println (= (list 1 2 3) (vector 1 2 3)))
    ))

; (chapter4)

(defn chapter5 []
  (do
    (println (= #{3} (set [3])))
    (println (= 3 (count #{1 2 3})))
    (println (= #{1 2 3 4 5} (set '(1 1 2 2 3 3 4 4 5 5))))
    (println (= #{1 2 3 4 5} (set/union #{1 2 3 4} #{2 3 5})))
    (println (= #{2 3} (set/intersection #{1 2 3 4} #{2 3 5})))
    (println (= #{1 4} (set/difference #{1 2 3 4 5} #{2 3 5})))
    ))

; (chapter5)

(defn chapter6 []
  (do
    (println (= {:a 1 :b 2} (hash-map :a 1 :b 2)))
    (println (= {:a 1} (hash-map :a 1)))
    (println (= 2 (count {:a 1 :b 2})))
    (println (= 2 (get {:a 1 :b 2} :b)))
    (println (= 1 ({:a 1 :b 2} :a)))
    (println (= 1 (:a {:a 1 :b 2})))
    (println (= "Sochi" ({2010 "Vancouver" 2014 "Sochi" 2018 "PyeongChang"} 2014)))
    (println (= nil (get {:a 1 :b 2} :c)))
    (println (= :key-not-found (get {:a 1 :b 2} :c :key-not-found)))
    (println (= true (contains? {:a nil :b nil} :b)))
    (println (= false (contains? {:a nil :b nil} :c)))
    (println (= {1 "January" 2 "February"} (assoc {1 "January"} 2 "February")))
    (println (= {1 "January"} (dissoc {1 "January" 2 "February"} 2)))
    (println (= {:a 1 :b 2 :c 3} (merge {:a 1 :b 2} {:c 3})))
    (println (= {:a 1 :b 2 :c 3} (merge-with + {:a 1 :b 1} {:b 1 :c 3})))
    (println (= (list 2010 2014 2018)
       (sort (keys { 2014 "Sochi" 2018 "PyeongChang" 2010 "Vancouver"}))))
    (println (= (list "PyeongChang" "Sochi" "Vancouver")
       (sort (vals {2010 "Vancouver" 2014 "Sochi" 2018 "PyeongChang"}))))
    (println (= {:a 2 :b 3}
       (into {}
             (map
               (fn [[k v]] [k (inc v)])
               {:a 1 :b 2}))))
    ))

; (chapter6)

(defn multiply-by-ten [n]
  (* 10 n))
(defn square [n] (* n n))

(defn chapter7 []
  (do
    (
      (println (= 81 (square 9)))
      (println (= 20 (multiply-by-ten 2)))
      (println (= 10 ((fn [n] (* 5 n)) 2)))
      (println (= 60 (#(* 15 %) 4)))
      (println (= 15 (#(+ %1 %2 %3) 4 5 6)))
      (println (= "AACC" (#(str "AA" %2) "bb" "CC")))
      (println (= 9 ((fn [n k] (+ n k)) 4 5)))
      (println (= 20 ((fn [f] (f 4 5)) *)))
      (println (= 25 (+ ((fn [n] (* n n)) 4) 9)))
      (println (= 25 (+ (square 4) 9)))
     )
    ))

; (chapter7)

(defn explain-exercise-velocity [exercise-term]
  (case exercise-term
    :bicycling        "pretty fast"
    :jogging          "not super fast"
    :walking          "not fast at all"
    "is that even exercise?"))

(defn chapter8 []
  (do
    (
      (println (= :a (if (false? (= 4 5)) :a :b)))
      (println (= [] (if (> 4 3) [])))
      (println (= nil (if (nil? 0) [:a :b :c])))
      (println (= :glory (if (not (empty? ())) :doom :glory)))
      (println (let [x 5] (= :your-road (cond (= x 6) :road-not-taken (= x 7) :another-road-not-taken :else :your-road))))
      (println (= 'doom (if-not (zero? 1) 'doom 'more-doom)))
      (println (= "pretty fast" (explain-exercise-velocity :bicycling)))
      (println (= "is that even exercise?" (explain-exercise-velocity :watching-tv)))
     )
    ))

; (chapter8)

(defn chapter9 []
  (do
    (println (= [4 8 12] (map (fn [x] (* 4 x)) [1 2 3])))
    (println (= [1 4 9 16 25] (map (fn [x] (* x x)) [1 2 3 4 5])))
    (println (= [false false true false false] (map nil? [:a :b nil :c :d])))
    (println (= '() (filter (fn [x] false) '(:anything :goes :here))))
    (println (= '(:anything :goes :here) (filter (fn [x] true) '(:anything :goes :here))))
    (println (= [10 20 30] (filter (fn [x] (<= x 30)) [10 20 30 40 50 60 70 80])))
    (println (= [10 20 30] (map (fn [x] (* x 10)) (filter (fn [x] (<= x 3)) [1 2 3 4 5 6 7 8]))))
    (println (= 24 (reduce (fn [a b] (* a b)) [1 2 3 4])))
    (println (= 2400 (reduce (fn [a b] (* a b)) 100 [1 2 3 4])))
    (println (= "longest" (reduce (fn [a b] (if (< (count a) (count b)) b a)) ["which" "word" "is" "longest"])))
    )
  )

; (chapter9)

(defn hello
  ([] "Hello World!")
  ([a] (str "Hello, you silly " a "."))
  ([a & more] (str "Hello to this group: " (apply str (interpose ", " (cons a more))) "!")))

(defmulti diet (fn [x] (:eater x)))
(defmethod diet :herbivore [a]
  (cond
    (= (:name a) "Bambi") "Bambi eats veggies."
    (= (:name a) "Thumper") "Thumper eats veggies."
    :else "Some"
  )
)

(defmethod diet :carnivore [a]
  (if (= (get a :name) "Simba")
    "Simba eats animals."
  )
)
(defmethod diet :default [a] "I don't know what Rich Hickey eats.")

(defn chapter10 []
  (do
    (println (= "Hello World!" (hello)))
    (println (= "Hello, you silly World." (hello "World")))
    (println (= "Hello to this group: Peter, Paul, Mary!" (hello "Peter" "Paul" "Mary")))
    (println (= "Bambi eats veggies." (diet {:species "deer" :name "Bambi" :age 1 :eater :herbivore})))
    (println (= "Thumper eats veggies." (diet {:species "rabbit" :name "Thumper" :age 1 :eater :herbivore})))
    (println (= "Simba eats animals." (diet {:species "lion" :name "Simba" :age 1 :eater :carnivore})))
    (println (= "I don't know what Rich Hickey eats." (diet {:name "Rich Hickey"})))
    )
  )

; (chapter10)

(defn chapter11 []
  (do
    (println (= [1 2 3 4] (range 1 5)))
    (println (= [0 1 2 3 4] (range 5)))
    (println (= [0 1 2 3 4 5 6 7 8 9] (take 10 (range 100))))
    (println (= [95 96 97 98 99] (drop 95 (range 100))))
    (println (= [1 2 4 8 16 32 64 128] (take 8 (iterate (fn [x] (* x 2)) 1))))
    (println (= [:a :a :a :a :a :a :a :a :a :a] (repeat 10 :a)))
    (println (= (repeat 100 "hello") (take 100 (iterate identity "hello"))))
  )
)

; (chapter11)

(defn chapter12 []
  (do
    (println (= [0 1 2 3 4 5] (for [x (range 6)] x)))
    (println (= '(0 1 4 9 16 25) (map (fn [x] (* x x)) (range 6)) (for [x (range 6)] (* x x))))
    (println (= '(1 3 5 7 9) (filter odd? (range 10)) (for [x (range 10) :when (odd? x)] x)))
    (println (= '(1 9 25 49 81) (map (fn [x] (* x x)) (filter odd? (range 10))) (for [x (range 10) :when (odd? x)] (* x x))))
    (println (= [[:top :left] [:top :middle] [:top :right]
        [:middle :left] [:middle :middle] [:middle :right]
        [:bottom :left] [:bottom :middle] [:bottom :right]]
       (for [row [:top :middle :bottom] column [:left :middle :right]] [row column])))
    )
  )

; (chapter12)

(defn chapter13 []
  (do
    (println (= [true false true] (let [not-a-symbol? (complement symbol?)] (map not-a-symbol? [:a 'b "c"]))))
    (println (= [:wheat "wheat" 'wheat] (let [not-nil? (complement nil?)] (filter not-nil? [nil :wheat nil "wheat" nil 'wheat nil]))))
    (println (= 20 (let [multiply-by-5 (partial * 5)] (multiply-by-5 4))))
    (println (= [:a :b :c :d] (let [ab-adder (partial concat [:a :b])] (ab-adder [:c :d]))))
    (println (= 25 (let [inc-and-square (comp square inc)] (inc-and-square 4))))
    (println (= 8 (let [double-dec (comp dec dec)] (double-dec 10))))
    (println (= 99 (let [square-and-dec (comp dec square)] (square-and-dec 10))))
    )
  )

; (chapter13)

(defn is-even? [n]
  (if (= n 0) true (complement (is-even? (dec n)))))

(defn is-even-bigint? [n]
  (loop [n n acc true]
    (if (= n 0) acc (recur (dec n) (not acc)))))

(defn recursive-reverse [coll]
  (loop [coll coll reversed []]
    (if (empty? coll) reversed (recur (rest coll) (cons (first coll) reversed)))
    )
  )

(defn factorial [n]
  (loop [i n res 1]
    (if (<= i 1) res (recur (dec i) (* res i))))
  )

(defn chapter14 []
  (do
    (
      (println (= true (is-even? 0)))
      (println (= false (not (is-even? 1))))
      (println (= false (is-even-bigint? 100003N)))
      (println (= '(1) (recursive-reverse [1])))
      (println (= '(6 5 4 3 2) (recursive-reverse [2 3 4 5 6])))
      (println (= 1 (factorial 1)))
      (println (= 2 (factorial 2)))
      (println (= 6 (factorial 3)))
      (println (= 24 (factorial 4)))
      (println (< 1000000000000000000000000N (factorial 1000N)))
      (println (< 1000000000000000000000000N (factorial 100003N)))
    )
  )
  )

; (chapter14)

(def test-address
  {:street-address "123 Test Lane"
   :city "Testerville"
   :state "TX"})

(defn chapter15 []
  (do
    (println (= ":bar:foo" ((fn [[a b]] (str b a)) [:foo :bar])))
    ;   (println (= (str "An Oxford comma list of apples, " "oranges, " "and pears.") ((fn [[a b c]] (str "An Oxford comma list of " a ", " b ", " and c ".")) ["apples" "oranges" "pears"])))
    (println (= "Rich Hickey aka The Clojurer aka Go Time aka Lambda Guru" (let [[first-name last-name & aliases] (list "Rich" "Hickey" "The Clojurer" "Go Time" "Lambda Guru")]  (str first-name " " last-name " aka " (clojure.string/join " aka " aliases)))))
    (println (= {:original-parts ["Stephen" "Hawking"] :named-parts {:first "Stephen" :last "Hawking"}} (let [[first-name last-name :as full-name] ["Stephen" "Hawking"]] {:original-parts [first-name last-name] :named-parts {:first "Stephen" :last "Hawking"}})))
    (println (= "123 Test Lane, Testerville, TX" (let [{street-address :street-address, city :city, state :state} test-address] (str street-address ", " city ", " state))))
    (println (= "123 Test Lane, Testerville, TX" (let [{:keys [street-address city state]} test-address] (str street-address ", " city ", " state))))
    (println (= "Test Testerson, 123 Test Lane, Testerville, TX" (let [[first-name last-name] ["Test" "Testerson"] {:keys [street-address city state]} test-address] (str first-name " " last-name ", " street-address ", " city ", " state))))
    )
  )

; (chapter15)

(def the-world (ref "hello"))
(def bizarro-world (ref {}))

(defn chapter16 []
  (do
    (println (= "hello" (deref the-world)))
    (println (= "hello" @the-world))
    (println (= "better" (do (dosync (ref-set the-world "better")) @the-world)))
    (println (= "better!!!" (let [exclamator (fn [x] (str x "!"))]
            (dosync
              (alter the-world exclamator)
              (alter the-world exclamator)
              (alter the-world exclamator))
            @the-world)))
    (println (= 0 (do (dosync (ref-set the-world 0)) @the-world)))
    (println (= 20 (do (dosync (alter the-world (fn [x] 20))))))
    (println (= ["Real Jerry" "Bizarro Jerry"]
       (do
         (dosync
           (ref-set the-world {})
           (alter the-world assoc :jerry "Real Jerry")
           (alter bizarro-world assoc :jerry "Bizarro Jerry")
           [(:jerry @the-world) (:jerry @bizarro-world)]))))
    )
  )

; (chapter16)

(def atomic-clock (atom 0))

(defn chapter17 []
  (do
    (println (= 0 @atomic-clock))
    (println (= 1 (do (swap! atomic-clock inc) @atomic-clock)))
    (println (= 5 (do (swap! atomic-clock (fn [x] (+ x 4))) @atomic-clock)))
    (println (= 20 (do (swap! atomic-clock + 1 2 3 4 5) @atomic-clock)))
    (println (= :fin (do (compare-and-set! atomic-clock 20 :fin) @atomic-clock)))
    (println (= 20 (do (compare-and-set! atomic-clock :fin 20) @atomic-clock)))
    )
  )

(chapter17)