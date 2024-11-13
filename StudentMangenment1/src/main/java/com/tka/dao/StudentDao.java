package com.tka.dao;

import com.tka.entity.Student;
import com.tka.utility.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    // Create operation
    public boolean addStudent(Student student) {
        String query = "INSERT INTO students (roll_no, name, marks) VALUES (?, ?, ?)";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, student.getRollNo());
            statement.setString(2, student.getName());
            statement.setInt(3, student.getMarks());
            int result = statement.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Read operation (fetch all students)
    public List<Student> getAllStudents() {
        String query = "SELECT roll_no, name, marks FROM students";
        List<Student> students = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int rollNo = resultSet.getInt("roll_no");
                String name = resultSet.getString("name");
                int marks = resultSet.getInt("marks");
                students.add(new Student(rollNo, name, marks));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    // Update operation
    public boolean updateStudent(Student student) {
        String query = "UPDATE students SET name = ?, marks = ? WHERE roll_no = ?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, student.getName());
            statement.setInt(2, student.getMarks());
            statement.setInt(3, student.getRollNo());
            int result = statement.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete operation
    public boolean deleteStudent(int rollNo) {
        String query = "DELETE FROM students WHERE roll_no = ?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, rollNo);
            int result = statement.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
