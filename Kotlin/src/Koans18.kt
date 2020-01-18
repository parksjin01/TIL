/*
* 이번문제에서는 기본 연산자 오버라이딩을 배우게 된다.
* '+' 연산자를 오버라이딩하는 것이 이번 문제로 MyDate에 TimeInterval을 더함으로써 값을 변경하는 방법을 배우게 된다.
* MyDate 클래스에 plus 함수를 추가하고 파라미터로 TimeInterval을 받게 함으로써 '+' 연산자를 오버라이딩 하는 것이다.
* 이렇게 오버라이딩 했을 경우에는 MyDate와 TimeInterval간 덧셈은 가능하지만 곱셈 연산은 불가능해지게 된다.
* 따라서 문제에서 요구하고 있는 today + YEAR * 2 + WEEK * 3 + DAY * 5는 연산이 불가능하다.
* 따라서 문제를 해결하기 위해 곱셈으로 표시된걸 전부 덧셈의 형태로 풀어서 작성했다.
* 아마 이 문제를 해결하기 위한 더 좋은 방법이 있을 것이라고 생각된다.
* */

import TimeInterval.*

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate {
    return this.addTimeIntervals(timeInterval, 1)
}

fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task2(today: MyDate): MyDate {
    return today + YEAR + YEAR + WEEK + WEEK + WEEK + DAY + DAY + DAY + DAY + DAY
}

fun main()
{
    println(task2(MyDate(2019, 1, 1)))
    println(task2(MyDate(2019, 12, 1)))
    println(task2(MyDate(2018, 12, 31)))
}