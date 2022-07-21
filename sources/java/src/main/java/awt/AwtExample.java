package awt;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ForkJoinWorkerThread;

class AwtExample {
    public static void main(String[] args){
        Frame wnd=new Frame("Окно AWT");
        wnd.setSize(300,200);
        wnd.setLocation(500,400);
        wnd.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
        Button btn = new Button();
        btn.setLabel("OK");
        btn.setSize(100, 50);

        wnd.add(btn);
        wnd.setVisible(true);
    }
}
