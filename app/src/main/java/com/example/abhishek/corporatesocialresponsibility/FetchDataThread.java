package com.example.abhishek.corporatesocialresponsibility;

/**
 * Created by Abhishek on 11-12-2016.
 */     import android.content.Context;
        import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.net.HttpURLConnection;
        import java.net.MalformedURLException;
        import java.net.ProtocolException;
        import java.net.URL;

public class FetchDataThread {

    public interface Callback {
        public void dataFetched(String responseString);
        public void imageFetched(Bitmap bitmap);
    }

    private Callback mCallback = null;

    public void fetchAndSetText(final Context context, final String url, Callback callback) {
        this.mCallback = callback;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                InputStream inputStream = null;
                String result = "";
                HttpURLConnection connection = null;
                try {
                    URL requestUrl = new URL(url);
                    connection = (HttpURLConnection) requestUrl.openConnection();
                    connection.setRequestMethod("GET");
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        System.out.println(inputLine);
                        result = inputLine.toString();
                        if (result != null && result.length() > 0) {
                            final String result1 = result;
                            if (mCallback != null) {

                                ((MainActivity) context).runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        mCallback.dataFetched(result1);
                                    }
                                });
                            }
                        }
                    }
                    in.close();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();
    }

    public void fetchImageAndSet(final Context context,final  String url, final Callback callback) {
        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                HttpURLConnection connect1 = null;
                try {
                    URL requestUrl = new URL(url);
                    connect1 = (HttpURLConnection) requestUrl.openConnection();
                    connect1.connect();
                    int responseCode = connect1.getResponseCode();
                    if (responseCode == 200) {
                        Bitmap bt=  BitmapFactory.decodeStream(connect1.getInputStream());
                        final Bitmap bt2=bt;
                        if (callback != null) {

                            ((MainActivity) context).runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    callback.imageFetched(bt2);
                                }
                            });
                        } else {
                        }}
                } catch (Exception e) {
                } finally {
                    if (connect1 != null) {
                        connect1.disconnect();
                    }
                }
            }

        });
        thread2.start();
    }
}


