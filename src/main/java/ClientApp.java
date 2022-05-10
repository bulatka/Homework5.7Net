import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientApp {
    public static void main(String[] args) {
        final String host = "netology.homework";
        final int port = 8089;
        final int age = 34;
        final String name = "Bulatka";
        final int choice = 5;

        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()))) {
            String resp = " ";
            try {
                while (!resp.equals("end!")) {
                    resp = in.readLine();
                    System.out.println(resp);
                    if (resp.contains("name")) {
                        System.out.println(name);
                        out.println(name);
                    }
                    if (resp.contains("old")) {
                        System.out.println(age);
                        out.println(age);
                    }
                    if (resp.contains("game")) {
                        System.out.println(choice);
                        out.println(choice);
                    }
                }
            } catch (NullPointerException npe) {
                npe.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
