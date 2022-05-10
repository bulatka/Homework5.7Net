import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] args) {
        int port = 8089;

        try (ServerSocket server = new ServerSocket(port);
             Socket socket = server.accept();
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()))) {
            System.out.println("New connection accepted");
            out.println("Write your name please:");

            final String name = in.readLine();


            out.println(String.format("Hi %s, how old are you?", name));

            try {
                final int age = Integer.parseInt(in.readLine());
                if (age < 18) {
                    out.println(String.format("Welcome to the kids area, %s! Let's watch cartoons!", name));
                    out.println("end!");
                } else if ((age >= 18) && (age <= 69)) {
                    out.println(String.format("Welcome to the adults area, %s! Let's play a game!))) Chose a number from 1 to 5!", name));
                    int choice = Integer.parseInt(in.readLine());
                    switch (choice) {
                        case 1:
                            out.println("Thank you for your choice! You are watching BDSM porno now!");
                            out.println("end!");
                        case 2:
                            out.println("Thank you for your choice! You are watching RickRoll now!");
                            out.println("end!");
                        case 3:
                            out.println("Thank you for your choice! You are watching BesogonTV now!");
                            out.println("end!");
                        case 4:
                            out.println("Thank you for your choice! You are watching SolovievLive now!");
                            out.println("end!");
                        case 5:
                            out.println("Thank you for your choice! You are watching Press Conference of President of the Russian Federation Vladimir Vladimirovich Putin now!");
                            out.println("end!");
                        case default:
                            out.println("Are you kidding me?");
                            out.println("end!");
                    }
                } else {
                    out.println(String.format("Dear, %s! Your are too aged! Please take your pills or you'll get asskicked.", name));
                    out.println("end!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
