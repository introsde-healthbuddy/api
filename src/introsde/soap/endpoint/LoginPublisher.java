package introsde.soap.endpoint;

import javax.xml.ws.Endpoint;

import introsde.soap.ws.LoginImpl;

//Endpoint publisher
public class LoginPublisher{

    public static void main(String[] args) {
	   Endpoint.publish("https://sleepy-fortress-27067.herokuapp.com/project/ws/login", new LoginImpl());
    }

}