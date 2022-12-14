@file:Suppress("unused")

import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

fun getInput() = readInput("input")

fun getTestInput() = readInput("input_test")

fun getInputString() = readInputString("input")

fun getTestInputString() = readInputString("input_test")

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src", "$name.txt")
    .readLines()

fun readInputString(name: String) = File("src", "$name.txt").readText()

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')
