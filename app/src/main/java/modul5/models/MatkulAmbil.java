package modul5.models;
import java.util.ArrayList;

public class MatkulAmbil{
    private MataKuliah matkul;
    private ArrayList<Presensi> presensi;
    private int n1, n2, n3;
    public MatkulAmbil(MataKuliah matkul, int n1, int n2, int n3) {
        this.matkul = matkul;
        this.presensi = new ArrayList<>();
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
    }
    public MataKuliah getMatkul() {
        return matkul;
    }
    public void setMatkul(MataKuliah matkul) {
        this.matkul = matkul;
    }
    public ArrayList<Presensi> getPresensi() {
        return presensi;
    }
    public void addPresensi(Presensi presensi){
        this.presensi.add(presensi);
    }
    public void setPresensi(ArrayList<Presensi> presensi) {
        this.presensi = presensi;
    }
    public int getN1() {
        return n1;
    }
    public void setN1(int n1) {
        this.n1 = n1;
    }
    public int getN2() {
        return n2;
    }
    public void setN2(int n2) {
        this.n2 = n2;
    }
    public int getN3() {
        return n3;
    }
    public void setN3(int n3) {
        this.n3 = n3;
    }
    
    @Override
    public String toString(){
        String listPresensi = "";
        for (Presensi presensi : getPresensi()) {
            listPresensi += presensi.toString() + "\n";
        }
        return matkul.toString() + " Nilai : (" + n1 + ", " + n2 + ", " + n3 + ")" + "\nPresensi: " + listPresensi;
    }
}
