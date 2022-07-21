package awt;

import java.awt.*;
import java.awt.event.*;

class PlotFrame extends Frame {

    PlotFrame(int H, int W) {

        setTitle("График функции");

        setBounds(100, 50, W, H);

        setBackground(Color.GRAY);

        setLayout(null);

        Font f = new Font("Arial", Font.BOLD, 11);

        setFont(f);

        setResizable(false);

        setIconImage(
            getToolkit().getImage(
                "D:/Pictures/Icons/icon.png"
            )
        );

        ButtonPanel BtnPnl = new ButtonPanel(6, 25, W / 4, H - 30);

        add(BtnPnl);

        PlotPanel PltPnl = new PlotPanel(
            W / 4 + 10, 25, 3 * W / 4 - 15, H - 120, BtnPnl
        );

        add(PltPnl);

        HelpPanel HlpPnl = new HelpPanel(
            W / 4 + 10, H - 90, 3 * W / 4 - 15, 85
        );

        add(HlpPnl);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {

                System.exit(0);
            }
        });

        BtnPnl.B1.addActionListener(
            new ButtonOneHandler(BtnPnl, PltPnl)
        );

        BtnPnl.B2.addActionListener(new ButtonTwoHandler());


        BtnPnl.Cbx[3].addItemListener(
            new CheckboxHandler(BtnPnl)
        );

        setVisible(true);
    }
}

class ButtonPanel extends Panel {

    public Label[] L;

    public CheckboxGroup CbxGrp;

    public Checkbox[] Cbx;

    public Choice Chc;

    public TextField TxtFld;

    public Button B1, B2;


    ButtonPanel(int x, int y, int W, int H) {

        setLayout(null);

        setBounds(x, y, W, H);

        setBackground(Color.LIGHT_GRAY);

        L = new Label[3];

        L[0] = new Label("Выбор цвета:", Label.CENTER);

        L[0].setFont(new Font("Arial", Font.BOLD, 12));

        L[0].setBounds(5, 5, getWidth() - 10, 30);

        add(L[0]);

        CbxGrp = new CheckboxGroup();

        Cbx = new Checkbox[4];

        Cbx[0] = new Checkbox(" красный ", CbxGrp, true);
        Cbx[1] = new Checkbox(" синий ", CbxGrp, false);
        Cbx[2] = new Checkbox(" черный ", CbxGrp, false);

        Cbx[3] = new Checkbox(" Сетка ", true);


        for (int i = 0; i < 4; i++) {
            Cbx[i].setBounds(5, 30 + i * 25, getWidth() - 10, 30);
            add(Cbx[i]);
        }


        Chc = new Choice();

        Chc.add("Зеленый");
        Chc.add("Желтый");
        Chc.add("Серый");

        Chc.setBounds(20, 140, getWidth() - 25, 30);

        add(Chc);

        L[1] = new Label("Интервал по х:", Label.CENTER);

        L[1].setFont(new Font("Arial", Font.BOLD, 12));

        L[1].setBounds(5, 220, getWidth() - 10, 30);

        add(L[1]);

        L[2] = new Label("От x=0 до x=", Label.LEFT);

        L[2].setBounds(5, 250, 70, 20);

        add(L[2]);


        TxtFld = new TextField("10");

        TxtFld.setBounds(75, 250, 45, 20);
        add(TxtFld);

        B1 = new Button("Нарисовать");

        B2 = new Button("Закрыть");

        B1.setBounds(5, getHeight() - 75, getWidth() - 10, 30);

        B2.setBounds(5, getHeight() - 35, getWidth() - 10, 30);

        add(B1);

        add(B2);
    }
}

class PlotPanel extends Panel {

    public Plotter G;

    class Plotter {

        private double Xmin = 0, Xmax, Ymin = 0, Ymax = 1.0;

        private boolean status;

        private Color clr;

        private Color gClr;


        Plotter(ButtonPanel P) {


            try {
                Xmax = Double.parseDouble(P.TxtFld.getText());
            } catch (NumberFormatException e) {
                P.TxtFld.setText("10");
                Xmax = 10;
            }

            status = P.Cbx[3].getState();

            switch (P.Chc.getSelectedIndex()) {
                case 0:
                    gClr = Color.GREEN;
                    break;
                case 1:
                    gClr = Color.YELLOW;
                    break;
                default:
                    gClr = Color.GRAY;
            }

            String name =
                P.CbxGrp.getSelectedCheckbox().getLabel();
            if (name.equalsIgnoreCase(" красный ")) {
                clr = Color.RED;
            } else {
                if (name.equalsIgnoreCase(" синий ")) {
                    clr = Color.BLUE;
                } else {
                    clr = Color.BLACK;
                }
            }
        }


