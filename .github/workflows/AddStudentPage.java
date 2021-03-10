package miniProject.front;


import miniProject.Client;
import miniProject.PackageData;
import miniProject.Students;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static miniProject.Client.setData;

public class AddStudentPage extends JPanel {
    private MainFrame parent;
    private JLabel label;
    private JLabel name, surname, age;
    private JTextField nameField, surnameField, ageTextField;
    private JButton addStudent, back;

    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getSurnameField() {
        return surnameField;
    }

    public JTextField getAgeTextField() {
        return ageTextField;
    }

    public JButton getAddStudent() {
        return addStudent;
    }

    public AddStudentPage(MainFrame parent) {
        this.parent = parent;
        setSize(500, 500);
        setLayout(null);

        name = new JLabel("Name:");
        name.setSize(100, 30);
        name.setLocation(100, 100);
        add(name);

        nameField = new JTextField("insert name");
        nameField.setSize(150, 30);
        nameField.setLocation(250, 100);
        add(nameField);

        surname = new JLabel("Surname: ");
        surname.setSize(100, 30);
        surname.setLocation(100, 160);
        add(surname);

        surnameField = new JTextField("insert surname");
        surnameField.setSize(150, 30);
        surnameField.setLocation(250, 160);
        add(surnameField);

        age = new JLabel("age: ");
        age.setSize(100, 30);
        age.setLocation(100, 220);
        add(age);

        ageTextField = new JTextField("0");
        ageTextField.setSize(150, 30);
        ageTextField.setLocation(250, 220);
        add(ageTextField);

        addStudent = new JButton("ADD");
        addStudent.setSize(100, 30);
        addStudent.setLocation(100, 370);
        add(addStudent);

        addStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String surname = surnameField.getText();
                String age = ageTextField.getText();
                if (!name.equals("") &&
                        !surname.equals("") &&
                        !age.equals("")) {
                    Students student = new Students(name, surname, Integer.parseInt(age));
                    setData(Client.bucket ,new PackageData("add", null,student));
                    nameField.setText("");
                    surnameField.setText("");
                    ageTextField.setText("");
                }
            }
        });
        back = new JButton("Back");
        back.setSize(100, 30);
        back.setLocation(300, 370);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getAddStudentPage().setVisible(false);
                parent.getMainMenuPage().setVisible(true);
            }
        });
    }
}