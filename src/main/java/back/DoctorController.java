package back;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Doctor;
import model.ResponseJson;
import mylist.DoctorList;
import mysql.SqlDoctor;

@RestController
public class DoctorController {
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, path = "/doctor")
	public String fun1() {
		ObjectMapper mapper = new ObjectMapper();
		DoctorList a = SqlDoctor.getAll();
		try {
			String doctors = mapper.writeValueAsString(a);
			ResponseJson resjson = new ResponseJson(200, "success", doctors);
			return mapper.writeValueAsString(resjson);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi ");
			System.out.println(e);
		}
		return "{}";
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, path = "/doctorheal")
	public String fun2(@RequestParam String id) {
		ObjectMapper mapper = new ObjectMapper();
		DoctorList a = SqlDoctor.getDoctorHeal(id);
		try {
			String doctors = mapper.writeValueAsString(a);
			ResponseJson resjson = new ResponseJson(200, "success", doctors);
			return mapper.writeValueAsString(resjson);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi ");
			System.out.println(e);
		}
		return "{}";
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, path = "/doctor")
	public String fun3(@RequestBody String objJson) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Doctor doctor = mapper.readValue(objJson, Doctor.class);
			System.out.println("in ra doctor");
			System.out.println(doctor.toString());
			int rs = SqlDoctor.add(doctor);
			if(rs == 0) {
				ResponseJson resjson = new ResponseJson(400, "fail", String.valueOf(rs));
				return mapper.writeValueAsString(resjson);
			}else {
				ResponseJson resjson = new ResponseJson(200, "success", String.valueOf(rs));
				return mapper.writeValueAsString(resjson);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi ");
			System.out.println(e);
		}
		return "{\"status\":\"400\"}";
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.DELETE, path = "/doctor")
	public String fun4(@RequestParam String id) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			int rs = SqlDoctor.delete(Integer.parseInt(id));
			if(rs == 0) {
				ResponseJson resjson = new ResponseJson(400, "fail", String.valueOf(rs));
				return mapper.writeValueAsString(resjson);
			}else {
				ResponseJson resjson = new ResponseJson(200, "success", String.valueOf(rs));
				return mapper.writeValueAsString(resjson);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "{\"status\":\"400\"}";
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.PUT, path = "/doctor")
	public String fun5(@RequestParam String id, @RequestBody String body) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Doctor doctor = mapper.readValue(body, Doctor.class);
			int rs = SqlDoctor.update(Integer.parseInt(id), doctor);
			if(rs == 0) {
				ResponseJson resjson = new ResponseJson(400, "fail", String.valueOf(rs));
				return mapper.writeValueAsString(resjson);
			}else {
				ResponseJson resjson = new ResponseJson(200, "success", String.valueOf(rs));
				return mapper.writeValueAsString(resjson);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "{\"status\":\"400\"}";
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, path = "/doctor/find")
	public String fun6(@RequestParam String type, @RequestParam String value) {
		ObjectMapper mapper = new ObjectMapper();
		DoctorList a = SqlDoctor.find(type, value);
		try {
			String doctors = mapper.writeValueAsString(a);
			ResponseJson resjson = new ResponseJson(200, "success", doctors);
			return mapper.writeValueAsString(resjson);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi ");
			System.out.println(e);
		}
		return "{\"status\":\"400\"}";
	}
}
