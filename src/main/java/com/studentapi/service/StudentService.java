package com.studentapi.service;

import com.studentapi.exception.StudentNotFoundException;
import com.studentapi.model.Student;
import com.studentapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student student = getStudentById(id);
        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());
        student.setDepartment(studentDetails.getDepartment());
        student.setCgpa(studentDetails.getCgpa());
        student.setPhone(studentDetails.getPhone());
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        studentRepository.delete(student);
    }

    public List<Student> getStudentsByDepartment(String department) {
        return studentRepository.findByDepartment(department);
    }

    public List<Student> getStudentsByCgpa(double cgpa) {
        return studentRepository.findByCgpaGreaterThanEqual(cgpa);
    }

    public List<Student> searchStudentsByName(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }
}