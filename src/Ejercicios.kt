package ejercicios

fun reto1() {
    println("\n--- Reto 1: Control de Gastos Diarios ---")
    val gastos = arrayOf(15000.0, 20000.0, 10000.0, 30000.0, 25000.0, 18000.0, 22000.0,
        12000.0, 35000.0, 28000.0, 16000.0, 14000.0, 40000.0, 19000.0, 23000.0)
    var total = 0.0
    var maxGasto = gastos[0]
    var minGasto = gastos[0]
    for (g in gastos) {
        total += g
        if (g > maxGasto) maxGasto = g
        if (g < minGasto) minGasto = g
    }
    val promedio = total / gastos.size
    println("Total: $total COP, Promedio: $promedio COP, Máximo: $maxGasto COP, Mínimo: $minGasto COP")
}

fun reto2() {
    println("\n--- Reto 2: Filtro de Empleados Senior ---")
    val empleados = listOf(Pair("Lara", 25), Pair("Carly", 35), Pair("Isabel", 40), Pair("Mario", 28))
    val seniors = empleados.filter { it.second > 30 }.map { it.first.uppercase() }
    println("Empleados senior: $seniors")
}

fun reto3() {
    println("\n--- Reto 3: Limpieza de Contactos Duplicados ---")
    val telefonos = listOf(
        "3011234567", "3109876543", "3011234567", "3156789012", "3109876543",
        "3204567890", "3112223344", "3156789012", "3135556677", "3147778899",
        "3011234567", "3169900112", "3173344556", "3109876543", "3181122334",
        "3194455667", "3112223344", "3135556677", "3204567890", "3147778899"
    )
    val unicos = telefonos.toSet().sorted()
    println("Números únicos ordenados: $unicos")
}

fun reto4() {
    println("\n--- Reto 4: Análisis de Carrito de Compras ---")
    val productosCarrito = listOf("manzana", "pan", "manzana", "leche", "pan", "pan", "huevos", "huevos")
    val conteo = mutableMapOf<String, Int>()
    for (p in productosCarrito) {
        conteo[p] = conteo.getOrDefault(p, 0) + 1
    }
    println("Conteo por producto: $conteo")
}

fun reto5() {
    println("\n--- Reto 5: Historial de Navegación Reversible ---")
    val urls = arrayOf("google.com", "facebook.com", "youtube.com", "github.com", "twitter.com")
    println("Original: ${urls.joinToString()}")

    val invertido = arrayOfNulls<String>(urls.size)
    for (i in urls.indices) {
        invertido[i] = urls[urls.size - 1 - i]
    }

    println("Invertido: ${invertido.joinToString()}")
}

fun reto6() {
    println("\n--- Reto 6: Compatibilidad de Intereses ---")
    val intereses1 = setOf("fútbol", "cine", "música", "lectura")
    val intereses2 = setOf("cine", "videojuegos", "música", "natación")
    val compartidos = intereses1.intersect(intereses2)
    val exclusivos1 = intereses1.subtract(intereses2)
    println("Intereses compartidos: $compartidos")
    println("Exclusivos de persona 1: $exclusivos1")
}

fun reto7() {
    println("\n--- Reto 7: Inventario de Despensa ---")
    val despensa = mutableMapOf("arroz" to 5, "frijoles" to 3, "aceite" to 1, "sal" to 2)
    println("Inventario inicial: $despensa")
    fun consumir(producto: String, cantidad: Int) {
        if (despensa.containsKey(producto)) {
            val nuevo = despensa[producto]!! - cantidad
            if (nuevo <= 0) {
                despensa.remove(producto)
                println("¡Alerta! $producto se agotó")
            } else {
                despensa[producto] = nuevo
            }
        }
    }
    consumir("arroz", 3)
    consumir("aceite", 1)
    consumir("sal", 2)
    println("Inventario final: $despensa")
}

fun reto8() {
    println("\n--- Reto 8: Cálculo de Promedio Académico ---")
    val notas = listOf(Pair(4.5, 0.3), Pair(3.8, 0.3), Pair(4.0, 0.4))
    var definitiva = 0.0
    for ((nota, porcentaje) in notas) {
        definitiva += nota * porcentaje
    }
    println("Nota final definitiva: ${String.format("%.2f", definitiva)}")
}