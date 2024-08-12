package com.clubconnect;

public class User {
            public String name, number, category, email, password;

        public User() {
            // Default constructor required for calls to DataSnapshot.getValue(User.class)
        }

        public User(String name, String number, String category, String email, String password) {
            this.name = name;
            this.number = number;
            this.category = category;
            this.email = email;
            this.password = password;
        }
    }