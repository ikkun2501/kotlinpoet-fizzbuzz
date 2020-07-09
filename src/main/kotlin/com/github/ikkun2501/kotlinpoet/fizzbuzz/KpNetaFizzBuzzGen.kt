package com.github.ikkun2501.kotlinpoet.fizzbuzz

import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import java.nio.file.Paths

fun main() {

    val fromIndex = 100

    val code = CodeBlock.builder()
        .beginControlFlow("for(i in 1..%L)", fromIndex)
        .beginControlFlow("when(i)").apply {
            for (i in 1..fromIndex) {
                val str = when {
                    i % 15 == 0 -> "FizzBuzz"
                    i % 3 == 0 -> "Fizz"
                    i % 5 == 0 -> "Buzz"
                    else -> i.toString()
                }
                this.addStatement("%L -> println(%S)", i, str)
            }
        }
        .addStatement("else -> {}")
        .endControlFlow()
        .endControlFlow()
        .build()

    FileSpec.builder("com.github.ikkun2501.kotlinpoet.fizzbuzz", "KpNetaFizzBuzz")
        .addFunction(FunSpec.builder("main").addCode(code).build())
        .build()
        .writeTo(Paths.get("/Users/hal/IdeaProjects/kotlinpoet-fizzbuzz/src/main/kotlin"))
}