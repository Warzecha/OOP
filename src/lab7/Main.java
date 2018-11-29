package lab7;

import lab7.Administration.AdminUnitList;

public class Main {


    public static void main(String args[]) {



//        "/home/damian/IdeaProjects/OOP/src/lab7/admin-units.csv"


        AdminUnitList unitList = new AdminUnitList();

        unitList.read("/home/damian/IdeaProjects/OOP/src/lab7/admin-units.csv");



        unitList.list(System.out, 10, 0);




    }


}
