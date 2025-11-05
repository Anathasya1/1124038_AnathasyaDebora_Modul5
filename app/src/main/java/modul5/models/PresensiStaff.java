package modul5.models;
import java.time.LocalTime;

public class PresensiStaff extends Presensi {
    private LocalTime jam;

    public PresensiStaff(String tanggal, String status, LocalTime jam) {
        super(tanggal, status);
        this.jam = jam;
    }

    public LocalTime getJam() {
        return jam;
    }
    public void setJam(LocalTime jam) {
        this.jam = jam;
    }

    @Override
    public String toString(){
        return "(Tanggal: " +  getTanggal() + " ,Status: " + getStatus() + " ,Jam: " + getJam() + ")";
    }
}
