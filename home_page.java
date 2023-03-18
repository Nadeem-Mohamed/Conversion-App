import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

public class home_page implements ActionListener {
  static JButton numberbase;
  static JButton measure;
  JFrame jframe;

  public void home() {
    jframe = new JFrame("Conversion App");
    JPanel mainwindow = new JPanel(new GridLayout(4, 1));
    mainwindow.setBackground(new Color(255, 255, 255));
    jframe.add(mainwindow);

    JLabel message = new JLabel("Conversion App");
    message.setForeground(Color.BLUE);
    message.setHorizontalAlignment(SwingConstants.CENTER);
    message.setFont(new Font("Arial", Font.BOLD, 36));
    mainwindow.add(message);

    JLabel submes = new JLabel("Choose a Conversion Type");
    submes.setForeground(Color.BLUE);
    submes.setHorizontalAlignment(SwingConstants.CENTER);
    submes.setFont(new Font("Arial", Font.PLAIN, 20));
    mainwindow.add(submes);

    JPanel panel1 = new JPanel(new GridLayout(2, 1));
    numberbase = new JButton("Number Base Conversion");
    numberbase.setBorder(null);
    numberbase.setBackground(Color.BLUE);
    numberbase.setForeground(Color.WHITE);
    numberbase.setFont(new Font("Arial", Font.PLAIN, 18));
    panel1.add(numberbase);
    JLabel numdes = new JLabel(
        "<html>Convert Numbers to Different Bases Such as Decimal, Binary and Hexadecimal.</html>");
    numdes.setForeground(Color.BLACK);
    numdes.setHorizontalAlignment(SwingConstants.CENTER);
    numdes.setFont(new Font("Arial", Font.PLAIN, 14));
    panel1.add(numdes);
    mainwindow.add(panel1);

    JPanel panel2 = new JPanel(new GridLayout(2, 1));
    measure = new JButton("Measurements Conversion");
    measure.setBorder(null);
    measure.setBackground(Color.BLUE);
    measure.setForeground(Color.WHITE);
    measure.setFont(new Font("Arial", Font.PLAIN, 18));
    panel2.add(measure);
    JLabel mesdes = new JLabel(
        "<html>Convert Numbers to Different Units in Length, Mass, Time and Temperature.</html>");
    mesdes.setForeground(Color.BLACK);
    mesdes.setHorizontalAlignment(SwingConstants.CENTER);
    mesdes.setFont(new Font("Arial", Font.PLAIN, 14));
    panel2.add(mesdes);
    mainwindow.add(panel2);

    numberbase.addActionListener(this);
    measure.addActionListener(this);

    jframe.setSize(600, 500);
    jframe.setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == numberbase) {
      Number_Base nb = new Number_Base();
      nb.Num_convert();
      jframe.dispose();
    } else if (e.getSource() == measure) {
      Measure ms = new Measure();
      ms.Measure_convert();
      jframe.dispose();
    }

  }
}
