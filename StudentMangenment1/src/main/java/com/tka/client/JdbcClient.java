package com.tka.client;

import com.tka.controller.StudentController;

public class JdbcClient {
    public static void main(String[] args) {
        StudentController controller = new StudentController();
        controller.handleUserInput();
    }
}
