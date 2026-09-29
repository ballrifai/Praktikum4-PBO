# Tugas Praktikum 4 - Pemrograman Berorientasi Objek

## Array, List, Iterator

<p align="center">
  <b>Nama: Iqbal Rifa'i<br>
  NIM: L0325004</b>
</p>

## Penjelasan Kode

### AsetIT.java

```java
package tugasprak4;

public class AsetIT {

    String idAset;
    String namaPerangkat;
    String lokasi;
    String statusKondisi;

    public AsetIT(String idAset, String namaPerangkat, String lokasi, String statusKondisi) {
        this.idAset = idAset;
        this.namaPerangkat = namaPerangkat;
        this.lokasi = lokasi;
        this.statusKondisi = statusKondisi;
    }

    public String getIdAset() {
        return idAset;
    }

    public String getNamaPerangkat() {
        return namaPerangkat;
    }

    public String getLokasi() {
        return lokasi;
    }

    public String getStatusKondisi() {
        return statusKondisi;
    }

    public void tampilkanInfoAset() {
        System.out.println("ID Aset        : " + idAset);
        System.out.println("Nama Perangkat : " + namaPerangkat);
        System.out.println("Lokasi         : " + lokasi);
        System.out.println("Status Kondisi : " + statusKondisi);
        System.out.println("-----------------------------------");
    }
}
```

Class `AsetIT` digunakan sebagai model untuk menyimpan data setiap aset IT. Class ini memiliki empat atribut, yaitu `idAset`, `namaPerangkat`, `lokasi`, dan `statusKondisi`. Karena atribut tersebut tidak menggunakan kata kunci `private`, class lain yang masih berada dalam `package` yang sama dapat mengaksesnya secara langsung.

Constructor pada class ini memiliki empat parameter yang digunakan untuk memberikan nilai awal pada setiap atribut saat objek `AsetIT` dibuat. Kata kunci `this` digunakan untuk membedakan atribut milik objek dengan parameter constructor yang memiliki nama sama.

Class ini memiliki empat method getter, yaitu `getIdAset`, `getNamaPerangkat`, `getLokasi`, dan `getStatusKondisi`. Keempat method tersebut digunakan untuk mengambil nilai dari masing-masing atribut. Pada class `ManajemenAset`, method `getIdAset` digunakan untuk mendapatkan ID aset yang akan diperiksa saat proses penghapusan.

Method `tampilkanInfoAset` digunakan untuk menampilkan seluruh informasi aset. Setiap atribut ditampilkan pada baris yang berbeda dengan label masing-masing, kemudian diakhiri dengan garis pemisah.

### ManajemenAset.java

```java
package tugasprak4;

import java.util.LinkedList;
import java.util.Iterator;

public class ManajemenAset {

    LinkedList<AsetIT> daftarAset;

    public ManajemenAset() {
        daftarAset = new LinkedList<>();
    }

    public void tambahAset(AsetIT asetBaru) {
        daftarAset.add(asetBaru);
        System.out.println("[INFO] Aset dengan ID " + asetBaru.getIdAset() + " berhasil ditambahkan.");
    }

    public void tampilkanSemuaAset() {
        System.out.println("\n===== DAFTAR SEMUA ASET IT =====");
        if (daftarAset.isEmpty()) {
            System.out.println("Belum ada data aset.");
            return;
        }

        for (AsetIT aset : daftarAset) {
            aset.tampilkanInfoAset();
        }
    }

    public void hapusAset(String idAset) {
        Iterator<AsetIT> iterator = daftarAset.iterator();
        boolean ditemukan = false;

        while (iterator.hasNext()) {
            AsetIT aset = iterator.next();
            if (aset.getIdAset().equalsIgnoreCase(idAset)) {
                iterator.remove();
                ditemukan = true;
                System.out.println("[INFO] Aset dengan ID " + idAset + " berhasil dihapus.");
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("[PERINGATAN] Aset dengan ID " + idAset + " tidak ditemukan!");
        }
    }
}
```

