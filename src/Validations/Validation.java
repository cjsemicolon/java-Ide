package Validations;

//P.nwankwo@native.semicolon.africa
//Email validation
//
//Password validation Between 8 and 16 characters
//No spaces
//one of these special characters(@_+#)

//at lease one digit

public class Validation {
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-z]\\.[a-z]+@native\\.semicolon\\.africa$";
        return email.matches(emailRegex);
    }

    public static  boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[0-9])(?=.*[@_+#])(?=\\S+$).{8,16}$";
        return password.matches(passwordRegex);

    }



}
