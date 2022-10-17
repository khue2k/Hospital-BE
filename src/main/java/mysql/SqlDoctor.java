package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Doctor;
import mylist.DoctorList;

public class SqlDoctor {
	public static DoctorList getAll() {
		try {
			Connection conn = MyConnect.getConnection();
			String sql = "SELECT * FROM doctor";
			PreparedStatement pre = conn.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			System.out.println("query xong");
			DoctorList lstDoc = new DoctorList();
			while(rs.next()) {
				Doctor a = new Doctor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8));
				lstDoc.add(a);
			}
			return lstDoc;
		} catch (Exception e) {
			System.out.println("loi mysql -> getalldoctor");
			System.out.println(e);
			// TODO: handle exception
		}
		return new DoctorList();
	}
	
	public static DoctorList find(String type, String value) {
		try {
			System.out.println("tim Doctor");
			Connection conn = MyConnect.getConnection();
			String sql = "SELECT * FROM doctor where "+type+"=?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1,value);
			ResultSet rs = pre.executeQuery();
			System.out.println("query xong find doctor");
			DoctorList lstDoc = new DoctorList();
			while(rs.next()) {
				Doctor a = new Doctor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8));
				System.out.println(a.toString());
				lstDoc.add(a);
			}
			return lstDoc;
		} catch (Exception e) {
			System.out.println("loi mysql -> getalldoctor");
			System.out.println(e);
			// TODO: handle exception
		}
		return new DoctorList();
	}
	
	public static int add(Doctor doctor) {
		try {
			System.out.println("add Doctor");
			Connection conn = MyConnect.getConnection();
			String sql = "INSERT INTO doctor (name,birthday,cmd,address,level,seniority,type) VALUES (?,?,?,?,?,?,?);";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, String.valueOf(doctor.getName()));
			pre.setString(2, String.valueOf(doctor.getBirthday()));
			pre.setString(3, String.valueOf(doctor.getCmd()));
			pre.setString(4, String.valueOf(doctor.getAddress()));
			pre.setString(5, String.valueOf(doctor.getLevel()));
			pre.setString(6, String.valueOf(doctor.getSeniority()));
			pre.setString(6, String.valueOf(doctor.getType()));
			int rs = pre.executeUpdate();
			if(rs == 0) {
				return 0;
			}else {
				return 1;
			}
		} catch (Exception e) {
			System.out.println("loi mysql -> add doctor");
			System.out.println(e);
			// TODO: handle exception
		}
		return 0;
	}
	
	public static int delete(int id) {
		try {
			System.out.println("delete Doctor");
			Connection conn = MyConnect.getConnection();
			String sql = "DELETE FROM doctor  WHERE iddoctor=?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, String.valueOf(id));
			int rs = pre.executeUpdate();
			if(rs == 0) {
				return 0;
			}else {
				return 1;
			}
		} catch (Exception e) {
			System.out.println("loi mysql -> delete doctor");
			System.out.println(e);
			// TODO: handle exception
		}
		return 0;
	}
	
	public static int update(int id,Doctor doctor) {
		try {
			System.out.println("update Doctor");
			Connection conn = MyConnect.getConnection();
			String sql = "UPDATE doctor SET name=?,birthday=?,cmd=?,address=?,level=?,seniority=?,type=? WHERE iddoctor=?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, String.valueOf(doctor.getName()));
			pre.setString(2, String.valueOf(doctor.getBirthday()));
			pre.setString(3, String.valueOf(doctor.getCmd()));
			pre.setString(4, String.valueOf(doctor.getAddress()));
			pre.setString(5, String.valueOf(doctor.getLevel()));
			pre.setString(6, String.valueOf(doctor.getSeniority()));
			pre.setString(7, String.valueOf(doctor.getType()));
			pre.setString(8, String.valueOf(id));
			int rs = pre.executeUpdate();
			if(rs == 0) {
				return 0;
			}else {
				return 1;
			}
		} catch (Exception e) {
			System.out.println("loi mysql -> update doctor");
			System.out.println(e);
			// TODO: handle exception
		}
		return 0;
	}
	
	public static DoctorList getDoctorHeal(String iddiseases) {
		try {
			Connection conn = MyConnect.getConnection();
			String sql = "SELECT doctor.* FROM ltwbs.doctordiseases \r\n"
					+ "inner join doctor on doctor.iddoctor = doctordiseases.iddoctor\r\n"
					+ "inner join diseases on diseases.iddiseases = doctordiseases.iddiseases\r\n"
					+ "where diseases.iddiseases = ? and doctor.type = 'active' and diseases.type = 'active' and doctordiseases.type = 'active';";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, String.valueOf(iddiseases));
			ResultSet rs = pre.executeQuery();
			System.out.println("query xong -- tim bac sy chua benh");
			DoctorList lstDoc = new DoctorList();
			while(rs.next()) {
				Doctor a = new Doctor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8));
				lstDoc.add(a);
			}
			return lstDoc;
		} catch (Exception e) {
			System.out.println("loi mysql -> tim bac sy chua benh");
			System.out.println(e);
			// TODO: handle exception
		}
		return new DoctorList();
	}
}
