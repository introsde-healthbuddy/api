package introsde.soap.client;

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;

import introsde.soap.ws.Login;

public class LoginClientTest{
	
	private static final String WS_URL = "http://localhost:6900/ws/login?wsdl";

	public static void main(String[] args) throws Exception {

	URL url = new URL(WS_URL);
        QName qname = new QName("http://ws.soap.introsde/", "LoginImplService");

        Service service = Service.create(url, qname);
        Login login = service.getPort(Login.class);

        /*******************UserName & Password ******************************/
        Map<String, Object> req_ctx = ((BindingProvider)login).getRequestContext();
        req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WS_URL);

        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        headers.put("Username", Collections.singletonList("ganjasmoker01"));
        headers.put("Password", Collections.singletonList("password"));
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
        /**********************************************************************/

        System.out.println(login.getLoginInfo());

    }
}