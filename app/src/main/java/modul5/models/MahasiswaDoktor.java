package modul5.models;

public class MahasiswaDoktor extends Mahasiswa{
    private String judulPenelitian;
    private int nilaiSidang1;
    private int nilaiSidang2;
    private int nilaiSidang3;
    public MahasiswaDoktor(String judulPenelitian, int nilaiSidang1, int nilaiSidang2,
            int nilaiSidang3, String nim, String kodeJurusan, String nama, String tempatLahir, String tanggalLahir,
            String alamat, String telepon) {
        super(nim, kodeJurusan, nama, tempatLahir, tanggalLahir, alamat, telepon);
        this.judulPenelitian = judulPenelitian;
        this.nilaiSidang1 = nilaiSidang1;
        this.nilaiSidang2 = nilaiSidang2;
        this.nilaiSidang3 = nilaiSidang3;
    }
    public String getJudulPenelitian() {
        return judulPenelitian;
    }
    public void setJudulPenelitian(String judulPenelitian) {
        this.judulPenelitian = judulPenelitian;
    }
    
    public int getNilaiSidang1() {
        return nilaiSidang1;
    }
    public void setNilaiSidang1(int nilaiSidang1) {
        this.nilaiSidang1 = nilaiSidang1;
    }

    public int getNilaiSidang2() {
        return nilaiSidang2;
    }
    public void setNilaiSidang2(int nilaiSidang2) {
        this.nilaiSidang2 = nilaiSidang2;
    }

    public int getNilaiSidang3() {
        return nilaiSidang3;
    }
    public void setNilaiSidang3(int nilaiSidang3) {
        this.nilaiSidang3 = nilaiSidang3;
    }

    @Override
    public String toString() {
        return  super.toString() + "\nJudul Penelitian: " + getJudulPenelitian() + "\nNilai Sidang 1: " + getNilaiSidang1()
        + "\nNilai Sidang 2: " + getNilaiSidang2() + "\nNilai Sidang 3: " + getNilaiSidang3();
    }
}
