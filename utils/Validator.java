package fa.training.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class Validator {
    
    // Email validation pattern
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
    );
    
    // Date format for dd/MM/yyyy
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    
    /**
     * Validates email format
     * @param email email to validate
     * @return true if valid email format, false otherwise
     */
    public static boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email.trim()).matches();
    }
    
    /**
     * Validates date format (dd/MM/yyyy)
     * @param dateStr date string to validate
     * @return true if valid date format, false otherwise
     */
    public static boolean isValidDateFormat(String dateStr) {
        if (dateStr == null || dateStr.trim().isEmpty()) {
            return false;
        }
        
        try {
            DATE_FORMAT.setLenient(false);
            DATE_FORMAT.parse(dateStr.trim());
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    
    /**
     * Parses date string to Date object
     * @param dateStr date string in dd/MM/yyyy format
     * @return Date object or null if invalid format
     */
    public static Date parseDate(String dateStr) {
        if (!isValidDateFormat(dateStr)) {
            return null;
        }
        
        try {
            DATE_FORMAT.setLenient(false);
            return DATE_FORMAT.parse(dateStr.trim());
        } catch (ParseException e) {
            return null;
        }
    }
    
    /**
     * Validates mark range (0 to 10)
     * @param mark mark to validate
     * @return true if mark is in valid range, false otherwise
     */
    public static boolean isValidMark(double mark) {
        return mark >= 0 && mark <= 10;
    }
    
    /**
     * Formats date to string
     * @param date Date object to format
     * @return formatted date string or null if date is null
     */
    public static String formatDate(Date date) {
        if (date == null) {
            return null;
        }
        return DATE_FORMAT.format(date);
    }
} 