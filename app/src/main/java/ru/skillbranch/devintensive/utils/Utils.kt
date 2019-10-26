package ru.skillbranch.devintensive.utils

import android.annotation.SuppressLint
import java.lang.StringBuilder

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")

        var firstName: String? = null
        var lastName: String? = null
        if (!fullName?.isBlank()!!) {
            if (parts?.size == 1) {
                firstName = parts.getOrNull(0)
            } else {
                firstName = parts?.getOrNull(0)
                lastName = parts?.getOrNull(1)
            }
        }
        return firstName to lastName
    }

    @SuppressLint("DefaultLocale")
    fun transliteration(payload: String, divider: String = " "): String {

        var parts = emptyArray<String>()

        val hashMap: HashMap<String, String> = hashMapOf(
            "а" to "a",
            "б" to "b",
            "в" to "v",
            "г" to "g",
            "д" to "d",
            "е" to "e",
            "ё" to "e",
            "ж" to "zh",
            "з" to "z",
            "и" to "i",
            "й" to "i",
            "к" to "k",
            "л" to "l",
            "м" to "m",
            "н" to "n",
            "о" to "o",
            "п" to "p",
            "р" to "r",
            "с" to "s",
            "т" to "t",
            "у" to "u",
            "ф" to "f",
            "х" to "h",
            "ц" to "c",
            "ч" to "ch",
            "ш" to "sh",
            "щ" to "sh'",
            "ъ" to "",
            "ы" to "i",
            "ь" to "",
            "э" to "e",
            "ю" to "yu",
            "я" to "ya",
            "a" to "a",
            "b" to "b",
            "v" to "v",
            "g" to "g",
            "d" to "d",
            "e" to "e",
            "e" to "e",
            "zh" to "zh",
            "z" to "z",
            "i" to "i",
            "i" to "i",
            "k" to "k",
            "l" to "l",
            "m" to "m",
            "n" to "n",
            "o" to "o",
            "p" to "p",
            "r" to "r",
            "s" to "s",
            "t" to "t",
            "u" to "u",
            "f" to "f",
            "h" to "h",
            "c" to "c",
            "ch" to "ch",
            "sh" to "sh",
            "sh'" to "sh'",
            "i" to "i",
            "e" to "e",
            "yu" to "yu",
            "ya" to "ya",
            "а".toUpperCase() to "a".toUpperCase(),
            "б".toUpperCase() to "b".toUpperCase(),
            "в".toUpperCase() to "v".toUpperCase(),
            "г".toUpperCase() to "g".toUpperCase(),
            "д".toUpperCase() to "d".toUpperCase(),
            "е".toUpperCase() to "e".toUpperCase(),
            "ё".toUpperCase() to "e".toUpperCase(),
            "ж".toUpperCase() to "Zh",
            "з".toUpperCase() to "z".toUpperCase(),
            "и".toUpperCase() to "i".toUpperCase(),
            "й".toUpperCase() to "i".toUpperCase(),
            "к".toUpperCase() to "k".toUpperCase(),
            "л".toUpperCase() to "l".toUpperCase(),
            "м".toUpperCase() to "m".toUpperCase(),
            "н".toUpperCase() to "n".toUpperCase(),
            "о".toUpperCase() to "o".toUpperCase(),
            "п".toUpperCase() to "p".toUpperCase(),
            "р".toUpperCase() to "r".toUpperCase(),
            "с".toUpperCase() to "s".toUpperCase(),
            "т".toUpperCase() to "t".toUpperCase(),
            "у".toUpperCase() to "u".toUpperCase(),
            "ф".toUpperCase() to "f".toUpperCase(),
            "х".toUpperCase() to "h".toUpperCase(),
            "ц".toUpperCase() to "c".toUpperCase(),
            "ч".toUpperCase() to "Ch",
            "ш".toUpperCase() to "Sh",
            "щ".toUpperCase() to "Sh'",
            "ъ".toUpperCase() to "",
            "ы".toUpperCase() to "i".toUpperCase(),
            "ь".toUpperCase() to "",
            "э".toUpperCase() to "e".toUpperCase(),
            "ю".toUpperCase() to "Yu",
            "я".toUpperCase() to "Ya",
            "a".toUpperCase() to "a".toUpperCase(),
            "b".toUpperCase() to "b".toUpperCase(),
            "v".toUpperCase() to "v".toUpperCase(),
            "g".toUpperCase() to "g".toUpperCase(),
            "d".toUpperCase() to "d".toUpperCase(),
            "e".toUpperCase() to "e".toUpperCase(),
            "e".toUpperCase() to "e".toUpperCase(),
            "Zh" to "Zh",
            "z".toUpperCase() to "z".toUpperCase(),
            "i".toUpperCase() to "i".toUpperCase(),
            "i".toUpperCase() to "i".toUpperCase(),
            "k".toUpperCase() to "k".toUpperCase(),
            "l".toUpperCase() to "l".toUpperCase(),
            "m".toUpperCase() to "m".toUpperCase(),
            "n".toUpperCase() to "n".toUpperCase(),
            "o".toUpperCase() to "o".toUpperCase(),
            "p".toUpperCase() to "p".toUpperCase(),
            "r".toUpperCase() to "r".toUpperCase(),
            "s".toUpperCase() to "s".toUpperCase(),
            "t".toUpperCase() to "t".toUpperCase(),
            "u".toUpperCase() to "u".toUpperCase(),
            "f".toUpperCase() to "f".toUpperCase(),
            "h".toUpperCase() to "h".toUpperCase(),
            "c".toUpperCase() to "c".toUpperCase(),
            "Ch" to "Ch",
            "Sh" to "Sh",
            "Sh'" to "Sh'",
            "i".toUpperCase() to "i".toUpperCase(),
            "e".toUpperCase() to "e".toUpperCase(),
            "Yu" to "Yu",
            "Ya" to "Ya"
        )

        var i = 0
        val str = StringBuilder()
        val str1 = StringBuilder()
        while (i < payload.length) {
            if (payload[i] == ' ') {
                parts += str.toString()
                i++
                while (i < payload.length) {
                    str1.append(hashMap[payload[i].toString()])
                    i++
                }
                parts += str1.toString()
            } else {
                str.append(hashMap[payload[i].toString()])
                i++
            }
        }

        val result: String? = parts[0] + divider + parts[1]

        return result.toString()
    }

    @SuppressLint("DefaultLocale")
    fun toInitials(firstName: String?, lastName: String?): String? {
        var initials: String?

        if (firstName != null && !firstName.isBlank()) {
            initials = "${firstName[0]}".toUpperCase()
            if (lastName != null && !lastName.isBlank()) {
                initials += "${lastName[0]}".toUpperCase()
            }
        } else {
            initials = null
        }

        return initials
    }
}




