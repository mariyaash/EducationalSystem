package com.example.uniproject.web;

import com.example.uniproject.domain.account.entity.Account;
import com.example.uniproject.domain.account.repository.AccountRepository;
import com.example.uniproject.domain.common.models.LoginCreateDTO;
import com.example.uniproject.domain.common.models.LoginSuccessDTO;
import com.example.uniproject.domain.student.models.StudentGetDTO;
import com.example.uniproject.domain.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping ("/mutual")
@Controller
@SessionAttributes(names = "accountId")
public class MutualController {
    private final AccountRepository accountRepository;
    private final StudentService studentService;

    @Autowired
    public MutualController(AccountRepository accountRepository, StudentService studentService) {
        this.accountRepository = accountRepository;
        this.studentService = studentService;
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("layout.html");
        modelAndView.addObject("view", "index.html");
        return modelAndView;
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<LoginSuccessDTO> create(@RequestBody  LoginCreateDTO loginCreateDTO, Model model) {
        Account account=accountRepository.findByEmailAndPassword(loginCreateDTO.getEmail(), loginCreateDTO.getPassword());
        if (account != null){
            model.addAttribute("accountId",account.getId());
            return ResponseEntity.ok(new LoginSuccessDTO("success"));
        } else {
            return ResponseEntity.ok(new LoginSuccessDTO("failed"));
        }
    }
    @GetMapping("/profile")
    public ResponseEntity<StudentGetDTO> getById(@SessionAttribute(name = "accountId",required = false) Long id) {
        if (id == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(studentService.findById(id));
    }
}
