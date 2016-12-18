package com.xoxo.dccapp.Coonection;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by danieloduonye on 12/18/16.
 */

public class JsonTask extends AsyncTask<String, String, String> {
      CallBackFunction callBackFunction;
    public  JsonTask(CallBackFunction callBackF){
        callBackFunction = callBackF;
    }
    @Override
    protected String doInBackground(String... strings) {

        HttpURLConnection connection = null;
        BufferedReader reader = null;
        try {
            URL url = new URL(strings[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();


            InputStream stream = connection.getInputStream();
            callBackFunction.success(stream);
              /*  reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";

                while ((line = reader.readLine()) != null) {
                    buffer.append(line+"\n");
                    Log.d("Response: ", "> " + line);   //here u ll get whole response...... :-)

                }

                */

            return null;


        } catch (MalformedURLException e) {
            e.printStackTrace();
            callBackFunction.error();
        } catch (IOException e) {
            e.printStackTrace();
            callBackFunction.error();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    protected void onPreExecute() {
        super.onPreExecute();
    }

}
