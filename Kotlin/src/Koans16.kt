/*
* 이전 문제에서는 in operator에 해당하는 함수를 구현하는 방법을 살펴보았다면
* 이번 문제에서는 .. operator에 해당하는 함수를 구현하는 방법을 살펴본다.
*
* 사실 .. operator에 해당하는 함수를 구현하는 방법은 in 함수를 구현하는 방법과 동일하다. (오히려 동일해서 더 햇갈리는 것 같기도 하다.)
* `in`, `..` operator 모두 ClosedRange 인터페이스를 통해 쉽게 구현할 수 있다.
* `in`의 경우에는 ClosedRange의 contains 함수를 구현하는 방법을 통해서 구현했다면,
* `..`의 경우에는 데이터 클래스에 rangeTo 함수에, ClosedRange 인터페이스를 implement한 클래스의 객체를 넘겨주면 된다.
*
* */

data class MyDate3(val year:Int, val month:Int, val dayOfMonth: Int): Comparable<MyDate3> {
    override fun compareTo(other: MyDate3): Int {
        if (this.year != other.year) return this.year - other.year
        if (this.month != other.month) return this.month - other.month
        return this.dayOfMonth - other.dayOfMonth
    }
}

class DataRange2(override val start: MyDate3, override val endInclusive: MyDate3): ClosedRange<MyDate3>

operator fun MyDate3.rangeTo(other: MyDate3) = DataRange2(this, other)

fun main()
{
    println(MyDate3(2019, 6, 4) in DataRange2(MyDate3(2019, 1, 1), MyDate3(2019, 12, 31)))
    println(MyDate3(2018, 6, 4) in DataRange2(MyDate3(2019, 1, 1), MyDate3(2019, 12, 31)))
    println(MyDate3(2019, 1, 1)..MyDate3(2019, 12, 31))
}