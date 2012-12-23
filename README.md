#EmBrace
A tiny purely productivity and coding-style targeted library for producing a clearer, uniformly styled and more natural code in Scala. The API consists of just two functions: `$` and `$$`, - which solve the problems described below.

##Problem: you need to sequentially apply several functions to some value 

####Scala solution:

    f(g(d(x)))

###EmBrace solution:
    
    x $ d $ g $ f

##Problem: you have a single-expression-formatted function and you need to apply another function to its result

Assuming the function you need to add is named `g` and the function you need to edit looks like this:

    def f ( a : List[Int] ) = a filter (_ % 2 == 0) map (_ * 2)

####Scala solution #1:
    
    def f ( a : List[Int] ) = {
      val b = a filter (_ % 2 == 0) map (_ * 2)
      g(b)
    }

####Scala solution #2:
    
    def f ( a : List[Int] ) = g( a filter (_ % 2 == 0) map (_ * 2) )

###EmBrace solution:

    def f ( a : List[Int] ) = a filter (_ % 2 == 0) map (_ * 2) $ g

How's that better? You have the logic applied to the argument sequentially, the function looks like a flow of transformations applied to an input value instead of scattered operations. Code like that is much easier to write, read and refactor: you just append `$`-functions and throw the braces management hell out of your head.

##Problem: You have a tuple which you want to pass as a parameter list to a function
####Scala solution #1:

    tuple match { case (a, b) => f(a, b) }

####Scala solution #2:

    (f _).tupled(tuple)

####Scala solution #3:

    Function.tupled(f)(tuple)

###EmBrace solution:
    
    tuple $$ f

##Unintended effect: `$` can be used instead of `match`

####Scala:

    x match {
      case 1 => ...
      case 2 => ...
    }

###Embrace:

    x $ {
      case 1 => ...
      case 2 => ...
    }

## Why `$`?
The choice of this name has been inspired by the Haskell programming language in which there exists a similar standard function which works in kinda reverse order due to particular differences of the languages.

##Using EmBrace
The library is distributed in Maven Central repository, so just add the following dependency to your project or the appropriate SBT dependency:

    <dependency>
      <groupId>com.github.nikita-volkov</groupId>
      <artifactId>embrace</artifactId>
      <version>0.1.3</version>
    </dependency>

In your Scala code you just have to add the following import statement:

    import embrace._
    
