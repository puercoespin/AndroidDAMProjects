package views

fun main() {
    val num = 17

    if(esPrimo(num)) println(" $num es primo") else println(" $num no es primo")

}

fun multiplos(numero : Int, limite : Int)
{
    var contador = 1
    while (numero * contador <= limite)
    {
        val resultado = numero * contador
        println(resultado)
        contador++
    }
}

fun divisores(numero : Int)
{
    for (i in 1..numero)
    {
        if(numero%i==0)
        {
            println(i)
        }
    }
}

fun esPrimo(numero : Int) : Boolean
{
    if(numero <= 1) return false

    for(i in 2 until numero)
    {
        if (numero % i == 0)
        {
            return false
        }
    }

    return true
}