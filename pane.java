import javax.lang.model.util.ElementFilter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputFilter.Status;
import java.security.MessageDigest;

public class pane {
    uw u = new uw();
    normal n = new normal();
    obese o = new obese();
    public double panel() {
        JFrame frame = new JFrame("BMI Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelTitle = new JPanel(new FlowLayout());
        JPanel panelOne = new JPanel(new GridLayout(2,2,1,1));
        JPanel panelTwo = new JPanel(new FlowLayout());
        JPanel panelThree = new JPanel(new FlowLayout());
        JButton button = new JButton("Enter");
        JButton button1 = new JButton("Show findings");
        panelTitle.setBounds(10,10,380,40);
        panelOne.setBounds(10,60,380,80);
        panelTwo.setBounds(10,200,380,40);
        panelThree.setBounds(10,200,380,40);
        JLabel labelOne, labelTwo, labelTitle;
        JTextField tFieldOne, tFieldTwo;
        tFieldOne = new JTextField(20);
        tFieldOne.setPreferredSize(new Dimension(80,20));
        tFieldTwo = new JTextField(20);
        tFieldTwo.setPreferredSize(new Dimension(80,20));
        labelTitle = new JLabel("Enter required:", JLabel.CENTER);
        labelOne = new JLabel("Enter Height in CM");
        labelTwo = new JLabel("Enter Weight");
        labelTitle.setBounds(10,10,90,20);
        labelOne.setBounds(10,10,90,20);
        tFieldOne.setBounds(5, 5, 50, 100);
        labelTwo.setBounds(10,10,90,20);
        tFieldTwo.setBounds(5, 5, 50, 100);

        panelTitle.add(labelTitle);

        panelOne.add(labelOne);
        panelOne.add(tFieldOne);
        panelOne.add(labelTwo);
        panelOne.add(tFieldTwo);

        button.setBounds(10,10,90,20);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double result = computeValue(tFieldOne.getText(),tFieldTwo.getText());
                displayMessage(String.valueOf(result));
            }
        });
        button.setBounds(10,10,90,20);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double bmi1 = Identifyy(null);;
                Identifyy(String.valueOf(bmi1));
            }
        });

        panelTwo.add(button);
        panelTwo.add(button1);

        frame.add(panelTitle);
        frame.add(panelOne);
        frame.add(panelTwo);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        frame.setSize(450,300);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        return width;
        
    }
    public  double computeValue(String height, String weight){
        int height1 = Integer.parseInt(height);
        int weight1= Integer.parseInt(weight);
        double convertedheight = height1*0.01;
        double h = convertedheight*convertedheight;
        double bmi = weight1/h;
        return bmi;
    }
    public double Identifyy(String bmi){
        double bmi1 = Integer.parseInt(bmi);
        if (bmi1<18.4) {
            u.identify();
        } else if (bmi1<24.9) {
            n.identify();
        } else {
            o.identify();
        }
        return 0;
    }
    public static void displayMessage(String message){
        JOptionPane.showMessageDialog( null, message, "YOUR BMI IS" , JOptionPane.INFORMATION_MESSAGE );
    }
    
}
        

