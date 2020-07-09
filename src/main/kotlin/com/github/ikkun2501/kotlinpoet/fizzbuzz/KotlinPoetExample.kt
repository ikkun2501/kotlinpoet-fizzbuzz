package com.github.ikkun2501.kotlinpoet.fizzbuzz

import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import java.nio.file.Paths

fun main() {

    // コードの生成
    val code = createCode()

    // 関数仕様の生成
    val funSpec = createFunSpec(code)

    // ファイル仕様の生成
    val fileSpec = createFileSpec(funSpec)

    // ファイル出力
    fileSpec.writeTo(Paths.get("/Users/hal/IdeaProjects/kotlinpoet-fizzbuzz/src/main/kotlin"))
}

fun createFileSpec(funSpec: FunSpec): FileSpec {

    // ファイルの仕様を定義
    return FileSpec
        // パッケージ名とファイル名を指定
        .builder("com.github.ikkun2501.kotlinpoet.fizzbuzz.example", "Main")
        // ファイルに関数を追加
        .addFunction(funSpec)
        // ファイルスペッククラスの構築
        .build()
}

fun createFunSpec(code: CodeBlock): FunSpec {

    // 関数の仕様を定義
    return FunSpec
        // 関数名を指定
        .builder("main")
        // コメント
        .addComment("// 1〜9の数字を出力")
        // コードを追加
        .addCode(code)
        // 関数スペックの構築
        .build()
}

fun createCode(): CodeBlock {

    // コードの生成
    return CodeBlock.builder()
        // For文　開始
        .beginControlFlow("for(i in 1..9)")
        // For文の中の処理
        .addStatement("println(i)")
        // For文　終了
        .endControlFlow()
        // コードの構築
        .build()
}