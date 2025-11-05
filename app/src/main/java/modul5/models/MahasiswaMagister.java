package modul5.models;
import java.util.ArrayList;

public class MahasiswaMagister extends Mahasiswa{
    private String judulTesis;
    private ArrayList<MatkulAmbil> matkul = new ArrayList<>();

    public MahasiswaMagister(String judulTesis, ArrayList<MatkulAmbil> matkul, String nim, String kodeJurusan, String nama, String tempatLahir, String tanggalLahir,
            String alamat, String telepon) {
        super(nim, kodeJurusan, nama, tempatLahir, tanggalLahir, alamat, telepon);
        this.judulTesis = judulTesis;
        this.matkul = matkul;
    }

    public String getJudulTesis() {
        return judulTesis;
    }
    public void setJudulTesis(String judulTesis) {
        this.judulTesis = judulTesis;
    }

    public ArrayList<MatkulAmbil> getMatkul() {
        return matkul;
    }
    public void setMatkul(ArrayList<MatkulAmbil> matkul) {
        this.matkul = matkul;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nJudul Tesis: " + getJudulTesis() + "\nmatkul: " + matkul;
    }
}
