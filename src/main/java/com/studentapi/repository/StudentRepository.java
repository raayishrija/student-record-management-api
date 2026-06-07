package com.studentapi.repository;

import com.studentapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByDepartment(String department);
    List<Student> findByCgpaGreaterThanEqual(double cgpa);
    List<Student> findByNameContainingIgnoreCase(String name);
}