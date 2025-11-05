package modul5.models;

public class DosenTetap extends Dosen{
    private int salary;

    public DosenTetap(String nik, String nama, String tempatLahir, String tanggalLahir, String alamat, String telepon,
            String departemen, int salary) {
        super(UserType.DOSEN_TETAP,nik, nama, tempatLahir, tanggalLahir, alamat, telepon, departemen);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary){
        this.salary = salary;
    }

    @Override
    public String toString(){
        return super.toString() + "\nHonor: " + getSalary();
    }
}
