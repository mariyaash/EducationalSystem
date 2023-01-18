package com.example.uniproject.web;

import com.example.uniproject.domain.mentor.models.MentorCreateDTO;
import com.example.uniproject.domain.mentor.models.MentorGetDTO;
import com.example.uniproject.domain.mentor.service.MentorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api/mentor")
public class MentorController {
    private final MentorService mentorService;

    @Autowired
    public MentorController(MentorService mentorService) {
        this.mentorService = mentorService;
    }

    @PostMapping
    public ResponseEntity<MentorGetDTO> create(@Valid @RequestBody MentorCreateDTO mentorCreateDTO) {
        return ResponseEntity.ok(mentorService.create(mentorCreateDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MentorGetDTO> get(@PathVariable Long id) {
        return ResponseEntity.ok(mentorService.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MentorGetDTO> update(Long id, MentorCreateDTO mentorCreateDTO) {
        return ResponseEntity.ok(mentorService.update(id, mentorCreateDTO));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}

