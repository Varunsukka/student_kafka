//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.kafka.student.controller.Consumer;

import com.kafka.student.service.consumer.ConsumerService;
import java.util.List;
import java.util.Optional;

import com.kafka.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/kafka"})
public class ConsumerEndPoints {
    @Autowired
    private ConsumerService consumerService;
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students =consumerService.getAllStudents();
        return ResponseEntity.ok(students);
    }
    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") String id){
        Optional<Student> student=consumerService.getStudentById(id);
        return student.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
}
