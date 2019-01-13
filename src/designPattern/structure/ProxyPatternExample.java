package designPattern.structure;

import java.util.ArrayList;
import java.util.List;

public class ProxyPatternExample {
    public static void main(String[] args) {
        IAccessInternet internet = new IEProxy(new IEBrowser());
        internet.getAPI("www.facebook.com");
        internet.getAPI("www.google.com");
        internet.postAPI("www.twitter.com", "username: Long");
        internet.postAPI("www.gmail.com", "username: Long");
    }
}


interface IAccessInternet{
    void getAPI(String address);
    void postAPI(String address, String value);
}

class IEProxy implements IAccessInternet{
    private IEBrowser ieBrowser;
    List<String> blockedSites;
    public IEProxy(IEBrowser ieBrowser) {
        this.ieBrowser = ieBrowser;
        blockedSites = new ArrayList<>();
        blockedSites.add("www.facebook.com");
        blockedSites.add("www.twitter.com");
    }

    @Override
    public void getAPI(String address) {
        if(blockedSites.contains(address)){
            System.out.println("Access denied");
        }
        else ieBrowser.getAPI(address);
    }

    @Override
    public void postAPI(String address, String value) {
        if(blockedSites.contains(address)){
            System.out.println("Access denied");
        }
        else ieBrowser.postAPI(address,value);
    }

}

class IEBrowser implements IAccessInternet{

    @Override
    public void getAPI(String address) {
        System.out.println("IE gets: "+address);
    }

    @Override
    public void postAPI(String address, String value) {
        System.out.println("IE posts:" +address +" with: "+ value);
    }
}