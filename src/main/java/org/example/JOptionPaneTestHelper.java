package org.example;
import javax.swing.*;
public class JOptionPaneTestHelper {
    private static String message;

    public static String showMessageDialogCalledWith() {
        return message;
    }

    public static int showMessageDialog(Object message) {
        JOptionPaneTestHelper.message = message.toString();
        return 0;
    }
}

