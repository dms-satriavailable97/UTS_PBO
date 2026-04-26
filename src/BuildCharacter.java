public class BuildCharacter extends Layanan {
    // Constructor Standar (Sudah ada)
    public BuildCharacter(String nama, int tingkat) {
        this.namaGrup = "Build Char";
        this.dataHarga = new Harga(tingkat, 1); // Memanggil Overload Harga 1
        this.namaPesanan = nama;
    }

    // Constructor Overloading
    public BuildCharacter(String nama, int tingkat, String namaPromo) {
        this.namaGrup = "Build Char";
        this.dataHarga = new Harga(tingkat, 1);

        int hargaAsli = dataHarga.getNilai();
        int hargaDiskon = hargaAsli - 10000;

        this.dataHarga = new Harga(hargaDiskon, namaPromo);
        this.namaPesanan = nama;
    }

    @Override
    public void tampilDetail() {
        System.out.println("[FOCUS BUILD: " + namaPesanan.toUpperCase() + "]");
        System.out.println("> Kategori/Promo: " + dataHarga.getKategori());
        System.out.println("> Harga: Rp" + dataHarga.getNilai());
    }
}