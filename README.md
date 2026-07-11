nama : brian bactiar sitompul
kelas : mi A
mapel: pengujian dan implementasi sistem

dokumentasi fitur awal manual:
TC1 : tambah catatan hasil ; add judul add isi
tc2 : isi note   hasil ; show note
tc3 : keluar apk hasil 3 ; pesan keluar

otomatis:
Tc1 note hanya judul dan konten
tc2 note dengan semua data
-------------------------------------------------------------------------------
Test set: com.keep.NoteTest
-------------------------------------------------------------------------------
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.001 s - in com.keep.NoteTest

add fitur:
tc3 : klon atau duplikat catatan
tc4 : manajemen kotak centang (tambah & centang semua)
tc5 : hapus catatan (ubah status isDeleted)
tc6 : aktifkan tema gelap
tc7 : aktifkan tema terang
tc8 : salin catatan ke format google dokumen
-------------------------------------------------------------------------------
Test set: com.keep.NoteTest
-------------------------------------------------------------------------------
Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.007 s - in com.keep.NoteTest

mocking:
tes awal (mocking):
tc9 : ambil catatan lewat mock dao hasil ; data tiruan sukses keluar tanpa koneksi database asli
-------------------------------------------------------------------------------
Test set: com.keep.NoteTest
-------------------------------------------------------------------------------
Tests run: 9, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 3.903 s - in com.keep.NoteTest
