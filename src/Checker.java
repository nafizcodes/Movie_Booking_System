import java.util.function.IntPredicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checker {

    public static boolean checkPassword(String password) {
        return password == null || !containsDigit(password) || !containsUpperCase(password) || !containsSpecialCharacter(password) || password.length() < 6;
    }

    private static boolean containsUpperCase(String str) {
        return contains(str, i -> Character.isLetter(i) && Character.isUpperCase(i));
    }

    private static boolean containsDigit(String str) {
        return contains(str, Character::isDigit);
    }

    private static boolean containsSpecialCharacter(String str) {
        Pattern pattern = Pattern.compile("[@#$%&*]");
        Matcher mat = pattern.matcher(str);
        return mat.find();
    }

    private static boolean contains(String str, IntPredicate predicate) {
        return str.chars().anyMatch(predicate);
    }

    public static boolean checkCard(long cardnumber){
        return !(String.valueOf(cardnumber).length() == 8); //assuming credit card number is 8digit
    }
}