        private double f(double x) {
            return (1 + Math.sin(x)) / (1 + Math.abs(x));
        }

        public Plotter remember(ButtonPanel P) {
            return new Plotter(P);
        }

        public void plot(Graphics Fig) {

            int H, W, h, w, s = 20;
            H = getHeight();
            W = getWidth();
            h = H - 2 * s;
            w = W - 2 * s;

            Fig.clearRect(0, 0, W, H);

            int k, nums = 10;

            Fig.setColor(Color.BLACK);

            Fig.drawLine(s, s, s, h + s);
            Fig.drawLine(s, s + h, s + w, s + h);


            for (k = 0; k <= nums; k++) {
                Fig.drawLine(s + k * w / nums, s + h, s + k * w / nums, s + h + 5);
                Fig.drawLine(s - 5, s + k * h / nums, s, s + k * h / nums);
                Fig.drawString(
                    Double.toString(Xmin + k * (Xmax - Xmin) / nums),
                    s + k * w / nums - 5, s + h + 15
                );
                Fig.drawString(
                    Double.toString(Ymin + k * (Ymax - Ymin) / nums),
                    s - 17, s + h - 1 - k * h);
            }

            if (status) {
                Fig.setColor(gClr);

                for (k = 1; k <= nums; k++) {
                    Fig.drawLine(s + k * w / nums, s, s + k * w / nums, h + s);
                    Fig.drawLine(
                        s, s + (k - 1) * h / nums, s + w, s + (k - 1) * h / nums
                    );
                }
            }

            Fig.setColor(clr);

            double dx = (Xmax - Xmin) / w, dy = (Ymax - Ymin) / h;

            double x1, x2, y1, y2;


            int h1, h2, w1, w2;

            x1 = Xmin;
            y1 = f(x1);
            w1 = s;
            h1 = h + s - (int) Math.round(y1 / dy);

            int step = 5;


            for (int i = step; i <= w; i += step) {
                x2 = i * dx;
                y2 = f(x2);
                w2 = s + (int) Math.round(x2 / dx);
                h2 = h + s - (int) Math.round(y2 / dy);

                Fig.drawLine(w1, h1, w2, h2);

                Fig.drawRect(w1 - 2, h1 - 2, 4, 4);

                x1 = x2;
                y1 = y2;
                w1 = w2;
                h1 = h2;
            }
        }
    }


    PlotPanel(int x, int y, int W, int H, ButtonPanel P) {

        G = new Plotter(P);

        setBackground(Color.WHITE);

        setBounds(x, y, W, H);
    }

    public void paint(Graphics g) {


        G.plot(g);
    }
}

class HelpPanel extends Panel {

    public Label L;

    public TextArea TxtA;


    HelpPanel(int x, int y, int W, int H) {

        setBackground(Color.LIGHT_GRAY);

        setBounds(x, y, W, H);

        setLayout(null);

        L = new Label("СПРАВКА", Label.CENTER);

        L.setBounds(0, 0, W, 20);

        add(L);

        TxtA = new TextArea(
            " График функции y(x)=(1+sin(x))/(1+|x|)"
        );

        TxtA.setFont(new Font("Serif", Font.PLAIN, 15));

        TxtA.setBounds(5, 20, W - 10, 60);

        TxtA.setEditable(false);

        add(TxtA);
    }
}

class ButtonOneHandler implements ActionListener {

    private ButtonPanel P1;

    private PlotPanel P2;

    ButtonOneHandler(ButtonPanel P1, PlotPanel P2) {
        this.P1 = P1;
        this.P2 = P2;
    }

    public void actionPerformed(ActionEvent ae) {


        P2.G = P2.G.remember(P1);

        P2.G.plot(P2.getGraphics());
    }
}

class ButtonTwoHandler implements ActionListener {

    public void actionPerformed(ActionEvent ae) {

        System.exit(0);
    }
}

class CheckboxHandler implements ItemListener {

    private Choice ch;


    CheckboxHandler(ButtonPanel P) {
        this.ch = P.Chc;
    }

    public void itemStateChanged(ItemEvent ie) {
        ch.setEnabled(
            ie.getStateChange() == ItemEvent.SELECTED
        );
    }
}

class MathFunctionDrawerExample {
    public static void main(String args[]) {

        new PlotFrame(400, 500);
    }
}
