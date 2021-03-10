package miniProject.front;

import miniProject.DbManager;
import miniProject.Students;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListPage extends JPanel {

    private MainFrame parent;

    private JLabel label;
    private JButton back;

    private String header[] = {"ID", "Name","Surname","Age"};
    private JTable table;
    private JScrollPane scrollPane;


    public ListPage(MainFrame parent) {

        this.parent = parent;

        setSize(500,500);
        setLayout(null);

        label = new JLabel("SECOND PAGE");
        label.setSize(300,30);
        label.setLocation(100,100);
        add(label);

        back = new JButton("BACK");
        back.setSize(300,30);
        back.setLocation(100,150);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getListPage().setVisible(false);
                parent.getMainMenuPage().setVisible(true);
            }
        });


        table = new JTable();
        table.setFont(new Font("Calibri", Font.PLAIN, 12));
        table.setRowHeight(30);


        scrollPane = new JScrollPane(table);
        scrollPane.setSize(300,200);
        scrollPane.setLocation(100,200);
        add(scrollPane);

    }

    public void generateTable(Students[] students){
        Object data[][] = new Object[students.length][4];

        for(int i =0;i<students.length;i++){
           data[i][0] = students[i].getId();
           data[i][1] = students[i].getName();
           data[i][2] = students[i].getSurname();
           data[i][3] = students[i].getAge();
        }

        DefaultTableModel model = new DefaultTableModel(data, header);
        table.setModel(model);

    }
}