package modul5.models;

public class Presensi {
    private String tanggal;
    private String status;

    public Presensi(String tanggal, String status) {
        this.tanggal = tanggal;
        this.status = status;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return "(Tanggal: " +  getTanggal() + " ,Status: " + getStatus() + ")";
    }
}
