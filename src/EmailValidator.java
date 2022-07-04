import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    /**
     * @param str which should be checked;
     * @return true - validate, false - not;
     */
    public boolean validate(String str) {
        Pattern email = Pattern.compile("([A-z0-9_-]+\\.)*[A-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}");
        Matcher checkEmail = email.matcher(str);
        if (!checkEmail.matches()) {
            throw new UserIncorrectException("Incorrect input");
        } else {
            return true;
        }
    }
}
