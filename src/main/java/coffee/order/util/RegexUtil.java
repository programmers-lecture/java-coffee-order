package coffee.order.util;

import java.util.regex.Pattern;

public class RegexUtil {

    public static final Pattern REGEX_PHONE_NUMBER_FORM_VALIDATOR =
            Pattern.compile("^[0-9]{3}-[0-9]{4}-[0-9]{4}$");

    public static final Pattern REGEX_SELECT_MENU_FOR_COUPON_FORM_VALIDATOR =
            Pattern.compile("^[0-9]*-[0-9]*$");

    public static final Pattern REGEX_SELECT_MENU_FORM_VALIDATOR =
            Pattern.compile("^[0-9]{1,3}-[0-9]{1,3}, [0-9]{1,10}$");

    public static final Pattern REGEX_YES_OR_NO_FORM_VALIDATOR =
            Pattern.compile("^[1|2]$");

    public static final Pattern REGEX_CUSTOMER_OR_BARISTA_FORM_VALIDATOR =
            Pattern.compile("^[1|2]$");

    public static final String END = "";

    public static boolean checkFormValid(Pattern pattern, String form) {
        if (form.equals(END)) return true;
        return pattern.matcher(form).find();
    }

}
