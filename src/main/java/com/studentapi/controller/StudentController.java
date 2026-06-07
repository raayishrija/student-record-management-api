package com.studentapi.controller;

import com.studentapi.model.Student;
import com.studentapi.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
        return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @Valid @RequestBody Student student) {
        return ResponseEntity.ok(studentService.updateStudent(id, student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully!");
    }

    @GetMapping("/department/{department}")
    public ResponseEntity<List<Student>> getByDepartment(@PathVariable String department) {
        return ResponseEntity.ok(studentService.getStudentsByDepartment(department));
    }

    @GetMapping("/cgpa/{cgpa}")
    public ResponseEntity<List<Student>> getByCgpa(@PathVariable double cgpa) {
        return ResponseEntity.ok(studentService.getStudentsByCgpa(cgpa));
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<Student>> searchByName(@PathVariable String name) {
        return ResponseEntity.ok(studentService.searchStudentsByName(name));
    }
}