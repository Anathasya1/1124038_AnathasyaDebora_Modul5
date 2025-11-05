package modul5.models;

public class MataKuliah {
    private String kodeMatkul;
    private int sks;
    private String namaMatkul;

    public MataKuliah(String kodeMatkul, int sks, String namaMatkul){
        this.kodeMatkul = kodeMatkul;
        this.sks = sks;
        this.namaMatkul = namaMatkul;
    }

    public String getKodeMatkul() {
        return kodeMatkul;
    }

    public void setKodeMatkul(String kodeMatkul){
        this.kodeMatkul = kodeMatkul;
    }
    public int getSks() {
        return sks;
    }
    public void setSks(int sks) {
        this.sks = sks;
    }

    public void setNamaMatkul(String namaMatkul) {
        this.namaMatkul = namaMatkul;
    }

    public String getNamaMatkul() {
        return namaMatkul;
    }
    
    @Override
    public String toString(){
        return namaMatkul + " (" + kodeMatkul + ", " + sks + " SKS)";
    }
}
