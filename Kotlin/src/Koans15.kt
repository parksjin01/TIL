/*
    Kotlin 역시 파이썬 언어처럼 `a in list` 형태의 명령어를 지원한다.
    파이썬에서는 리스트를 쉽게 만들기 위해서 `range(start, end)` 클래스를 사용했지만,
    Kotlin에서는 start..end 형태를 사용해서 쉽게 리스트를 만들수 있다.
    .. operator를 사용하면 rangeTo라는 함수가 실행되면서 리스트가 만들어진다고 한다.
    .. operator를 사용해서 리스트를 만들기 위해서는 기본적으로 .. operator의 피연산자가 comparable 해야한다.

    in 명령어를 사용하면 뒤에 등장하는 list 객체의 contains라는 함수를 실행해서 결과를 출력한다.
    따라서 뒤에오는 객체에 contains라는 함수를 지원해주면 쉽게 in 키워드를 이용해서 해당 오브젝트가 포함되어 있는지 체크할 수 있다.
    기본적으로는 operator fun contains(value: Type): Boolean 이라는 함수를 구현해주면 되지만
    ClosedRange<T> 라는 인터페이스를 implement 해서 contains 함수를 구현하는 방식으로도 지원 가능하다.

 */

data class MyDate2(val year: Int, val month: Int, val dayOfMonth: Int): Comparable<MyDate2> {
    override fun compareTo(other: MyDate2): Int {
        if (this.year != other.year) return this.year - other.year
        if (this.month != other.month) return this.month - other.month
        if (this.dayOfMonth != other.dayOfMonth) return this.dayOfMonth - other.dayOfMonth
        return 0
    }
}

class DataRange(override val start: MyDate2, override val endInclusive: MyDate2): ClosedRange<MyDate2> {

    override fun contains(value: MyDate2): Boolean {
        return value in start..endInclusive
    }
}

fun main()
{
    println(MyDate2(2019, 6, 4) in DataRange(MyDate2(2019, 1, 1), MyDate2(2019, 12, 31)))
    println(MyDate2(2018, 6, 4) in DataRange(MyDate2(2019, 1, 1), MyDate2(2019, 12, 31)))
    println(MyDate2(2019, 1, 1)..MyDate2(2019, 12, 31))
}