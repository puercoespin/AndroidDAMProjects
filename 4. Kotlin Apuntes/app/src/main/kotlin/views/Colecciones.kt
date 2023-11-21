package views

fun main() {
    // mutable, tamaño fijo
    var week = arrayOf("Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo")
    println(week[0])
    week[0]="Lones"
    println(week[0])
    // mutable
    var array2 = arrayListOf(1,"asd",4)
    println("${array2[0]}  ${array2[1]}")

    array2.forEach {p-> print(p) }

}