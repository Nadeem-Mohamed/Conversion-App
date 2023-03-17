import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class temperature implements ActionListener {
  static JTextField frombox;
  static JTextField tobox;
  static JComboBox<String> frombase;
  static JComboBox<String> tobase;
  static JButton reset;
  static JButton done;
  static JButton back;
  JFrame jframe;

  public void temp_convert() {
    jframe = new JFrame("Temperature");
    JPanel main_content = new JPanel();
    jframe.add(main_content);

    JLabel message = new JLabel("Temperature");
    message.setBounds(150, 0, 200, 30);
    main_content.add(message);

    String[] tempmeasures = { "Kelvin", "Fahrenheit", "Celsius" };

    frombase = new JComboBox<>(tempmeasures);
    frombase.setBounds(0, 100, 140, 20);
    main_content.add(frombase);

    tobase = new JComboBox<>(tempmeasures);
    tobase.setBounds(0, 150, 140, 20);
    main_content.add(tobase);

    frombox = new JTextField(10);
    frombox.setBounds(150, 100, 130, 20);
    main_content.add(frombox);

    tobox = new JTextField(10);
    tobox.setBounds(150, 150, 130, 20);
    main_content.add(tobox);

    done = new JButton("Convert");
    done.setBounds(0, 200, 100, 20);
    main_content.add(done);

    reset = new JButton("Reset");
    reset.setBounds(150, 200, 130, 20);
    main_content.add(reset);

    back = new JButton("Back");
    back.setBounds(300, 200, 130, 20);
    main_content.add(back);

    frombase.addActionListener(this);
    tobase.addActionListener(this);
    frombox.addActionListener(this);
    tobox.addActionListener(this);
    reset.addActionListener(this);
    done.addActionListener(this);
    back.addActionListener(this);

    jframe.setSize(600, 500);
    main_content.setLayout(null);
    jframe.setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == back) {
      Measure ms = new Measure();
      ms.Measure_convert();
      jframe.dispose();
    }

    if (e.getSource() == reset) {
      frombox.setText("");
      tobox.setText("");
      return;
    }

    String from = (String) frombase.getSelectedItem();
    String too = (String) tobase.getSelectedItem();
    String fromInput = frombox.getText();
    if (!fromInput.matches("^[0-9\\.]+$")) {
      tobox.setText("Invalid Inputs");
      return;
    }

    double fromval = Double.parseDouble(frombox.getText());

    if (from.equals("Kelvin") && too.equals("Fahrenheit")) {
      double fr = 1.8 * (fromval - 273) + 32;
      if (e.getSource() == done) {
        tobox.setText(String.format("%.2f", fr));
      }
    } else if (from.equals("Kelvin") && too.equals("Celsius")) {
      double cs = fromval - 273.15;
      if (e.getSource() == done) {
        tobox.setText(String.format("%.2f", cs));
      }
    } else if (from.equals("Kelvin") && too.equals("Kelvin")) {
      if (e.getSource() == done) {
        tobox.setText("Same measures");
      }
    }

    else if (from.equals("Fahrenheit") && too.equals("Kelvin")) {
      double kl = (fromval - 32) * 5 / 9 + 273.15;
      if (e.getSource() == done) {
        tobox.setText(String.format("%.2f", kl));
      }
    }

    else if (from.equals("Fahrenheit") && too.equals("Celsius")) {
      double cs = (fromval - 32) * 5 / 9;
      if (e.getSource() == done) {
        tobox.setText(String.format("%.2f", cs));
      }
    }

    else if (from.equals("Fahrenheit") && too.equals("Fahrenheit")) {
      if (e.getSource() == done) {
        tobox.setText("Same measures");
      }
    }

    else if (from.equals("Celsius") && too.equals("Kelvin")) {
      double kl = fromval + 273.15;
      if (e.getSource() == done) {
        tobox.setText(String.format("%.2f", kl));
      }
    }

    else if (from.equals("Celsius") && too.equals("Fahrenheit")) {
      double fr = (fromval * 9 / 5) + 32;
      if (e.getSource() == done) {
        tobox.setText(String.format("%.2f", fr));
      }
    }

    else if (from.equals("Celsius") && too.equals("Celsius")) {
      if (e.getSource() == done) {
        tobox.setText("Same measures");
      }
    }

  }
}
