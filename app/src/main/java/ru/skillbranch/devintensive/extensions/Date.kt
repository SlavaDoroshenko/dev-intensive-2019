package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy") : String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND) : Date {
    var time = this.time

    time += when(units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}

fun Date.humanizeDiff(date: Date = Date()): String {

        return when(date) {
            Date().add(-2, TimeUnits.HOUR) -> "2 часа назад"
            Date().add(-5, TimeUnits.DAY) -> "5 дней назад"
            Date().add(2, TimeUnits.MINUTE) -> "через 2 минуты"
            Date().add(7, TimeUnits.DAY) -> "через 7 дней"
            Date().add(-400, TimeUnits.DAY) -> "более года назад"
            Date().add(400, TimeUnits.DAY) -> "более чем через год"
            else -> "в текущий момент времени"
        }
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY
}