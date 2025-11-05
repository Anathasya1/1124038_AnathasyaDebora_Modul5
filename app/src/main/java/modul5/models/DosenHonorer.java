package modul5.models;

public class DosenHonorer extends Dosen{
    private int honorPerSKS;

    public DosenHonorer(String nik, String nama, String tempatLahir, String tanggalLahir, String alamat, String telepon,
            String departemen, int honorPerSKS) {
        super(UserType.DOSEN_HONORER, nik, nama, tempatLahir, tanggalLahir, alamat, telepon, departemen);
        this.honorPerSKS = honorPerSKS;
    }

    public int getHonorPerSKS(){
        return honorPerSKS;
    }
    public void setHonorPerSKS(int honorPerSKS){
        this.honorPerSKS = honorPerSKS;
    }

    @Override
    public String toString() {
        
        return super.toString() + "\nHonor Per SKS: " + getHonorPerSKS();
    }
    
}
