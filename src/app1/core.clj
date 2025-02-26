(ns app1.core)
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

(chapter2)