Class `ManajemenAset` berfungsi untuk mengelola kumpulan objek `AsetIT`. Data disimpan dalam atribut `daftarAset` bertipe `LinkedList<AsetIT>` yang dibuat melalui constructor. `LinkedList` digunakan untuk menyimpan data aset sehingga proses penambahan dan penghapusan dapat dilakukan dengan lebih mudah, terutama saat menggunakan `Iterator`.

Method `tambahAset` digunakan untuk memasukkan objek aset baru ke dalam list menggunakan method `add`. Setelah aset berhasil ditambahkan, program menampilkan pesan `[INFO]`. Method ini termasuk dalam operasi Create.

Method `tampilkanSemuaAset` digunakan untuk menampilkan seluruh aset yang tersimpan dalam list. Program terlebih dahulu memeriksa kondisi list menggunakan `isEmpty`. Jika list kosong, program menampilkan pesan bahwa belum ada data aset, kemudian method dihentikan menggunakan `return`. Jika terdapat data, setiap aset ditampilkan menggunakan perulangan `for each` dan method `tampilkanInfoAset`. Method ini termasuk dalam operasi Read.

Method `hapusAset` digunakan untuk mencari sekaligus menghapus aset berdasarkan `idAset` dengan bantuan `Iterator`. Penggunaan `iterator.remove()` memungkinkan elemen dihapus dengan aman saat list sedang ditelusuri dan menghindari terjadinya `ConcurrentModificationException`. Method ini termasuk dalam operasi Delete.

Proses `hapusAset` dilakukan melalui beberapa tahap:

1. Membuat `Iterator` dari `daftarAset` dan mengatur nilai awal `ditemukan` menjadi `false`.
2. Perulangan `while` memeriksa apakah masih terdapat elemen menggunakan `hasNext`, kemudian mengambil elemen tersebut dengan `next`.
3. ID aset dibandingkan menggunakan `equalsIgnoreCase`, sehingga perbedaan huruf besar dan kecil tidak menjadi masalah. Contohnya, `ast003` tetap dapat menemukan `AST003`.
4. Jika ID ditemukan, `iterator.remove()` digunakan untuk menghapus aset, kemudian `ditemukan` diubah menjadi `true`. Program menampilkan pesan keberhasilan dan menghentikan perulangan menggunakan `break`. Jika tidak ditemukan sampai akhir proses, program menampilkan pesan `[PERINGATAN]`.

### MainAset.java

```java
package tugasprak4;

public class MainAset {

    public static void main(String[] args) {

        ManajemenAset manajemen = new ManajemenAset();

        manajemen.tambahAset(new AsetIT("AST001", "Server Dell R740", "Ruang Server", "Baik"));
        manajemen.tambahAset(new AsetIT("AST002", "Router Cisco 2900", "Ruang Jaringan", "Baik"));
        manajemen.tambahAset(new AsetIT("AST003", "Switch TP-Link 24 Port", "Ruang Jaringan", "Rusak"));
        manajemen.tambahAset(new AsetIT("AST004", "PC Dell OptiPlex 3090", "Ruang Admin", "Baik"));

        manajemen.tampilkanSemuaAset();

        System.out.println("\n>>> Menghapus aset dengan ID AST003 (Switch) <<<");
        manajemen.hapusAset("AST003");

        System.out.println("\n>>> Mencoba menghapus aset dengan ID yang tidak ada (AST999) <<<");
        manajemen.hapusAset("AST999");

        manajemen.tampilkanSemuaAset();
    }
}
```

Class `MainAset` merupakan class utama yang digunakan untuk menjalankan program. Pada awal program dibuat objek `ManajemenAset`, kemudian empat data aset, yaitu Server, Router, Switch, dan PC, dimasukkan menggunakan method `tambahAset`.

