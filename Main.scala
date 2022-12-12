//Semana 10
//Programacion Activa
//Programacion reactiva funcional

//Ejemplo de scala rx
package semana10
import rx._

object Main extends App{
  val a = Var(1)
  val b = Var(2)
  val c = Rx{a() + b()}

  println(c.now)
  a() = 4
  println(c.now)
}

//Otro codigo
object Main2 extends App{
  val a = Var(1)
  val b = Var(2)

  val c = Rx{a() + b()}
  val d = Rx{c() * 5}
  val e = Rx{c() + 4}
  val f = Rx{d() + e() + 4}

  println(f.now)
  a() = 3
  println(f.now)
}

//Observers u Obs
//Ejemplo

object Main3 extends App{
  val a = Var(1)
  var count = 0
  val o = a.trigger { //El trigger esta pendiente de 'a' desde que se la declaracion
    count = a.now + 1
  }
  println(count)
  a() = 4
  println(count)
}

//Otro ejemplo
object Main4 extends App{
  val a = Var(1)
  var count = 0
  val o = a.triggerLater { //El triggerLater esta pendiente de 'a' despues de su declaracion
    count = a.now + 1
  }
  println(count)
  a() = 4
  println(count)
}

//Es posible apagar un Obs, usando el metodo kill
//Ejemplo

object Main5 extends App{
  val a = Var(1)
  val b = Rx{2 + a()}
  var target = 0
  val o = b.trigger{
    target = b.now
  }

  println(target)
  a() = 2
  println(target)
  o.kill() //El .kill() hace que el trigger deje de estar pendiente de los cambios de b
  a() = 3
  println(target)
}