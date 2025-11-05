package modul5.models;
import java.util.ArrayList;

public class MatkulAjar {
    private MataKuliah matkul;
    private ArrayList<PresensiStaff> listPresensiStaff;
    public MatkulAjar(MataKuliah matkul, ArrayList<PresensiStaff> listPresensiStaff) {
        this.matkul = matkul;
        this.listPresensiStaff = listPresensiStaff;
    }
    public MataKuliah getMatkul() {
        return matkul;
    }
    public void setMatkul(MataKuliah matkul) {
        this.matkul = matkul;
    }
    public ArrayList<PresensiStaff> getListPresensiStaff() {
        return listPresensiStaff;
    }
    public void setListPresensiStaff(ArrayList<PresensiStaff> listPresensiStaff) {
        this.listPresensiStaff = listPresensiStaff;
    }

    @Override
    public String toString(){
        return matkul.toString() + listPresensiStaff.toString();
    }
}
