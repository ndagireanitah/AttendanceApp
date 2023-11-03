package com.example.attendanceapp;

public class student {
    public class Student {
        private String studentName;
        private String studentNumber;
        private String classStream;
        private String term;

        public Student() {
            // Default constructor required for calls to DataSnapshot.getValue(Student.class)
        }

        public Student(String studentName, String studentNumber, String classStream, String term) {
            this.studentName = studentName;
            this.studentNumber = studentNumber;
            this.classStream = classStream;
            this.term = term;
        }

        public String getStudentName() {
            return studentName;
        }

        public String getStudentNumber() {
            return studentNumber;
        }

        public String getClassStream() {
            return classStream;
        }

        public String getTerm() {
            return term;
        }
    }}

