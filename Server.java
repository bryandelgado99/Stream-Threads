import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class Server {

    public static void main(String[] args) throws IOException {

           try{
               ServerSocket socket_Server = new ServerSocket(5000);
               System.out.println("Esperando conexión...\n");

               while(true) {

                   Socket socket_Client = socket_Server.accept();

                   hiloClient hilo = new hiloClient(socket_Client);
                   hilo.start();

               }
           }catch (IOException e){
               e.printStackTrace();
           }
    }
}
