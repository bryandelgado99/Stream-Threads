import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class hiloClient extends Thread{

    Socket socket_Client;

    public hiloClient(Socket socket_Client){
        this.socket_Client = socket_Client;
    }

    @Override
    public void run() {
        try{
            Scanner scanner = new Scanner(System.in);

               /////////////////////////////////////////////////////////////////////////
               // Creación de buffer de entrada y salida
               BufferedReader entrada = new BufferedReader(
                       new InputStreamReader(socket_Client.getInputStream())
               );
               PrintWriter salida = new PrintWriter(socket_Client.getOutputStream(), true);

               // Lectura de datos del buffer de entrada
               String datos_recibidos = entrada.readLine();
               System.out.println("Los datos recibidos son: " + datos_recibidos);

               // Escritura de datos de entrada
               String mensaje_salida = scanner.nextLine();
               salida.println(mensaje_salida);
        }catch (IOException E){
            E.printStackTrace();
        }
    }
}
