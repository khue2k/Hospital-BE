package back;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Medicineperexam;
import model.ResponseJson;
import mylist.MedicineperexamList;
import mysql.SqlMedicineperexam;

@RestController
public class MedicineperexamController {
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, path = "/medicineperexam")
	public String fun1() {
		ObjectMapper mapper = new ObjectMapper();
		MedicineperexamList a = SqlMedicineperexam.getAll();
		try {
			String Medicineperexams = mapper.writeValueAsString(a);
			ResponseJson resjson = new ResponseJson(200, "success", Medicineperexams);
			return mapper.writeValueAsString(resjson);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi cmnr");
			System.out.println(e);
		}
		return "{}";
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, path = "/medicineperexam")
	public String fun2(@RequestBody String objJson) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Medicineperexam Medicineperexam = mapper.readValue(objJson, Medicineperexam.class);
			System.out.println("in ra Medicineperexam");
			System.out.println(Medicineperexam.toString());
			int rs = SqlMedicineperexam.add(Medicineperexam);
			if (rs == 0) {
				ResponseJson resjson = new ResponseJson(400, "fail", String.valueOf(rs));
				return mapper.writeValueAsString(resjson);
			} else {
				ResponseJson resjson = new ResponseJson(200, "success", String.valueOf(rs));
				return mapper.writeValueAsString(resjson);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi cmnr");
			System.out.println(e);
		}
		return "{\"status\":\"400\"}";
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.DELETE, path = "/medicineperexam")
	public String fun3(@RequestParam String id) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			int rs = SqlMedicineperexam.delete(Integer.parseInt(id));
			if (rs == 0) {
				ResponseJson resjson = new ResponseJson(400, "fail", String.valueOf(rs));
				return mapper.writeValueAsString(resjson);
			} else {
				ResponseJson resjson = new ResponseJson(200, "success", String.valueOf(rs));
				return mapper.writeValueAsString(resjson);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "{\"status\":\"400\"}";
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.PUT, path = "/medicineperexam")
	public String fun4(@RequestParam String id, @RequestBody String body) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Medicineperexam Medicineperexam = mapper.readValue(body, Medicineperexam.class);
			int rs = SqlMedicineperexam.update(Integer.parseInt(id), Medicineperexam);
			if (rs == 0) {
				ResponseJson resjson = new ResponseJson(400, "fail", String.valueOf(rs));
				return mapper.writeValueAsString(resjson);
			} else {
				ResponseJson resjson = new ResponseJson(200, "success", String.valueOf(rs));
				return mapper.writeValueAsString(resjson);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "{\"status\":\"400\"}";
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, path = "/medicineperexam/find")
	public String fun5(@RequestParam String type, @RequestParam String value) {
		ObjectMapper mapper = new ObjectMapper();
		MedicineperexamList a = SqlMedicineperexam.find(type, value);
		try {
			String Medicineperexams = mapper.writeValueAsString(a);
			ResponseJson resjson = new ResponseJson(200, "success", Medicineperexams);
			return mapper.writeValueAsString(resjson);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi cmnr");
			System.out.println(e);
		}
		return "{\"status\":\"400\"}";
	}
}
