package back;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.DoctorDiseases;
import model.ResponseJson;
import mylist.DoctorDiseasesList;
import mysql.SqlDoctorDiseases;

@RestController
public class DoctorDiseasesController {
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, path = "/doctordiseases")
	public String fun1() {
		ObjectMapper mapper = new ObjectMapper();
		DoctorDiseasesList a = SqlDoctorDiseases.getAll();
		try {
			String DoctorDiseasess = mapper.writeValueAsString(a);
			ResponseJson resjson = new ResponseJson(200, "success", DoctorDiseasess);
			return mapper.writeValueAsString(resjson);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi cmnr");
			System.out.println(e);
		}
		return "{}";
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, path = "/doctordiseases")
	public String fun2(@RequestBody String objJson) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			DoctorDiseases DoctorDiseases = mapper.readValue(objJson, DoctorDiseases.class);
			System.out.println("in ra DoctorDiseases");
			System.out.println(DoctorDiseases.toString());
			int rs = SqlDoctorDiseases.add(DoctorDiseases);
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
	@RequestMapping(method = RequestMethod.DELETE, path = "/doctordiseases")
	public String fun3(@RequestParam String id) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			int rs = SqlDoctorDiseases.delete(Integer.parseInt(id));
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
	@RequestMapping(method = RequestMethod.PUT, path = "/doctordiseases")
	public String fun4(@RequestParam String id, @RequestBody String body) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			DoctorDiseases DoctorDiseases = mapper.readValue(body, DoctorDiseases.class);
			int rs = SqlDoctorDiseases.update(Integer.parseInt(id), DoctorDiseases);
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
	@RequestMapping(method = RequestMethod.GET, path = "/doctordiseases/find")
	public String fun5(@RequestParam String type, @RequestParam String value) {
		ObjectMapper mapper = new ObjectMapper();
		DoctorDiseasesList a = SqlDoctorDiseases.find(type, value);
		try {
			String DoctorDiseasess = mapper.writeValueAsString(a);
			ResponseJson resjson = new ResponseJson(200, "success", DoctorDiseasess);
			return mapper.writeValueAsString(resjson);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi cmnr");
			System.out.println(e);
		}
		return "{\"status\":\"400\"}";
	}
}