Setelah semua data dimasukkan, program memanggil `tampilkanSemuaAset` untuk melihat kondisi awal daftar aset. Selanjutnya dilakukan percobaan pertama dengan menghapus aset ber-ID `AST003` yang tersedia dalam list. Percobaan kedua menggunakan ID `AST999` yang tidak terdapat dalam data untuk menguji pesan peringatan pada method `hapusAset`. Terakhir, seluruh data ditampilkan kembali untuk melihat hasil setelah proses penghapusan.

## Output Program

```text
[INFO] Aset dengan ID AST001 berhasil ditambahkan.
[INFO] Aset dengan ID AST002 berhasil ditambahkan.
[INFO] Aset dengan ID AST003 berhasil ditambahkan.
[INFO] Aset dengan ID AST004 berhasil ditambahkan.

===== DAFTAR SEMUA ASET IT =====
ID Aset        : AST001
Nama Perangkat : Server Dell R740
Lokasi         : Ruang Server
Status Kondisi : Baik
-----------------------------------
ID Aset        : AST002
Nama Perangkat : Router Cisco 2900
Lokasi         : Ruang Jaringan
Status Kondisi : Baik
-----------------------------------
ID Aset        : AST003
Nama Perangkat : Switch TP-Link 24 Port
Lokasi         : Ruang Jaringan
Status Kondisi : Rusak
-----------------------------------
ID Aset        : AST004
Nama Perangkat : PC Dell OptiPlex 3090
Lokasi         : Ruang Admin
Status Kondisi : Baik
-----------------------------------

>>> Menghapus aset dengan ID AST003 (Switch) <<<
[INFO] Aset dengan ID AST003 berhasil dihapus.

>>> Mencoba menghapus aset dengan ID yang tidak ada (AST999) <<<
[PERINGATAN] Aset dengan ID AST999 tidak ditemukan!

===== DAFTAR SEMUA ASET IT =====
ID Aset        : AST001
Nama Perangkat : Server Dell R740
Lokasi         : Ruang Server
Status Kondisi : Baik
-----------------------------------
ID Aset        : AST002
Nama Perangkat : Router Cisco 2900
Lokasi         : Ruang Jaringan
Status Kondisi : Baik
-----------------------------------
ID Aset        : AST004
Nama Perangkat : PC Dell OptiPlex 3090
Lokasi         : Ruang Admin
Status Kondisi : Baik
-----------------------------------
```

## Penjelasan Output

Empat pesan `[INFO]` yang muncul di awal merupakan hasil dari setiap pemanggilan method `tambahAset`. Setiap aset yang berhasil ditambahkan ke dalam list akan menghasilkan satu pesan informasi.

Pada tampilan pertama, terdapat empat aset sesuai dengan urutan saat data dimasukkan. `LinkedList` mempertahankan urutan elemen yang ditambahkan, sedangkan perulangan `for each` pada `tampilkanSemuaAset` digunakan untuk membaca dan menampilkan setiap data secara berurutan.

Baris `>>> Menghapus aset dengan ID AST003 (Switch) <<<` berasal dari `main` sebelum method `hapusAset` dijalankan. Karena `AST003` terdapat dalam list, aset tersebut berhasil dihapus dan program menampilkan pesan `[INFO]` tanpa memberikan peringatan.

Selanjutnya, program menampilkan pesan `>>> Mencoba menghapus aset dengan ID yang tidak ada (AST999) <<<` sebelum mencari ID `AST999`. Iterator memeriksa data yang masih tersimpan, yaitu `AST001`, `AST002`, dan `AST004`, tetapi tidak menemukan ID tersebut. Karena nilai `ditemukan` tetap `false`, program kemudian menampilkan pesan `[PERINGATAN]`.

Pada tampilan terakhir, hanya terdapat tiga aset, yaitu `AST001`, `AST002`, dan `AST004`. Aset `AST003` sudah tidak muncul karena berhasil dihapus, sedangkan data lainnya tetap sama dan berada dalam urutan semula. Hasil ini menunjukkan bahwa proses penghapusan menggunakan `Iterator` telah berjalan sesuai yang diharapkan.
