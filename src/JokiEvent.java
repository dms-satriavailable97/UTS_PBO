public class JokiEvent extends Layanan {
    public JokiEvent(String nama, int tingkat) {
        this.namaGrup = "Joki Event";
        this.dataHarga = new Harga(tingkat, 2);
        this.namaPesanan = nama;
    }

    @Override
    public void tampilDetail() {
        System.out.println("[EVENT : " + namaPesanan + "]");
        System.out.println("> Tingkat Kesulitan: " + dataHarga.getKategori());
        System.out.println("> Deadline/Catatan : " + catatanTambahan);
    }
}