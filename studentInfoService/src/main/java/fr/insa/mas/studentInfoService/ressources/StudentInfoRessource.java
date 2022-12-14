package fr.insa.mas.studentInfoService.ressources;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.mas.studentInfoService.model.StudentInfos;

@RestController
@RequestMapping("/student")
public class StudentInfoRessource {
	
	@Value("${db.uri}")
	private String DBuri;
	@Value("${db.name}")
	private String DBName;
	@Value("${db.login}")
	private String DBLogin;
	@Value("${db.pwd}")
	private String DBPwd;

	@GetMapping("/{idStudent}")
	public StudentInfos getInfoStudent(@PathVariable("idStudent") int id) {
		List<StudentInfos> studentsInfos = Arrays.asList(
				new StudentInfos(0,"Demain","Haimorty","Erik"),
				new StudentInfos(1,"L'autre jour","Mie","Hanne"),
				new StudentInfos(2,"Hier","Reujeument","Emma"),
				new StudentInfos(3,"Bientôt","Faimal","Chama")
				);
		System.out.println("Connection a la BDD :" + this.getDBName() + " a l'URI :"
				+ this.getDBuri());
		
		return studentsInfos.get(id);		
	}

	@GetMapping("/dburi")
	public String getDBuri() {
		return DBuri;
	}

	public void setDBuri(String dBuri) {
		DBuri = dBuri;
	}

	@GetMapping("/dbName")
	public String getDBName() {
		return DBName;
	}

	public void setDBName(String dBName) {
		DBName = dBName;
	}

	@GetMapping("/dbLogin")
	public String getDBLogin() {
		return DBLogin;
	}

	public void setDBLogin(String dBLogin) {
		DBLogin = dBLogin;
	}

	@GetMapping("/dbPwd")
	public String getDBPwd() {
		return DBPwd;
	}

	public void setDBPwd(String dBPwd) {
		DBPwd = dBPwd;
	}

	
	
	
}
