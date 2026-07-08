package com.keep;


import java.util.List;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {

        DatabaseHelper.initializeDatabase();

        NoteDAO noteDAO = new NoteDAO();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        //loop

        while (running) {
        System.out.println("=================================");
        System.out.println("     GOOGLE KEEP VERSION CLI     ");
        System.out.println("=================================");
        System.out.println("1. Tambah Catatan Baru");
         System.out.println("2. Tampilkan Semua Catatan");
        System.out.println("3. Keluar dari Aplikasi");
        System.out.print("Pilih menu (1-3): ");
        
      String pilihan = scanner.nextLine();
      switch (pilihan) {
                case "1":
                    System.out.println("--- TAMBAH CATATAN BARU ---");
                    System.out.print("Masukkan Judul: ");
                    String title = scanner.nextLine();
                    System.out.print("Masukkan Isi Catatan: ");
                    String content = scanner.nextLine();

                    Note newNote = new Note(title, content);
                    noteDAO.addNote(newNote);
                    System.out.println("[SUKSES] Catatan berhasil disimpan ke database!");
                    break;

                    case "2":
                    System.out.println("--- DAFTAR CATATAN KAMU ---");
                    List<Note> notes = noteDAO.getAllNotes();

                    if (notes.isEmpty()) {
                        System.out.println("(Belum ada catatan yang tersimpan)");
                        } else {
                        for (Note note : notes) {
                            System.out.println("[ID: " + note.getId() + "] " + note.getTitle());
                            System.out.println("Isi: " + note.getContent());
                            System.out.println("---------------------------------");
                        }
                    }
                    break;
                    case "3":
                    System.out.println("Keluar dari aplikasi");
                    running = false;
                    break;

                    default:
                    System.out.println("[ERROR] Pilihan tidak valid! Masukkan angka 1, 2, atau 3.");
            }
        }
            scanner.close();
    }
}