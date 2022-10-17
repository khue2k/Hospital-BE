package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Examination;
import mylist.ExaminationList;

public class SqlExamination {
	public static ExaminationList getAll() {
		try {
			Connection conn = MyConnect.getConnection();
			String sql = "SELECT * FROM examination";
			PreparedStatement pre = conn.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			System.out.println("query xong");
			ExaminationList lstDoc = new ExaminationList();
			while (rs.next()) {
				Examination a = new Examination(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7));
				lstDoc.add(a);
			}
			return lstDoc;
		} catch (Exception e) {
			System.out.println("loi mysql -> getallExamination");
			System.out.println(e);
			// TODO: handle exception
		}
		return new ExaminationList();
	}

	public static ExaminationList find(String type, String value) {
		try {
			System.out.println("tim Examination");
			Connection conn = MyConnect.getConnection();
			String sql = "SELECT * FROM examination where " + type + "=?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, value);
			ResultSet rs = pre.executeQuery();
			System.out.println("query xong find Examination");
			ExaminationList lstDoc = new ExaminationList();
			while (rs.next()) {
				Examination a = new Examination(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7));
				System.out.println(a.toString());
				lstDoc.add(a);
			}
			return lstDoc;
		} catch (Exception e) {
			System.out.println("loi mysql -> getallExamination");
			System.out.println(e);
			// TODO: handle exception
		}
		return new ExaminationList();
	}

	public static int add(Examination Examination) {
		try {
			System.out.println("add Examination");
			Connection conn = MyConnect.getConnection();
			String sql = "INSERT INTO examination (iddoctordiseases,idnurse,idpatient,dayin,dayout,type) VALUES (?,?,?,?,?,?);";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, String.valueOf(Examination.getIddoctordiseases()));
			pre.setString(2, String.valueOf(Examination.getIdnurse()));
			pre.setString(3, String.valueOf(Examination.getIdpatient()));
			pre.setString(4, String.valueOf(Examination.getDayin()));
			pre.setString(5, String.valueOf(Examination.getDayout()));
			pre.setString(6, String.valueOf(Examination.getType()));
			int rs = pre.executeUpdate();
			if (rs == 0) {
				return 0;
			} else {
				return 1;
			}
		} catch (Exception e) {
			System.out.println("loi mysql -> add Examination");
			System.out.println(e);
			// TODO: handle exception
		}
		return 0;
	}

	public static int delete(int id) {
		try {
			System.out.println("delete Examination");
			Connection conn = MyConnect.getConnection();
			String sql = "DELETE FROM examination  WHERE idExamination=?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, String.valueOf(id));
			int rs = pre.executeUpdate();
			if (rs == 0) {
				return 0;
			} else {
				return 1;
			}
		} catch (Exception e) {
			System.out.println("loi mysql -> delete Examination");
			System.out.println(e);
			// TODO: handle exception
		}
		return 0;
	}

	public static int update(int id, Examination Examination) {
		try {
			System.out.println("update Examination");
			Connection conn = MyConnect.getConnection();
			String sql = "UPDATE examination SET iddoctordiseases=?,idnurse=?,idpatient=?,dayin=?,dayout=?,type=? WHERE idexamination=?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, String.valueOf(Examination.getIddoctordiseases()));
			pre.setString(2, String.valueOf(Examination.getIdnurse()));
			pre.setString(3, String.valueOf(Examination.getIdpatient()));
			pre.setString(4, String.valueOf(Examination.getDayin()));
			pre.setString(5, String.valueOf(Examination.getDayout()));
			pre.setString(6, String.valueOf(Examination.getType()));
			pre.setString(7, String.valueOf(id));
			int rs = pre.executeUpdate();
			if (rs == 0) {
				return 0;
			} else {
				return 1;
			}
		} catch (Exception e) {
			System.out.println("loi mysql -> update Examination");
			System.out.println(e);
			// TODO: handle exception
		}
		return 0;
	}
	
	public static ExaminationList getExamOfDoctor(String iddoctor) {
		try {
			Connection conn = MyConnect.getConnection();
			String sql = "SELECT examination.* FROM ltwbs.examination\r\n"
					+ "inner join doctordiseases on doctordiseases.iddoctordiseases = examination.iddoctordiseases\r\n"
					+ "where doctordiseases.iddoctor = ?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, String.valueOf(iddoctor));
			ResultSet rs = pre.executeQuery();
			System.out.println("query xong");
			ExaminationList lstDoc = new ExaminationList();
			while (rs.next()) {
				Examination a = new Examination(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7));
				lstDoc.add(a);
			}
			return lstDoc;
		} catch (Exception e) {
			System.out.println("loi mysql -> get exam of doctor");
			System.out.println(e);
			// TODO: handle exception
		}
		return new ExaminationList();
	}
}
