package lab6.csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVReader {
    private BufferedReader reader;
    private String delimiter;
    private boolean hasHeader;


    private List<String> columnLabels = new ArrayList<>();
    private Map<String,Integer> columnLabelsToInt = new HashMap<>();

    private String[]current;








    void parseHeader() {
        // wczytaj wiersz
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (line == null) {
            return;
        }
        // podziel na pola
        String[] header = line.split(delimiter);
        // przetwarzaj dane w wierszu
        for (int i = 0; i < header.length; i++) {
            // dodaj nazwy kolumn do columnLabels i numery do columnLabelsToInt

            columnLabels.add(header[i]);
            columnLabelsToInt.put(header[i], i);

        }
    }


    public boolean next(){

        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (line == null) {
            return false;
        }
        // podziel na pola
        current = line.split(delimiter);



        return true;
    }




    public CSVReader(String filename,String delimiter,boolean hasHeader) {
        try {
            reader = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.delimiter = delimiter;
        this.hasHeader = hasHeader;
        if(hasHeader) parseHeader();

    }


    public String get(int n) {
        if(n >= current.length)
            throw new RuntimeException("Index out of range");
        return current[n];
    }


    public int getInt(int n) {
        if(n >= current.length)
            throw new RuntimeException("Index out of range");
        return Integer.parseInt(current[n]);
    }

    public double getDouble(int n) {
        if(n >= current.length)
            throw new RuntimeException("Index out of range");
        return Double.parseDouble(current[n]);
    }

    public long getLong(int n) {
        if(n >= current.length)
            throw new RuntimeException("Index out of range");
        return Long.parseLong(current[n]);
    }



    public String get(String key) {
        if(columnLabelsToInt.containsKey(key))
        {
            int index = columnLabelsToInt.get(key);
            return current[index];
        }

        throw new RuntimeException("No such element");

    }


    public int getInt(String key) {
        if(columnLabelsToInt.containsKey(key))
        {
            int index = columnLabelsToInt.get(key);
            return Integer.parseInt(current[index]);
        }

        throw new RuntimeException("No such element");

    }

    public double getDouble(String key) {
        if(columnLabelsToInt.containsKey(key))
        {
            int index = columnLabelsToInt.get(key);
            return Double.parseDouble(current[index]);
        }

        throw new RuntimeException("No such element");

    }

    public long getLong(String key) {
        if(columnLabelsToInt.containsKey(key))
        {
            int index = columnLabelsToInt.get(key);
            return Long.parseLong(current[index]);
        }

        throw new RuntimeException("No such element");

    }





    public String get(String key, String defaultValue) {
        if(columnLabelsToInt.containsKey(key))
        {
            int index = columnLabelsToInt.get(key);

            if(!(index < 0 || index >= current.length || current[index].equals("")))
                return current[index];
        }

        return defaultValue;
    }


    public int getInt(String key, int defaultValue) {
        if(columnLabelsToInt.containsKey(key))
        {
            int index = columnLabelsToInt.get(key);
            if(!(index < 0 || index >= current.length || current[index].equals("")))
                return Integer.parseInt(current[index]);
        }

        return defaultValue;

    }

    public double getDouble(String key, double defaultValue) {
        if(columnLabelsToInt.containsKey(key))
        {
            int index = columnLabelsToInt.get(key);
            if(!(index < 0 || index >= current.length || current[index].equals("")))
                return Double.parseDouble(current[index]);
        }

        return defaultValue;

    }

    public long getLong(String key, long defaultValue) {
        if(columnLabelsToInt.containsKey(key))
        {
            int index = columnLabelsToInt.get(key);
            if(!(index < 0 || index >= current.length || current[index].equals("")))
                return Long.parseLong(current[index]);
        }

        return defaultValue;

    }









    public boolean isMissing(int n) {
        return n < 0 || n >= current.length || current[n].equals("");

    }


    public boolean isMissing(String key) {

        int n = columnLabelsToInt.get(key);
        return n < 0 || n >= current.length || current[n].equals("");
    }


    public int getRecordLength() {
        return current.length;
    }


//    public String getCurrentLine() { return current; }


}