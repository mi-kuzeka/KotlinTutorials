package com.example.kotlintutorials.topics

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

object InlineFunctionsTopic {

    /* --------INLINE EXAMPLE-------- */
    fun inlineExample() {
        val list = (1..100).toList()
        list.inlinedForEach { println(it) }
    }

    fun <T> List<T>.normalForEach(action: (T) -> Unit) {
        for (item in this) {
            action(item)
        }
    }

    private inline fun <T> List<T>.inlinedForEach(action: (T) -> Unit) {
        for (item in this) {
            action(item)
        }
    }

    /* --------INLINE WITH COROUTINE SCOPE-------- */
    fun inlineWithCoroutineExample() {
        val list = (1..100).toList()
//        val job = CoroutineScope(Dispatchers.IO).launch {
        // I'm using runBlocking for testing
        runBlocking {
//            list.normalForEach {
//                // The delay can't be invoked for not inline function
//                // because it doesn't know the context for coroutine
//                delay(1000L)
//                println(it)
//            }
            list.inlinedForEach {
                // The delay now can be invoked with inline function
                // because it placed inside this coroutine scope after compiling
                delay(200L)
                println(it)
            }
        }
    }

    /* --------REIFIED MODIFIER-------- */
    fun reifiedExample() {
        "Hello world".className()
    }

    // If we don't use a 'reified' modifier, then a compiler will show as an error:
    // >'Cannot use 'T' as reified type parameter. Use a class instead.'
    private inline fun <reified T> T.className() {
        println(T::class.simpleName)
    }

    /* --------NON-LOCAL RETURN WITH INLINE FUNCTION-------- */
    fun nonLocalReturnExample() {
        val list = (1..10).toList()
        list.normalForEach {
            println(it)
//            return // you can't use a non-local return here
            return@normalForEach
        }
        list.inlinedForEach {
            println(it)
            // you can use both return types in inline function
            return
//            return@inlinedForEach
        }
    }

    /* --------CROSSINLINE MODIFIER-------- */
    fun crossInlineModifierExample() {
        executeAsync {
            println("Hello")
//            return //you can't use non-local return here
        }
    }

    /*
    To indicate that the lambda parameter of the inline function
    cannot use non-local returns, mark the lambda parameter
    with the crossinline modifier
    https://kotlinlang.org/docs/inline-functions.html#returns
     */
    private inline fun executeAsync(crossinline action: () -> Unit) {
//        CoroutineScope(Dispatchers.Default).launch {
        // I'm using runBlocking for testing
        runBlocking {
            // If we don't use a 'crossinline' modifier then we receive a complain by compiler^
            // >'Can't inline 'action' here: it may contain non-local returns.
            // > Add 'crossinline' modifier to parameter declaration 'action''
            action()
        }
    }

    /* --------INLINE VARIABLE-------- */
    private inline val <T> List<T>.lastItem: T
        get() = get(lastIndex)

    fun inlineVariableExample() {
        val list = (1..25).toList()
        println(list.lastItem)
    }

    /* --------INLINE CLASS-------- */
    @JvmInline
    value class Month(val number: Int)
}