package ru.netology

import java.time.LocalDateTime

object NotesKeeper {
    private var noteNewId = 0
    private var commentNewId = 0
    private var notes = mutableListOf<Note>()
    private var comments = mutableListOf<Comment>()
    private var deletedComments = mutableListOf<Comment>()

    fun add(
        title: String,
        text: String,
        ownerId: Int
    ): Int {
        val thisNoteId = noteNewId++
        notes.add(Note(
            id = thisNoteId,
            title = title,
            text = text,
            ownerId = ownerId
        ))
        return thisNoteId
    }

    fun createComment(
        noteId: Int,
        replyTo: Int? = null,
        message: String,
        fromId: Int
    ): Int {
        if (notes.find { it.id == noteId } == null) {
            println("Заметки с №${noteId + 1} не существует.\n")
            return -1
        }
        val thisCommentId = commentNewId++
        comments.add(Comment(
            id = thisCommentId,
            fromId = fromId,
            toNoteId = noteId,
            ownerId = (notes.find { it.id == noteId })!!.ownerId,
            replyToUser = replyTo,
            text = message
        ))
        return thisCommentId
    }

    fun delete(noteId: Int): Boolean {
        val noteToDelete = notes.find { it.id == noteId } ?: return false
        comments = comments.filter { it.toNoteId != noteId }.toMutableList()
        return notes.remove(noteToDelete)
    }

    fun deleteComment(commentId: Int): Comment? {
        val commentToDelete = comments.find { it.id == commentId } ?: return null
        deletedComments.add(commentToDelete)
        comments.remove(commentToDelete)
        return deletedComments.find { it.id == commentId }
    }

    fun edit(
        noteId: Int,
        title: String,
        text: String
    ): Note? {
        val noteToEdit = notes.find { it.id == noteId } ?: return null
        val i = notes.indexOf(noteToEdit)
        notes[i] = notes[i].copy(
            title = title,
            text = text,
            date = LocalDateTime.now()
        )
        return notes[i]
    }

    fun editComment(commentId: Int, message: String): Comment? {
        val commentToEdit = comments.find { it.id == commentId } ?: return null
        val i = comments.indexOf(commentToEdit)
        comments[i] = comments[i].copy(
            text = message,
            date = LocalDateTime.now()
        )
        return comments[i]
    }

    fun get(userId: Int, sort: Boolean = true): String {
        val getNotes = notes.filter { it.ownerId == userId }
        if (getNotes.isEmpty()) return "У пользователя №$userId нет заметок.\n"
        if (sort)
            getNotes.sortedByDescending { it.date }
        else getNotes.sortedBy { it.date }
        val notesToString = StringBuilder()
        for (n in getNotes)
            notesToString.append(n).append("\n")
        return notesToString.toString()
    }

    fun getById(noteId: Int): String {
        return notes.find { it.id == noteId }?.toString()
            ?: "Заметки с №${noteId + 1} не существует.\n"
    }

    fun getComments(noteId: Int, sort: Boolean = true): String {
        notes.find { it.id == noteId } ?: return "Заметки с №${noteId + 1} не существует.\n"
        val getComments = comments.filter { it.toNoteId == noteId }
        if (getComments.isEmpty()) return "У заметки №${noteId + 1} нет комментариев.\n"
        if (sort)
            getComments.sortedByDescending { it.date }
        else getComments.sortedBy { it.date }
        val commentsToString = StringBuilder()
        for (c in getComments)
            commentsToString.append(c).append("\n")
        return commentsToString.toString()
    }

    fun restoreComment(commentId: Int): String {
        val commentToRestore = deletedComments.find { it.id == commentId } ?:
            return "Среди удаленных комментариев отсутствует комментарий с номером №${commentId + 1}.\n"
        comments.add(commentToRestore)
        deletedComments.remove(commentToRestore)
        return "Комментарий №${commentId + 1} успешно восстановлен.\n"
    }

    fun getNoteNewId(): Int {
        return noteNewId
    }

    fun getCommentNewId(): Int {
        return commentNewId
    }

    fun deletedCommentsIsEmpty(): Boolean {
        return deletedComments.isEmpty()
    }

    fun notesIsEmpty(userId: Int): Boolean {
        return notes.none { it.ownerId == userId }
    }

    fun commentsIsEmpty(noteId: Int): Boolean {
        return comments.none { it.toNoteId == noteId }
    }

    fun containsNote(noteId: Int): Boolean {
        return notes.filter { it.id == noteId }.isNotEmpty()
    }

    fun containsDeletedComment(commentId: Int): Boolean {
        return deletedComments.any { it.id == commentId }
    }

    fun clear() {
        noteNewId = 0
        commentNewId = 0
        notes = mutableListOf()
        comments = mutableListOf()
        deletedComments = mutableListOf()
    }
}