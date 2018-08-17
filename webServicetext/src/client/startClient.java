package client;

public class startClient {
    public static void main(String[] args) {
        StartServerService startServerService = new StartServerService();
        startServerService.getStartServerPort().sayhello();
    }
}
