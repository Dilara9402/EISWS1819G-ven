import java.io.*;
import java.net.*;

public class RCServer {

    private static final int STEERING_CENTER = 1400;
    private static final int STEERING_RIGHT_MAX = 1130;
    private static final int STEERING_LEFT_MAX = 1670;
    private static final int GPIO_PIN = 23;

    private Steering steering;

    RCServer() {
        this.steering = new Steering();
    }

    public static void main(String[] args){

        RCServer rcServer = new RCServer();

        try(ServerSocket serverSocket = new ServerSocket(4141)) {
            while (true) {
                System.out.println("Listening on port 4141, CRTL-C to quit ");
                Socket socket = serverSocket.accept();
                try ( 	PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                         BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                ){
                    System.out.println("Connection accepted.");
                    String in = "";
                    while ((in = input.readLine()) != null) {
                        System.out.println("Received: " + in);
                        if (in.equals("SYN")){ // Synchronize
                            rcServer.write(output, "SYN-ACK"); // Synchronize-Acknowledge
                        }
                        if (in.equals("FIN")){ // Final
                            rcServer.write(output, "FIN-ACK"); // Final-Acknowledge
                            break;
                        }
                        if (in.contains("pwAngle=")){
                            rcServer.write(output, rcServer.turn(in));
                        }
                    }
                    System.out.print("Closing socket.\n\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void write(PrintWriter output, String message) {
        System.out.println("Sending: "+message);
        output.println(message);
    }

    String turn(String input) {
        int i = 0;
        try {
            i = Integer.parseInt(input.substring(8));
            i = (STEERING_RIGHT_MAX + STEERING_LEFT_MAX) - i; // Reverse the value to correct the physical turning direction
            if (i >= STEERING_RIGHT_MAX && i <= STEERING_LEFT_MAX) {
                steering.turnWheels(GPIO_PIN, i);
                return ("response=OK");
            }
        } catch (NumberFormatException e) {
            return ("response=FAILED");
        }
        return "response=FAILED";
    }
}