/*
    Kotlin supports lambda.
    lambda is kind of functional style programming.
    Assign function to variables (most of programming language supports it) and pass that function variable into
    other functions parameter so that function can use passed function variable
 */

fun containsEven(collection: Collection<Int>): Boolean = collection.any({x: Int -> x % 2 == 0})

fun main()
{
    println(containsEven(listOf(1, 3, 5, 7, 9)))
    println(containsEven(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)))
}