/*
* 이문제는 전혀 감이 잡히지 않아서 인터넷 도움을 받았다. (https://github.com/Kotlin/kotlin-koans/issues/153)
* 지금까지 만들어온 MyDate 라는 클래스의 이터레이터 클래스를 만드는 문제였다.
* 문제에서는 그냥 Iterable 인터페이스에 `iterator()` 함수 구현하면 된다고 나와있었지만 `iterator()` 함수에 뭘 넣어줘야 iterator를 만들수 있을지 감이 잡히지 않았다.
*
* 갓 구글에서 검색해본 결과 해결 방법중 1가지로 문제를 해결할 수 있었다.
* 바로 Iterator 인터페이스를 구현하는 클래스를 만들고 `iterator()` 함수의 반환형으로 해당 클래스의 인스턴스를 반환하면 된다고 나와있었다.
* 이 방법을 통해 쉽게 문제를 해결할 수 있었다. 기존 자바에 대한 지식이 탄탄한 사람들의 경우 큰 문제없이 해결 할 수 있었을 것으로 생각되지만
* 기존에 파이썬을 주로 사용하던 사람으로써 자바 지식이 없다보니 Iterator에 대한 인터페이스 존재 유무를 몰라서 더 어려웠던것 같다.
* */

import java.util.Calendar

fun MyDate.nextDay() = addTimeIntervals(TimeInterval.DAY, 1)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

fun MyDate.addTimeIntervals(timeInterval: TimeInterval, number: Int): MyDate {
    val c = Calendar.getInstance()
    c.set(year + if (timeInterval == TimeInterval.YEAR) number else 0, month, dayOfMonth)
    var timeInMillis = c.getTimeInMillis()
    val millisecondsInADay = 24 * 60 * 60 * 1000L
    timeInMillis += number * when (timeInterval) {
        TimeInterval.DAY -> millisecondsInADay
        TimeInterval.WEEK -> 7 * millisecondsInADay
        TimeInterval.YEAR -> 0L
    }
    val result = Calendar.getInstance()
    result.setTimeInMillis(timeInMillis)
    return MyDate(result.get(Calendar.YEAR), result.get(Calendar.MONTH), result.get(Calendar.DATE))
}

class DateRange(val start:MyDate, val end:MyDate): Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> = DateIterator(this)
}

class DateIterator(val dateRange: DateRange): Iterator<MyDate> {
    var current: MyDate = dateRange.start
    override fun next(): MyDate {
        val result = current
        current = current.nextDay()
        return result
    }

    override fun hasNext(): Boolean = current <= dateRange.end
}

fun main()
{
    val dr = DateRange(MyDate(2019, 1, 1), MyDate(2019, 11, 31))
    val di = DateIterator(dr)

    while (di.hasNext())
        println(di.next())
}