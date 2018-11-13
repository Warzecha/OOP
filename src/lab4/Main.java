package lab4;

import lab4.resume.Document;
import lab4.resume.ParagraphWithList;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Main {


    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {



        Document cv = new Document("Damian Warzecha - CV");
        cv.addPhoto("/home/damian/IdeaProjects/OOP/src/lab4/cv_photo.png");
        cv.addSection("Education")
                .addParagraph("2017-2021 AGH in Cracow - Computer Science")
                .addParagraph("2016-2020 AGH in Cracow - Automatics and Robotics");
        cv.addSection("Skills")
                .addParagraph(
                        new ParagraphWithList().setContent("Programming Languages")
                                .addListItem("C")
                                .addListItem("C++")
                                .addListItem("Java")
                );



        cv.writeHTML(new PrintStream("cv.html","ISO-8859-2"));

    }


}
