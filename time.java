import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class time implements ActionListener {
  static JTextField frombox;
  static JTextField tobox;
  static JComboBox<String> frombase;
  static JComboBox<String> tobase;
  static JButton reset;
  static JButton done;
  static JButton back;
  JFrame jframe;

  public void time_convert() {
    jframe = new JFrame("Time");
    JPanel main_content = new JPanel();
    jframe.add(main_content);

    JLabel message = new JLabel("Time");
    message.setBounds(150, 0, 200, 30);
    main_content.add(message);

    String[] timemeasures = { "Hours", "Minutes", "Seconds" };

    frombase = new JComboBox<>(timemeasures);
    frombase.setBounds(0, 100, 140, 20);
    main_content.add(frombase);

    tobase = new JComboBox<>(timemeasures);
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
    back.setBounds(150, 200, 130, 20);
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

    if (from.equals("Hours") && too.equals("Minutes")) {
      double mn = fromval * 60;
      if (e.getSource() == done) {
        tobox.setText(String.format("%.2f", mn));
      }
    } else if (from.equals("Hours") && too.equals("Seconds")) {
      double sc = fromval * 3600;
      if (e.getSource() == done) {
        tobox.setText(String.format("%.2f", sc));
      }
    } else if (from.equals("Hours") && too.equals("Hours")) {
      if (e.getSource() == done) {
        tobox.setText("Same measures");
      }
    }

    else if (from.equals("Minutes") && too.equals("Hours")) {
      double hr = fromval / 60;
      if (e.getSource() == done) {
        tobox.setText(String.format("%.2f", hr));
      }
    }

    else if (from.equals("Minutes") && too.equals("Seconds")) {
      double sc = fromval * 60;
      if (e.getSource() == done) {
        tobox.setText(String.format("%.2f", sc));
      }
    }

    else if (from.equals("Minutes") && too.equals("Minutes")) {
      if (e.getSource() == done) {
        tobox.setText("Same measures");
      }
    }

    else if (from.equals("Seconds") && too.equals("Hours")) {
      double hr = fromval / 3600;
      if (e.getSource() == done) {
        tobox.setText(String.format("%.2f", hr));
      }
    }

    else if (from.equals("Seconds") && too.equals("Minutes")) {
      double mn = fromval / 60;
      if (e.getSource() == done) {
        tobox.setText(String.format("%.2f", mn));
      }
    }

    else if (from.equals("Seconds") && too.equals("Seconds")) {
      if (e.getSource() == done) {
        tobox.setText("Same measures");
      }
    }

  }
}
