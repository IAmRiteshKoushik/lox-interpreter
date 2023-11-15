## The Parts of a Language

### Step 1 : Scanning

Also known as lexing or `lexical analysis`. A scanner (or lexer) takes in a linear 
stream of characters and chunks them together into a series of something meaningful.
Ing programming, each of these words are called "tokens". Some tokens are single
characters while other can be a combination of characters. 

Eg : "(", ")" are single character tokens while "123" and "hello" are multi-character
tokens.

Some characters like "whitespace" in a source file do not mean anything. A scanner 
also discards comments in a programming language's source code. 

```java
var average = (min + min) / 2;
```

### Step 2 : Parsing

Parsing is where our syntax gets something similar to a "grammar". A parser takes 
a flat sequence of tokens and builds a tree structure that mirrors the nested nature of the grammar. These go by a few different names - "parse tree", "abstract syntax tree"
, or just "trees".

The job of the parser is to report about syntax errors.

### Step 3 : Static Analysis

While the first two stages are pretty similar across all implementations. But then
the individual characteristics of a language start coming into play. The first
bit of analysis that most languages do is called *binding* or *resolution*. 

For each identifier we find out where that name is defined and wire the two together. 
This is where *scope* comes in - a certain name is used to refer to a certain
declaration. If a language is statically typed, this is when we type check.

```java
// For example
a + b
```

### Step 4 : Intermediate Representations

The compiler as a pipeline where each stage's job is to organize the data 
representing the user's code in a way that makes the next stage simpler 
to implement.

In themiddle the code may be stored in some intermediate representation (or IR)
that is not tightly tied to either the source or destination forms.
Instead, the IR acts as an interface between these two langauges.

Look into - control flow graph, static single-assignment, continuation-passing style
three-address code

### Step 5 : Optimization

Let's take the example of "constant folding": if some expression always evaluates to 
the exact same value, we can do the evaluation at compile time and replace the code 
for the expression with its result. For example :
```java
area = 3.14159 * (0.75 / 2) * (0.75 / 2);
// can be folded into
area = 0.4417860938;
```

However many successful languages have surprisingly few compile-time optimizations.
Many of them focus most of their performance effort on the runtime.

### Step 6 : Code Generation

Here, code refers to the primitive assembly like instructions a CPU runs and not the 
kind of "source code" a human might want to read. 

Finally, we are in the backend. Here, our code becomes more and more primitive. It 
is like evolution but in reverse. Here, we have a decision to make - do we generate 
instructions for a real CPU or a virtual one ? Native code is lightning fast, but 
generating it with today's architecutre means that there is a lot of work to be done. 

Also, langauges are supposed to be independent of the architecture (x86 or ARM) so 
many a languages got around this by generating something called as bytecode where 
each instruction is roughly one-byte long. 

These synthetic instructions are designed to map a little more closely to the language
semantics and not be so tied to the peculiarities of one machine's architecture. 

### Step n+2 : Virtual Machine

## Shortcuts and Alternate Routes 

### Single-pass compilers
### Tree-walk interpreters
### Transpilers
### Just-in-time compilation


