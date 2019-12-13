/*
    Kotlin도 다른 언어처럼 +, >, <등의 연산자 오버라이딩이 가능하다.
    다만 파이썬의 경우 기본적으로 클래스에 포함된 메서드인 __le__, __lt__, __ge__, __gt__ 을 오버라이딩 시키면 되지만
    Kotlin은 Comparable 인터페이스를 구현해야한다.
 */


data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int): Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        if (year > other.year)
            return 1
        else if (year < other.year)
            return -1
        else
        {
            if (month > other.month)
                return 1
            else if (month < other.month)
                return -1
            else
            {
                if (dayOfMonth > other.dayOfMonth)
                    return 1
                else if (dayOfMonth < other.dayOfMonth)
                    return -1
                else
                    return 0
            }
        }
    }
}

fun main()
{
    println("Test #1")
    println(MyDate(2019, 12, 6) > MyDate(2018, 12, 6))
    println("Test #2")
    println(MyDate(2019, 12, 6) == MyDate(2019, 12, 6))
    println("Test #3")
    println(MyDate(2018, 12, 6) < MyDate(2019, 12, 6))
}