package miniProject;

import java.util.ArrayList;

public interface DAO {
    Students getStudentByName(String name);
    ArrayList<Students> getStudents();
    void addStudent(Students student);
}
