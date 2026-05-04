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

fun reto9() {
    println("\n--- Reto 9: Traductor de Códigos de País ---")
    val paises = mapOf("CO" to "Colombia", "MX" to "México", "AR" to "Argentina", "ES" to "España")
    for ((codigo, nombre) in paises) {
        println("El código $codigo pertenece a $nombre")
    }
}

fun reto10() {
    println("\n--- Reto 10: Rotación de Turnos de Trabajo ---")
    val empleadosTurnos = mutableListOf("Teresa", "Rubi", "Maribel", "Alejandro", "Diego", "Gema", "Pablo")
    val k = 2
    println("Turnos original: $empleadosTurnos")

    rotarTurnos(empleadosTurnos, k)

    println("Turnos rotados $k posiciones: $empleadosTurnos")
}

fun rotarTurnos(lista: MutableList<String>, k: Int) {
    repeat(k) {
        val ultimo = lista.removeAt(lista.size - 1)
        lista.add(0, ultimo)
    }
}

fun reto11() {
    println("\n--- Reto 11: Organizador de Maleta ---")
    val objetos = listOf("camisa" to 2, "pantalón" to 3, "zapatos" to 2, "chaqueta" to 4, "gorra" to 1)
    val porPeso = mutableMapOf<Int, MutableList<String>>()
    for ((obj, peso) in objetos) {
        porPeso.computeIfAbsent(peso) { mutableListOf() }.add(obj)
    }
    println("Objetos agrupados por peso: $porPeso")
}

fun reto12() {
    println("\n--- Reto 12: Verificador de Ruta Reversible ---")
    val ruta = listOf("A", "B", "C", "B", "A")
    val esReversible = ruta == ruta.reversed()
    println("Ruta $ruta es reversible: $esReversible")
}

fun reto13() {
    println("\n--- Reto 13: Reparto de Pedidos por Camión ---")
    val paquetes = (1..50).toList()
    val lotes = paquetes.chunked(10)
    println("Paquetes repartidos en ${lotes.size} camiones")
    lotes.forEachIndexed { idx, lote -> println("Camión ${idx + 1}: $lote") }
}

fun reto14() {
    println("\n--- Reto 14: Identificador de Ticket Único ---")
    val ids = listOf(101, 202, 101, 303, 404, 202, 505)

    // Contar cuántas veces aparece cada ID
    val frecuencia = ids.groupingBy { it }.eachCount()

    // Buscar el primer ID que aparece solo una vez
    val primerIdUnico = ids.find { id -> frecuencia[id] == 1 }

    if (primerIdUnico != null) {
        println("El primer ID de error no reportado por otros usuarios es: $primerIdUnico")
    } else {
        println("No hay IDs únicos en la lista")
    }
}

fun reto15() {
    println("\n--- Reto 15: Calculadora de IVA Selectiva ---")
    val precios = listOf(100000.0, 25000.0, 60000.0, 15000.0)

    val preciosConIva = precios.map { precio ->
        if (precio > 50000) precio * 1.19 else precio
    }

    println("Precios originales: $precios")
    println("Precios con IVA selectivo: $preciosConIva")
}

fun reto16() {
    println("\n--- Reto 16: Mantenimiento de Sensores ---")
    val sensores = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 13)
    sensores.removeAll { it % 3 == 0 }
    println("Sensores restantes: $sensores")
}

fun reto17() {
    println("\n--- Reto 17: Mapa de Almacén ---")
    val almacen = arrayOf(
        intArrayOf(1, 2, 3, 4),
        intArrayOf(5, 6, 7, 8),
        intArrayOf(9, 10, 11, 12),
        intArrayOf(13, 14, 15, 16)
    )
    var diagonalPrincipal = 0
    var diagonalSecundaria = 0
    val n = almacen.size  // en lugar de usar 3 fijo

    for (i in 0 until n) {
        diagonalPrincipal += almacen[i][i]
        diagonalSecundaria += almacen[i][n - 1 - i]
    }

    println("Diagonal principal: $diagonalPrincipal")
    println("Diagonal secundaria: $diagonalSecundaria")
}

fun reto18() {
    println("\n--- Reto 18: Fusión de Recetas ---")
    val chef1 = mapOf("harina" to 500.0, "huevos" to 6.0, "azúcar" to 200.0)
    val chef2 = mapOf("huevos" to 4.0, "leche" to 300.0, "mantequilla" to 100.0)
    val fusion = mutableMapOf<String, Double>()
    for ((ing, cant) in chef1) fusion[ing] = fusion.getOrDefault(ing, 0.0) + cant
    for ((ing, cant) in chef2) fusion[ing] = fusion.getOrDefault(ing, 0.0) + cant
    println("Lista de compras combinada: $fusion")
}

fun reto19() {
    println("\n--- Reto 19: Ranking de Apps por Calificación ---")
    val apps = mutableListOf(
        Pair("AppA", 4.5), Pair("AppB", 3.8), Pair("AppC", 4.9), Pair("AppD", 4.2),
        Pair("AppE", 4.0), Pair("AppF", 3.5), Pair("AppG", 4.7), Pair("AppH", 4.1),
        Pair("AppI", 3.9), Pair("AppJ", 4.3)
    )

    // Ordenamiento manual (burbuja)
    for (i in 0 until apps.size - 1) {
        for (j in 0 until apps.size - 1 - i) {
            if (apps[j].second < apps[j + 1].second) {
                val temp = apps[j]
                apps[j] = apps[j + 1]
                apps[j + 1] = temp
            }
        }
    }

    println("Top 10 apps:")
    for (i in 0 until apps.size) {
        println("   ${i + 1}. ${apps[i].first} - ${apps[i].second} estrellas")
    }
}

fun reto20() {
    println("\n--- Reto 20: Unión de Agendas Ordenadas ---")
    val agenda1 = listOf("Ana", "Carlos", "Luis")
    val agenda2 = listOf("Beatriz", "David", "Sofia")
    val combinada = mutableListOf<String>()
    var i1 = 0
    var i2 = 0
    while (i1 < agenda1.size && i2 < agenda2.size) {
        if (agenda1[i1] < agenda2[i2]) {
            combinada.add(agenda1[i1])
            i1++
        } else {
            combinada.add(agenda2[i2])
            i2++
        }
    }
    combinada.addAll(agenda1.subList(i1, agenda1.size))
    combinada.addAll(agenda2.subList(i2, agenda2.size))
    println("Agendas combinadas: $combinada")
}