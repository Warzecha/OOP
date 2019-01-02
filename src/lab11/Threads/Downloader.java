package lab11.Threads;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Downloader implements Runnable {
    private final String url;

    Downloader(String url)
    {
        this.url = url;
    }

    @Override
    public void run() {

        String[] arr = url.split("/");
        String filename = arr[arr.length - 1];


        try (InputStream in = new URL(url).openStream();
             FileOutputStream out = new FileOutputStream(filename))
        {
            while(true) {
                int c = in.read();
                if (c < 0) break;
                out.write(c);
            }



        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done: " + filename);


    }
}
