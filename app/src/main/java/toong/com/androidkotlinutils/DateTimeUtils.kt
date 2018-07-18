package toong.com.androidkotlinutils

import java.text.SimpleDateFormat
import java.util.*

fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
    val formatter = SimpleDateFormat(format, locale)
    return formatter.format(this)
}

/**
 * we can use localtime if minSdk >= 26
 */
fun getCurrentDateTime(): Date {
    return Calendar.getInstance().time
}

fun Date.getPreviousDateTime(): Date {
    return Calendar.getInstance().let {
        it.time = this
        it.add(Calendar.DATE, -1)
        it.time
    }
}

fun Date.getNextDateTime(): Date {
    return Calendar.getInstance().let {
        it.time = this
        it.add(Calendar.DATE, 1)
        it.time
    }
}

fun String.toDate(format: String, locale: Locale = Locale.getDefault()): Date {
    return SimpleDateFormat(format, locale).parse(this)
}

fun String.changeTimeFormat(oldFormat: String, newFormat: String,
                            locale: Locale = Locale.getDefault()): String {
    val simpleDateFormat = SimpleDateFormat(oldFormat, locale)
    val date = simpleDateFormat.parse(this)
    simpleDateFormat.applyPattern(newFormat)
    return simpleDateFormat.format(date)
}
