import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Random;
import java.util.Scanner;

public class Server
{
    public static void main(String[] args)
    {
        try
        {
            ServerSocket serverSocket=new ServerSocket(8080);
            System.out.println("Server Running");
            Socket client = serverSocket.accept();

            while(true)
            {
                System.out.println("Client connected");
                OutputStream out=client.getOutputStream();
                PrintWriter writer=new PrintWriter(out);

                InputStream in=client.getInputStream();
                BufferedReader reader=new BufferedReader(new InputStreamReader(in));

                String send;
                int cmd=Integer.parseInt(reader.readLine());
                System.out.println("Message From Client: "+cmd);

                if(cmd==0)
                    break;
                else if(cmd==1)
                    send="Die LED ist "+ledStatus();
                else if(cmd==2)
                    send="Es ist "+temperature()+" Grad Celsius";
                else if(cmd==3)
                    send=energy();
                else
                    send="Befehl konnte nicht interpretiert werden.";
                writer.write(send+"\n");
                writer.flush();

                reader.close();
                writer.close();
            }
            serverSocket.close();
        }
        catch(SocketException e)
        {
            System.out.println("Client disconnected");
            e.printStackTrace();
            System.exit(1);
        }
        catch(IOException e)
        {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private static String ledStatus()
    {
        String[] led={"AN","AUS"};
        Random random = new Random();
        int select=random.nextInt(led.length);
        return led[select];
    }

    private static double temperature()
    {
        Random random = new Random();
        return random.nextDouble();
    }

    private static String energy()
    {
        Random costs = new Random();
        Random usage = new Random();
        double kosten=costs.nextDouble();
        double verbrauch=usage.nextDouble();
        return "Sie haben "+verbrauch+" KWH Strom verbrauch. Bei einem Strompreis von "+kosten+" zhalen Sie "+verbrauch*kosten;
    }
}
