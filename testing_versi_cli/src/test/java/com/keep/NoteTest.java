package com.keep;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

//ini unit test
public class NoteTest{
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
    
    @Test
    public void test_clone_catatan() {
        Note original = new Note(1, "Belajar TI", "Materi Testing", "Kuliah", "Hari ini");
        Note clone = original.cloneNote();

        assertNotSame(original, clone, "Objek clone harus memiliki referensi memori yang berbeda");
        assertEquals(original.getTitle(), clone.getTitle(), "Judul harus sama");
        assertEquals(original.getContent(), clone.getContent(), "Konten harus sama");
    }

    
    @Test
    public void test_manajemen_kotak_centang() {
        Note note = new Note("Belanjaan", "Beli kebutuhan kost");
        
        // Tambah item kotak centang
        note.addChecklistItem("Susu", false);
        note.addChecklistItem("Roti", false);
        assertEquals(2, note.getChecklistItems().size());

        // Munculkan & Sembunyikan kotak centang
        note.setShowCheckboxes(true);
        assertTrue(note.isShowCheckboxes());
        note.setShowCheckboxes(false);
        assertFalse(note.isShowCheckboxes());

        // Centang semua item
        note.checkAllItems();
        assertTrue(note.getChecklistStatus().get(0), "Item pertama harus tercentang");
        assertTrue(note.getChecklistStatus().get(1), "Item kedua harus tercentang");
    }

    @Test
    public void test_hapus_catatan() {
        Note note = new Note("rahasia negara", "ga boleh tengok");
        assertFalse(note.isDeleted(), "jangan dihapus");
        
        note.delete();
        assertTrue(note.isDeleted(), "bagus udah kehapus");
    }

    @Test
    public void test_aktifkan_tema_gelap() {
        Note note = new Note("Catatan Nyaman", "Mata ga sakit");
        note.setDarkModeEnabled(true);
        assertTrue(note.isDarkModeEnabled());
    }

     @Test
    public void test_aktifkan_tema_terang() {
        Note note = new Note("Catatan Nyaman", "Mata ga sakit");
        note.setLightModeEnabled(true);
        assertTrue(note.isLightModeEnabled());
    }

    @Test
    public void test_salin_ke_google_dokumen() {
        Note note = new Note("Ide Bisnis", "peminjaman iphone");
        String formatGoogleDocs = note.convertToGoogleDocsFormat();
        assertNotNull(formatGoogleDocs);
        assertTrue(formatGoogleDocs.contains("DOCS EXPORT"));
        assertTrue(formatGoogleDocs.contains("Ide Bisnis"));
    }

//ini mocking

@Test
    public void test_ambil_catatan_lewat_mock_dao() {
        NoteDAO noteDAOMock = mock(NoteDAO.class);
        java.util.List<Note> daftarCatatanTiruan = new java.util.ArrayList<>();
        daftarCatatanTiruan.add(new Note(67, "judulclone", "contentmocking"));

        when(noteDAOMock.getAllNotes()).thenReturn(daftarCatatanTiruan);
        java.util.List<Note> hasilUji = noteDAOMock.getAllNotes();

        assertNotNull(hasilUji, "Data harusnya berhasil keluar");
        assertEquals(1, hasilUji.size());
        assertEquals("judulclone", hasilUji.get(0).getTitle(), "Judul harus sama kayak yang di mocking");
        assertEquals("contentmocking", hasilUji.get(0).getContent(), "Konten harus sama kayak yang di mocking");
        verify(noteDAOMock, times(1)).getAllNotes();
    }

    @Test
    public void test_simpan_catatan_lewat_mock_dao() {
        NoteDAO noteDAOMock = mock(NoteDAO.class);
        Note note = new Note(88, "judulmock", "kontenmock");

        doNothing().when(noteDAOMock).addNote(note);
        noteDAOMock.addNote(note);

        verify(noteDAOMock, times(1)).addNote(note);
        verifyNoMoreInteractions(noteDAOMock);
    }

    @Test
    public void test_edit_catatan_mengubah_judul_dan_konten() {
        Note note = new Note(1, "Lama", "Isi lama", "Label", "Besok");

        note.edit("Baru", "Isi baru", "Kerja", "Minggu depan");

        assertEquals("Baru", note.getTitle());
        assertEquals("Isi baru", note.getContent());
        assertEquals("Kerja", note.getLabel());
        assertEquals("Minggu depan", note.getReminder());
    }
}



