package com.example.exostu.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exostu.document.Student;
import com.example.exostu.dto.SchoolDto;
import com.example.exostu.dto.StudentDto;
import com.example.exostu.repository.StudentRepository;
import com.example.exostu.service.SchoolService;

@RestController
//@RequestMapping("/")
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SchoolService schoolService;

    // 🔹 Récupérer tous les étudiants
    @GetMapping
    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll().stream().map(student -> {
            SchoolDto school = schoolService.getSchoolById(student.getSchool_id().toString());
            return new StudentDto(student.getId(), student.getName(), student.getAge(), student.getGenre(), school);
        }).collect(Collectors.toList());
    }

    // 🔹 Récupérer un étudiant par ID
    @GetMapping("/{_id}")
    public Optional<StudentDto> getStudentById(@PathVariable("_id") String id) {
        return studentRepository.findById(id).map(student -> {
            SchoolDto school = schoolService.getSchoolById(student.getSchool_id().toString());
            return new StudentDto(student.getId(), student.getName(), student.getAge(), student.getGenre(), school);
        });
    }

    // 🔹 Ajouter un étudiant
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    // 🔹 Mettre à jour un étudiant
    @PutMapping("/{_id}")
    public Student updateStudent(@PathVariable String id, @RequestBody Student studentDetails) {
        return studentRepository.findById(id).map(student -> {
            student.setName(studentDetails.getName());
            student.setAge(studentDetails.getAge());
            student.setGenre(studentDetails.getGenre());
            student.setSchool_id(studentDetails.getSchool_id());
            return studentRepository.save(student);
        }).orElseThrow(() -> new RuntimeException("Étudiant non trouvé avec l'ID : " + id));
    }

    // 🔹 Supprimer un étudiant
    @DeleteMapping("/{_id}")
    public void deleteStudent(@PathVariable String id) {
        studentRepository.deleteById(id);
    }
}
