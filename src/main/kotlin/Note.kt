package ru.netology

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Note(
    val id: Int = 0,
    val ownerId: Int,
    val title: String? = null,
    val text: String? = null,
    val date: LocalDateTime = LocalDateTime.now(),
    val comments: Int = 0,
    val canComment: Boolean = true
) {
    private val DEFAULT_TIME_FORMAT =
        DateTimeFormatter.ofPattern("HH:mm:ss, dd.MM.yyyy")

    override fun toString(): String {
        return """
            |Заметка №${id + 1}:
            |Тема: ${title ?: "Заголовок заметки"}
            |Содержание: ${text ?: "Здесь что-то будет написано..."}
            |Автор: Пользователь №$ownerId
            |Время публикации: ${date.format(DEFAULT_TIME_FORMAT)}
            |
        """.trimMargin()
    }
}
