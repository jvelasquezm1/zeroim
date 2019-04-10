package test.osdarTest.generic;

import java.util.HashSet;
import java.util.Set;

public interface StringOperations {

    String EMPTY = "";
    int INDEX_NOT_FOUND = -1;

    default boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }

    default boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs != null && (strLen = cs.length()) != 0) {
            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }

    default boolean isNotEmpty(final CharSequence cs) {
        return !isEmpty(cs);
    }

    default boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    default <T extends CharSequence> T defaultIfEmpty(T str, T defaultStr) {
        return isEmpty(str) ? defaultStr : str;
    }

    default String substringAfter(final String str, final String separator) {
        if (isEmpty(str)) {
            return str;
        }

        if (separator == null) {
            return EMPTY;
        }

        final int pos = str.indexOf(separator);

        if (pos == INDEX_NOT_FOUND) {
            return EMPTY;
        }

        return str.substring(pos + separator.length());
    }

    default String capitalizeWords(final String str) {
        if (isEmpty(str)) {
            return str;
        }
        final Set<Integer> delimiterSet = generateDelimiterSet(null);
        final int strLen = str.length();
        final int[] newCodePoints = new int[strLen];
        int outOffset = 0;

        boolean capitalizeNext = true;
        for (int index = 0; index < strLen;) {
            final int codePoint = str.codePointAt(index);

            if (delimiterSet.contains(codePoint)) {
                capitalizeNext = true;
                newCodePoints[outOffset++] = codePoint;
                index += Character.charCount(codePoint);
            } else if (capitalizeNext) {
                final int titleCaseCodePoint = Character.toTitleCase(codePoint);
                newCodePoints[outOffset++] = titleCaseCodePoint;
                index += Character.charCount(titleCaseCodePoint);
                capitalizeNext = false;
            } else {
                newCodePoints[outOffset++] = codePoint;
                index += Character.charCount(codePoint);
            }
        }
        return new String(newCodePoints, 0, outOffset);
    }

    default Set<Integer> generateDelimiterSet(final char[] delimiters) {
        final Set<Integer> delimiterHashSet = new HashSet<>();
        if (delimiters == null || delimiters.length == 0) {
            if (delimiters == null) {
                delimiterHashSet.add(Character.codePointAt(new char[] {' '}, 0));
            }

            return delimiterHashSet;
        }

        for (int index = 0; index < delimiters.length; index++) {
            delimiterHashSet.add(Character.codePointAt(delimiters, index));
        }
        return delimiterHashSet;
    }

}

