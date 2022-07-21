package swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class CalculatorFrame extends JFrame{
    CalculatorFrame(){
        int w=270,h=240;
        setTitle("Калькулятор");
        setBounds(100,100,w,h);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        CalcPanel panel=new CalcPanel(w,h);
        add(panel);
        setResizable(false);
        setVisible(true);
    }
}
class CalcPanel extends JPanel{
    public JTextField TxtFld;
    private BtnAction BtnPressed;
    CalcPanel(int W,int H){
        int w=W/5,h=H/8,sx=w/5,sy=h/3;
        setLayout(null);
        setBorder(BorderFactory.createEtchedBorder());
        JTextField TxtFld=new JTextField();
        TxtFld.setHorizontalAlignment(JTextField.RIGHT);
        TxtFld.setBounds(sx,sy,2*sx+3*w,h);
        TxtFld.setEditable(false);
        add(TxtFld);
        BtnPressed=new BtnAction(TxtFld);
        String[] BtnTxt={
            "1","2","3","+","4","5","6","-",
            "7","8","9","/","0",".","=","*"};
        for(int i=0;i<BtnTxt.length;i++){
            addBtn(sx+(w+sx)*(i%4),(2*sy+h)+(sy+h)*(i/4),
                w,h,BtnTxt[i],BtnPressed);
        }
        JButton BtnC=new JButton("C");
        BtnC.setBounds(4*sx+3*w,sy,w,h);
        BtnC.addActionListener(BtnPressed);
        BtnC.setFocusPainted(false);
        BtnC.setForeground(Color.RED);
        add(BtnC);
    }
    void addBtn(int i,int j,int w,int h,
                String txt,
                ActionListener AcList){
        JButton b=new JButton(txt);
        b.setBounds(i,j,w,h);
        b.setFocusPainted(false);
        b.addActionListener(AcList);
        add(b);
    }
}
class BtnAction implements ActionListener{
    public JTextField TxtFld;
    private boolean start;
    private boolean point;
    private String cmd;
    private double result;
    private void onStart(){
        start=true;
        point=true;
        cmd="C";
        result=0;
        TxtFld.setText("0.0");
    }
    private void calc(){
        double x;
        x=Double.parseDouble(TxtFld.getText());
        switch (cmd) {
            case "*" -> result *= x;
            case "/" -> result /= x;
            case "-" -> result -= x;
            case "+" -> result += x;
            default -> result = x;
        }
        TxtFld.setText(Double.toString(result));
    }
    BtnAction(JTextField TxtFld){
        this.TxtFld=TxtFld;
        onStart();
    }
    public void actionPerformed(ActionEvent ae){
        String str=ae.getActionCommand();
        if(str.equals("C")){
            onStart();
            return;
        }
        if(str.equals("+")|str.equals("-")|str.equals("*")|
            str.equals("/")|str.equals("=")){
            calc();
            cmd=str;
            start=true;
            point=true;
            return;
        }
        
        if(start){
            if(str.equals(".")){
                TxtFld.setText("0.");
                point=false;
            }
            else{
                TxtFld.setText(str);
            }
            start=false;
            return;
        }
        else{
            if(str.equals(".")){
                str=point?str:"";
                point=false;}
            if(TxtFld.getText().equals("0")&!str.equals(".")){
                TxtFld.setText(str);
            }
            else{
                TxtFld.setText(TxtFld.getText()+str);
            }
        }
    }
}
class  Calculator {
    public static void main(String[] args){
        new CalculatorFrame();
    }
}
