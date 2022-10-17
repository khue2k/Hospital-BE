package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Medicine;
import mylist.MedicineList;

public class SqlMedicine {
	public static MedicineList getAll() {
		try {
			Connection conn = MyConnect.getConnection();
			String sql = "SELECT * FROM medicine";
			PreparedStatement pre = conn.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			System.out.println("query xong");
			MedicineList lstDoc = new MedicineList();
			while (rs.next()) {
				Medicine a = new Medicine(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
				lstDoc.add(a);
			}
			return lstDoc;
		} catch (Exception e) {
			System.out.println("loi mysql -> getallMedicine");
			System.out.println(e);
			// TODO: handle exception
		}
		return new MedicineList();
	}

	public static MedicineList find(String type, String value) {
		try {
			System.out.println("tim Medicine");
			Connection conn = MyConnect.getConnection();
			String sql = "SELECT * FROM medicine where " + type + "=?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, value);
			ResultSet rs = pre.executeQuery();
			System.out.println("query xong find Medicine");
			MedicineList lstDoc = new MedicineList();
			while (rs.next()) {
				Medicine a = new Medicine(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
				System.out.println(a.toString());
				lstDoc.add(a);
			}
			return lstDoc;
		} catch (Exception e) {
			System.out.println("loi mysql -> getallMedicine");
			System.out.println(e);
			// TODO: handle exception
		}
		return new MedicineList();
	}

	public static int add(Medicine Medicine) {
		try {
			System.out.println("add Medicine");
			Connection conn = MyConnect.getConnection();
			String sql = "INSERT INTO medicine (name,cost,type) VALUES (?,?,?);";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, String.valueOf(Medicine.getName()));
			pre.setString(2, String.valueOf(Medicine.getCost()));
			pre.setString(3, String.valueOf(Medicine.getType()));
			int rs = pre.executeUpdate();
			if (rs == 0) {
				return 0;
			} else {
				return 1;
			}
		} catch (Exception e) {
			System.out.println("loi mysql -> add Medicine");
			System.out.println(e);
			// TODO: handle exception
		}
		return 0;
	}

	public static int delete(int id) {
		try {
			System.out.println("delete Medicine");
			Connection conn = MyConnect.getConnection();
			String sql = "DELETE FROM medicine  WHERE idmedicine=?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, String.valueOf(id));
			int rs = pre.executeUpdate();
			if (rs == 0) {
				return 0;
			} else {
				return 1;
			}
		} catch (Exception e) {
			System.out.println("loi mysql -> delete Medicine");
			System.out.println(e);
			// TODO: handle exception
		}
		return 0;
	}

	public static int update(int id, Medicine Medicine) {
		try {
			System.out.println("update Medicine");
			Connection conn = MyConnect.getConnection();
			String sql = "UPDATE medicine SET name=?,cost=?,type=? WHERE idmedicine=?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, String.valueOf(Medicine.getName()));
			pre.setString(2, String.valueOf(Medicine.getCost()));
			pre.setString(3, String.valueOf(Medicine.getType()));
			pre.setString(4, String.valueOf(id));
			int rs = pre.executeUpdate();
			if (rs == 0) {
				return 0;
			} else {
				return 1;
			}
		} catch (Exception e) {
			System.out.println("loi mysql -> update Medicine");
			System.out.println(e);
			// TODO: handle exception
		}
		return 0;
	}
}
