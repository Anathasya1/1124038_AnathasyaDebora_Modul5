package modul5.models;
public class MataKuliahPilihan extends MataKuliah{
    private int jumlahMinMhs;

    public MataKuliahPilihan(String kodeMatkul, int sks, String namaMatkul, int jumlahMinMhs) {
        super(kodeMatkul, sks, namaMatkul);
        this.jumlahMinMhs = jumlahMinMhs;
    }

    public int getJumlahMhs(){
        return jumlahMinMhs;
    }

    public void setJumlahMhs(int jumlahMinMhs){
        this.jumlahMinMhs = jumlahMinMhs;
    }
    
}
