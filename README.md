# Practice Coding some small puzzles in a variety of programming languages.
Written in Java, Python (for the moment!).

Many puzzles here are from the book below. I don't try to write perfect code or optimize it as much as possible because "Premature optimization is the root of all evil (Donald Knuth)".

## Interesting points learnt:

* For checking duplicates in a collection, it's good to apply some kinds of "hashmap". One ideal approach is to use the value of element as its position in an array of bits. When an element encountered for the first time, we turn the bit at the corresponding position to 1. In Java, we have HashMap class, which is convenient for counting duplicates.

* Python embraces the idea of "consenting adults". For example, there is no private field in a module or a class. Just use the prefix "_" or "__" as a warning to users that they should avoid directly using such fields/methods.

## Software Environment:

* IntelliJ IDEA Community Edition 2016.1.2

* PyCharm Community Edition 2016.1.4

* Python v3.5 64-bit

* Java v1.8.0_92 64-bit

## References:

* [Cracking the Coding Interview (Gayle Laakmann McDowell)] (http://www.amazon.com/Cracking-Coding-Interview-6th-Programming/dp/0984782850/)
