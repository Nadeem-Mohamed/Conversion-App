import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Measure implements ActionListener {
  static JButton length;
  static JButton mass;
  static JButton time;
  static JButton temp;
  static JButton back;
  JFrame jframe;

  public void Measure_convert() {
    jframe = new JFrame("Measurements");
    JPanel mainwindow = new JPanel();
    jframe.add(mainwindow);

    JLabel message = new JLabel("Measurements");
    message.setBounds(150, 50, 200, 30);
    mainwindow.add(message);

    length = new JButton("Length");
    length.setBounds(0, 100, 100, 20);
    mainwindow.add(length);

    mass = new JButton("Mass");
    mass.setBounds(120, 100, 100, 20);
    mainwindow.add(mass);

    time = new JButton("Time");
    time.setBounds(240, 100, 100, 20);
    mainwindow.add(time);

    temp = new JButton("Temperature");
    temp.setBounds(360, 100, 140, 20);
    mainwindow.add(temp);

    back = new JButton("Back");
    back.setBounds(120, 150, 140, 20);
    mainwindow.add(back);

    length.addActionListener(this);
    mass.addActionListener(this);
    time.addActionListener(this);
    temp.addActionListener(this);
    back.addActionListener(this);

    jframe.setSize(600, 500);
    mainwindow.setLayout(null);
    jframe.setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == back) {
      home_page h = new home_page();
      h.home();
      jframe.dispose();
    }
    if (e.getSource() == length) {
      lengthcon lg = new lengthcon();
      lg.length_convert();
      jframe.dispose();
    } else if (e.getSource() == mass) {
      mass mg = new mass();
      mg.mass_convert();
      jframe.dispose();
    } else if (e.getSource() == time) {
      time tm = new time();
      tm.time_convert();
      jframe.dispose();
    }

    else if (e.getSource() == temp) {
      temperature tp = new temperature();
      tp.temp_convert();
      jframe.dispose();
    }
  }
}