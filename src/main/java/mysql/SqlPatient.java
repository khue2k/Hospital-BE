package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Patient;
import mylist.PatientList;

public class SqlPatient {
	public static PatientList getAll() {
		try {
			Connection conn = MyConnect.getConnection();
			String sql = "SELECT * FROM patient";
			PreparedStatement pre = conn.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			System.out.println("query xong Patient");
			PatientList lstDoc = new PatientList();
			while (rs.next()) {
				Patient a = new Patient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
				lstDoc.add(a);
			}
			return lstDoc;
		} catch (Exception e) {
			System.out.println("loi mysql -> getallPatient");
			System.out.println(e);
			// TODO: handle exception
		}
		return new PatientList();
	}

	public static PatientList find(String type, String value) {
		try {
			System.out.println("tim Patient");
			Connection conn = MyConnect.getConnection();
			String sql = "SELECT * FROM patient where " + type + "=?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, value);
			ResultSet rs = pre.executeQuery();
			System.out.println("query xong find Patient");
			PatientList lstDoc = new PatientList();
			while (rs.next()) {
				Patient a = new Patient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
				System.out.println(a.toString());
				lstDoc.add(a);
			}
			return lstDoc;
		} catch (Exception e) {
			System.out.println("loi mysql -> getallPatient");
			System.out.println(e);
			// TODO: handle exception
		}
		return new PatientList();
	}

	public static int add(Patient Patient) {
		try {
			System.out.println("add Patient");
			Connection conn = MyConnect.getConnection();
			String sql = "INSERT INTO patient (name,birthday,cmd,address,phone) VALUES (?,?,?,?,?);";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, String.valueOf(Patient.getName()));
			pre.setString(2, String.valueOf(Patient.getBirthday()));
			pre.setString(3, String.valueOf(Patient.getCmd()));
			pre.setString(4, String.valueOf(Patient.getAddress()));
			pre.setString(5, String.valueOf(Patient.getPhone()));
			int rs = pre.executeUpdate();
			if (rs == 0) {
				return 0;
			} else {
				return 1;
			}
		} catch (Exception e) {
			System.out.println("loi mysql -> add Patient");
			System.out.println(e);
			// TODO: handle exception
		}
		return 0;
	}

	public static int delete(int id) {
		try {
			System.out.println("delete Patient");
			Connection conn = MyConnect.getConnection();
			String sql = "DELETE FROM patient  WHERE idPatient=?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, String.valueOf(id));
			int rs = pre.executeUpdate();
			if (rs == 0) {
				return 0;
			} else {
				return 1;
			}
		} catch (Exception e) {
			System.out.println("loi mysql -> delete Patient");
			System.out.println(e);
			// TODO: handle exception
		}
		return 0;
	}

	public static int update(int id, Patient Patient) {
		try {
			System.out.println("update Patient");
			Connection conn = MyConnect.getConnection();
			String sql = "UPDATE patient SET name=?,birthday=?,cmd=?,address=?,phone=? WHERE idPatient=?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, String.valueOf(Patient.getName()));
			pre.setString(2, String.valueOf(Patient.getBirthday()));
			pre.setString(3, String.valueOf(Patient.getCmd()));
			pre.setString(4, String.valueOf(Patient.getAddress()));
			pre.setString(5, String.valueOf(Patient.getPhone()));
			pre.setString(6, String.valueOf(id));
			int rs = pre.executeUpdate();
			if (rs == 0) {
				return 0;
			} else {
				return 1;
			}
		} catch (Exception e) {
			System.out.println("loi mysql -> update Patient");
			System.out.println(e);
			// TODO: handle exception
		}
		return 0;
	}
}
