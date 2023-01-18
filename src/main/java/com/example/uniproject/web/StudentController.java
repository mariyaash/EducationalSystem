package com.example.uniproject.web;

import com.example.uniproject.domain.student.models.StudentCreateDTO;
import com.example.uniproject.domain.student.models.StudentGetDTO;
import com.example.uniproject.domain.student.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@SessionAttributes("accountId")
@RequestMapping("/api/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentGetDTO> create(@Valid @RequestBody StudentCreateDTO studentCreateDTO) {
        return ResponseEntity.ok(studentService.create(studentCreateDTO));
    }

    /*  @GetMapping("/{id}")
      public ModelAndView viewMentor(@PathVariable Long id, ModelAndView modelAndView) {
          StudentGetDTO student = studentService.findById(id);
          modelAndView.setViewName("fragments/layout");
          //modelAndView.addObject("view", "views/students/student-details.html");
          modelAndView.addObject("student", student);
          return modelAndView;
      }

     */
    @GetMapping("/profile")
    public ResponseEntity<StudentGetDTO> getById(@SessionAttribute(name = "accountId",required = false) Long id) {
        if (id == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(studentService.findById(id));
    }

    @GetMapping
    public ResponseEntity<Page<StudentGetDTO>> getAll(Pageable pageable) {
        return ResponseEntity.ok(studentService.getAll(pageable));
    }

    @PutMapping
    public ResponseEntity<StudentGetDTO> update(Long id, StudentCreateDTO studentCreateDTO) {
        return ResponseEntity.ok(studentService.update(id, studentCreateDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}
