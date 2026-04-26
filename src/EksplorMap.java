public class EksplorMap extends Layanan {
    public EksplorMap(String nama, int tingkat) {
        this.namaGrup = "Eksplor Map";
        this.dataHarga = new Harga(tingkat, 3);
        this.namaPesanan = nama;
    }

    @Override
    public void tampilDetail() {
        System.out.println("[EKSPLOR MAP: " + namaPesanan + "]");
        System.out.println("> Cakupan Area: " + dataHarga.getKategori());
        System.out.println("> Catatan  : " + catatanTambahan);
    }
}