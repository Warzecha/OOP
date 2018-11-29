package lab6.csv;

public class Main {


    public static void main(String[] args) {

        CSVReader reader = new CSVReader("/home/damian/IdeaProjects/OOP/src/lab6/csv/no-header.csv",";",true);
        while(reader.next()){




            System.out.print(reader.get(3));
            System.out.println(reader.get(1));
        }



    }
}

