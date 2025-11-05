package modul5.repository;

import modul5.util.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modul5.models.DosenHonorer;
import modul5.models.DosenTetap;
import modul5.models.Karyawan;
import modul5.models.Mahasiswa;
import modul5.models.User;

public class UserRepository {
    public ArrayList<User> listAllSearchByName(String name) {
        ArrayList<User> userList = new ArrayList<>();
        Connection conn = Database.connect();
       String sql = "SELECT u.*, mahasiswa.*, dosen_tetap.*, dosen_honorer.*, karyawan.* FROM \"user\" u LEFT JOIN mahasiswa ON u.id = mahasiswa.nim LEFT JOIN karyawan ON u.id = karyawan.nik LEFT JOIN dosen_honorer ON u.id = dosen_honorer.nik LEFT JOIN dosen_tetap ON u.id = dosen_tetap.nik WHERE u.nama =? ";
       try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet resultQuery = preparedStatement.executeQuery();

            while (resultQuery.next()) {
                String idUser = resultQuery.getString("id");
                String nama = resultQuery.getString("nama");
                String alamat = resultQuery.getString("alamat");
                String tanggal_lahir = resultQuery.getString("tanggal_lahir");
                String tempat_lahir = resultQuery.getString("tempat_lahir");
                String telepon = resultQuery.getString("telepon");
                String departemen = resultQuery.getString("departemen");
                String kode_jurusan = resultQuery.getString("kode_jurusan");
                int salary = resultQuery.getInt("salary");
                int honor_per_sks = resultQuery.getInt("honor_persks");

                switch (resultQuery.getString("status")) {
                    case "Mahasiswa Sarjana":
                    case "Mahasiswa Doktor":
                    case "Mahasiswa Magister":
                        userList.add(new Mahasiswa(idUser, kode_jurusan, nama, tempat_lahir,tanggal_lahir, alamat, telepon));
                        break;
                    case "Karyawan":
                        userList.add(new Karyawan(idUser, nama, tempat_lahir, tanggal_lahir, alamat, telepon, salary));
                        break;    
                    case "Dosen Tetap":
                        userList.add(new DosenTetap(idUser, nama, tempat_lahir, tanggal_lahir, alamat, telepon, departemen, salary));
                        break;
                    case "Dosen Honorer":
                        userList.add(new DosenHonorer(idUser, nama, tempat_lahir, tanggal_lahir, alamat, telepon, departemen, honor_per_sks));
                        break;
                    default:
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
