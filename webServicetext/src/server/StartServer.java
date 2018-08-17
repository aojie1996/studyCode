package server;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class StartServer {
    public void sayhello(){
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        String address = "http://localhost:8080/hand";
        Endpoint.publish(address,new StartServer());
        System.out.println("发布成功");
    }
}
