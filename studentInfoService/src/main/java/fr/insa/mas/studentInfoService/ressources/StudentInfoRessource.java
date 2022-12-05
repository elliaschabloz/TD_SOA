package fr.insa.mas.studentInfoService.ressources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.mas.studentInfoService.model.StudentInfos;

@RestController
@RequestMapping("/student")
public class StudentInfoRessource {

	@GetMapping("/{idStudent}")
	public StudentInfos getInfoStudent(@PathVariable("idStudent") int id) {
		List<StudentInfos> studentsInfos = Arrays.asList(
				new StudentInfos(0,"Demain","Haimorty","Erik"),
				new StudentInfos(1,"L'autre jour","Mie","Hanne"),
				new StudentInfos(2,"Hier","Reujeument","Emma"),
				new StudentInfos(3,"Bientôt","Faimal","Chama")
				);
		System.out.println("Cold!");
		return studentsInfos.get(id);		
	}
}
