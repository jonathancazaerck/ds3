package ds3;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class NodeMain {
    public static void main(String[] args) {
        System.setProperty("java.net.preferIPv4Stack", "true");

        String name = args[0];
        int port = args.length > 2 ? Integer.parseInt(args[2]) : Constants.DEFAULT_PORT;
        InetSocketAddress address = new InetSocketAddress(args[1], port);

        try {
            Node node = new Node(name, address);

            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    try {
                        node.shutdown();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    } catch (NotBoundException e) {
                        e.printStackTrace();
                    }
                }
            });

            node.start();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnknownMessageException e) {
            e.printStackTrace();
        }
    }
}
