package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?) : Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")

        var firstName: String? = null
        var lastName: String? = null
        if (!fullName?.isBlank()!!) {
            if(parts?.size == 1) {
                firstName = parts.getOrNull(0)
            } else {
                firstName = parts?.getOrNull(0)
                lastName = parts?.getOrNull(1)
            }
        }
        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " "): String {
        TODO("not implemented")
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        TODO("not implemented")
    }
}