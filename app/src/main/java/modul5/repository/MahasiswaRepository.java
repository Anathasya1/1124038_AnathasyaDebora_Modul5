package modul5.repository;

import modul5.models.MataKuliah;
import modul5.models.Presensi;
import modul5.models.MatkulAmbil;
import modul5.util.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MahasiswaRepository {
    private static Connection conn;

    static {
        conn = Database.connect();
    }
    
    public double printNilAkhir(String nim, String kodeMk) {
        String sql = "SELECT nilai1,nilai2,nilai3 FROM matkul_ambil WHERE nim_mhs = ? AND kode_matkul_ambil = ?";
        double hasilHitung = 0;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, nim);
            preparedStatement.setString(2, kodeMk);
            ResultSet resultQuery = preparedStatement.executeQuery();
            
            if (resultQuery.next()) {
                double nil1 = resultQuery.getInt("nilai1");
                double nil2 = resultQuery.getInt("nilai2");
                double nil3 = resultQuery.getInt("nilai3");
                hasilHitung = (nil1 + nil2 + nil3) / 3;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hasilHitung;
    }

    public double printNilAkhir(String nim) {
        String sql = "SELECT nilai_sidang1,nilai_sidang2,nilai_sidang3 FROM mahasiswa_doktor WHERE nim = ?";
        double hasilHitung = 0;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, nim);
            ResultSet resultQuery = preparedStatement.executeQuery();
            
            if (resultQuery.next()) {
                double nil1 = resultQuery.getInt("nilai_sidang1");
                double nil2 = resultQuery.getInt("nilai_sidang2");
                double nil3 = resultQuery.getInt("nilai_sidang3");
                hasilHitung = (nil1 + nil2 + nil3) / 3;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hasilHitung;
    }

    public double printNilaiAkhir(String kodeMK){
        String sql = "SELECT nilai1, nilai2, nilai3 FROM matkul_ambil WHERE kode_matkul_ambil= ?";
        double hasilHitung = 0;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, kodeMK);
            ResultSet resultQuery = preparedStatement.executeQuery();
            
            int jumlahMhs = 0;
            while (resultQuery.next()) {
                double nil1 = resultQuery.getInt("nilai1");
                double nil2 = resultQuery.getInt("nilai2");
                double nil3 = resultQuery.getInt("nilai3");
                jumlahMhs++;
                hasilHitung += (nil1 + nil2 + nil3) / 3;
            }
            return hasilHitung/jumlahMhs;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public String printLulusMK (String kodeMk){
        String sql = "SELECT matkul_ambil.nilai1, matkul_ambil.nilai2, matkul_ambil.nilai3, matakuliah.nama_matkul FROM matkul_ambil INNER JOIN matakuliah ON matkul_ambil.kode_matkul_ambil = matakuliah.kode_matkul WHERE kode_matkul_ambil= ? ";
        double hasilHitung = 0;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, kodeMk);
            ResultSet resultQuery = preparedStatement.executeQuery();
            
            int jumlahMhs = 0;
            int totalMhs = 0;
            String namaMatkul = "";
            while (resultQuery.next()) {
                double nil1 = resultQuery.getInt("nilai1");
                double nil2 = resultQuery.getInt("nilai2");
                double nil3 = resultQuery.getInt("nilai3");
                hasilHitung += (nil1 + nil2 + nil3) / 3;
                if (hasilHitung < 56) {
                    jumlahMhs++;
                }
                totalMhs++;
                namaMatkul = resultQuery.getString("nama_matkul");
            }
            return jumlahMhs + " dari " + totalMhs + " mahasiswa tidak lulus matakuliah " + namaMatkul;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }


    public List<MatkulAmbil> matkulAmbildanPresensi(String nim){
        String sql = "SELECT mk_ambil.kode_matkul_ambil, mk_ambil.nilai1, mk_ambil.nilai2, mk_ambil.nilai3, mk.kode_matkul, mk.nama_matkul, mk.sks, p.tanggal_presensi_mhs, p.status_presensi_mhs FROM matkul_ambil mk_ambil INNER JOIN matakuliah mk ON mk_ambil.kode_matkul_ambil = mk.kode_matkul LEFT JOIN presensi_mhs p ON mk_ambil.nim_mhs = p.nim AND p.kode_matkul = mk_ambil.kode_matkul_ambil WHERE mk_ambil.nim_mhs = ?";
        List<MatkulAmbil> listMK = new ArrayList<>();
        MatkulAmbil matkulAmbil = null;
        String lastKodeMk = null;

        //String sql = "SELECT mk_ambil.*, SUM(absen_mhs.status_presensi_mhs) AS , absen_mhs.tanggal_presensi_mhs, mk.* FROM matkul_ambil mk_ambil INNER JOIN presensi_mhs absen_mhs ON mk_ambil.nim_mhs = absen_mhs.nim INNER JOIN matakuliah mk mk_ambil.kode_matkul_ambil = mk.kode_matkul WHERE nim=?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, nim);
            ResultSet resultQuery = preparedStatement.executeQuery();
            
            while (resultQuery.next()) {
                MataKuliah matkul = new MataKuliah(resultQuery.getString("kode_matkul"), resultQuery.getInt("sks"), resultQuery.getString("nama_matkul"));
                Presensi presensi = new Presensi(resultQuery.getString("tanggal_presensi_mhs"), resultQuery.getString("status_presensi_mhs"));
                
                if (lastKodeMk == null || !lastKodeMk.equalsIgnoreCase(resultQuery.getString("kode_matkul"))) {
                    matkulAmbil = new MatkulAmbil(matkul, resultQuery.getInt("nilai1"), resultQuery.getInt("nilai2"), resultQuery.getInt("nilai3"));
                    matkulAmbil.addPresensi(presensi);
                    listMK.add(matkulAmbil);
                } else {
                    matkulAmbil.addPresensi(presensi);
                }

                              
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listMK;
    }
    
}
