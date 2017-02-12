package introsde.soap.endpoint;

import javax.xml.ws.Endpoint;

import introsde.soap.ws.LoginImpl;

//Endpoint publisher
public class LoginPublisher{

    public static void main(String[] args) {
	   Endpoint.publish("http://localhost:6900/ws/login", new LoginImpl());
    }

}