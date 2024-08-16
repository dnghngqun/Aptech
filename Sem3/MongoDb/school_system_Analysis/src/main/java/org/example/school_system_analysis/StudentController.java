package org.example.school_system_analysis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/top")
    public List<Student> getTopStudents(){
        return studentService.getTopStudents();
    }

    @GetMapping("/date/year/{year}/month/{month}")
    public List<Student> getStudentByYearAndMonth(@PathVariable String year, @PathVariable String month){
        return studentService.getByMonthAndYear(Integer.parseInt(month), Integer.parseInt(year));
    }
}
