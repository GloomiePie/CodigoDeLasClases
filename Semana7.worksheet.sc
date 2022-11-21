//Tuplas y listas
val goleadores = List(
("Oscar Becerra", 17), 
("Luis Amarilla", 16), 
("Michael Estrada", 16), 
("Fidel Martínez", 16), 
("Gonzalo Mastriani", 13), 
("Leonel Vides", 13), 
("Rodrigo Aguirre", 12), 
("Carlos Garces", 12), 
("Jonathan Borja", 11))

//1.
val goles = goleadores.map(_._2).map(_.toDouble)
val average = 
    (values : List[Double]) => values.sum / values.length
val avgGol = average(goles)

//2. 
goleadores.maxBy(_._2)._1

//3.
val mayoresAvg = goleadores.
filter(_._2 > avgGol).
map(_._1)

//4.
val menoresAvg = goleadores.
filter(_._2 < avgGol).
map(_._1)

//-------------------------------------------------------------------------------
//Conjuntos
val conj2 : Set[Int] = Set()
val conjunto : Set[Int] = Set(1, 1, 2, 2, 2, 3)

//Algunas funciones
val conjunto2 : Set[Int] = Set(1, 1, 2, 2, 2, 3)
val conNuevo = conjunto2 + 6

val conNuevo2 = conjunto2.concat(List(2, 3, 4, 5))

val conNuevo3 = conjunto2.concat(List(2, 3, 4, 5))
conNuevo2.intersect(conjunto2)

//Mapas o diccionarios
//Map[K, V]K representa a las claves y V los valores

Map(("apples", 3), ("oranges", 2), ("pears", 0))

List(("apples", 3), ("oranges", 2), ("pears", 0)).toMap

Map(("apples", 3), ("oranges", 2), ("pears", 0)).toSeq

//Funciones
val fruitBasket = Map(("apples", 3), ("oranges", 2), ("pears", 0))

fruitBasket.map(data => data match {
    case (fruit, count) => count * 2
})

fruitBasket.map{case(fruit, count) => count * 2} //<-----equivalente

fruitBasket.map{case (fruit, count) => (fruit, count * 2)}

fruitBasket.map{case (fruit, count) => (fruit, count, count * 2)}.
map{case(fruit, _, count2) => (fruit, count2/2)}.toMap

//Group By
Seq("wombat", "xanthan", "yogurt", "zebra").
groupBy(s => if(s startsWith "y") 1 else 2)

List(1, 2, 3, 4, 5).groupBy(k => k % 3)

//--------------------------------------------------------
val goleadores2 = List(
("Oscar Becerra", 17), 
("Luis Amarilla", 16), 
("Michael Estrada", 16), 
("Fidel Martínez", 16), 
("Gonzalo Mastriani", 13), 
("Leonel Vides", 13), 
("Rodrigo Aguirre", 12), 
("Carlos Garces", 12), 
("Jonathan Borja", 11)).toMap

goleadores.groupBy{case (_, goals) => goals} 

goleadores.groupBy{
    case (_, goals) => goals}.map(row => row match{
        case (goles, lista) => (goles, lista.size)
    })
