package modul5.controllers;
import java.util.List;

import modul5.models.MatkulAmbil;
import modul5.repository.MahasiswaRepository;

public class MahasiswaController {
    private MahasiswaRepository mahasiswaRepository;

    public MahasiswaController(){
        this.mahasiswaRepository = new MahasiswaRepository();
    }

    public double nilaiAkhirMahasiswa(String nim, String kodeMk){
        return mahasiswaRepository.printNilAkhir(nim, kodeMk);
    }
    public double nilaiAkhirMahasiswa(String nim){
        return mahasiswaRepository.printNilAkhir(nim);
    }

    public double nilaiRataRataMK(String kodeMK){
        return mahasiswaRepository.printNilaiAkhir(kodeMK);
    }

    public String printLulusMK(String kodeMK){
        return mahasiswaRepository.printLulusMK(kodeMK);
    }

    public List<MatkulAmbil> getMatkulAmbil(String nim){
        return mahasiswaRepository.matkulAmbildanPresensi(nim);
    }

}
