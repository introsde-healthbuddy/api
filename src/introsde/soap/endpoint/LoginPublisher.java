package introsde.soap.endpoint;

import javax.xml.ws.Endpoint;

import introsde.soap.ws.LoginImpl;

//Endpoint publisher
public class LoginPublisher{
	
        public static String SERVER_URL = "http://localhost";
        public static String PORT = "6900";
        public static String BASE_URL = "/ws/login";

        public static String getEndpointURL() {
            return SERVER_URL+":"+PORT+BASE_URL;
        }

        public static void main(String[] args) {
            String endpointUrl = getEndpointURL();
            System.out.println("Starting Login Service...");
            System.out.println("--> Published at = "+endpointUrl);
            Endpoint.publish(endpointUrl, new LoginImpl());
        }
}