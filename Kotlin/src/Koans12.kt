/*
    이번 문제 역시 11번 문제와 동일하게 Kotlin 리스트를 자바의 Collections.sort로 정렬하는 것을 목표로 한다.
    다만 11번과의 차이는 11번 문제의 경우 object 키워드를 사용하여 Comparator 인터페이스를 구현한 익명 클래스를 만들어서 해결했지만
    이번 12번 문제에서는 SAM(Single-Abstract-Method) 방법을 이용하여 해결한다.
    SAM은 JAVA8에서부터 지원하기 시작하는 기능인데, 인터페이스를 구현하는 클래스를 만드는 것이 아니라,
    꼭 필요한 메서드(이 문제에서는 compare)만을 구현하면, 인터페이스 구현 클래스를 대체할 수 있다고 한다.
    단 주의할 점이 1개의 abstract method만 구현하는 것이 가능하고, abstract class는 대체할 수 없다는 것을 기억해야한다.
 */

//import java.util.*;
//
//fun getList(): List<Int> {
//    val arrayList: List<Int> = arrayListOf<Int>(1, 5, 2)
//    Collections.sort(arrayList, {x, y -> if(x < y) 1 else -1})
//    return arrayList
//}
//
//fun main()
//{
//    println(getList())
//}