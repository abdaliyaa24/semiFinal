package miniProject.front;
import miniProject.Students;

import javax.swing.*;

import javax.swing.*;

public class MainFrame extends JFrame {

    private MainMenu mainMenuPage;
    private AddStudentPage addStudentPage;
    private ListPage listPage;

    public MainMenu getMainMenuPage() {
        return mainMenuPage;
    }

    public AddStudentPage getAddStudentPage() {
        return addStudentPage;
    }

    public ListPage getListPage() {
        return listPage;
    }

    public MainFrame() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("BITLAB Application");
        setSize(500, 500);
        setLayout(null);
        mainMenuPage = new MainMenu(this);
        mainMenuPage.setVisible(true);
        add(mainMenuPage);

        addStudentPage = new AddStudentPage(this);
        addStudentPage.setVisible(false);
        add(addStudentPage);

        listPage = new ListPage(this);
        listPage.setVisible(false);
        add(listPage);
    }

}

