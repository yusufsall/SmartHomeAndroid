package sal.yusuf.numur;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yusuf on 25.11.2017.
 */

public class UdpCommunication  {
    public static List<String> messages = new ArrayList<>();
    static DatagramSocket socket;
    static InetAddress IPAddress;
    static String ip = "192.168.1.177";
    static int port = 8888;
    static boolean isStarted = false;

    public static void start(){
        String ip = "192.168.1.177";

        try {
            socket = new DatagramSocket(port);
            IPAddress =  InetAddress.getByName(ip);
            isStarted = true;
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

    public static void send(String message){
        ClickListener.busy = true;

        byte[] send_data = message.getBytes();

        try {
            IPAddress =  InetAddress.getByName(ip);
            DatagramPacket send_packet = new DatagramPacket(send_data,message.length(), IPAddress, port);
            socket.send(send_packet);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ClickListener.busy = false;

    }

    public static void recieve(){
        byte[] recvBuf = new byte[15000];

        while(true) {
            DatagramPacket packet = new DatagramPacket(recvBuf, recvBuf.length);
            try {
                socket.receive(packet);

                String message = new String(packet.getData()).trim();

                if(!message.equals("")) {
                    String buffer = "";
                    List<String> bufferList = new ArrayList<>();

                    messages.add(message);
                    int ln = UdpCommunication.messages.size();
                    if(ln > 0) {
                        for (char buf : UdpCommunication.messages.get(ln - 1).toCharArray()) {
                            if (buf == ':') {
                                bufferList.add(buffer);
                                buffer = "";
                            } else
                                buffer += buf;
                        }

                        for (int i = 0; i < 16; i++) {
                            BaseActivity.relays[i] = bufferList.get(2 * i + 1).equals("1");
                        }
                        BaseActivity.sicaklik = Float.parseFloat(bufferList.get(33));
                        BaseActivity.nem = Float.parseFloat(bufferList.get(35));
                        BaseActivity.checkDoor = bufferList.get(37).equals("1");
                    }
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void close(){
    }
}
