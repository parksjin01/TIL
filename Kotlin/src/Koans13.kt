/*
    이 문제 역시 이전에 11번, 12번 문제와 동일하게 사용된다.
    가장 깔끔하게 문제를 풀 수 있는 방법인데 미리 만들어진 메서드를 사용해서 문제를 푼다....
  */

fun getList(): List<Int> = arrayListOf(1, 5, 2).sortedDescending()

fun main()
{
    println(getList())
}