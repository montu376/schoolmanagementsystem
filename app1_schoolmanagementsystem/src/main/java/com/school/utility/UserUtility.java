package com.school.utility;

public class UserUtility {

    public static String generateStudentRollNumber() {
        return "STU-" + (int)(Math.random() * 100000); // e.g. STU-45678
    }

    public static String generateTeacherId() {
        return "TEA-" + (int)(Math.random() * 100000); // e.g. TEA-12345
    }
}
