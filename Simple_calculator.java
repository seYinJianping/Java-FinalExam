package cal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class GUI {
    private JFrame jf;
    private JTextField jtf;
    private JButton[] jbs;
    private JButton[] jbC;

    public GUI() {
        jf=new JFrame("Overwatch");
        jtf=new JTextField(15);
        jbC=new JButton[1];
        jbC[0]=new JButton("C");
        jbs=new JButton[16];
        for (int i = 0; i < jbs.length; i++) {
            switch(i){
                case 0:jbs[0]=new JButton("1");
                case 1:jbs[1]=new JButton("2");
                case 2:jbs[2]=new JButton("3");
                case 3:jbs[3]=new JButton("+");
                case 4:jbs[4]=new JButton("4");
                case 5:jbs[5]=new JButton("5");
                case 6:jbs[6]=new JButton("6");
                case 7:jbs[7]=new JButton("-");
                case 8:jbs[8]=new JButton("7");
                case 9:jbs[9]=new JButton("8");
                case 10:jbs[10]=new JButton("9");
                case 11:jbs[11]=new JButton("*");
                case 12:jbs[12]=new JButton("0");
                case 13:jbs[13]=new JButton(".");
                case 14:jbs[14]=new JButton("=");
                case 15:jbs[15]=new JButton("÷");
            }
        }
    }

    private void init(){
        jf.add(jtf,BorderLayout.NORTH);
        jf.setLayout(new FlowLayout(FlowLayout.RIGHT,20,20));
        jf.add(jbC[0]);
        JPanel jp=new JPanel();
        jp.setLayout(new GridLayout(4,4,20,20));
        for (int i = 0; i < jbs.length; i++) {
            jp.add(jbs[i]);
        }
        jf.add(jp);
    }
    private void setStyle(){
        jf.setFont(new Font("Courier New",Font.PLAIN,16));
        jtf.setHorizontalAlignment(JTextField.RIGHT);
        jtf.setBackground(Color.WHITE);
    }

    public void show(){
        init();
        setStyle();
        Event();
        jf.setSize(275,300);
        jf.setVisible(true);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void Event(){
        //Text(jbC[0]);
        Text(jbs[0]);
        Text(jbs[1]);
        Text(jbs[2]);
        Text(jbs[3]);
        Text(jbs[4]);
        Text(jbs[5]);
        Text(jbs[6]);
        Text(jbs[7]);
        Text(jbs[8]);
        Text(jbs[9]);
        Text(jbs[10]);
        Text(jbs[11]);
        Text(jbs[12]);
        Text(jbs[13]);
        //Text(jbs[14]);
        Text(jbs[15]);
        jbs[14].addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                jtf.setText(jtf.getText()+jtf.getText());
                    //加法运算
                if(jtf.getText().contains("+")){
                    StringTokenizer st1 = new StringTokenizer(jtf.getText(),"+");
                    double d1,d2 = 0;
                    d1 = Double.parseDouble(st1.nextToken());
                    while(st1.hasMoreTokens()){
                        StringTokenizer st2 = new StringTokenizer(st1.nextToken(),"=");
                        d2 = Double.parseDouble(st2.nextToken());
                    }

                    jtf.setText(" "+(d1+d2));

                    //减法运算
                }else if(jtf.getText().contains("-")){
                    StringTokenizer st1 = new StringTokenizer(jtf.getText(),"-");
                    double d1,d2 = 0;
                    d1 = Double.parseDouble(st1.nextToken());
                    while(st1.hasMoreTokens()){
                        StringTokenizer st2 = new StringTokenizer(st1.nextToken(),"=");
                        d2 = Double.parseDouble(st2.nextToken());
                    }

                    jtf.setText(" "+(d1-d2));

                    //乘法运算
                }else if(jtf.getText().contains("*")){
                    StringTokenizer st1 = new StringTokenizer(jtf.getText(),"*");
                    double d1,d2 = 0;
                    d1 = Double.parseDouble(st1.nextToken());
                    while(st1.hasMoreTokens()){
                        StringTokenizer st2 = new StringTokenizer(st1.nextToken(),"=");
                        d2 = Double.parseDouble(st2.nextToken());
                    }

                    jtf.setText(" "+(d1*d2));

                    //除法运算
                }else if(jtf.getText().contains("÷")){
                    StringTokenizer st1 = new StringTokenizer(jtf.getText(),"÷");
                    double d1,d2 = 0;
                    d1 = Double.parseDouble(st1.nextToken());
                    while(st1.hasMoreTokens()){
                        StringTokenizer st2 = new StringTokenizer(st1.nextToken(),"=");
                        d2 = Double.parseDouble(st2.nextToken());
                    }
                    jtf.setText(" "+(d1/d2));
                }
            }

        });

        jbC[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtf.setText("");
            }
        });
    }
    public void Text(JButton button){
        button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                String str = button.getText();
                jtf.setText(jtf.getText()+str);
            }
        });
    }

    public static void main(String[] args){
        new GUI().show();
    }


}
