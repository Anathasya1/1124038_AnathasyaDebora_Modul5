package modul5.views;
import modul5.util.CLIUtil;
import modul5.controllers.UserController;
import modul5.controllers.MahasiswaController;
import modul5.controllers.DosenController;
import modul5.controllers.StaffController;
import javax.swing.JOptionPane;

import modul5.models.MatkulAmbil;
import modul5.models.User;

public class MenuView {

    UserController userController = new UserController();
    MahasiswaController mahasiswaController = new MahasiswaController();
    DosenController dosenController = new DosenController();
    StaffController staffController = new StaffController();

    public void render(){
        int menuSIA = 0;

        do {
            menuSIA = CLIUtil.askForInt("""
                Menu SIA: \n1. Print data User (input name)\n
                2. print Nilai Akhir mahasiswa (input nim, kodeMk)\n
                3. Print rata rata Nilai Akhir seuluruh mahasiswa (input kodeMK)\n
                4. Print mahasiswa yang tidak lulus matakuliah\n
                5. Print Matkul yang diambil mahasiswa beserta total presensi\n
                6. Print total jam seorang dosen hadir dan mengajar dari seluruh MK yang diajar\n
                7. Sout print gaji seorang staff\n
                Masukkan menu: """);
            handleMenuInput(menuSIA);
        } while (menuSIA != 0);

    
    }

    private void handleMenuInput(int menu){
        switch (menu) {
            case 1:
                printMenu1();
                break;
            case 2:
                printMenu2();
                break;
            case 3:
                printMenu3();
                break;
            case 4:
                printMenu4();
                break;
            case 5:
                printMenu5();
                break;
            case 6:
                printMenu6();
                break;
            case 7:
                printMenu7();
                break;
            default:
                break;
        }
    }


    public void printMenu1(){
        String inputNama = "";
        do {
            inputNama = CLIUtil.askForString("Input nama:");

            for (User users : userController.printAllUser(inputNama)) {
                JOptionPane.showMessageDialog(null,users.toString());
            }
        } while (!inputNama.equalsIgnoreCase(""));
    }

    public void printMenu2(){
        String status = CLIUtil.askForString("Apakah Mahasiswa Doktor (ya/tidak): ");
        String inputNim = "";
        String inputKodeMk ="";
        if (status.equalsIgnoreCase("Ya")) {
            inputNim = CLIUtil.askForString("Input nim:");
            JOptionPane.showMessageDialog(null, "Nilai Akhir: " + mahasiswaController.nilaiAkhirMahasiswa(inputNim));
        } else {
            inputNim = CLIUtil.askForString("Input nim:");
            inputKodeMk = CLIUtil.askForString("Masukan Kode MK: ");
            JOptionPane.showMessageDialog(null, "Nilai Akhir: " + mahasiswaController.nilaiAkhirMahasiswa(inputNim, inputKodeMk));
        }   

    }

    public void printMenu3(){
        String kodeMK = CLIUtil.askForString("Masukkan kode matkul: ");
        JOptionPane.showMessageDialog(null,"Rata rata kode matkul " + kodeMK + ": " + mahasiswaController.nilaiRataRataMK(kodeMK));
    }

    public void printMenu4(){
        String kodeMK = CLIUtil.askForString("Masukkan kode matkul: ");
        JOptionPane.showMessageDialog(null,"Lulus Mk: " + mahasiswaController.printLulusMK(kodeMK));
    }

    public void printMenu5(){
        String nim = CLIUtil.askForString("Masukkan nim: ");
        for (MatkulAmbil list : mahasiswaController.getMatkulAmbil(nim)) {
            JOptionPane.showMessageDialog(null,list.toString());
        }
    }

    public void printMenu6(){
        String nik = CLIUtil.askForString("Masukkan nik: ");
        JOptionPane.showMessageDialog(null,"Total jam kerja: " + dosenController.totalJamKerja(nik) + " jam");
    }

    public void printMenu7(){
        String nik = CLIUtil.askForString("Masukkan nik: ");
        JOptionPane.showMessageDialog(null, "Honor: " + staffController.Gaji(nik) + " rupiah");
    }

}
