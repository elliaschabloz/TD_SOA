package fr.insa.mas.studentListService.ressources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import fr.insa.mas.studentListService.model.Evaluation;
import fr.insa.mas.studentListService.model.Student;
import fr.insa.mas.studentListService.model.StudentIDList;
import fr.insa.mas.studentListService.model.StudentInfos;

@RestController
@RequestMapping("/students")
public class StudentListRessource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/ids/{idSpeciality}")
	public List<Student> getStudents(@PathVariable("idSpeciality") String speciality) {
		StudentIDList studentsID = new StudentIDList();
		studentsID.addStudentToList(0);
		studentsID.addStudentToList(1);
		studentsID.addStudentToList(2);
		studentsID.addStudentToList(3);
		
		//RestTemplate restTemplate = new RestTemplate();
		int i = 0;
		List<Student> listStudents = new ArrayList<Student>();
		while(i<studentsID.getStudentList().size()) {
			StudentInfos studentInfos = restTemplate.getForObject("http://studentInfoService/student/"+i, StudentInfos.class);
			Evaluation eval = restTemplate.getForObject("http://studentEvalService/evaluation/"+i, Evaluation.class);
			listStudents.add(new Student(i,studentInfos.getFirstName(), studentInfos.getLastName(), eval.getAverage()));
			i++;
		}
		return listStudents;
	}
	
}

