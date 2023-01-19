package com.express.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zzy
 */
public class RegExpressionCheck {
    static final Pattern PATTERN = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$");
    public static boolean checkPas(String pas) {
        Matcher matcher = PATTERN.matcher(pas);
        return matcher.matches();
    }
}
