# CodigoDeLasClases
Semana 4
----------------------------------------------------------------------
-Funcion que puede asignarse

val cedula = "1105964694"
cedula = "1105964693"
----------------------------------------------------------------------
-Funciones de Orden Superior

    .Funcion que puede asignarse a un valor:
    (x:Double) => -Math.pow(x,2) + 8 * x - 12
    val f1 = (x:Double) => -Math.pow + 8 * x - 12

-----------------------------------------------------------------------
-Funcion que devuelve otra funcion:
    def select(option: Char) : (Int, Int) => Double = {
        option match {   //Similar a un switch case
            case '+' => (a: Int, b: Int) => a + b
            case '-' => (a: Int, b: Int) => a - b
            case '' => (a: Int, b: Int) => a b
            case '/' => (a: Int, b: Int) => a / b.toDouble
            case  => (a: Int, b: Int) => 0/(a+b) //Para que devuelva siempre 0,  significa default
        }
    }

    select('+')(2, 1)
    val operation = select('+')
    operation(2, 1)

-------------------------------------------------------------------------------------------------------
Dada una lista de enteros [5, 6, 7, 8, 9] ¿Cuántos son pares?

val isEven = (k : Int) => if (k % 2 == 0) 1 else 0

def isEven(k : Int) : Int = (k % 2) match{
    case 0 => 1
    case  => 0
}

//Ambas funciones son lo mismo, la funcion con nombre es mas funcional

def countEven(s : List[Int]) : Int = s.map(isEven).sum

//Resultado

-------------------------------------------------------------------------------------------------------

sum // método que calcula la suma de todos los números de la lista
map // Aplica a cada elemento y como resultado lo ubica en una nueva lista (nombre diferente)

List(1, 2, 3).map(x=> x * x + 100 * x)
res3: List[Int] = List(101, 204, 309)

val nums = List(1, 2, 3)
nums.map(x => x + 1) //Resultado (2, 3, 4)

def add1(a : Int) : Int = a + 1
nums.map(add1)

nums.map(x => add1(x))
nums.map(x => add1())

val suma2 = (a: Int, b: Int) => a+b
nums.map(x => sumaDos(x, x))
val cedula = "1106765321"
cedula = "1106239138" //Al reasignar valores, produce error
var cedula = "1106765321" //Cambio correcto (var en lugar de val para cambiar valores)

f(x) = -x^2 + 8x - 12                        --------- Matematica
(x: Double) => -Math.pow(x, 2) + 8 * x - 12          -- Programacion
val f1 = (x: Double) => -Math.pow(x, 2) + 8 * x - 12 
f1(12)                             // Se invoca a la funcion aignada al valor f1
((x: Double) => -Math.pow(x, 2) + 8 * x - 12)(12)      // Forma de invocar una funcion en una misma sentencia, "anonima" 

-------------------------------------------------------------------------------------------------------
# Código Semana 5


def isEven(k : Int) : Int = (k % 2)match {
	case 0 => 1
	case _=> 0
}
def countEven(s : List[Int]) : Int = s.map(isEven).sum



def countEven(s : List[Int]) : Int = {
	def isEven(k : Int) : Int = (k % 2)match {
	case 0 => 1
	case _=> 0
	}
 s.map(isEven).sum
}



def countEven(s : List[Int]) : Int = {
	val isEven(k : Int) : Int => k % 2 match {
	case 0 => 1
	case _=> 0
	}
 s.map(isEven).sum
}

Mapeo de una lista de cadenas de texto a lista de enteros que representan la longitud del texto

val names : List[String] = List("Leo", "Cristiano", "Enner", "Felipe")
names.map(_.length)

Dada una lista de números enteros, desarrollar las funciones necesarias que le permitan contar cuantos elementos de la lista son números primos

val numbers = List(3, 4, 7, 11, 12)
val isPrime = (nro : Int) => (2 to nro - 1).forall(nro % _ != 0)
numbers.map(isPrime(_) match {
	case true => 1
	case false => 0
}).sum
Otro tipo de funciones 
val numbers = List(6, 28, 15, 12, 11, 24)

numbers.max
res26: Int = 28

numbers.min
res27: Int = 6

numbers.size
res28: Int = 6

El forall devuelve true sí y solo si el predicado devuelve true para todos los valores de la lista
val isPrime = (nro : Int) : Boolean = (2 until nro).forall(nro % _ != 0)

El exists devuelve true si y solo si el predicado devuelve true para por lo menos un valor de la lista
def isPrime(nro : Int) : Boolean = !(2 until nro).exists(nro % _ == 0)

