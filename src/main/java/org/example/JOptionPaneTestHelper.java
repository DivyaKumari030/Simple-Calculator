package org.example;

public class JOptionPaneTestHelper {
    private static String message;

    private JOptionPaneTestHelper() {
        // Private constructor to hide the implicit public one
    }

    public static String showMessageDialogCalledWith() {
        return message;
    }

    public static int showMessageDialog(Object message) {
        JOptionPaneTestHelper.message = message.toString();
        return 0;
    }
}


