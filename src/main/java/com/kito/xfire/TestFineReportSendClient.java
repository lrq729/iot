package com.kito.xfire;/**
 * Created by zhaoyipc on 2017/6/14.
 */

import org.codehaus.xfire.client.Client;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author zhaoyi
 * @date 2017-06-2017/6/14-16:38
 */
public class TestFineReportSendClient {
    public static void helloWorld(){
        try {
            System.out.println("================================helloWorld()========================");
            URL url = new URL("http://localhost:8080/kito/services/FineReportSendService?wsdl");
            Client client = new Client(url);
            Object[] results = new Object[1];
            results = client.invoke("executeSaleImgSend",null);
            System.out.println(results[0]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        helloWorld();
    }
}
