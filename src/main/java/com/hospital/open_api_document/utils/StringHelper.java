package com.hospital.open_api_document.utils;

public class StringHelper {
    public static String showEscapeDoubleQuote(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder escaped = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '\"')
                escaped.append("\\\"");
            else
                escaped.append(c);
        }
        return escaped.toString();
    }

    public static String doNotShowEscapeDoubleQuote(String str) {
        if (str == null) {
            return null;
        }
        return str.replace("\\\"", "\"");
    }
}
