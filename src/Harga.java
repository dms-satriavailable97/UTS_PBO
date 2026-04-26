public class Harga {
    private int nilai;
    private String kategori;

    public Harga(int pilihan, int tipeLayanan) {
        if (tipeLayanan == 1) {
            if (pilihan == 1) { this.nilai = 20000; this.kategori = "Leveling Saja"; }
            else if (pilihan == 2) { this.nilai = 45000; this.kategori = "Build Echo/Artefak"; }
            else { this.nilai = 80000; this.kategori = "Full Build (Siap Pakai)"; }
        } else if (tipeLayanan == 2) {
            if (pilihan == 1) { this.nilai = 15000; this.kategori = "Mudah"; }
            else if (pilihan == 2) { this.nilai = 30000; this.kategori = "Menengah"; }
            else { this.nilai = 50000; this.kategori = "Sulit"; }
        } else {
            if (pilihan == 1) { this.nilai = 25000; this.kategori = "Area Kecil"; }
            else if (pilihan == 2) { this.nilai = 50000; this.kategori = "Area Sedang"; }
            else { this.nilai = 100000; this.kategori = "Full Map"; }
        }
    }

    // OVERLOADING
    public Harga(int hargaKustom, String namaPromo) {
        this.nilai = hargaKustom;
        this.kategori = "PROMO: " + namaPromo;
    }

    public int getNilai() { return nilai; }
    public String getKategori() { return kategori; }
}