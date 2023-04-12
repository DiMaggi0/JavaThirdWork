import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

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
        bigField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                while(true) {

                    String str = bigField.getText();
                    if (str.split(" ").length != 4) {
                        if(str.split("\\.").length == 3) {

                            ShowDialogMessage("Введите ФИО в формате: Фамилия Имя Отчество");
                            bigField.setText("");
                            break;
                        } else {
                            ShowDialogMessage("Введите ФИО и дату рождения в формате: Фамилия Имя Отчество dd.MM.yyyy");
                            bigField.setText("");
                            break;
                        }

                    } else {
                        if (str.split("\\.").length != 3) {
                            ShowDialogMessage("Введите дату рождения в формате: dd.MM.yyyy");
                            break;
                        } else {
                            if (str.indexOf(".") < str.indexOf(" ")) {
                                ShowDialogMessage("Поменяйте местами ввод ФИО и даты рождения и повторите попытку.");
                                break;
                            } else {
                                String[] input = str.split(" |\\.");
                                // работа с полом человека
                                int genderCount = 0;
                                if (input[2].endsWith("вич")) {
                                    genderCount--;
                                } else if (input[2].endsWith("вна")) {
                                    genderCount++;
                                }
                                if (input[1].endsWith("а") || input[1].endsWith("я") || input[1].endsWith("ь") && !(input[1].equals("Данила")) && !(input[1].equals("Никита"))) {
                                    genderCount++;
                                } else {
                                    genderCount--;
                                }
                                char gender;
                                if (genderCount > 0) {
                                    gender = 'Ж';
                                } else if (genderCount < 0) {
                                    gender = 'М';
                                } else {
                                    ShowDialogMessage("Невозможно идентифицировать пол, проверьте правильность введенных данных.");
                                    break;
                                }
                                // работа с датой рождения
                                Date workWithDate = new Date(input[3], input[4], input[5]);
                                if (!workWithDate.isValidDate()) {
                                    ShowDialogMessage("Введена некорректная дата, проверьте данные и повторите попытку.");
                                    break;
                                }
                                int age = workWithDate.ageCount();
                                String ageEnd;
                                if (age % 10 == 1 && age != 11) {
                                    ageEnd = "год";
                                } else if ((age % 10 == 2 || age % 10 == 3 || age % 10 == 4) && (age != 12 && age != 13 && age != 14)) {
                                    ageEnd = "года";
                                } else {
                                    ageEnd = "лет";
                                }
                                String output = String.format("%s %c.%c. %c %d %s", input[0], input[1].charAt(0), input[2].charAt(0), gender, age, ageEnd);
                                ShowDialogMessage(output);
                                bigField.setText("");
                                break;
                            }
                        }
                    }
                }
            }
        });
        JPanel contents = new JPanel(new FlowLayout(FlowLayout.CENTER));
        contents.add(new JLabel("Введите ФИО и дату рождения в формате: Фамилия Имя Отчество dd.MM.yyyy"));
        contents.add(label1);
        contents.add(bigField);
        contents.add(new JLabel("Программа предусматривает неверный ввод данных, но вы всегда можете его исправить."));
        contents.add(label);
        setContentPane(contents);
        // Определяем размер окна и выводим его на экран
        setSize(600, 200);
        setLocationRelativeTo(null);

        setVisible(true);

            }


}