package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.DoctorDiseases;
import mylist.DoctorDiseasesList;

public class SqlDoctorDiseases {
	public static DoctorDiseasesList getAll() {
		try {
			Connection conn = MyConnect.getConnection();
			String sql = "SELECT * FROM doctordiseases";
			PreparedStatement pre = conn.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			System.out.println("query xong DoctorDiseases");
			DoctorDiseasesList lstDoc = new DoctorDiseasesList();
			while (rs.next()) {
				DoctorDiseases a = new DoctorDiseases(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4));
				lstDoc.add(a);
			}
			return lstDoc;
		} catch (Exception e) {
			System.out.println("loi mysql -> getallDoctorDiseases");
			System.out.println(e);
			// TODO: handle exception
		}
		return new DoctorDiseasesList();
	}

	public static DoctorDiseasesList find(String type, String value) {
		try {
			System.out.println("tim DoctorDiseases");
			Connection conn = MyConnect.getConnection();
			String sql = "SELECT * FROM doctordiseases where " + type + "=?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, value);
			ResultSet rs = pre.executeQuery();
			System.out.println("query xong find DoctorDiseases");
			DoctorDiseasesList lstDoc = new DoctorDiseasesList();
			while (rs.next()) {
				DoctorDiseases a = new DoctorDiseases(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4));
				System.out.println(a.toString());
				lstDoc.add(a);
			}
			return lstDoc;
		} catch (Exception e) {
			System.out.println("loi mysql -> getallDoctorDiseases");
			System.out.println(e);
			// TODO: handle exception
		}
		return new DoctorDiseasesList();
	}

	public static int add(DoctorDiseases DoctorDiseases) {
		try {
			System.out.println("add doctordiseases");
			Connection conn = MyConnect.getConnection();
			String sql = "INSERT INTO doctordiseases (iddoctordiseases,iddoctor,iddiseases,type) VALUES (?,?,?,?);";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, String.valueOf(DoctorDiseases.getIddoctordiseases()));
			pre.setString(2, String.valueOf(DoctorDiseases.getIddoctor()));
			pre.setString(3, String.valueOf(DoctorDiseases.getIddiseases()));
			pre.setString(4, String.valueOf(DoctorDiseases.getType()));
			int rs = pre.executeUpdate();
			if (rs == 0) {
				return 0;
			} else {
				return 1;
			}
		} catch (Exception e) {
			System.out.println("loi mysql -> add DoctorDiseases");
			System.out.println(e);
			// TODO: handle exception
		}
		return 0;
	}

	public static int delete(int id) {
		try {
			System.out.println("delete DoctorDiseases");
			Connection conn = MyConnect.getConnection();
			String sql = "DELETE FROM doctordiseases  WHERE iddoctordiseases=?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, String.valueOf(id));
			int rs = pre.executeUpdate();
			if (rs == 0) {
				return 0;
			} else {
				return 1;
			}
		} catch (Exception e) {
			System.out.println("loi mysql -> delete DoctorDiseases");
			System.out.println(e);
			// TODO: handle exception
		}
		return 0;
	}

	public static int update(int id, DoctorDiseases DoctorDiseases) {
		try {
			System.out.println("update DoctorDiseases");
			Connection conn = MyConnect.getConnection();
			String sql = "UPDATE doctordiseases SET iddoctor=?,iddiseases=?,type=? WHERE iddoctordiseases=?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, String.valueOf(DoctorDiseases.getIddoctor()));
			pre.setString(2, String.valueOf(DoctorDiseases.getIddiseases()));
			pre.setString(3, String.valueOf(DoctorDiseases.getType()));
			pre.setString(4, String.valueOf(id));
			int rs = pre.executeUpdate();
			if (rs == 0) {
				return 0;
			} else {
				return 1;
			}
		} catch (Exception e) {
			System.out.println("loi mysql -> update DoctorDiseases");
			System.out.println(e);
			// TODO: handle exception
		}
		return 0;
	}
}