El filter devuelve una lista que únicamente contiene los valores que cumplen con el predicado
List(1, 2, 3, 4, 5).filter(k => k % 3 != 0)
res: List[Int] = List(1, 2, 4, 5)

El takeWhile trunca la lista cuando encuentra un valor que no cumple con el predicado
List(1, 2, 3, 4, 5).takeWhile(k => k % 3 != 0)
res: List[Int] = List(1, 2)



(n : Int) => (1 until n).filter(div => n % div == 0)
val sumDiv = (n : Int) => (1 until n).filter(div => n % div == 0)

 
val numbers = List(6, 28, 15, 12, 11, 24)
val sumDiv = (nro : Int) => (1 until nro).filter(div => nro % div == 0)

numbers.filter(nro => nro == sumDiv2(nro)).size

Factorial escalonado
def FactorialEscalonado(n : Int) : Int ={
    n % 2 match {
        case 0 => (2 to n by 2).product
        case _ => (1 to n by 2).product
    }
 }

 FactorialEscalonado(8)
 FactorialEscalonado(9)

Pares e Impares
val numbers = (1 to 20).toList

 //Contar pares
 numbers.filter(nro => nro % 2 == 0).size
 numbers.count(nro => nro % 2 == 0)

 //Contar impares
 numbers.filter(nro => nro % 2 != 0).size
 numbers.count(nro => nro % 2 != 0)

Cuenta primos

//Contar primos
 def contarPrimos(nros : List[Int]) : Int = {
    val isPrime = (n : Int) => (2 until n).forall(n % _ != 0)
    nros.filter(isPrime).size
    //nros.count(isPrime)
 }

 contarPrimos(numbers)

3 factores
//Presentar 3 factores
 def tresFactores(nros : List[Int]) : List[Int] = {
    val factores = (n : Int) => (2 until n).filter(n % _ == 0)

    nros.filter(nro => factores(nro).size == 3)
 }
 tresFactores((1 to 1000).toList)
------------------------------------------------------------------------------
Semana 6
1.	Función para calcular desviación estándar de un grupo de números
val nros = List(727.7, 1086.5, 1361.3, 1490.5, 1956.1)

def promedio(valores : List[Double]) : Double = valores.sum / valores.size

def devEst(valores : List[Double]) : Double = {
	val avg = promedio(valores)

	def varianza(valores: List[Double]) : Double =
		valores.map(x => Math.pow(x - avg, 2)).sum * (1.0/ valores.size)

	Math.sqrt(varianza(valores))
}
def clasifica(valores : List[Double]): Unit ={
    val s = devEst(valores)
    val avg = promedio(valores)

    (1 to 3).foreach(i =>
        println(valores.filter(x => 
            x >= (avg - i * s) && x <= (avg + i * s)).size))
}

2.	Tuplas

Definir una Tupla
val par = (1, "Abad Ana")

Llamar a diferentes datos de la Tupla
println(par._1)
println(par._2)

val student = (1, "Abad Ana")

val datos = ("jorgaf", 'M', 45, 95.2, true)

3.	Algunas funciones con Tuplas
val student2 = (1, "Abad Ana")
val (edad, nombre) = student2
print(edad)
print(nombre)

student2.swap

student2.canEqual((1, "Abad Ana"))


Estructuras de datos funcionales
4.	Listas

val values = List(1, 2, 3, 4)
val names = List("jorge", "Pepe")

val values2: List[Int] = List(1, 2, 3, 4)
val names2: List[String] = List("jorge", "Pepe")

5.	Diferentes Operaciones de las listas

val myList = List(10, 20, 30, 40, 50, 60)
myList.isEmpty
myList.drop(2)
myList.dropWhile(_ < 25)
myList.slice(2, 4)
myList.tail
myList.take(3)
myList.takeWhile(_ < 30)
myList.sorted

6.	Otras operaciones con listas
Va desde la izquierda hasta la derecha
myList.foldLeft(0)((x, y) => x + y) 
x almacena el valor y Y es el valor actual de la lista
myList.foldLeft(0)(_ + _)

myList.foldRight(0)((x, y) => x + y)
myList.foldRight(0)(_ + _)

7.	Operaciones con foldLeft()

def average(valores : Seq[Double]): Double = {
    val t = valores.foldLeft((0.0, 0))((acc, currVal) => (acc._1 + currVal, acc._2 + 1))
    t._1 / t._2
}

