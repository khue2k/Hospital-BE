package back;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Medicine;
import model.ResponseJson;
import mylist.MedicineList;
import mysql.SqlMedicine;

@RestController
public class MedicineController {
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, path = "/medicine")
	public String fun1() {
		ObjectMapper mapper = new ObjectMapper();
		MedicineList a = SqlMedicine.getAll();
		try {
			String Medicines = mapper.writeValueAsString(a);
			ResponseJson resjson = new ResponseJson(200, "success", Medicines);
			return mapper.writeValueAsString(resjson);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi ");
			System.out.println(e);
		}
		return "{}";
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, path = "/medicine")
	public String fun2(@RequestBody String objJson) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Medicine Medicine = mapper.readValue(objJson, Medicine.class);
			System.out.println("in ra Medicine");
			System.out.println(Medicine.toString());
			int rs = SqlMedicine.add(Medicine);
			if (rs == 0) {
				ResponseJson resjson = new ResponseJson(400, "fail", String.valueOf(rs));
				return mapper.writeValueAsString(resjson);
			} else {
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
	@RequestMapping(method = RequestMethod.DELETE, path = "/medicine")
	public String fun3(@RequestParam String id) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			int rs = SqlMedicine.delete(Integer.parseInt(id));
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
	@RequestMapping(method = RequestMethod.PUT, path = "/medicine")
	public String fun4(@RequestParam String id, @RequestBody String body) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Medicine Medicine = mapper.readValue(body, Medicine.class);
			int rs = SqlMedicine.update(Integer.parseInt(id), Medicine);
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
	@RequestMapping(method = RequestMethod.GET, path = "/medicine/find")
	public String fun5(@RequestParam String type, @RequestParam String value) {
		ObjectMapper mapper = new ObjectMapper();
		MedicineList a = SqlMedicine.find(type, value);
		try {
			String Medicines = mapper.writeValueAsString(a);
			ResponseJson resjson = new ResponseJson(200, "success", Medicines);
			return mapper.writeValueAsString(resjson);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi ");
			System.out.println(e);
		}
		return "{\"status\":\"400\"}";
	}
}
