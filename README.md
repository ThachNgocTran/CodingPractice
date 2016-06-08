# Practice Coding some small puzzles in a variety of programming languages.
Written in Java, Python (for the moment!).

Many puzzles here are from the book below. I don't try to write perfect code or optimize it as much as possible because "Premature optimization is the root of all evil (Donald Knuth)".

Normally there are many ways to overcome an issue (reading files, for example). We take some time to investigate a variety of approaches (their pros and cons); then we apply them, and forget most of them in the next week. Until some day, we encounter the issue again, but the old code snippet may have been lost somewhere. Now the journey of finding the solution again... (a waste of time!)

I often note down those findings using Google Docs, but now GitHub is such a much better way. Keep everything on the cloud, and they will be readily available when needed.

## Interesting points learnt:

* For checking duplicates in a collection, it's good to apply some kinds of "hashmap". One ideal approach is to use the value of element as its position in an array of bits. When an element encountered for the first time, we turn the bit at the corresponding position to 1. In Java, we have HashMap class, which is convenient for counting duplicates.

* Python embraces the idea of "consenting adults". For example, there is no private field in a module or a class. Just use the prefix "\_" or "\_\_" as a warning to users that they should avoid directly using such fields/methods.

## Software Environment:

* IntelliJ IDEA Community Edition 2016.1.2

* PyCharm Community Edition 2016.1.4

* Python v3.5 64-bit

* Java v1.8.0_92 64-bit

## References:

* [Cracking the Coding Interview (Gayle Laakmann McDowell)] (http://www.amazon.com/Cracking-Coding-Interview-6th-Programming/dp/0984782850/)
