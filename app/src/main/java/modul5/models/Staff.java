package modul5.models;
public class Staff extends User{
    String nik;
     public Staff(UserType type, String nik, String nama, String tempatLahir, String tanggalLahir, String alamat, String telepon){
        super(type, nama, tempatLahir, tanggalLahir, alamat, telepon);
        this.nik = nik;
    }
    public String getNik(){
        return nik;
    }

    @Override
    public String toString(){
       return "Nik: " + getNik() + "\nNama: " + getNama()  + "\nTempat Tanggal Lahir: "
        + getTempatLahir() + ", " + getTanggalLahir() + "\nAlamat: " + getAlamat() + "\nTelepon: " + getTelepon() + "\nStatus: " + getStatus();
    }
}
