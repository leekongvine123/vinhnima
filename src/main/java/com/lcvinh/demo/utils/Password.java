package com.lcvinh.demo.utils;

import org.mindrot.jbcrypt.BCrypt;

public class Password {

    // Hash the password using bcrypt
    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    // Check if the password matches the hashed password
    public static boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
