import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class lengthcon implements ActionListener {
  static JTextField frombox;
  static JTextField tobox;
  static JComboBox<String> frombase;
  static JComboBox<String> tobase;
  static JButton reset;
  static JButton done;
  static JButton back;
  JFrame jframe;

  public void length_convert() {
    jframe = new JFrame("Distance");
    JPanel main_content = new JPanel();
    jframe.add(main_content);

    JLabel message = new JLabel("Distance");
    message.setBounds(150, 0, 200, 30);
    main_content.add(message);

    String[] lengthmeasures = { "Feet", "Metres", "Inches" };

    frombase = new JComboBox<>(lengthmeasures);
    frombase.setBounds(0, 100, 140, 20);
    main_content.add(frombase);

    tobase = new JComboBox<>(lengthmeasures);
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

    if (from.equals("Feet") && too.equals("Metres")) {
      double met = fromval / 3.281;
      if (e.getSource() == done) {
        tobox.setText(String.format("%.2f", met));
      }
    } else if (from.equals("Feet") && too.equals("Inches")) {
      double in = fromval * 12;
      if (e.getSource() == done) {
        tobox.setText(String.format("%.2f", in));
      }
    } else if (from.equals("Feet") && too.equals("Feet")) {
      if (e.getSource() == done) {
        tobox.setText("Same measures");
      }
    }

    else if (from.equals("Metres") && too.equals("Feet")) {
      double ft = fromval * 3.281;
      if (e.getSource() == done) {
        tobox.setText(String.format("%.2f", ft));
      }
    }

    else if (from.equals("Metres") && too.equals("Inches")) {
      double in = fromval * 39.37;
      if (e.getSource() == done) {
        tobox.setText(String.format("%.2f", in));
      }
    }

    else if (from.equals("Metres") && too.equals("Metres")) {
      if (e.getSource() == done) {
        tobox.setText("Same measures");
      }
    }

    else if (from.equals("Inches") && too.equals("Feet")) {
      double ft = fromval / 12;
      if (e.getSource() == done) {
        tobox.setText(String.format("%.2f", ft));
      }
    }

    else if (from.equals("Inches") && too.equals("Metres")) {
      double mt = fromval / 39.37;
      if (e.getSource() == done) {
        tobox.setText(String.format("%.2f", mt));
      }
    }

    else if (from.equals("Inches") && too.equals("Inches")) {
      if (e.getSource() == done) {
        tobox.setText("Same measures");
      }
    }

  }
}
