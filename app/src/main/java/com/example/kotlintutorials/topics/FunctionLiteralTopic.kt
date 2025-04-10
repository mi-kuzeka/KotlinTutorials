package com.example.kotlintutorials.topics

object FunctionLiteralTopic {
    fun functionLiteralExample() {
        doSomeTask { name = "learning" }
        Task { name = "home work" }
    }

    class Task(init: Task.() -> Unit) {
        var name = ""

        init {
            init()
            workingOn()
        }

        private fun workingOn() {
            println("Currently working on $name")
        }
    }

    // 'Task' here is a receiver
    private fun doSomeTask(setTaskName: Task.() -> Unit) {
        Task(setTaskName)
    }
}