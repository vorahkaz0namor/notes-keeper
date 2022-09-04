package ru.netology

import org.junit.Test

import org.junit.Assert.*

class NotesKeeperTest {

    @Test
    fun add() {
        NotesKeeper.add(
            "First note",
            "It's first note",
            2
        )
        assertTrue(NotesKeeper.getNoteNewId() != 0)
    }

    @Test
    fun createCommentTrue() {
        NotesKeeper.createComment(
            noteId = 0,
            message = "First comment to first note",
            fromId = 1
        )
        assertTrue(NotesKeeper.getCommentNewId() != 0)
    }

    @Test
    fun createCommentFalse() {
        assertTrue(NotesKeeper.createComment(
            noteId = 1,
            message = "",
            fromId = 1
        ) == -1)
    }

    @Test
    fun deleteTrue() {
        assertTrue(NotesKeeper.delete(0))
    }

    @Test
    fun deleteFalse() {
        assertFalse(NotesKeeper.delete(99))
    }

    @Test
    fun deleteCommentTrue() {
        fillSomeInstances()
        NotesKeeper.deleteComment(NotesKeeper.getCommentNewId() - 2)
        assertFalse(NotesKeeper.deletedCommentsIsEmpty())
    }

    @Test
    fun deleteCommentFalse() {
        assertTrue(NotesKeeper.deleteComment(99) == null)
    }

    @Test
    fun editTrue() {
        assertTrue(NotesKeeper.edit(
            1,
            "Second note, v.2.0",
            "It's edited second note"
        ) != null)
    }

    @Test
    fun editFalse() {
        assertTrue(NotesKeeper.edit(2,"","") == null)
    }

    @Test
    fun editCommentTrue() {
        fillSomeInstances()
        assertTrue(NotesKeeper.editComment(
            NotesKeeper.getCommentNewId() - 1,
            "Second comment to second note was edited"
        ) != null)
    }

    @Test
    fun editCommentFalse() {
        assertTrue(NotesKeeper.editComment(99,"") == null)
    }

    @Test
    fun getTrue() {
        assertFalse(NotesKeeper.notesIsEmpty(2))
    }

    @Test
    fun getFalse() {
        assertTrue(NotesKeeper.notesIsEmpty(99))
    }

    @Test
    fun getByIdTrue() {
        assertTrue(NotesKeeper.containsNote(NotesKeeper.getNoteNewId() - 1))
    }

    @Test
    fun getByIdFalse() {
        assertFalse(NotesKeeper.containsNote(99))
    }

    @Test
    fun getCommentsTrue() {
        assertFalse(NotesKeeper.commentsIsEmpty(NotesKeeper.getNoteNewId() - 1))
    }

    @Test
    fun getCommentsFalse() {
        assertTrue(NotesKeeper.commentsIsEmpty(99))
    }

    @Test
    fun restoreCommentTrue() {
        fillSomeInstances()
        NotesKeeper.deleteComment(NotesKeeper.getCommentNewId() - 2)
        assertTrue(NotesKeeper.containsDeletedComment(NotesKeeper.getCommentNewId() - 2))
    }

    @Test
    fun restoreCommentFalse() {
        assertFalse(NotesKeeper.containsDeletedComment(99))
    }

    private fun fillSomeInstances() {
        NotesKeeper.clear()
        NotesKeeper.add(
            "Next note",
            "It's next note",
            2
        )
        NotesKeeper.createComment(
            noteId = NotesKeeper.getNoteNewId() - 1,
            message = "First comment to next note",
            fromId = 1
        )
        NotesKeeper.createComment(
            noteId = NotesKeeper.getNoteNewId() - 1,
            message = "Second comment to next note",
            fromId = 1
        )
    }
}