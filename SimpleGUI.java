import javax.swing.*;

import java.awt.*;


public class SimpleGUI extends JFrame {
    JTextField bigField;
    public void ShowDialogMessage(String input){
        JOptionPane.showMessageDialog(SimpleGUI.this, input);

    }

    public SimpleGUI() {
        super("JavaThirdWork");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        bigField = new JTextField(40);
        JLabel label = new JLabel("Чтобы выйти из программы, нажмите на крестик в правом верхнем углу.");
        JLabel label1 = new JLabel("Нажмите Enter, чтобы закончить ввод и получить информацию по вашим данным.");
        label.setForeground(Color.RED);
        label1.setForeground(Color.GREEN);
        bigField.setFont(new Font("Dialog", Font.PLAIN, 16));
        bigField.setHorizontalAlignment(JTextField.CENTER);
        JPanel contents = new JPanel(new FlowLayout(FlowLayout.CENTER));
        contents.add(new JLabel("Введите ФИО и дату рождения в формате: Фамилия Имя Отчество dd.MM.yyyy"));
        contents.add(label1);
        contents.add(bigField);
        contents.add(new JLabel("Программа предусматривает неверный ввод данных, но вы всегда можете его исправить."));
        contents.add(label);
        setContentPane(contents);
        setSize(600, 200);
        setLocationRelativeTo(null);

        setVisible(true);

            }


}