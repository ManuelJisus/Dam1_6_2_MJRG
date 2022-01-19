import kotlin.random.Random
/*Teórica:

b) ¿Que beneficios obtienes al usar una clase abstracta? ¿Y de una interface?

La principal ventaja que aporta tanto una clase abstracta y una interfaz es la simplicidad es decir,
aprovechar codigo escrito o reutilizarlo para clases u objetos parecidos. la diferencia es que en las clases abstractas
si se meten funcionalidades y metodos mientras que en las interfaces es basicamente solo para declarar por lo que hace mas facil
la reutilizacion como plantilla de esta ultima.

c) ¿Que modificadores y mecanismos has utilizado para bloquear y forzar la herencia de clases y métodos?

 Para forzar las clases utilizamos el "open" antes de definir la clase y dos puntos(:) . Pasa lo mismo pero sin el open
 para las interfaces, lo cual es otra forma de forzar la herencia. Si se quisiera bloquear la herencia, el propio kotlin
 por defecto no la permite a no ser que se use open, pero para bloquearla aun mas se puede utilizar el "final" para evitar su
 sobreescritura.
 */
interface Disparar {
    var municion: Int
    var municionARestar: Int
    var nombre : String
    fun dispara(): Int {
        municion -= municionARestar
        return municion

    }
}

class Bocadillo(override var municionARestar: Int, override var municion: Int, override var nombre: String) : Disparar{
    override fun toString(): String {
        if (municion > 0) {
            return "El $nombre ha disparado y le quedan $municion balas"
        } else {
            return "El $nombre no ha disparado porque le quedan $municion balas"
        }
    }
}

class Casa(override var municionARestar: Int, override var municion: Int, override var nombre: String) : Disparar{
    override fun toString(): String {
        if (municion > 0) {
            return "El $nombre ha disparado y le quedan $municion balas"
        } else {
            return "El $nombre no ha disparado porque le quedan $municion balas"
        }
    }
}

class Coche(override var municionARestar: Int, override var municion: Int, override var nombre: String) : Disparar{
    override fun toString(): String {
        if (municion > 0) {
            return "El $nombre ha disparado y le quedan $municion balas"
        } else {
            return "El $nombre no ha disparado porque le quedan $municion balas"
        }
    }
}

abstract class ArmaDeFuego(
    override var nombre: String,
    override var municion: Int,
    override var municionARestar: Int,
    var tipoDeMunicion: String,
    var danio: Int

) : Disparar {


    override fun dispara(): Int {
        municion -= municionARestar
        return municion

    }

    open fun recarga(recarga: Int): Int {
        municion += recarga
        return municion
    }


}

class Pistola(nombre: String, municion: Int, municionARestar: Int, tipoDeMunicion: String, danio: Int) :
    ArmaDeFuego(nombre, municion, municionARestar, tipoDeMunicion, danio) {

    override fun dispara(): Int {

        if (municion > 0) municion -= (municionARestar * 1)

        return municion
    }

    override fun toString(): String {
        if (municion > 0) {
            return "El $nombre ha disparado y le quedan $municion balas"
        } else {
            return "El $nombre no ha disparado porque le quedan $municion balas"
        }
    }
}

class Rifle(nombre: String, municion: Int, municionARestar: Int, tipoDeMunicion: String, danio: Int) :
    ArmaDeFuego(nombre, municion, municionARestar, tipoDeMunicion, danio) {

    override fun dispara(): Int {
        if (municion > 0) municion -= (municionARestar * 2)

        return municion
    }

    override fun toString(): String {
        if (municion > 0) {
            return "El $nombre ha disparado y le quedan $municion balas"
        } else {
            return "El $nombre no ha disparado porque le quedan $municion balas"
        }
    }
}

class Bazooka(nombre: String, municion: Int, municionARestar: Int, tipoDeMunicion: String, danio: Int) :
    ArmaDeFuego(nombre, municion, municionARestar, tipoDeMunicion, danio) {

    override fun dispara(): Int {
        if (municion > 0) municion -= (municionARestar * 3)

        return municion
    }


    override fun toString(): String {
        if (municion > 0) {
            return "El $nombre ha disparado y le quedan $municion balas"
        } else {
            return "El $nombre no ha disparado porque le quedan $municion balas"
        }
    }
}

fun main() {
    var revolver = Pistola("Revolver", 20, 1, "explosiva", 25)
    var ak = Rifle("AK47", 35, 1, "punta hueca", 15)
    var langostinazo = Bazooka("burbarof", 6, 1, "explosiva", 50)
    var bocachicha = Bocadillo(2,50,"Bocata de zarchicha")
    var casalujo = Casa(3,40,"cazita en el palma")
    var cocheBMW = Coche(6,50,"BMW Guapizimo")
    var cont = 1

    var armas = mutableListOf<Disparar>(revolver, ak, langostinazo,bocachicha,casalujo,cocheBMW)
    var mapadearmas = mapOf(
        1 to armas.get((0..5).random()),
        2 to armas.get((0..5).random()),
        3 to armas.get((0..5).random()),
        4 to armas.get((0..5).random()),
        5 to armas.get((0..5).random()),
        6 to armas.get((0..5).random()),
        7 to armas.get((0..5).random()),
        8 to armas.get((0..5).random()),
        9 to armas.get((0..5).random()),
        10 to armas.get((0..5).random()),
        11 to armas.get((0..5).random()),
    )
    var valorDelDisparo = mapadearmas.get(cont)


    while (cont <= 11) {
        mapadearmas.get(cont)?.dispara()
        println(mapadearmas.get(cont))
        cont += 1

    }
}