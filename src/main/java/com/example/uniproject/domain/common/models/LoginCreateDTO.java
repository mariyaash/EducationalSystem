package com.example.uniproject.domain.common.models;

import com.example.uniproject.infrastructure.security.constraint.ValidPassword;
import jakarta.validation.constraints.Email;

public class LoginCreateDTO {
        private String email;

        private String password;

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }
}

