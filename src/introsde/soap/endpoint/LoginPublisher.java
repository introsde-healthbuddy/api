package introsde.soap.endpoint;

import javax.xml.ws.Endpoint;

import introsde.soap.ws.LoginImpl;

//Endpoint publisher
public class LoginPublisher{
	
        public static String endpointUrl = "https://sleepy-fortress-27067.herokuapp.com/ws/login";
//        public static String PORT = "";
//        public static String BASE_URL = "/ws/login";

//        public static String getEndpointURL() {
//            return SERVER_URL+BASE_URL;
//        }

        public static void main(String[] args) {
            System.out.println("Starting Login Service...");
            System.out.println("--> Published at = "+endpointUrl);
            Endpoint.publish(endpointUrl, new LoginImpl());
        }
}