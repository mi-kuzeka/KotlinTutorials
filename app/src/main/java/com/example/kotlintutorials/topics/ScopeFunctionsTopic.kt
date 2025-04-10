package com.example.kotlintutorials.topics

import android.content.Intent

object ScopeFunctionsTopic {

    /* --------WITH-------- */
    fun withExample() {
        // the type of the intent variable is Unit because
        // the with scope returns the last line of the scope (the result of the block)
        val intent = with(Intent()) {
            // we can use the Intent methods directly inside this scope
            // without putting any variable name before that
            putExtra("stringValue", "Hello")
            putExtra("intValue", 0)
            action = ""
        }
    }

    /* --------RUN-------- */
    fun runExample() {
        // the type of the intent variable is Unit because
        // the run scope returns the last line of the scope (the result of the block)
        val intent = Intent().run {
            // we can use the Intent methods directly inside this scope
            // without putting any variable name before that
            putExtra("stringValue", "Hello")
            putExtra("intValue", 0)
            action = ""
        }
    }

    /* --------APPLY-------- */

    fun applyExample() {
        // the type of the intent variable is Intent
        val intent = Intent().apply {
            // we can use the Intent methods directly inside this scope
            // without putting any variable name before that
            putExtra("stringValue", "Hello")
            putExtra("intValue", 0)
            action = ""
        }
    }

    /* --------ALSO-------- */
    private var i = 0

    fun alsoExample() {
        println(getSquaredI())
        println(getSquaredI())
    }

    private fun getSquaredI() = (i * i).also { i += 4 }

    /* --------LET-------- */
    private var number: Int? = null

    fun letExample() {
        // x has the Unit? type because the 'let' block returns
        // the last line of the block (the result of the block)
        val x = number?.let {
            val number1 = it + 1 // this line is Unit?
        }

        // y has the Int? type
        val y = number?.let {
            val number1 = it + 1 // this line is Unit?
            number1 // this line is Int?
        }

        // z has the Int (non-nullable) type
        // because if the 'let' block is null then we return 3
        val z = number?.let {
            val number1 = it + 1 // this line is Unit?
            number1 // this line is Int?
        } ?: 3 // this line is Int
    }
}