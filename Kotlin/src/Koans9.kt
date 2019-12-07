/*
    In problem 9, we have to use smart cast of Kotlin

    To use smart cast we can use `when` expression.
    It's form is similar with C switch keywords. In switch, if value matchs condition, source code in that block
    would be executed. It is same in this. If value in when matchs with type, it will do commands
 */

import java.lang.IllegalArgumentException

fun eval(expr: Expr): Int =
    when (expr) {
        is Num -> expr.value
        is Sum -> eval(expr.left) + eval(expr.right)
        else -> throw IllegalArgumentException("Unknown Expression")
    }

interface Expr
class Num(val value:Int): Expr
class Sum(val left: Expr, val right: Expr): Expr

fun main()
{
    println("Test #1")
    println(eval(Num(1)))
    println("Test #2")
    println(eval(Num(13)))
    println("Test #3")
    println(eval(Sum(Num(1), Num(2))))
    println("Test #4")
    print(eval(Sum(Sum(Num(1), Num(2)), Num(3))))
}