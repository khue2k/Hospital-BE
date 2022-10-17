package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Medicineperexam;
import mylist.MedicineperexamList;

public class SqlMedicineperexam {
	public static MedicineperexamList getAll() {
		try {
			Connection conn = MyConnect.getConnection();
			String sql = "SELECT * FROM medicineperexam";
			PreparedStatement pre = conn.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			System.out.println("query xong");
			MedicineperexamList lstDoc = new MedicineperexamList();
			while (rs.next()) {
				Medicineperexam a = new Medicineperexam(rs.getInt(1), rs.getInt(2), rs.getInt(3));
				lstDoc.add(a);
			}
			return lstDoc;
		} catch (Exception e) {
			System.out.println("loi mysql -> getallMedicineperexam");
			System.out.println(e);
			// TODO: handle exception
		}
		return new MedicineperexamList();
	}

	public static MedicineperexamList find(String type, String value) {
		try {
			System.out.println("tim Medicineperexam");
			Connection conn = MyConnect.getConnection();
			String sql = "SELECT * FROM medicineperexam where " + type + "=?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, value);
			ResultSet rs = pre.executeQuery();
			System.out.println("query xong find Medicineperexam");
			MedicineperexamList lstDoc = new MedicineperexamList();
			while (rs.next()) {
				Medicineperexam a = new Medicineperexam(rs.getInt(1), rs.getInt(2), rs.getInt(3));
				System.out.println(a.toString());
				lstDoc.add(a);
			}
			return lstDoc;
		} catch (Exception e) {
			System.out.println("loi mysql -> getallMedicineperexam");
			System.out.println(e);
			// TODO: handle exception
		}
		return new MedicineperexamList();
	}

	public static int add(Medicineperexam Medicineperexam) {
		try {
			System.out.println("add Medicineperexam");
			Connection conn = MyConnect.getConnection();
			String sql = "INSERT INTO medicineperexam (idmedicine,idexamination) VALUES (?,?);";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, String.valueOf(Medicineperexam.getIdmedicine()));
			pre.setString(2, String.valueOf(Medicineperexam.getIdexamination()));
			int rs = pre.executeUpdate();
			if (rs == 0) {
				return 0;
			} else {
				return 1;
			}
		} catch (Exception e) {
			System.out.println("loi mysql -> add Medicineperexam");
			System.out.println(e);
			// TODO: handle exception
		}
		return 0;
	}

	public static int delete(int id) {
		try {
			System.out.println("delete Medicineperexam");
			Connection conn = MyConnect.getConnection();
			String sql = "DELETE FROM medicineperexam  WHERE idmedicineperexam=?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, String.valueOf(id));
			int rs = pre.executeUpdate();
			if (rs == 0) {
				return 0;
			} else {
				return 1;
			}
		} catch (Exception e) {
			System.out.println("loi mysql -> delete Medicineperexam");
			System.out.println(e);
			// TODO: handle exception
		}
		return 0;
	}

	public static int update(int id, Medicineperexam Medicineperexam) {
		try {
			System.out.println("update Medicineperexam");
			Connection conn = MyConnect.getConnection();
			String sql = "UPDATE medicineperexam SET idmedicine=?,idexamination=? WHERE idmedicineperexam=?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, String.valueOf(Medicineperexam.getIdmedicine()));
			pre.setString(2, String.valueOf(Medicineperexam.getIdexamination()));
			pre.setString(3, String.valueOf(id));
			int rs = pre.executeUpdate();
			if (rs == 0) {
				return 0;
			} else {
				return 1;
			}
		} catch (Exception e) {
			System.out.println("loi mysql -> update Medicineperexam");
			System.out.println(e);
			// TODO: handle exception
		}
		return 0;
	}
}
