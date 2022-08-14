package segunda

fun main(args: Array<String>) {
    val listaValores = arrayOf(1, 2, 34, 9, 10)
    val listaPrimos = arrayOf(1, 2, 3, 4, 5, 6, 7)
    adquirirValores(listaValores, ::adquirirPosicionfibonacci)
    println("--------------------------------------------------")
    adquirirValores(listaPrimos, ::esPrimo)
}

fun adquirirValores(listaEnteros: Array<Int>, funcion: ((Int) -> Any)) {
    for (i in listaEnteros) {
        println(i)
        funcion(i)
    }
}

fun adquirirPosicionfibonacci(num: Int): Any {
    var isInFibonacci: Boolean = false
    var a: Int = 1
    var b: Int = 0
    var c: Int = 0
    var i: Int = 0
    var contador = 0
    if (num > 0) {
        while (c < num) {
            c = a + b
            a = b
            b = c
            i += 1
            contador++
            if (num == c) {
                isInFibonacci = true
                println("%-> $c")
                println("-------------- sucesión de Fibonacci -----------------")
                c = num + 1
            } else {
                print("%-> $c")
            }
        }
        println("")
        if (isInFibonacci) {
            println("Si se encuentra en la serie de fibonacci\nLa posicion en fibonacci de este numero es: $contador\n----------------------------")
        } else {
            println("No se encuentra en la sucesion de fibonacci")
        }
    } else {
        println("Ingresa un numero mayor que cero!")
    }
    return ""
}

fun esPrimo(num1: Int): Any {
    var contador = 2
    var primo = true
    while (primo && contador != num1) {
        if (num1 % contador === 0) primo = false
        contador++
    }
    if (primo){
        println("\n-------------------Es primo-----------------------------------------")
    }else{
        println("\n-------------------No es primo--------------------------------------")
    }
    return primo
}





