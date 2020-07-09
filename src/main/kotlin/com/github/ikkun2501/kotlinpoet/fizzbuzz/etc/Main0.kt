package com.github.ikkun2501.kotlinpoet.fizzbuzz.etc

import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec

fun main() {
    // 関数の実装
    val i = 0

    val codeBlock = CodeBlock.builder()
        .beginControlFlow("for(i in 1..10)")
        .addStatement("println(%L)", i)
        .endControlFlow()
        .build()

    val fileSpec = FileSpec
        .builder("com.github.ikkun2501.kotlinpoet.fizzbuzz.etc.main", "FizzBuzz")
        .addFunction(
            FunSpec.builder("forprint")
                .addCode(codeBlock)
                .build()
        )
        .build()

    fileSpec.writeTo(System.out)
}


