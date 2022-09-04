package ru.netology

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Comment(
    val id: Int = 0,
    val fromId: Int,
    val toNoteId: Int = 0,
    val ownerId: Int = 0,
    val date: LocalDateTime = LocalDateTime.now(),
    val text: String? = null,
    val replyToUser: Int? = null,
    val replyToComment: Int? = null
) {
    private val DEFAULT_TIME_FORMAT =
        DateTimeFormatter.ofPattern("HH:mm:ss, dd.MM.yyyy")

    override fun toString(): String {
        return """Комментарий №${id + 1} к Заметке №${toNoteId + 1}:
            |-=< ${text ?: "пустой комментарий"} >=-
            |Разместил пользователь №$fromId
            |Время публикации - ${date.format(DEFAULT_TIME_FORMAT)}
            |
            """.trimMargin()
    }
}