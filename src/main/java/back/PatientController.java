package back;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Patient;
import model.ResponseJson;
import mylist.PatientList;
import mysql.SqlPatient;

@RestController
public class PatientController {
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, path = "/patient")
	public String fun1() {
		ObjectMapper mapper = new ObjectMapper();
		PatientList a = SqlPatient.getAll();
		try {
			String Patients = mapper.writeValueAsString(a);
			ResponseJson resjson = new ResponseJson(200, "success", Patients);
			return mapper.writeValueAsString(resjson);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi cmnr");
			System.out.println(e);
		}
		return "{}";
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, path = "/patient")
	public String fun2(@RequestBody String objJson) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Patient Patient = mapper.readValue(objJson, Patient.class);
			System.out.println("in ra Patient");
			System.out.println(Patient.toString());
			int rs = SqlPatient.add(Patient);
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
	@RequestMapping(method = RequestMethod.DELETE, path = "/patient")
	public String fun3(@RequestParam String id) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			int rs = SqlPatient.delete(Integer.parseInt(id));
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
	@RequestMapping(method = RequestMethod.PUT, path = "/patient")
	public String fun4(@RequestParam String id, @RequestBody String body) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Patient Patient = mapper.readValue(body, Patient.class);
			int rs = SqlPatient.update(Integer.parseInt(id), Patient);
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
	@RequestMapping(method = RequestMethod.GET, path = "/patient/find")
	public String fun5(@RequestParam String type, @RequestParam String value) {
		ObjectMapper mapper = new ObjectMapper();
		PatientList a = SqlPatient.find(type, value);
		try {
			String Patients = mapper.writeValueAsString(a);
			ResponseJson resjson = new ResponseJson(200, "success", Patients);
			return mapper.writeValueAsString(resjson);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi cmnr");
			System.out.println(e);
		}
		return "{\"status\":\"400\"}";
	}
}
