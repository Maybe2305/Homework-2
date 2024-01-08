fun main() {
    println(agoToText())
}

val amountSeconds = 19210
val minuteAgo = amountSeconds / 60
val hoursAgo = amountSeconds / 60 / 60
fun agoToText(): String = when (amountSeconds) {
    in 0..60 -> "Был(а) только что"
    in 61..60 * 60 -> "Был(а) в сети $minuteAgo ${endingWordsMinute()} назад"
    in 60 * 60 + 1..24 * 60 * 60 -> "Был(а) в сети $hoursAgo ${endingWordsHours()} назад"
    in 24 * 60 * 60..(24 * 60 * 60) * 2 -> "Был(а) в сети вчера"
    in (24 * 60 * 60) * 2..(24 * 60 * 60) * 3 -> "Был(а) в сети позавчера"
    else -> "Был(а) в сети давно"
}

fun endingWordsMinute(): String = when {
    (amountSeconds / 60) % 10 == 1 && (amountSeconds / 60) % 100 != 11 -> "минуту"
    (amountSeconds / 60) % 10 == 3 || (amountSeconds / 60) % 10 == 4 || (amountSeconds / 60) % 10 == 2 -> "минуты"
    else -> "минут"
}

fun endingWordsHours() = when {
    (amountSeconds / 3600) % 10 == 1 && (amountSeconds / 3600) % 100 != 11 -> "час"
    (amountSeconds / 3600) % 10 == 3 || (amountSeconds / 3600) % 10 == 4 || (amountSeconds / 3600) % 10 == 2 -> "часа"
    else -> "часов"
}