import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import static java.lang.System.lineSeparator;
import static java.lang.System.out;

public class MuseumGUI extends JFrame {
    // ���������� ������
    private JButton submit = new JButton("�������� ������");
    private JButton search = new JButton("�����");
    private JButton close = new JButton("�����");
    // ���������� ��������� �����
    private JTextField nameField = new JTextField("", 15);
    private JTextField dateField = new JTextField("", 8);
    private JTextField placeField = new JTextField("", 15);
    private JTextField searchField = new JTextField("", 15);
    // ���������� �������� � �����
    private JLabel nameLabel = new JLabel("������� ��� ���������: ");
    private JLabel emptyLabel = new JLabel("");
    private JLabel dateLabel = new JLabel("������� ���� ������� ��.��.��: ");
    private JLabel placeLabel = new JLabel("������� ����� ����������: ");
    private JLabel headingLabel = new JLabel("������� ������ ��� ��������� �����:");

    public MuseumGUI() {
        super("Museum_JAVA");
        this.setBounds(430,200,500,250);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // ������� ���������� ���������� ��� �����
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(6, 2, 5,5));
        container.add(headingLabel);
        container.add(emptyLabel);
        container.add(nameLabel);
        container.add(nameField);
        container.add(dateLabel);
        container.add(dateField);
        container.add(placeLabel);
        container.add(placeField);
        submit.addActionListener(new ButtonSubmitListener());
        container.add(submit);
        close.addActionListener(new ButtonCloseListener());
        container.add(close);
        search.addActionListener(new ButtonSearchListener());
        container.add(search);
        container.add(searchField);
    }
    class ButtonSubmitListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
    // ������� ��������� � �������� ������ � ���� �����
            String message = "";
            message += "������ ������ ���������: \n";
            message += "��� ���������: " + nameField.getText() + "\n";
            message += "���� ������: " + dateField.getText() + "\n";
            message += "����� ����������: " + placeField.getText() + "\n";
            JOptionPane.showMessageDialog(null, message,
                    "������ ������ ���������", JOptionPane.PLAIN_MESSAGE);
    // �������� ���������� ��� ���������� ������
            String name = nameField.getText();
            String date = dateField.getText();
            String place = placeField.getText();

    // ������ ��������� ����� � ����
            String fileRead = "Museum_JAVA.txt";
            String text = name + "\t"  + date  + "\t" + place + "\n";
            try {
                Files.write(Paths.get(fileRead), text.getBytes(), StandardOpenOption.APPEND);
            }
            catch (IOException ex) {
                out.print(text + "\n");
            }
    // ������� ����� ��� ����� ����� ������
            headingLabel.setText("������� ������ ���������� ���������:");
            nameField.setText("");
            dateField.setText("");
            placeField.setText("");
        }
    }
    class ButtonSearchListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String message = "";
            message += ": \n";
            message += "��� ���������: " + nameField.getText() + "\n";
            message += "���� ������: " + dateField.getText() + "\n";
            message += "����� ����������: " + placeField.getText() + "\n";
            JOptionPane.showMessageDialog(null, message,
                    "������ ������ ���������", JOptionPane.PLAIN_MESSAGE);
        }
    }
    class ButtonCloseListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

}
