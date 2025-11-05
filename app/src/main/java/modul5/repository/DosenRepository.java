package modul5.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modul5.util.Database;

public class DosenRepository {
    private static Connection conn;

    static {
        conn = Database.connect();
    }

    public int totalMengajar(String nik){
        String sql = "SELECT SUM(absen.jam) AS total_jam, mk.nik FROM presensi_staff absen INNER JOIN matkul_ajar mk ON absen.id_presensi = mk.nik_kodemk WHERE absen.status_presensi='Hadir' AND mk.nik=? GROUP BY mk.nik";
        int totalJam = 0;
         try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, nik);
            ResultSet resultQuery = preparedStatement.executeQuery();
            
            if (resultQuery.next()) {
                String nik_terdaftar = resultQuery.getString("nik");
                if (nik.equalsIgnoreCase(nik_terdaftar)) {
                    totalJam = resultQuery.getInt("total_jam");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalJam;
    }
}
