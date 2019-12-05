/*
    Kotlin supports regex pattern.
    Pattern can be initialized with three quotation mark (e.g. """pattern""")

    In Koans problem 6, it asks proper regex pattern for date information format (DD month_abbreviation YYYY)
 */

fun getPattern():String = """\d{2} (JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC) \d{4}"""

fun main()
{
    println("Hello World".matches(getPattern().toRegex()))
    println("12 FEB 2019".matches(getPattern().toRegex()))
}