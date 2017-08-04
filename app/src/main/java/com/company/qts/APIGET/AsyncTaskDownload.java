//package com.company.qts.API;
//
//import android.os.AsyncTask;
//import android.util.Log;
//
//import java.io.BufferedInputStream;
//import java.io.BufferedReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.URL;
//
//import javax.net.ssl.HttpsURLConnection;
//
///**
// * Created by MyPC on 04/08/2017.
// */
//public class AsyncTaskDownload extends AsyncTask<String, Void, String> {
//
//    private Downloadinterface downloadinterface = null;
//    public void SetLister (Downloadinterface _downloadinterface)
//    {
//        downloadinterface = _downloadinterface;
//    }
//    String server_response;
//    @Override
//    protected String doInBackground(String... jsonUrl) {
//
//        String dataUrl = jsonUrl[0];
//        InputStream inputStream = null;
//        String strResult = "";
//        try {
//            URL url = new URL(dataUrl);
//            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
//            inputStream = new BufferedInputStream(connection.getInputStream());
//            strResult = convertInputStreamToString(inputStream);//;string return json
//        } catch (Exception e) {
//            Log.i("download json", "Error download json");
//            e.printStackTrace();
//        }
//        Log.i("", "Json:" + strResult);
//        return strResult;
//    }
////        InputStream inputStream = null;
////        URL url;
////        HttpURLConnection urlConnection = null;
////        try {
////            url = new URL(jsonUrl[0]);
////            urlConnection = (HttpURLConnection) url.openConnection();
////            int responseCode = urlConnection.getResponseCode();
////            if (responseCode == HttpURLConnection.HTTP_OK) {
////                server_response = readStream(urlConnection.getInputStream());
////                Log.v("CatalogClient", server_response);
////            }
////        } catch (MalformedURLException e) {
////            e.printStackTrace();
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////
////        try {
////            url = new URL(jsonUrl[0]);
////            urlConnection = (HttpURLConnection) url.openConnection();
////            BufferedReader in = new BufferedReader(new InputStreamReader(
////                    urlConnection.getInputStream()));
////            String inputLine;
////            while ((inputLine = in.readLine()) != null)
////                System.out.println(inputLine);
////            in.close();
////            Log.v("bufferv ", server_response);
////        } catch (MalformedURLException e) {
////            e.printStackTrace();
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        return null;
////    }
////
////    private String readStream(InputStream inputStream) {
////        return null;
////    }
//
//    private String convertInputStreamToString(InputStream inputStream) {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//        String line="", result = "";
//        try {
//            while ( (line = bufferedReader.readLine() ) != null) {
//                result += line;
//            }
//        }catch (Exception e) {
//            Log.i("", "Error!");
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    @Override
//    protected void onPostExecute(String strResult) {
//        super.onPostExecute(strResult);
//        if (downloadinterface != null) {
//            downloadinterface.OnFinisheDownload(strResult);
//        }
//    }
//}
//
