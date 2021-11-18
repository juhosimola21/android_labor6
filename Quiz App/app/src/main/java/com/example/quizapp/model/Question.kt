package com.example.quizapp.model

data class Question(
    val text: String,
    val answers: List<String>,
    val correctAnswer: String
    )

var correctAnswers = 0

val questions: MutableList<Question> = mutableListOf(
    Question(
        text = "Kotlin is developed by?",
        answers = mutableListOf("Google", "JetBrains", "Microsoft", "Adobe"),
        correctAnswer = "JetBrains"
    ),
    Question(
        text = "Which of following is used to handle null exceptions in Kotlin?",
        answers = mutableListOf("Range", "Sealed Class", "Elvis Operator", "Lambda function"),
        correctAnswer = "Elvis Operator"
    ),
    Question(
        text = "All classes in Kotlin classes are by default?",
        answers = mutableListOf("public", "final", "sealed", "abstract"),
        correctAnswer = "final"
    ),
    Question(
        text = "What is correct way to create an arraylist in Kotlin?",
        answers = mutableListOf("val map = hashMapOf(1 to \"one\", 2 to \"two\", 3 to \"three\")", " enum class Color {RED, GREEN, BLUE}", "val list = arrayListOf(1, 2, 3)", " val set = hashSetOf(1, 2, 3)"),
        correctAnswer = "val list = arrayListOf(1, 2, 3)"
    ),
    Question(
        text = "What is an immutable variable?",
        answers = mutableListOf("A variable that cannot change, read-only", "A variable that can be changed", "A variable used for string interpolation", "A variable that cannot change, write-only"),
        correctAnswer = "A variable that cannot change, read-only"
    ),
    Question(
        text = "How to make a multi lined comment in Kotlin?",
        answers = mutableListOf("//", "/* */", "/ multi line comment /", "%"),
        correctAnswer = "/ multi line comment /"
    ),
    Question(
        text = "Which of the followings constructors are available in Kotlin?",
        answers = mutableListOf("Primary constructor", "Secondary constructor", "Both 1 & 2", "None of the above"),
        correctAnswer = "Both 1 & 2"
    ),
    Question(
        text = "Which of the following is not the basic data types in Kotlin?",
        answers = mutableListOf("Numbers", "Strings", "Arrays", "Lists"),
        correctAnswer = "Lists"
    ),
    Question(
        text = "What is the difference between listOf() and mutableListOf() functions?",
        answers = mutableListOf("kotlin has only mutableListOf() function", "kotlin has only listOf() function", "listOf() create an immutable list and other create a mutable", "there is no difference"),
        correctAnswer = "listOf() create an immutable list and other create a mutable"
    ),
    Question(
        text = "Which of the following extension methods are used in Kotlin?",
        answers = mutableListOf("Read texts() & Headlines()", "Buffer reader()", "Read each line()", "All of the above"),
        correctAnswer = "All of the above"
    )
    )
