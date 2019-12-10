/*
    여기서 부터는 한국어로 작성한다.
    일단 Jetbrain사에서 제공하고 있는 Koans 문제에 따르면 이 문제 자체가 Kotlin과 Java를 동시에 잘 사용하는 사례를 보여주는 것이라고 한다.
    코틀린 리스트를 만들고 이 리스트를 정렬하는데 자바의 Collections.sort 메서드가 사용된다.

    이 문제에서의 핵심은 object 키워드를 사용하여 익명의 함수 객체를 만드는 것이다.
    여기서 Collections.sort의 정렬기준을 object로 새로 만들게 되는데 이때 Comparator 클래스를 상속받아서
    compare 메서드를 오버라이딩 하여 만들게 된다.
    여기서 Comparator 클래스를 상속받는 다는 것을 생각못해서 검색을 통해 해결했다...
 */

//import java.util.*;
//
//fun getList(): List<Int> {
//    val arrayList: List<Int> = arrayListOf(1, 3, 5)
//    Collections.sort(arrayList, object: Comparator<Int> {
//        override fun compare(o1: Int?, o2: Int?): Int {
//            if (o1!! < o2!!)
//                return 1;
//            else
//                return -1
//        }
//    })
//
//    return arrayList
//}

fun main()
{
    println(getList())
}
