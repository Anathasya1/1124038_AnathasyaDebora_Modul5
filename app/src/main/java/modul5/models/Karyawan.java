package modul5.models;
import java.util.ArrayList;

public class Karyawan extends Staff {
    private int salary;
    private ArrayList<PresensiStaff> listPresensiStaff;

    public Karyawan (String nik, String nama, String tempatLahir, String tanggalLahir, String alamat, String telepon, int salary){
        super(UserType.KARYAWAN, nik, nama, tempatLahir, tanggalLahir, alamat, telepon);
        this.salary = salary;
    }

    public int getSalary(){
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public ArrayList<PresensiStaff> getListPresensiStaff(){
        return listPresensiStaff;
    }
    public void setListPresensiStaff(ArrayList<PresensiStaff> listPresensiStaff) {
        this.listPresensiStaff = listPresensiStaff;
    }

    @Override
    public String toString(){
        return super.toString() + "\nHonor: " + getSalary();
        //return super.toString() + "\nPresensi: " + listPresensiStaff.toString() + "\nHonor: " + getSalary() + "\nStatus: " + getStatus();
    }

}
