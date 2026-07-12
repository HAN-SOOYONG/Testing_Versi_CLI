dokumentasi project

1.deskripsi
ini adalah clone googlekeep yang menggunakan sqlite sebagai database, junit 5 sebagai unit test, mockito untuk mocking dan sdknya jdk 21

2.struktur folder
- src/main/java/com/keep/ : kode utama aplikasi
  - App.java : kelas utama aplikasi
  - Note.java : model data note
  - NoteDAO.java: kelas akses data untuk operasi note
  - DatabaseHelper.java : helper untuk koneksi database
  - src/test/java/com/keep/ : file unit test
  - AppTest.java : test sederhana untuk aplikasi
  - NoteTest.java : test untuk model Note dan mocking DAO
  - pom.xml : konfigurasi Maven dan dependensi

3. Kelas Utama
#Note
Kelas Note merepresentasikan entitas catatan dengan atribut seperti:
- id
- title
- content
- label
- reminder
- status hapus (isDeleted)
- status checkbox
- mode tema gelap/terang
- daftar checklist

Fungsi yang tersedia meliputi:
- membuat note baru
- mengkloning note
- menambahkan item checklist
- menandai semua checklist selesai
- menghapus note
- mengedit data note
- mengubah format export ke Google Docs

 NoteDAO
Kelas NoteDAO berfungsi sebagai layer akses data yang menangani operasi simpan dan ambil data note.

DatabaseHelper
Kelas DatabaseHelper digunakan untuk membantu koneksi ke database, terutama saat aplikasi berinteraksi dengan data persistence.

4.Test yang Ada
Project ini menggunakan JUnit 5 dan Mockito untuk unit testing.

Beberapa test yang tersedia antara lain:
- membuat note dengan judul dan konten saja
- membuat note dengan data lengkap
- menguji fungsi clone note
- menguji manajemen checklist
- menguji fungsi delete
- menguji tema gelap/terang
- menguji export ke Google Docs
- menguji mock DAO untuk mengambil data
- menguji mock DAO untuk menyimpan data
- menguji method edit note

5.Cara Menjalankan Test
Masuk ke folder project lalu jalankan perintah berikut:

```bash
mvn test
```

Jika semua test berhasil, Maven akan menampilkan "BUILD SUCCESS".

6.Dependensi yang Digunakan
Project ini menggunakan:
- JUnit 5 untuk unit test
- Mockito untuk mocking object pada test
- SQLite JDBC untuk koneksi database
- Maven sebagai build tool

7.Hasil Testing
-------------------------------------------------------------------------------
Test set: com.keep.NoteTest
-------------------------------------------------------------------------------
Tests run: 11, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 7.809 s - in com.keep.NoteTest

