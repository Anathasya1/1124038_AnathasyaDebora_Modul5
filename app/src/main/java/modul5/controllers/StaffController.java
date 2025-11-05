package modul5.controllers;
import modul5.repository.StaffRepository;

public class StaffController {
    StaffRepository staffRepository;

    public StaffController(){
        staffRepository = new StaffRepository();
    }

    public double Gaji(String nik){
        return staffRepository.gaji(nik);
    }
}
