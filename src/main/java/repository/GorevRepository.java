package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import GorevYoneticisi.Config;
import model.Gorev;

public class GorevRepository {
	public GorevRepository() {}

	public void create(Gorev gorev) {
		String str = "INSERT INTO gorev(gorev_adi, gorev_aciklamasi, yapilmis_gorev, kisi_id) VALUES ('"
				+ gorev.getGorevAdý() + "','" + gorev.getGorevAciklamasi() + "'," + gorev.isYapýlmýsGorev() + ",2)";
		RepositoryHelper.execute(str);
	}

	public void delete(int id) {
		String str = "delete from gorev where id=" + id;
		RepositoryHelper.execute(str);
	}
	
	public void update(Gorev gorev) {
		String str = "update gorev set gorev_adi='" + gorev.getGorevAdý() + "' , gorev_aciklamasi='"
				+ gorev.getGorevAciklamasi() + "' , yapilmis_gorev=" + gorev.isYapýlmýsGorev() + " where id="
				+ gorev.getId();
		RepositoryHelper.execute(str);
	}

	public ArrayList<Gorev> getGorevler() {
		String str = "select id,gorev_adi,gorev_aciklamasi,yapilmis_gorev , kisi_id from gorev";
		return parseGorev(str);
	
	}

	public Gorev getGorev(int index) {
		String str = "select * from gorev where id = " + index;
		ArrayList<Gorev> gorevler = parseGorev(str);
		return gorevler.get(0);
	}
	
	private ArrayList<Gorev> parseGorev(String query) {
		ArrayList<Gorev> gorevler = new ArrayList<Gorev>();
		String connectionUrl = Config.connectionString;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(connectionUrl);
			ResultSet rs = conn.prepareStatement(query).executeQuery();
			while (rs !=null && rs.next()) {
				int id = rs.getInt(1);
				String gorevAdi = rs.getString(2);
				String aciklama = rs.getString(3);
				Boolean yapilmisGorev = rs.getBoolean(4);
				int kisiId = rs.getInt(5);
				gorevler.add(new Gorev(id, gorevAdi, aciklama, yapilmisGorev));
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
		return gorevler;
	}
	
	

}
