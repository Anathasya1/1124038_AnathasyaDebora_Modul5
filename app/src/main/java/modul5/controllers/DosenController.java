package modul5.controllers;
import modul5.repository.DosenRepository;

public class DosenController {
    DosenRepository dosenRepository;

    public DosenController(){
        this.dosenRepository = new DosenRepository();
    }

    public int totalJamKerja(String nik){
        return dosenRepository.totalMengajar(nik);
    }
}
