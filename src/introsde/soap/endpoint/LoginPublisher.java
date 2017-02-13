package introsde.soap.endpoint;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URISyntaxException;

import javax.xml.ws.Endpoint;

import introsde.soap.ws.LoginImpl;

//Endpoint publisher
public class LoginPublisher{

    public static void main(String[] args) throws IllegalArgumentException, IOException, URISyntaxException{
        String PROTOCOL = "http://";
        String HOSTNAME = InetAddress.getLocalHost().getHostAddress();
        if (HOSTNAME.equals("127.0.0.1"))
        {
            HOSTNAME = "localhost";
        }
        String PORT = "6900";
        String BASE_URL = "/ws/login";

        if (String.valueOf(System.getenv("PORT")) != "null"){
            PORT=String.valueOf(System.getenv("PORT"));
        }

        String endpointUrl = PROTOCOL+HOSTNAME+":"+PORT+BASE_URL;
        System.out.println("Starting Inlog Service...");
        System.out.println("--> Published at = "+endpointUrl);
        Endpoint.publish(endpointUrl, new LoginImpl());
        }

}