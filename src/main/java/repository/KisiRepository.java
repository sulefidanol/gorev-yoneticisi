package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import GorevYoneticisi.Config;
import model.Kisi;

public class KisiRepository {
	public KisiRepository() {
	}

	public void create(Kisi kisi) {
		String query = "INSERT INTO kisiler(kisi_adi, kisi_soyadi) VALUES ('" + kisi.getKisiAdi() + "','"
				+ kisi.getKisiSoyadi() + "')";
		RepositoryHelper.execute(query);
	}

	public void delete(int kisiId) {
		String query = "delete from kisiler where id=" + kisiId;
		RepositoryHelper.execute(query);
	}

	public void update(Kisi kisi) {
		String query = "update kisiler set kisi_adi='" + kisi.getKisiAdi() + "' , kisi_soyadi='" + kisi.getKisiSoyadi()
				+ "' where id=" + kisi.getKisiId();

		RepositoryHelper.execute(query);
	}

	public ArrayList<Kisi> getKisiler() {
		System.out.println("kiþi listeleme");
		String connectionUrl = Config.connectionString;
		Connection conn = null;
		ArrayList<Kisi> kisiler = new ArrayList<Kisi>();
		try {
			conn = DriverManager.getConnection(connectionUrl);
			String str = "select kisi_adi,kisi_soyadi, id from kisiler";
			ResultSet rs = conn.prepareStatement(str).executeQuery();
			while (rs.next()) {
				String kisiAdi = rs.getString(1);
				String kisiSoyadi = rs.getString(2);
				int kisiId = rs.getInt(3);
				kisiler.add(new Kisi(kisiId, kisiAdi, kisiSoyadi));
			}
			
			return kisiler;
		} catch (Exception e) {
			e.printStackTrace();
			
			return kisiler;
		} finally {
			try {
				conn.close();
				
				return kisiler;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Kisi getKisi(int index) {
		ArrayList<Kisi> kisiler = new ArrayList<Kisi>();
		String str = "select id,kisi_adi,kisi_soyadi from kisiler where id = " + index;
		String connectionUrl = Config.connectionString;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(connectionUrl);
			ResultSet rs = conn.prepareStatement(str).executeQuery();
			while (rs.next()) {
				String kisiAdi = rs.getString(1);
				String kisiSoyadi = rs.getString(2);
				int kisiId = rs.getInt(1);
				kisiler.add(new Kisi(kisiId, kisiAdi, kisiSoyadi));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return kisiler.get(0);
	}
}
