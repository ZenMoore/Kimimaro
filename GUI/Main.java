package GUI;

import Handle.unzip;
import Handle.zip;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/**
 * Created by admin on 2016/8/5.
 */
public class Main extends JFrame{
    private Container container=getContentPane();
    private Point origin=new Point();
    private JTextField sourceField=new JTextField();
    private JTextField directionField=new JTextField();
    private JPanel panel=new JPanel();
    private JRadioButton zipRadio=new JRadioButton("zip");
    private JRadioButton unzipRadio=new JRadioButton("unzip");
    private ButtonGroup radioGroup=new ButtonGroup();
    private JButton platon =new JButton("PLAY");
    private JButton minton=new JButton("MIN");
    private JButton exiton =new JButton("EXIT");
    private int mark=new Random().nextInt(7)+1;
    private JPanel allPanel=new JPanel(){
        public void paintComponent(Graphics g) {
//            // TODO: 2016/8/4
            ImageIcon icon = new ImageIcon("./Image/back"+mark+".gif");
//             图片随窗体大小而变化
            g.drawImage(icon.getImage(), 0, 0, 500,400, this);
        }
    };

    public Main(){
        super("Kimimaro.");

        this.setallPanel();
        this.setSourceField();
        this.setDirectionField();
        this.setButton();
        this.setRadioButton();
        this.setRadioGroup();
        this.setPanel();
        this.setContainer();

        this.setIconImage(new ImageIcon ("./image/zipPNG.png").getImage());
        switch(mark){
            case 3:this.setColor(Color.darkGray.brighter());break;
            case 5:this.setColor(Color.white);break;
            case 4:this.setColor(Color.white);break;
            case 6:this.setColor(Color.cyan.darker().darker().darker());break;
        }

        this.addMouseListener(new MouseAdapter() {
            // 按下(mousePressed
            // 不是点击，而是鼠标被按下没有抬起)
            public void mousePressed(MouseEvent e) {
                // 当鼠标按下的时候获得窗口当前的位置
                origin.x = e.getX();
                origin.y = e.getY();
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            // 拖动（mouseDragged
            // 指的不是鼠标在窗口中移动，而是用鼠标拖动）
            public void mouseDragged(MouseEvent e) {
                // 当鼠标拖动时获取窗口当前位置
                Point p =Main.this.getLocation();
                // 设置窗口的位置
                // 窗口当前的位置 + 鼠标当前在窗口的位置 - 鼠标按下的时候在窗口的位置
                Main.this.setLocation(p.x + e.getX() - origin.x, p.y + e.getY()
                        - origin.y);
            }
        });

        this.setBounds(480,200,500,400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBackground(Color.black);
        this.setUndecorated(true);
        this.setAutoRequestFocus(true);
        this.setFont(new Font("微软雅黑",Font.PLAIN,20));
//        this.setOpacity(0.9f);
        this.setVisible(true);
        this.setResizable(false);

    }

    public void setSourceField(){
//        sourceField.setSize(300,10);
        sourceField.setOpaque(false);
        sourceField.setFont(new Font("微软雅黑",Font.PLAIN,19));
        sourceField.setBorder(new EmptyBorder(0,0,0,0));
        sourceField.setText("SOURCE: C://Program Files/file-name(Having a expanded-name, don't forget it.)");

        sourceField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                sourceField.setFont(new Font("微软雅黑",Font.PLAIN,20));
            }

            public void focusLost(FocusEvent e) {
                sourceField.setFont(new Font("微软雅黑",Font.PLAIN,19));
            }
        });
    }

    public void setDirectionField(){
        directionField.setOpaque(false);
//        directionField.setSize(300,10);
        directionField.setBorder(new EmptyBorder(0,0,0,0));
        directionField.setFont(new Font("微软雅黑",Font.PLAIN,19));
        directionField.setText("DIRECTION: C://Program Files/file-name(Include which file(best .zip) or which directory to put it.)");

        directionField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                directionField.setFont(new Font("微软雅黑",Font.PLAIN,20));
            }

            public void focusLost(FocusEvent e) {
                directionField.setFont(new Font("微软雅黑",Font.PLAIN,19));
            }
        });
    }

    public void setButton(){
        platon.setFont(new Font("黑体",Font.BOLD,25));
//        platon.setPreferredSize(new Dimension(15,15));
        platon.setOpaque(false);
        platon.setBackground(Color.pink);
        platon.setBorderPainted(false);
        platon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                // TODO: 2016/8/4
                if(zipRadio.isSelected()){
                    zip.play(Main.this.sourceField.getText(),Main.this.directionField.getText());
                }else{
                    unzip.play(Main.this.sourceField.getText(),Main.this.directionField.getText());
                }
            }
        });

        exiton.setFont(new Font("黑体",Font.BOLD,25));
        exiton.setOpaque(false);
//        exiton.setPreferredSize(new Dimension(15,15));
        exiton.setBackground(Color.pink);
        exiton.setBorderPainted(false);
        exiton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(-1);
            }
        });

        minton.setFont(new Font("黑体",Font.BOLD,25));
        minton.setOpaque(false);
//        minton.setPreferredSize(new Dimension(15,15));
        minton.setBackground(Color.pink);
        minton.setBorderPainted(false);
        minton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.this.setExtendedState(Frame.ICONIFIED|getExtendedState());
            }
        });

    }

    public void setRadioButton(){
        zipRadio.setOpaque(false);
        zipRadio.setSelected(true);
        zipRadio.setBorderPainted(false);
        zipRadio.setFont(new Font("微软雅黑",Font.PLAIN,20));
        zipRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.this.setIconImage(new ImageIcon("./image/zipPNG.png").getImage());
            }
        });

        unzipRadio.setOpaque(false);
        unzipRadio.setBorderPainted(false);
        unzipRadio.setFont(new Font("微软雅黑",Font.PLAIN,20));
        unzipRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.this.setIconImage(new ImageIcon("./image/unzipPNG.png").getImage());
            }
        });
    }

    public void setRadioGroup(){
        radioGroup.add(zipRadio);
        radioGroup.add(unzipRadio);
    }

    public void setContainer(){
        this.add(allPanel);
    }

    public void setallPanel(){
        allPanel.setLayout(new GridLayout(3,1,10,10));
        allPanel.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
        allPanel.add(sourceField);
        allPanel.add(directionField);
        allPanel.add(panel);

        allPanel.setOpaque(false);
    }

    public void setPanel(){
        panel.setLayout(new GridLayout(1,3));
        panel.add(zipRadio);
        panel.add(unzipRadio);
        panel.add(platon);
        panel.add(exiton);
        panel.add(minton);
        panel.setOpaque(false);
    }

    public void setColor(Color color){
        sourceField.setForeground(color);
        directionField.setForeground(color);
        zipRadio.setForeground(color);
        unzipRadio.setForeground(color);
        platon.setForeground(color);
        minton.setForeground(color);
        exiton.setForeground(color);
    }

    public static void main(String[] args){
        new Main();
    }

}
