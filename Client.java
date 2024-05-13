import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Proxy;
import java.net.Socket;
import java.util.Scanner;


public class Client {
    public static void main(String[] args) {

        while(true){

            Scanner scanner = new Scanner(System.in);

            try {
                Socket socket_Client = new Socket("localhost", 5000);
                System.out.println("Cliente conectado...");

                /////////////////////////////////////////////////////////////////////////

                    // Creación de buffer de entrada y salida
                    BufferedReader entrada = new BufferedReader(
                            new InputStreamReader(socket_Client.getInputStream())
                    );
                    PrintWriter salida = new PrintWriter(socket_Client.getOutputStream(), true);

                    // Escritura de datos de entrada
                    String mensaje_salida = scanner.nextLine();
                    salida.println(mensaje_salida);

                    // Lectura de datos del buffer de entrada
                    String datos_recibidos = entrada.readLine();
                    System.out.println("Los datos recibidos son: " + datos_recibidos);
            }catch (IOException E){
                E.printStackTrace();
            }
        }
    }
}
