public class Main {
    public static void main(String[] args) {
        SimpleGUI gui = new SimpleGUI();
        gui.bigField.addActionListener(e -> {
            while (true) {
                String str = gui.bigField.getText();
                if (str.split(" ").length != 4) {
                    if (str.split("\\.").length == 3) {

                        gui.ShowDialogMessage("Введите ФИО в формате: Фамилия Имя Отчество");
                        gui.bigField.setText("");
                        break;

                    } else {
                        gui.ShowDialogMessage("Введите ФИО и дату рождения в формате: Фамилия Имя Отчество dd.MM.yyyy");
                        gui.bigField.setText("");
                        break;

                    }

                } else {
                    if (str.split("\\.").length != 3) {
                        gui.ShowDialogMessage("Введите дату рождения в формате: dd.MM.yyyy");
                        break;

                    } else {
                        if (str.indexOf(".") < str.indexOf(" ")) {
                            gui.ShowDialogMessage("Поменяйте местами ввод ФИО и даты рождения и повторите попытку.");
                            break;

                        } else {
                            String[] input = str.split(" |\\.");
                            // работа с полом человека
                            int genderCount = 0;
                            if (input[2].endsWith("ч")) {
                                genderCount--;
                            } else if (input[2].endsWith("а")) {
                                genderCount++;
                            }
                            if ((input[1].endsWith("а") || input[1].endsWith("я") || input[1].endsWith("ь")) && !(input[1].equals("Данила")) && !(input[1].equals("Никита"))) {
                                genderCount++;
                            } else {
                                genderCount--;
                            }
                            char gender = 'g';
                            if (genderCount > 0) {
                                gender = 'Ж';
                            } else if (genderCount < 0) {
                                gender = 'М';
                            } else {
                                gui.ShowDialogMessage("Невозможно идентифицировать пол, проверьте правильность введенных данных.");
                                break;

                            }
                            // работа с датой рождения
                            Date workWithDate = new Date(input[3], input[4], input[5]);
                            if (!workWithDate.isValidDate()) {
                                gui.ShowDialogMessage("Введена некорректная дата, проверьте данные и повторите попытку.");
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
                            gui.ShowDialogMessage(output);
                            gui.bigField.setText("");
                            break;
                        }
                    }
                }
            }
        });
    }
}

