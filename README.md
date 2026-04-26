# 🎮 System Management Joki WUWA
### UTS Pemrograman Berorientasi Objek (PBO)

| Keterangan | Detail |
|---|---|
| **Nama** | Dimas Elang Satria |
| **Kelas** | Informatika A 2024 |
| **Mata Kuliah** | Pemrograman Berorientasi Objek (PBO) |
| **Tugas** | Ujian Tengah Semester (UTS) |

---

## 📋 Deskripsi Program

**System Management Joki WUWA** adalah aplikasi berbasis terminal untuk mengelola pesanan jasa joki game *Wuthering Waves (WUWA)*. Program ini memungkinkan pengguna untuk menambah, melihat, memperbarui status, dan menghapus data pesanan joki secara terstruktur.

Terdapat 3 jenis layanan joki yang tersedia:
- 🧱 **Build Character** — Leveling, build echo/artefak, hingga full build siap pakai
- ⚔️ **Joki Event** — Mengerjakan event dengan tingkat kesulitan mudah, menengah, atau sulit
- 🗺️ **Eksplor Map** — Eksplorasi area kecil, sedang, atau full map

---

## 🗂️ Struktur Class

```
UTS_PBO/
└── src/
    ├── Main.java             # Entry point, menu utama, logika CRUD
    ├── Layanan.java          # Parent class (superclass) semua layanan
    ├── BuildCharacter.java   # Child class: layanan build karakter
    ├── JokiEvent.java        # Child class: layanan joki event
    ├── EksplorMap.java       # Child class: layanan eksplorasi map
    ├── Harga.java            # Class harga dengan constructor overloading
    └── DataJoki.java         # Class penyimpan data akun & pesanan
```

---

## 💡 Konsep OOP yang Diterapkan

### 1. 🔁 Perulangan — Dua Metode

**a. `do-while`** — Digunakan untuk menu utama yang terus berjalan sampai user memilih keluar:
```java
do {
    System.out.println("1. Tambah Pesanan Baru");
    // ...
    menuUtama = inputKeyboard.nextInt();
} while (menuUtama != 5);
```

**b. `for` (enhanced & indexed)** — Digunakan untuk menampilkan daftar pesanan:
```java
// Enhanced for - tampil daftar pesanan
for (DataJoki d : daftarPesanan) {
    if (d.getStatus() == 1) {
        d.getInfoJoki().tampilDetail();
    }
}

// Indexed for - tampil dengan nomor urut
for (int i = 0; i < daftarPesanan.size(); i++) {
    System.out.println((i+1) + ". " + daftarPesanan.get(i).getUsername());
}
```

---

### 2. 🔀 Kondisi & Percabangan

**a. `if-else`** — Di class `Harga`, menentukan harga & kategori berdasarkan tipe layanan dan tingkat:
```java
if (tipeLayanan == 1) {
    if (pilihan == 1) { this.nilai = 20000; this.kategori = "Leveling Saja"; }
    else if (pilihan == 2) { this.nilai = 45000; this.kategori = "Build Echo/Artefak"; }
    else { this.nilai = 80000; this.kategori = "Full Build (Siap Pakai)"; }
}
```

**b. `switch-case`** — Di `Main.java` untuk menangani pilihan menu utama:
```java
switch (menuUtama) {
    case 1: // Tambah Pesanan
    case 2: // Lihat Daftar
    case 3: // Tandai Selesai
    case 4: // Hapus Data
    case 5: // Keluar
    default: System.out.println("Menu tidak tersedia!");
}
```

---

### 3. 🔒 Enkapsulasi

Di class `DataJoki` dan `Harga`, semua atribut `private` dan diakses via getter/setter. Setter `setStatus()` dilengkapi validasi:
```java
public void setStatus(int status) {
    // Validasi: hanya boleh 1 (proses) atau 2 (selesai)
    if (status == 1 || status == 2) {
        this.status = status;
    }
}
```

---

### 4. 🧬 Inheritance (Pewarisan)

`BuildCharacter`, `JokiEvent`, dan `EksplorMap` mewarisi class induk `Layanan`:
```java
public class BuildCharacter extends Layanan { ... }
public class JokiEvent extends Layanan { ... }
public class EksplorMap extends Layanan { ... }
```

---

### 5. 🎭 Polimorfisme

**Method Overriding** — Setiap class turunan mengoverride `tampilDetail()` dengan output berbeda.

**Dynamic Polymorphism** — Variabel bertipe `Layanan` menampung berbagai objek turunan, method dipanggil secara dinamis saat runtime:
```java
Layanan layananBaru;
if (tipe == 1) layananBaru = new BuildCharacter(namaInput, tingkat);
else if (tipe == 2) layananBaru = new JokiEvent(namaInput, tingkat);
else layananBaru = new EksplorMap(namaInput, tingkat);

// Polymorphism: tampilDetail() menyesuaikan tipe objek aslinya
d.getInfoJoki().tampilDetail();
```

**Constructor Overloading** — `BuildCharacter` & `Harga` punya lebih dari satu constructor:
```java
public BuildCharacter(String nama, int tingkat) { ... }          // biasa
public BuildCharacter(String nama, int tingkat, String namaPromo) { ... } // dengan promo
```

---

## ▶️ Cara Menjalankan

**Persyaratan:** Java JDK 8+, IntelliJ IDEA (rekomendasi)

```bash
git clone https://github.com/dms-satriavailable97/UTS_PBO.git
cd UTS_PBO/src
javac *.java
java Main
```

---

## 🎮 Fitur Program

| Menu | Fungsi |
|---|---|
| 1. Tambah Pesanan | Input data akun + pilih layanan + kode promo |
| 2. Lihat Semua Daftar | Tampil antrian aktif dan riwayat selesai |
| 3. Tandai Selesai | Update status pesanan → selesai |
| 4. Hapus Data | Hapus data pesanan dari sistem |
| 5. Keluar | Keluar dari program |

> 💡 **Kode Promo:** Masukkan `DISKONSAHUR` saat pesan Build Character untuk diskon Rp10.000!

---

## 📤 Submission

🔗 [https://forms.gle/teS6szNtYreWAzth6](https://forms.gle/teS6szNtYreWAzth6)

---

**Dimas Elang Satria** — Informatika A 2024 | [@dms-satriavailable97](https://github.com/dms-satriavailable97)