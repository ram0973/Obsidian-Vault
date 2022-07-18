package swing;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class FlatLafIntellijDemo {
    public static void main(String[] args) {
        FlatLaf.setup(new FlatIntelliJLaf());
        String txt, str;
        txt = showInputDialog("Введите текст:");
        int size = txt.length();
        char A = txt.charAt(0);
        char B = txt.charAt(size - 1);
        str = "Текст: " + txt + "\n";
        str += "Символов в тексте: " + size + "\n";
        str += "Первый символ: " + A + "\n";
        str += "Последний символ: " + B;
        showMessageDialog(null, str);


    }
}
