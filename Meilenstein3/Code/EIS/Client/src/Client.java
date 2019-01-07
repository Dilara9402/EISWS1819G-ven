import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client
{
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost",8080); //"192.168.43.92"
            System.out.println("Client started");

            OutputStream out=s.getOutputStream();
            PrintWriter writer=new PrintWriter(out);
            InputStream in=s.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(in));
            int ui=-1;

            while (ui!=0) {             //wenn UI 0 ist, wird Schleife beendet
                System.out.println("\nMögliche Befehle: ");
                System.out.println("[1] LED AN/AUS");
                System.out.println("[2] Temperatur anzeigen");
                System.out.println("[3] Stromverbrauch und Stromkosten anzeigen");
                System.out.println("[0] Beendet den Server\n");
                System.out.println("Ihr Eingabe: ");
                Scanner sc=new Scanner(System.in);
                ui=sc.nextInt();

                writer.write(ui+"\n");
                writer.flush();

                String recv;
                while((recv=reader.readLine())!=null)
                    System.out.println(recv);
            }

            System.out.println("Closing connection to server...");
            reader.close();
            writer.close();
            System.out.println("Connection closed. Good bye.");
        }
        catch (SocketException e)
        {
            System.out.println("Server closed the connection or it could not be established");
            System.exit(-1);
        } catch (IOException e)
        {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}