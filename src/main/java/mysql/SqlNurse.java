package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Nurse;
import mylist.NurseList;

public class SqlNurse {
	public static NurseList getAll() {
		try {
			Connection conn = MyConnect.getConnection();
			String sql = "SELECT * FROM nurse";
			PreparedStatement pre = conn.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			System.out.println("query xong nurse");
			NurseList lstDoc = new NurseList();
			while (rs.next()) {
				Nurse a = new Nurse(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getInt(8),rs.getString(9));
				lstDoc.add(a);
			}
			return lstDoc;
		} catch (Exception e) {
			System.out.println("loi mysql -> getallNurse");
			System.out.println(e);
			// TODO: handle exception
		}
		return new NurseList();
	}

	public static NurseList find(String type, String value) {
		try {
			System.out.println("tim Nurse");
			Connection conn = MyConnect.getConnection();
			String sql = "SELECT * FROM nurse where " + type + "=?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, value);
			ResultSet rs = pre.executeQuery();
			System.out.println("query xong find Nurse");
			NurseList lstDoc = new NurseList();
			while (rs.next()) {
				Nurse a = new Nurse(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getInt(8),rs.getString(9));
				System.out.println(a.toString());
				lstDoc.add(a);
			}
			return lstDoc;
		} catch (Exception e) {
			System.out.println("loi mysql -> getallNurse");
			System.out.println(e);
			// TODO: handle exception
		}
		return new NurseList();
	}

	public static int add(Nurse Nurse) {
		try {
			System.out.println("add Nurse");
			Connection conn = MyConnect.getConnection();
			String sql = "INSERT INTO nurse (name,birthday,cmd,address,level,phone,seniority,type) VALUES (?,?,?,?,?,?,?,?);";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, String.valueOf(Nurse.getName()));
			pre.setString(2, String.valueOf(Nurse.getBirthday()));
			pre.setString(3, String.valueOf(Nurse.getCmd()));
			pre.setString(4, String.valueOf(Nurse.getAddress()));
			pre.setString(5, String.valueOf(Nurse.getLevel()));
			pre.setString(6, String.valueOf(Nurse.getPhone()));
			pre.setString(7, String.valueOf(Nurse.getSeniority()));
			pre.setString(8, String.valueOf(Nurse.getType()));
			int rs = pre.executeUpdate();
			if (rs == 0) {
				return 0;
			} else {
				return 1;
			}
		} catch (Exception e) {
			System.out.println("loi mysql -> add Nurse");
			System.out.println(e);
			// TODO: handle exception
		}
		return 0;
	}

	public static int delete(int id) {
		try {
			System.out.println("delete Nurse");
			Connection conn = MyConnect.getConnection();
			String sql = "DELETE FROM nurse  WHERE idnurse=?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, String.valueOf(id));
			int rs = pre.executeUpdate();
			if (rs == 0) {
				return 0;
			} else {
				return 1;
			}
		} catch (Exception e) {
			System.out.println("loi mysql -> delete Nurse");
			System.out.println(e);
			// TODO: handle exception
		}
		return 0;
	}

	public static int update(int id, Nurse Nurse) {
		try {
			System.out.println("update Nurse");
			Connection conn = MyConnect.getConnection();
			String sql = "UPDATE nurse SET name=?,birthday=?,cmd=?,address=?,level=?,seniority=?,phone=?,type=? WHERE idnurse=?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, String.valueOf(Nurse.getName()));
			pre.setString(2, String.valueOf(Nurse.getBirthday()));
			pre.setString(3, String.valueOf(Nurse.getCmd()));
			pre.setString(4, String.valueOf(Nurse.getAddress()));
			pre.setString(5, String.valueOf(Nurse.getLevel()));
			pre.setString(6, String.valueOf(Nurse.getSeniority()));
			pre.setString(7, String.valueOf(Nurse.getPhone()));
			pre.setString(8, String.valueOf(Nurse.getType()));
			pre.setString(9, String.valueOf(id));
			int rs = pre.executeUpdate();
			if (rs == 0) {
				return 0;
			} else {
				return 1;
			}
		} catch (Exception e) {
			System.out.println("loi mysql -> update Nurse");
			System.out.println(e);
			// TODO: handle exception
		}
		return 0;
	}
}
