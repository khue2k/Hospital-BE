package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Diseases;
import mylist.DiseasesList;

public class SqlDiseases {
	public static DiseasesList getAll() {
		try {
			Connection conn = MyConnect.getConnection();
			String sql = "SELECT * FROM diseases";
			PreparedStatement pre = conn.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			System.out.println("query xong");
			DiseasesList lstDoc = new DiseasesList();
			while (rs.next()) {
				Diseases a = new Diseases(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4));
				lstDoc.add(a);
			}
			return lstDoc;
		} catch (Exception e) {
			System.out.println("loi mysql -> getallDiseases");
			System.out.println(e);
			// TODO: handle exception
		}
		return new DiseasesList();
	}

	public static DiseasesList find(String type, String value) {
		try {
			System.out.println("tim Diseases");
			Connection conn = MyConnect.getConnection();
			String sql = "SELECT * FROM diseases where " + type + "=?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, value);
			ResultSet rs = pre.executeQuery();
			System.out.println("query xong find Diseases");
			DiseasesList lstDoc = new DiseasesList();
			while (rs.next()) {
				Diseases a = new Diseases(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4));
				System.out.println(a.toString());
				lstDoc.add(a);
			}
			return lstDoc;
		} catch (Exception e) {
			System.out.println("loi mysql -> getallDiseases");
			System.out.println(e);
			// TODO: handle exception
		}
		return new DiseasesList();
	}

	public static int add(Diseases Diseases) {
		try {
			System.out.println("add Diseases");
			Connection conn = MyConnect.getConnection();
			String sql = "INSERT INTO diseases (name,description,type) VALUES (?,?,?);";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, String.valueOf(Diseases.getName()));
			pre.setString(2, String.valueOf(Diseases.getDescription()));
			pre.setString(3, String.valueOf(Diseases.getType()));
			int rs = pre.executeUpdate();
			if (rs == 0) {
				return 0;
			} else {
				return 1;
			}
		} catch (Exception e) {
			System.out.println("loi mysql -> add Diseases");
			System.out.println(e);
			// TODO: handle exception
		}
		return 0;
	}

	public static int delete(int id) {
		try {
			System.out.println("delete Diseases");
			Connection conn = MyConnect.getConnection();
			String sql = "DELETE FROM diseases  WHERE iddiseases=?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, String.valueOf(id));
			int rs = pre.executeUpdate();
			if (rs == 0) {
				return 0;
			} else {
				return 1;
			}
		} catch (Exception e) {
			System.out.println("loi mysql -> delete Diseases");
			System.out.println(e);
			// TODO: handle exception
		}
		return 0;
	}

	public static int update(int id, Diseases Diseases) {
		try {
			System.out.println("update Diseases");
			Connection conn = MyConnect.getConnection();
			String sql = "UPDATE diseases SET name=?,description=?,type=? WHERE iddiseases=?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, String.valueOf(Diseases.getName()));
			pre.setString(2, String.valueOf(Diseases.getDescription()));
			pre.setString(3, String.valueOf(Diseases.getType()));
			pre.setString(4, String.valueOf(id));
			int rs = pre.executeUpdate();
			if (rs == 0) {
				return 0;
			} else {
				return 1;
			}
		} catch (Exception e) {
			System.out.println("loi mysql -> update Diseases");
			System.out.println(e);
			// TODO: handle exception
		}
		return 0;
	}
}
