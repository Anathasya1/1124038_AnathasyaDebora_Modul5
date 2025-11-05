package modul5.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modul5.util.Database;

public class StaffRepository {
    private static Connection conn;

    static {
        conn = Database.connect();
    }

    public double gaji(String nik) {
        double gaji = 0;
        try {
            String sql = "SELECT status FROM \"user\" WHERE id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, nik);
            ResultSet resultQuery = preparedStatement.executeQuery();

            if (resultQuery.next()) {
                String getStatus = resultQuery.getString("status");

                if (getStatus.equalsIgnoreCase("Dosen tetap") || getStatus.equalsIgnoreCase("Dosen honorer")) {
                    String sqlPresensiDosen = "SELECT COUNT(absen.status_presensi) AS total_presensi, mk.nik FROM presensi_staff absen INNER JOIN matkul_ajar mk ON absen.id_presensi = mk.nik_kodemk WHERE absen.status_presensi='Hadir' AND mk.nik=? GROUP BY mk.nik";
                    PreparedStatement presensiDosen = conn.prepareStatement(sqlPresensiDosen);
                    presensiDosen.setString(1, nik);
                    ResultSet resultPresensiDosen = presensiDosen.executeQuery();
                    resultPresensiDosen.next();
                    double unitDosen = resultPresensiDosen.getInt("total_presensi");

                    if (getStatus.equalsIgnoreCase("dosen tetap")) {
                        String sqlDosenTetap = "SELECT u.id, dt.salary FROM \"user\" u  INNER JOIN dosen_tetap dt ON u.id = dt.nik WHERE u.id = ?";
                        PreparedStatement getDosenTetap = conn.prepareStatement(sqlDosenTetap);
                        getDosenTetap.setString(1, nik);
                        ResultSet gajiDosenTetap = getDosenTetap.executeQuery();
                        gajiDosenTetap.next();
                        gaji = gajiDosenTetap.getInt("salary") + (unitDosen * 250000);
                    } else if (getStatus.equalsIgnoreCase("dosen honorer")) {
                        String sqlDosenHonorer = "SELECT u.id, dh.honor_persks FROM \"user\" u  INNER JOIN dosen_honorer dh ON u.id = dh.nik WHERE u.id = ?";
                        PreparedStatement getDosenHonorer = conn.prepareStatement(sqlDosenHonorer);
                        getDosenHonorer.setString(1, nik);
                        ResultSet gajiDosenHonorer = getDosenHonorer.executeQuery();
                        gajiDosenHonorer.next();
                        gaji = unitDosen * gajiDosenHonorer.getInt("honor_persks");
                    }

                } else if (getStatus.equalsIgnoreCase("karyawan")) {
                    String sqlKaryawan = "SELECT COUNT(status_presensi) as total_presensi_karyawan FROM presensi_staff WHERE status_presensi = 'Hadir' AND id_presensi = ? GROUP BY id_presensi";
                    PreparedStatement absenKaryawan = conn.prepareStatement(sqlKaryawan);
                    absenKaryawan.setString(1, nik);
                    ResultSet resultAbsenKaryawan = absenKaryawan.executeQuery();
                    resultAbsenKaryawan.next();
                    double unitKaryawan = resultAbsenKaryawan.getInt("total_presensi_karyawan");

                    String salaryKaryawan = "SELECT COUNT(absen.status_presensi) AS presensi_karyawan, u.id, k.salary_karyawan FROM \"user\" u INNER JOIN karyawan k ON u.id = k.nik INNER JOIN presensi_staff absen ON u.id = absen.id_presensi WHERE u.id=? GROUP BY u.id, k.salary_karyawan";
                    PreparedStatement getKaryawan = conn.prepareStatement(salaryKaryawan);
                    getKaryawan.setString(1, nik);
                    ResultSet gajiKaryawan = getKaryawan.executeQuery();
                    gajiKaryawan.next();
                    gaji = unitKaryawan / 22 * gajiKaryawan.getInt("salary_karyawan");
                }
            } else {
                gaji = 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gaji;
    }
}
