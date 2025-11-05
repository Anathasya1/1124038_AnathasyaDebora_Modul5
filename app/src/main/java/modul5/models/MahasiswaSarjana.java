package modul5.models;
import java.util.ArrayList;

public class MahasiswaSarjana extends Mahasiswa{
    private ArrayList<MatkulAmbil> matkul = new ArrayList<>();

    public MahasiswaSarjana(ArrayList<MatkulAmbil> matkul, String nim, String kodeJurusan, String nama, String tempatLahir, String tanggalLahir,
            String alamat, String telepon) {
        super(nim, kodeJurusan, nama, tempatLahir, tanggalLahir, alamat, telepon);
        this.matkul = matkul;
    }

    public ArrayList<MatkulAmbil> getMatkul(){
        return matkul;
    }
    public void setMatkul(ArrayList<MatkulAmbil> matkul){
        this.matkul = matkul;
    }

    @Override
    public String toString() {
        return super.toString() + "\nmatkul: " + matkul ;
    }
    
    
}
