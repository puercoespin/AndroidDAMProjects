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

    var array3 = week.map { a->a.startsWith("M") } // find saca el ultimo

    println(" Array resultante: $array3") // saca un array de booleanos comprobando si empieza por m o no

     var array4 = week.filter { it.startsWith("M") } // filtra y saca un array de los elementos que empiecen por M

    println(" Array resultante 2: $array4")

}