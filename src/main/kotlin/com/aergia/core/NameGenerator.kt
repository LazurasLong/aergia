package com.aergia.core

import java.util.*

private val parts = arrayOf(
    arrayOf("br", "cr", "dr", "fr", "gr", "j", "kr", "l", "m", "n", "pr", "", "", "", "r", "sh", "tr", "v", "wh", "x",
            "y", "z"),
    arrayOf("a", "a", "e", "e", "i", "i", "o", "o", "u", "u", "ae", "ie", "oo", "ou"),
    arrayOf("b", "ck", "d", "g", "k", "m", "n", "p", "t", "v", "x", "z")
)

private val random: Random = Random()

fun generateName(): String {
    var result = StringBuilder()

    for (i in 0..5) {
        val p = parts[i % 3]
        result.append(p[random.nextInt(p.size)])
    }

    return result.toString().capitalize()
}