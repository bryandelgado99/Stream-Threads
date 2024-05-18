import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Proxy;
import java.net.Socket;
import java.util.Scanner;


public class Client {
    public static void main(String[] args) {

        do {

            Scanner scanner = new Scanner(System.in);

            try {
                Socket socket_Client = new Socket("localhost", 5000);
                System.out.println("Cliente conectado...");

                /////////////////////////////////////////////////////////////////////////

                // Creación de buffer de entrada y salida
                BufferedReader entrada = new BufferedReader(new InputStreamReader(socket_Client.getInputStream()));
                PrintWriter salida = new PrintWriter(socket_Client.getOutputStream(), true);

                String datosRecibidos;

                while ((datosRecibidos = entrada.readLine()) != null) {
                    System.out.println("Server: " + datosRecibidos);

                    if (datosRecibidos.equals("No more questions")) {
                        break;
                    } else if (datosRecibidos.equals("Next question")) {
                        continue;
                    } else if (datosRecibidos.startsWith("Wrong.") || datosRecibidos.equals("Correct")) {
                        continue;
                    } else {
                        System.out.print("Escriba su respuesta: ");
                        String answers = scanner.nextLine();
                        salida.println(answers);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (true);
    }
}
