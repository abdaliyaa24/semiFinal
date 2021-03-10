package miniProject;
import miniProject.front.MainFrame;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {

    public static void setData(Bucket bucket, PackageData data){
        try {
            bucket.outputStream.writeObject(data);
            bucket.outputStream.flush();
            bucket.outputStream.reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PackageData getData(Bucket bucket) {
        PackageData dataFromServer;
        try {
            bucket.outputStream.writeObject(new PackageData("list", null,null));
            bucket.outputStream.flush();
            bucket.outputStream.reset();
            while (true) {
                if ((dataFromServer = (PackageData) bucket.inputStream.readObject()) != null) {
                    return dataFromServer;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Bucket bucket;

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 2222);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            bucket = new Bucket(socket, inputStream, outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
    }

    public static Students[] getArrayOf(ArrayList<Students> students) {
        Students[] studentsArray = new Students[students.size()];
        int i = 0;
        for (Students s : students) {
            studentsArray[i] = s;
            i++;
        }
        return studentsArray;
    }

}