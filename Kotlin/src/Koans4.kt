/*
    Kotlin also supports overload likely as Java
    Kotlin has named argument and default argument
    So Kotlin can represent multi-overloaded method into one method
 */

fun foo(name: String, number: Int = 42, toUpperCase: Boolean = false): String {
    return (if (toUpperCase) name.toUpperCase() else name) + number
}

fun main() {
    println(foo("Damotorie"))
    println(foo("Damotorie", 27))
    println(foo("Damotorie", toUpperCase = true))
    println(foo("Damotorie", 27, true))
}