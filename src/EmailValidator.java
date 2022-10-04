import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    private final String PATTERN_FIND_EMAIL = "([A-z0-9_-]+\\.)*[A-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}";

    /**
     * @param str which should be checked;
     * @return true - validate, false - not;
     */
    public boolean validate(String str) {
        Pattern email = Pattern.compile(PATTERN_FIND_EMAIL);
        Matcher checkEmail = email.matcher(str);
        if (!checkEmail.matches()) {
            throw new UserIncorrectException("Email " + str + " is incorrect");
        } else {
            return true;
        }
    }
}
