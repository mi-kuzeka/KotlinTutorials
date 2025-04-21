package com.example.kotlintutorials.topics

import java.io.File
import java.time.ZonedDateTime

object AllClassesInKotlinTopic {
    /* --------NORMAL CLASSES-------- */
    fun normalClassExample() {
        val file = File("hello.txt")
        val sessionStorage1 = SessionStorage(file)
        val sessionStorage2 = SessionStorage(file)

        println(sessionStorage1) // prints: com.example.kotlintutorials.topics.AllClassesInKotlinTopic$SessionStorage@b1bc7ed
        println(sessionStorage1 == sessionStorage2) // prints: false
    }

    class SessionStorage(
        private val file: File
    ) {
        var counter = 0

        fun save(value: String) {
            // ...
        }
    }

    /* --------DATA CLASSES-------- */
    fun dataClassExample() {
        val person1 = Person("Sam", "12.01.1976", "sam@gmail.com")
        val person2 = Person("Sam", "12.01.1976", "sam@gmail.com")
        println(person1) // prints: Person(name=Sam, birthDate=12.01.1976, email=sam@gmail.com)
        println(person1 == person2) // prints: true

        val person3 = person1.copy()
        println(person3 == person1) // prints: true

        val person4 = person1.copy(name = "Toy")
        println(person4 == person1) // prints: false
    }

    private data class Person(
        val name: String,
        val birthDate: String,
        val email: String
    ) {

    }

    /* --------OBJECT CLASSES-------- */
    fun objectClassExample() {
        DateUtil.format(ZonedDateTime.now())
        println(DateUtil) // prints: com.example.kotlintutorials.topics.AllClassesInKotlinTopic$DateUtil@17a7cec2
    }

    object DateUtil {
        fun format(dateTime: ZonedDateTime): String {
            return ".."
        }
    }

    /* --------DATA OBJECT CLASSES-------- */
    fun dataObjectClassExample() {
        DateUtil2.format(ZonedDateTime.now())
        println(DateUtil2) // prints: DateUtil2
    }

    data object DateUtil2 {
        fun format(dateTime: ZonedDateTime): String {
            return ".."
        }
    }

    /* --------ENUM CLASSES-------- */
    fun enumClassExample() {
        val response = HttpStatus.NOT_FOUND
        println(response.toResponseString())
        HttpStatus.entries.forEach {
            println(it.message)
        }
    }

    enum class HttpStatus(val code: Int, val message: String) {
        OK(200, "OK"),
        BAD_REQUEST(400, "Bad Request"),
        NOT_FOUND(404, "Not Found");

        fun toResponseString(): String {
            return "$code: $message"
        }
    }

    /* --------SEALED CLASSES-------- */
    fun sealedClassExample() {
        val resultA = NetworkResult.Success("Data A")
        val resultB = NetworkResult.Success("Data B")
    }

    sealed class NetworkResult {
        data class Success(val data: String) : NetworkResult()
        data class Error(val throwable: Throwable) : NetworkResult()
        data object Empty : NetworkResult()
    }

    sealed interface NetworkResultI {
        data class Success(val data: String) : NetworkResultI
        data class Error(val throwable: Throwable) : NetworkResultI
        data object Empty : NetworkResultI
    }

    /* --------ABSTRACT CLASSES-------- */
    fun abstractClassExample() {
        val sensor: Sensor = HeartRateSensor()
    }

    abstract class Sensor {
        abstract val name: String

        open fun startListening(onNewValue: (Float) -> Unit) {
            //TODO default implementation
        }
    }

    class HeartRateSensor() : Sensor() {
        override val name: String
            get() = "Heart rate tracker"

        override fun startListening(onNewValue: (Float) -> Unit) {
            TODO("Not yet implemented")
        }

    }

    /* --------OPEN CLASSES-------- */
    fun openClassExample() {

    }

    open class TouchSensor() : Sensor() {
        override val name: String
            get() = "Touch sensor"

        override fun startListening(onNewValue: (Float) -> Unit) {
            TODO("Not yet implemented")
        }

    }

    class CustomTouchSensor() : TouchSensor() {
        override val name: String
            get() = "custom name"
    }

    /* --------ANONYMOUS CLASSES-------- */
    // they called anonymous because they don't have a name
    fun anonymousClassExample() {
        val specialSensor = object : Sensor() {
            override val name: String
                get() = "Special sensor"

            override fun startListening(onNewValue: (Float) -> Unit) {
                super.startListening(onNewValue)
            }
        }
    }

    /* --------VALUE CLASSES-------- */
    fun valueClassExample() {
        val email = Email("eg@example.com")
    }

    @JvmInline
    value class Email(val email: String) {
        init {
            if (!email.contains('@')) {
                throw IllegalArgumentException("Invalid email")
            }
        }
    }

    /* --------ANNOTATION CLASSES-------- */
    fun annotationClassExample() {
        val example = ExampleClassWithAnnotation("That's me!")
    }

    @CustomDeprecated("This class is deprecated")
    @JvmInline
    value class ExampleClassWithAnnotation @CustomDeprecated("This constructor is deprecated") constructor(
        val smth: String
    ) {
        init {
            println(smth)
        }
    }

    annotation class CustomReplaceWith(val expression: String)

    @Target(
        AnnotationTarget.CLASS,
        AnnotationTarget.CONSTRUCTOR
    )
    annotation class CustomDeprecated(
        val message: String,
        val replaceWith: CustomReplaceWith = CustomReplaceWith("")
    )

    /* --------INNER CLASSES-------- */
    fun innerClassExample() {

    }

    class NormalClass(
        val defaultValue: Int
    ) {
        var newVariable = 0

        fun doSomething() {
            //...
        }

        // This is a nested class
        class NestedClass() {
            fun changeTheValue() {
                // this class can't have an access to the NormalClass variables
//                newVariable = defaultValue
            }
        }

        // This is an inner class
        inner class InnerClass() {
            // here we have full access to all variables of the NormalClass
            fun changeTheValue() {
                newVariable = defaultValue
            }
        }
    }
}