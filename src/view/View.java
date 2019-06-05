/*
 * Copyright (c)
 */

package view;

/**
 * Class created for a training
 * @version v.1.1 05 Jun 2019
 * @author Aleksey Muratov
 */
public class View {
    public static final String PROMPT_MRSSAGE = "Enter your ";
    public static final String COLON_SIGN = ":";
    public static final char NEW_LINE_SIGN = '\n';
    public static final String RESULT_NESSAGE = "Your entering:";
    public static final String NOT_OK_MESSAGE
            = "It is wrong. Try again...";

    public void printMessage(String mess) {
        System.out.print(mess);
    }

}
