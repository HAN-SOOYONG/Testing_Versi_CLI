package com.keep;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NoteTest {

    @Test
    public void test_membuat_hanya_juduldankonten() {
        Note note = new Note("test", "Menulis unit test");

        assertEquals(0, note.getId());
        assertEquals("test", note.getTitle());
        assertEquals("Menulis unit test", note.getContent());
        assertNull(note.getLabel());
        assertNull(note.getReminder());
    }

    @Test
    public void test_membuat_note_data_kengkap() {
        Note note = new Note(1, "Tugas", "coding", "Kerja", "Besok");

        assertEquals(1, note.getId());
        assertEquals("Tugas", note.getTitle());
        assertEquals("coding", note.getContent());
        assertEquals("Kerja", note.getLabel());
        assertEquals("Besok", note.getReminder());
    }
}
