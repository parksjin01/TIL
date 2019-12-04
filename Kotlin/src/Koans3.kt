/*
    Kotlin has arguments name.
 */

fun joinOptions(options: Collection<String>): String = options.joinToString(prefix = "[", postfix = "]")

fun main()
{
    print(joinOptions(listOf("Apple", "Banana", "Kiwi")))
}