package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.*
import ru.skillbranch.devintensive.models.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
//        val user = User("1")
        val user1 = User("2", "John", "Cena")
//        val user2 = User("3", "John", "Silverhand", null, lastVisit = Date(), isOnline = true)

//        user.printMe()
//        user1.printMe()
//        user2.printMe()

//        println("$user")
    }

    @Test
    fun test_factory() {
//        val user = User.Factory.makeUser("John Cena")
//        val user1 = User.Factory.makeUser("John Wick")
        val user2 = User.Factory.makeUser("John Silverhand")
        val user3 = user2.copy(id = "2", lastName = "Cena", lastVisit = Date())
        print("$user2 \n$user3")
    }

    @Test
    fun test_decomposition() {
        val user2 = User.Factory.makeUser("John Silverhand")

        fun getUserInfo() = user2

        val (id, firstName, lastName) = getUserInfo()

        print("${user2.component1()}, ${user2.component2()}, ${user2.component3()}")
    }

    @Test
    fun test_copy() {
        val user1 = User.Factory.makeUser("John Silverhand")
        val user2 = user1.copy(lastVisit = Date())
        val user3 = user1.copy(lastVisit = Date().add(-2, TimeUnits.SECOND))
        val user4 = user1.copy(lastName = "Cena", lastVisit = Date().add(2, TimeUnits.HOUR))

        println("""
            ${user1.lastVisit?.format()}
            ${user2.lastVisit?.format()}
            ${user3.lastVisit?.format()}
            ${user4.lastVisit?.format()}
        """.trimIndent())
    }

    @Test
    fun test_dataq_maping() {
        val user = User.Factory.makeUser("Дорошенко Вячеслав")
        val newUser = user.copy(lastVisit = Date().add(-7, TimeUnits.SECOND))
        val userView = user.toUserView()

        userView.printMe()
    }

    @Test
    fun test_abstract_factory() {
        val user = User.Factory.makeUser("Вячеслав Дорошенко")
        val txtMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any text message", type = "text")
        val imgMessage = BaseMessage.makeMessage(user, Chat("0"), date = Date().add(-2, TimeUnits.HOUR), payload = "any image message", type = "image")

         println(txtMessage.formatMessage())
         println(imgMessage.formatMessage())
    }

    @Test
    fun test_humanizeDiff() {
        println(Date().add(7, TimeUnits.DAY).humanizeDiff())
    }
}
