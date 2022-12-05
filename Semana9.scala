import Scala.io.StdIn
import Scala.util.{Try, Success, Failure}

object Semana9 {
  def main(args:  Array[String]): Unit = {
        val name = StdIn.readLine("Nombre: ")
        val age = StdIn.readLine("Edad: ").toInt
        val weight = StdIn.readLine("Peso: ").toDouble

        printf("Hola %s, tienes %d años y pesas %fkg\n", 
        name, age match{
            case Success(v) => v
            case Failure(e) => "Error"
        }, weight match {
            case Succes(v) => v
            case Failure(e) => "Error"
        } 
        )
    }
}
//-------------------------------------------------------------
val values = List("1", "3", "5", "2o")
val data = values.map(x => Try{x.toInt})

data.filter(_.isSuccess).map(_.get)
