package miniProject;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

public class ClientHandler extends Thread {
    private Socket socket;
    private int id;

    public ClientHandler(Socket socket, int id) {
        this.socket = socket;
        this.id = id;
    }

    public void run() {
        System.out.println("run started");
        try {
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("steam is done");
            PackageData data = null;
            DAO dao = new DAOImpl();
            System.out.println("dao created");
            while ((data = (PackageData) inputStream.readObject()) != null) {
                System.out.println("we get in while");
                if (data.getOperationType().equalsIgnoreCase("add")){
                    System.out.println("go to db");
                    dao.addStudent(data.getStudent());
                    System.out.println("db done");
                }else if (data.getOperationType().equalsIgnoreCase("list")){
                    System.out.println("get list");
                    outputStream.writeObject(new PackageData("done",dao.getStudents(), null));
                    outputStream.flush();
                    outputStream.reset();
                    System.out.println("list sended");
                }
                System.out.println("done");

            }
            System.out.println("not in while");
        } catch (Exception e) {
            try {
                System.out.println(socket.getKeepAlive());
            } catch (SocketException ex) {
                ex.printStackTrace();
            }
            System.out.println("there is some problem catched");
            e.printStackTrace();
        }
    }
}