package epi.gi4.tp7amine;

import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RestosWS {



    public static String convertInputStreamToString(InputStream is){
        String ch="";
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        try{
            String x =br.readLine();
            while(x!=null){
                ch+=x;
                x=br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return ch;
    }


    public static String invokeWS(String serverURL) {

        InputStream inputStream = null;
        String result = "";
        try {

            HttpClient httpclient = new DefaultHttpClient();

            HttpResponse httpResponse = httpclient.execute(new HttpGet(serverURL));

            inputStream = httpResponse.getEntity().getContent();

            if (inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";

        } catch (Exception e) {
            Log.i("resultInvoke",result);
            Log.d("InputStream", e.getMessage());
        }

        return result;
    }


}
