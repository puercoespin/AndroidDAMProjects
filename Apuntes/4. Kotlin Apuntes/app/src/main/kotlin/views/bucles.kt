package views

fun main() {

    // bucle for que itera en rangos
    for (i in 1..10)
    {
        println(i)
    }

    var contador = 0
    while (contador<5)
    {
        contador++
    }

    var contador2 = 0
    do {
        println(contador2)
        contador2++
    }while (contador2 < 5)

    val numeros = arrayListOf(1,2,3,4,5)

    for ( num in numeros)
    {
        println(num)
    }
}