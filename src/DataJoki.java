public class DataJoki {
    private String username, password, nomorHp;
    private int status;
    private Layanan infoJoki;

    public DataJoki(String user, String pass, String hp, Layanan l) {
        this.username = user;
        this.password = pass;
        this.nomorHp = hp;
        this.infoJoki = l;
        this.status = 1;
    }

    // Getter dan Setter
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getNomorHp() { return nomorHp; }
    public Layanan getInfoJoki() { return infoJoki; }

    public int getStatus() { return status; }
    public void setStatus(int status) {
        // Validasi: Status hanya boleh 1 (proses) atau 2 (selesai)
        if (status == 1 || status == 2) {
            this.status = status;
        }
    }
}