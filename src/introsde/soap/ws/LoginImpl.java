package introsde.soap.ws;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import introsde.rest.ehealth.model.Person;

//Service Implementation Bean
@WebService(endpointInterface = "introsde.soap.ws.Login")
public class LoginImpl implements Login{

    @Resource
    WebServiceContext wsctx;

    @Override
    public String getLoginInfo() {

	MessageContext mctx = wsctx.getMessageContext();

	//get detail from request headers
        Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
        List userList = (List) http_headers.get("Username");
        List passList = (List) http_headers.get("Password");

        String username = "";
        String password = "";

        if(userList!=null){
        	//get username
        	username = userList.get(0).toString();
        }

        if(passList!=null){
        	//get password
        	password = passList.get(0).toString();
        }

        //Should validate username and password with database
        
        if (Person.verifyUser(username, password)){
        	return "logged in!";
        }else{
        	return "Unknown User!";
        }
        
//        if (username.equals("ganjasmoker01") && password.equals("password")){
//        	return "logged in!";
//        }else{
//        	return "Unknown User!";
//        }

    }
}