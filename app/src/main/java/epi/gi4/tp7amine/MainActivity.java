package epi.gi4.tp7amine;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new HttpAsyncTask().execute("https://maps.googleapis.com/maps/api/place/textsearch/json?query=restaurant+in+Monastir&sensor=false&key=AIzaSyDhz9NVQu-0efoerbScGQzqCMQgUpohj_E");
        tMain = (TextView) findViewById(R.id.mainTextView);
    }



    private class HttpAsyncTask extends AsyncTask<String, Void, String> {



        protected void onPostExecute(String result){
            Log.i("AAAAPPPPPIIIIII",result);
            tMain.setText(result);
        }

        @Override
        protected String doInBackground(String... urls) {

            Log.i("AAAAPPPPPIIIIII",urls[0]);
            String s=  RestosWS.invokeWS(urls[0]);
            Log.i("sssss",s);
            return s;

        }

    }




}



