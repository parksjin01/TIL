/*
    Kotlin has class same as other OOP languages
    Specially, Kotlin has `data class` which is not commonly included in other languages

    In Kotlin document, `data class` purpose is mainly for holding data.
    When we use `data class` instead of normal `class`, Kotlin compiler will automatically generate equals, hashCode, toString and many other functions
    I think this `data class` is similar with java bean class
 */

data class Person(val name:String, val age:Int)
fun getPerson(): List<Person> = listOf(Person("Damotorie", 31), Person("Prodo", 12))

fun main()
{
    println(getPerson())
}
