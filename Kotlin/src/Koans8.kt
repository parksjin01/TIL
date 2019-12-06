/*
    Many things to remember in this problem

    1. Kotlin also has interface as same as Java, for same function call in many classes
       In Java, interface was implemented by using implements keyword.
       But in Kotlin, interface is implemented by using colon
       It is same method to inherit class in Kotlin. Both implements and extends are same in Kotlin

    2. Kotlin has null-safe data type by appending ?
       When variable is declared as null-safe data type, it can eliminates NPE(Null-Pointer-Exception)
       There are two ways to get value in null-safe data type
       We can get value by appending `?` after the variable or appending `!!` after the variable
       However when using `!!` NPE can be occurred so we need to take care of it
 */

fun sendMessageToClient(client: Client?, message: String?, mailer: Mailer) {
    if (client != null && client.personalInfo != null && client.personalInfo.email != null && message != null) {

        // sendMessage의 파라미터로 email?, message?가 되지 않는 이유는 ?를 사용하게 되면 Null이 반환될 수도 있는데
        // Mailer 인터페이스의 sendMessage 함수의 경우에는 파라미터로 (String, String) 즉 Null이 들어오면 안되기 때문에
        // email?, message? 가 허용되지 않는다.
        mailer.sendMessage(client.personalInfo.email.toString(), message.toString())
    }
}

class Client(val personalInfo: PersonalInfo?){}
class PersonalInfo(val email: String?){}
interface Mailer {
    fun sendMessage(email:String, message:String)
}

class MailBox(): Mailer {
    override fun sendMessage(email: String, message: String) {
        println("Sending message to " + email + "\n\n\nBody\n\n" + message)
    }
}

fun main()
{
    val mailbox = MailBox()
    val client1 = Client(PersonalInfo("helloworld@icloud.com"))
    val client2 = Client(null)

    println("Test #1")
    sendMessageToClient(client1, "Hello World?", mailbox)
    println("Test #2")
    sendMessageToClient(client2, "Hello World?", mailbox)
    println("Test #3")
    sendMessageToClient(client1, null, mailbox)
}