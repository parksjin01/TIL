/*
    In problem 10 we can use extension function

    In other programming language, we should inherit class if we want to add functions
    Expecially in third-party modules sometimes we want to add our own function and we have to inherit class to do it
    However in Kotlin, we can insert our own functions to ready declared class without inheritance
 */

fun Int.r(): RationalNumber = RationalNumber(this, 1)
fun Pair<Int, Int>.r(): RationalNumber = RationalNumber(first, second)

data class RationalNumber(val numerator: Int, val denominator: Int)

fun main()
{
    println("Test #1")
    println(13.r())
    println("Test #2")
    println(Pair(13, 2).r())
}