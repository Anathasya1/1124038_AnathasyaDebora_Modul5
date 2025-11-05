package modul5.models;

public class Mahasiswa extends User {
    private String nim;
    private String kodeJurusan;

    public Mahasiswa(String nim, String kodeJurusan, String nama, String tempatLahir, String tanggalLahir, String alamat, String telepon){
        super(UserType.MAHASISWA, nama, tempatLahir, tanggalLahir, alamat, telepon);
        this.nim = nim;
        this.kodeJurusan = kodeJurusan;
    }

    public String getNim(){
        return nim;
    }
    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setKodeJurusan(String kodeJurusan) {
        this.kodeJurusan = kodeJurusan;
    }

    public String getKodeJurusan(){
        return kodeJurusan;
    }

    @Override
    public String toString(){
        return "Nim: " + getNim() + "\nNama: " + getNama() + "\nKode Jurusan: " + getKodeJurusan() + "\nTempat Tanggal Lahir: "
        + getTempatLahir() + ", " + getTanggalLahir() + "\nAlamat: " + getAlamat() + "\nTelepon: " + getTelepon() + "\nStatus: " + getStatus();
    }
}
