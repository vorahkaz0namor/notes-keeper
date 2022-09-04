package ru.netology

fun main() {
    println("СОЗДАНИЕ ЗАМЕТОК И ДОБАВЛЕНИЕ КОММЕНТАРИЕВ К НИМ...")
    createInstances()
    println(NotesKeeper.getById(0))
    println(NotesKeeper.getComments(0))
    println(NotesKeeper.getById(1))
    println(NotesKeeper.getComments(1))
    println(NotesKeeper.getById(2))
    println(NotesKeeper.getComments(2))

    println("УДАЛЕНИЕ ЗАМЕТКИ...")
    NotesKeeper.delete(0)
    println(NotesKeeper.getById(0))
    println(NotesKeeper.getComments(0))

    println("УДАЛЕНИЕ КОММЕНТАРИЯ...")
    NotesKeeper.deleteComment(1)
    println(NotesKeeper.getComments(1))

    println("ИЗМЕНЕНИЕ ЗАМЕТКИ...")
    NotesKeeper.edit(
        1,
        "Second note, v.2.0",
        "It's edited second note"
    )
    println(NotesKeeper.getById(1))

    println("ИЗМЕНЕНИЕ КОММЕНТАРИЯ...")
    NotesKeeper.editComment(
        2,
        "Second comment to second note was edited"
    )
    println(NotesKeeper.getComments(1))

    println("ВОССТАНОВЛЕНИЕ КОММЕНТАРИЯ...")
    println(NotesKeeper.restoreComment(1))
}

fun createInstances() {
    NotesKeeper.add(
        "First note",
        "It's first note",
        2
    )
    NotesKeeper.createComment(
        noteId = 0,
        message = "First comment to first note",
        fromId = 1
    )
    Thread.sleep(1000)
    NotesKeeper.add(
        "Second note",
        "It's second note",
        2
    )
    NotesKeeper.createComment(
        noteId = 1,
        message = "First comment to second note",
        fromId = 1
    )
    Thread.sleep(1000)
    NotesKeeper.createComment(
        noteId = 1,
        message = "Second comment to second note",
        fromId = 1
    )
    Thread.sleep(1000)
    NotesKeeper.add(
        "Third note",
        "It's third note",
        3
    )
}