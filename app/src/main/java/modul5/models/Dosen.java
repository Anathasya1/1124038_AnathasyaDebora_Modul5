package modul5.models;
import java.util.ArrayList;

public class Dosen extends Staff{
    private ArrayList<MatkulAjar> matkul = new ArrayList<>();
    private String departemen;
    public Dosen(UserType type, String nik, String nama, String tempatLahir, String tanggalLahir, String alamat, String telepon,
             String departemen) {
        super(type, nik, nama, tempatLahir, tanggalLahir, alamat, telepon);
        this.departemen = departemen;
    }

    public ArrayList<MatkulAjar> getMatkul(){
        return matkul;
    }

    public void setMatkul(ArrayList<MatkulAjar> matkul) {
        this.matkul = matkul;
    }

    public void setDepartemen(String departemen) {
        this.departemen = departemen;
    }

    public String getDepartemen(){
        return departemen;
    }

    public String toString(){
        return super.toString() + "\nDepartement: " + getDepartemen();
        // return "Nim: " + getNik() + "\nNama: " + getNama() + "\nDepartement: " + getDepartemen() + "\nTempat Tanggal Lahir: "
        // + getTempatLahir() + ", " + getTanggalLahir() + "\nAlamat: " + getAlamat() + "\nTelepon: " + getTelepon() + "\nStatus: " + getStatus();
    }
}
