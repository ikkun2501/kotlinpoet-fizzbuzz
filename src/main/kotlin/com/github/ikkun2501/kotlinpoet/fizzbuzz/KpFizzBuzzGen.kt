package com.github.ikkun2501.kotlinpoet.fizzbuzz

import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import java.nio.file.Paths

fun main() {

    val fromIndex = 100

    val code = CodeBlock.builder()
        .beginControlFlow("for (i in 1 until %L)", fromIndex)
        .add(
            CodeBlock.builder()
                .beginControlFlow("if(i %% 15 == 0)")
                .addStatement("println(%S)", "FizzBuzz")
                .nextControlFlow("else if(i %% 3 == 0)")
                .addStatement("println(%S)", "Fizz")
                .nextControlFlow("else if(i %% 5 == 0)")
                .addStatement("println(%S)", "Buzz")
                .nextControlFlow("else")
                .addStatement("println(%L)", "i")
                .endControlFlow()
                .build()
        )
        .endControlFlow()
        .build()

    // 関数定義
    val funSpec = FunSpec.builder("main")
        .addCode(code)
        .build()

    // ファイル仕様定義
    val fileSpec = FileSpec.builder("com.github.ikkun2501.kotlinpoet.fizzbuzz", "KpFizzBuzz")
        .addFunction(funSpec)
        .build()

    // ファイル出力
    fileSpec.writeTo(Paths.get("/Users/hal/IdeaProjects/kotlinpoet-fizzbuzz/src/main/kotlin"))
}