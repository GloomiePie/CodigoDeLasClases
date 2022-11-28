//Problema de los efectos colaterales
//ejemplo

var cont = 0
val addOne = {
    cont = cont + 1 // El efecto colateral ocurre aqui
}
//El efecto colateral consiste en cambiar el valor de los atributos que esten fuera de la función

val newState = print("Hola")

//la estructura 'var' es una variable mutable en cambio 'val' es inmutable
//A continuacion una funcion impura

def division(n1: Double, n2: Double) =
    if(n2 == 0) throw new RuntimeException("Division por 0")
    else n1/n2

division(4, 2)

//A continuacion una funcion pura
import scala.util.Try
def pureDivision(n1: Double, n2: Double): Try[Double] = 
    Try{division(n1, n2)}

pureDivision(5, 2)
/*
Las funciones puras son aquellas que siempre devuelven el mismo tipo de dato, en cambio las impuras,
saben variar el tipo, a la vez las funciones impuras tienen efectos colaterales, en cambio 
las funciones puras no
*/

import scala.util.{Success, Failure}

val result = pureDivision(1, 3)
result match{
    case Success(v) => println(v)
    case Failure(e) => println(e.getMessage) 
}

val result2 = pureDivision(1, 0)
result2 match{
    case Success(v) => println(v)
    case Failure(e) => println(e.getMessage) 
}

//Option / Some / None

def toInt(s: String): Option[Int] ={
    try{
        Some(Integer.parseInt(s))
    } catch {
        case e: Exception => None
    }
}
toInt("1")
toInt("Uno")
val txtNumber = List("1", "2", "foo", "3", "bar")
txtNumber.map(toInt)
txtNumber.map(toInt).flatten

//Obtener valores
//getOrElse / foreach / match

val x = toInt("1").getOrElse(0)
toInt("1").foreach{ i => printf("Obtener un int: %d", i)}
toInt("Dos") match{
    case Some(i) => println(i)
    case None => println("That didn't work my dude, try something else :/")
}

//Either / Left / Right

def divideXByY(x: Int, y: Int): Either[String, Int] =
    if(y == 0) Left("No se puede dividir por 0")
    else Right(x/y)

divideXByY(1, 0)

//Trabaja como si fuera Try, Success y Failure
//Try -> Either, Failure -> Left, Succes -> Right

val x2 = divideXByY(1, 1).right.getOrElse(0)
val x3 = divideXByY(1, 0).right.getOrElse(0)

divideXByY(1, 0) match{
    case Left(s) => println("Answer: "+ s)
    case Right(i) => println("Answer: "+ i)
}

//Recomendacion usar Try/ Success/ Failure