package org.mymediadb.api.ttdb.internal.model;

import java.util.Arrays;

class MiscModelUtils {
    static String[] splitByPipe(String input) {
        String[] splittedInput = input.split("\\|");
        return Arrays.copyOfRange(splittedInput, 1, splittedInput.length);
    }
}
