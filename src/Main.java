import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main() {
        // List untuk menampung semua data joki yang masuk
        ArrayList<DataJoki> daftarPesanan = new ArrayList<>();
        Scanner inputKeyboard = new Scanner(System.in);
        int menuUtama;

        do {
            System.out.println("\n========================================");
            System.out.println("     SYSTEM MANAGEMENT JOKI WUWA");
            System.out.println("========================================");
            System.out.println("1. Tambah Pesanan Baru");
            System.out.println("2. Lihat Semua Daftar");
            System.out.println("3. Tandai Selesai (Update)");
            System.out.println("4. Hapus Data (Delete)");
            System.out.println("5. Keluar");

            while (true) {
                try {
                    System.out.print("Pilih Menu: ");
                    menuUtama = inputKeyboard.nextInt();
                    inputKeyboard.nextLine();
                    break;
                } catch (Exception e) {
                    System.out.println("Input harus angka! Balik ulang pilih menu ya...");
                    inputKeyboard.nextLine(); // buang input error
                }
            }

            if (menuUtama == 1) {
                try {
                    System.out.println("\n--- INPUT DATA AKUN ---");
                    System.out.print("Username Akun: ");
                    String user = inputKeyboard.nextLine();
                    if (user.equals("0")) continue;

                    System.out.print("Password Akun: ");
                    String pass = inputKeyboard.nextLine();
                    System.out.print("Nomor HP/WA  : ");
                    String hp = inputKeyboard.nextLine();

                    System.out.println("\n--- PILIH TIPE JOKI ---");
                    System.out.println("1. Build Character");
                    System.out.println("2. Joki Event");
                    System.out.println("3. Eksplor Map");
                    System.out.println("0. Kembali");
                    System.out.print("Pilih: ");
                    int tipe = inputKeyboard.nextInt();
                    inputKeyboard.nextLine();
                    if (tipe == 0) continue;

                    System.out.print("Nama (Karakter/Event/Map): ");
                    String namaInput = inputKeyboard.nextLine();

                    Layanan layananBaru;
                    boolean pakaiDiskon = false;
                    String namaPromo = "";

                    if (tipe == 1) {
                        System.out.print("Masukkan Kode Promo (Tekan Enter jika tidak ada): ");
                        String kode = inputKeyboard.nextLine();

                        if (kode.equals("DISKONSAHUR")) {
                            pakaiDiskon = true;
                            namaPromo = "Diskon Sahur";
                        }

                        System.out.println("\n--- PILIH TINGKAT LAYANAN ---");
                        System.out.println("1. Leveling Saja (20rb)");
                        System.out.println("2. Build Echo/Artefak (45rb)");
                        System.out.println("3. Full Build (80rb)");

                    } else if (tipe == 2) {
                        System.out.println("\n--- PILIH TINGKAT LAYANAN ---");
                        System.out.println("1. Mudah (15rb)");
                        System.out.println("2. Menengah (30rb)");
                        System.out.println("3. Sulit (50rb)");
                    } else {
                        System.out.println("\n--- PILIH TINGKAT LAYANAN ---");
                        System.out.println("1. Area Kecil (25rb)");
                        System.out.println("2. Area Sedang (50rb)");
                        System.out.println("3. Full Map (100rb)");
                    }
                    System.out.println("0. Kembali");
                    System.out.print("Pilih: ");
                    int tingkat = inputKeyboard.nextInt();
                    inputKeyboard.nextLine();
                    if (tingkat == 0) continue;

                    if (tipe == 1) {
                        if (pakaiDiskon) {
                            layananBaru = new BuildCharacter(namaInput, tingkat, namaPromo);
                        } else {
                            layananBaru = new BuildCharacter(namaInput, tingkat);
                        }
                    } else if (tipe == 2) {
                        layananBaru = new JokiEvent(namaInput, tingkat);
                    } else {
                        layananBaru = new EksplorMap(namaInput, tingkat);
                    }


                    System.out.print("Masukkan Catatan Tambahan : ");
                    String catatanUser = inputKeyboard.nextLine();
                    layananBaru.setCatatan(catatanUser);

                    DataJoki dataBaru = new DataJoki(user, pass, hp, layananBaru);
                    daftarPesanan.add(dataBaru);
                    System.out.println(">> Berhasil Menambahkan Pesanan!");
                } catch (Exception e) {
                    System.out.println("Input salah! Balik ke menu utama...");
                    inputKeyboard.nextLine();
                }


            } else if (menuUtama == 2) {
                try {
                    System.out.println("\n--- [ DAFTAR BELUM SELESAI ] ---");
                    int nomorAntrian = 1;
                    for (DataJoki d : daftarPesanan) {
                        //GETTER
                        if (d.getStatus() == 1) {
                            System.out.print(nomorAntrian + ". ");

                            // Memanggil Dynamic Polymorphism
                            d.getInfoJoki().tampilDetail();

                            System.out.println("   [Akun: " + d.getUsername() + "| Pass : " + d.getPassword() + " | WA: " + d.getNomorHp() + "]");
                            nomorAntrian++;
                        }
                    }
                    if (nomorAntrian == 1) System.out.println("(Antrian Kosong)");

                    System.out.println("\n--- [ RIWAYAT SUDAH SELESAI ] ---");
                    int nomorRiwayat = 1;
                    for (DataJoki d : daftarPesanan) {
                        //GETTER
                        if (d.getStatus() == 2) {
                            System.out.print(nomorRiwayat + ". ");

                            // Memanggil Dynamic Polymorphism
                            d.getInfoJoki().tampilDetail();

                            System.out.println("   [Akun: " + d.getUsername() + "| Pass : " + d.getPassword() + " | WA: " + d.getNomorHp() + "]");
                            nomorRiwayat++;
                        }
                    }
                    if (nomorRiwayat == 1) System.out.println("(Belum ada riwayat)");

                } catch (Exception e) {
                    System.out.println("Input salah! Balik ke menu utama...");
                    inputKeyboard.nextLine();
                }

            } else if (menuUtama == 3) {
                try {
                    System.out.println("\n--- PILIH NOMOR YANG SUDAH SELESAI ---");
                    boolean adaBelumSelesai = false;
                    for (int i = 0; i < daftarPesanan.size(); i++) {
                        //GETTER
                        if (daftarPesanan.get(i).getStatus() == 1) {
                            System.out.println((i + 1) + ". " + daftarPesanan.get(i).getUsername() + " (" + daftarPesanan.get(i).getInfoJoki().getNamaGrup() + ")");
                            adaBelumSelesai = true;
                        }
                    }

                    if (adaBelumSelesai) {
                        System.out.print("Pilih Nomor Pesanan (0 Kembali): ");
                        int pilihUpdate = inputKeyboard.nextInt();
                        if (pilihUpdate > 0 && pilihUpdate <= daftarPesanan.size()) {
                            //SETTER
                            daftarPesanan.get(pilihUpdate - 1).setStatus(2);
                            System.out.println(">> Status berhasil diperbarui ke SELESAI!");
                        }
                    } else {
                        System.out.println("Semua pesanan sudah selesai atau tidak ada data.");
                    }
                } catch (Exception e) {
                    System.out.println("Input salah! Balik ke menu utama...");
                    inputKeyboard.nextLine();
                }


            } else if (menuUtama == 4) {
                try {
                    System.out.println("\n--- PILIH NOMOR UNTUK DIHAPUS ---");
                    if (daftarPesanan.isEmpty()) {
                        System.out.println("Data kosong.");
                    } else {
                        for (int i = 0; i < daftarPesanan.size(); i++) {
                            // GETTER
                            System.out.println((i + 1) + ". " + daftarPesanan.get(i).getUsername() + " [" + daftarPesanan.get(i).getInfoJoki().getNamaGrup() + "]");
                        }
                        System.out.print("Masukkan Nomor (0 Kembali): ");
                        int pilihHapus = inputKeyboard.nextInt();
                        if (pilihHapus > 0 && pilihHapus <= daftarPesanan.size()) {
                            daftarPesanan.remove(pilihHapus - 1);
                            System.out.println(">> Data berhasil dihapus dari sistem!");
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Input salah! Balik ke menu utama...");
                    inputKeyboard.nextLine();
                }

            }

        } while (menuUtama != 5);

        System.out.println("Terima kasih! ");
    }
}