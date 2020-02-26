import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Manejador  extends Thread{
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public Manejador(Socket socket, BufferedReader in, PrintWriter out) {
        this.socket = socket;
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String recibido = in.readLine();
                System.out.println("Recibido desde el cliente: " + recibido);
                if (recibido.equalsIgnoreCase("fin")) {
                    System.out.println("Cerrando conexión");
                    socket.close();
                    System.out.println("Cerrada conexión");
                    break;
                }
                out.println(recibido.toUpperCase());
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
