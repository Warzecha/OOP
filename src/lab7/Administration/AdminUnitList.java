package lab7.Administration;


import lab6.csv.CSVReader;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminUnitList {
    List<AdminUnit> units = new ArrayList<>();


    Map<Long, AdminUnit> idToParent;









    public void read(String filename) {


//        "/home/damian/IdeaProjects/OOP/src/lab7/admin-units.csv"

        CSVReader reader = new CSVReader(filename,",",true);
        while(reader.next()){

            System.out.println(reader.get(2));




            int id = reader.getInt("id", -1);
            int parentId = reader.getInt("parent", -1);
            String name = reader.get("name", "Missing name");
            int adminLevel = reader.getInt("admin_level", -1);
            double population = reader.getDouble("population", -1);
            double area = reader.getDouble("area", -1);
            double density = reader.getDouble("density", -1);
            double x1 = reader.getDouble("x1", -1);
            double y1 = reader.getDouble("y1", -1);
            double x2 = reader.getDouble("x2", -1);
            double y2 = reader.getDouble("y2", -1);



            double x3 = reader.getDouble("x3", -1);
            double y3 = reader.getDouble("y3", -1);
            double x4 = reader.getDouble("x4", -1);
            double y4 = reader.getDouble("y4", -1);


//            AdminUnit parent = new AdminUnit("Parent", -1, -1, -1, -1, null);

            AdminUnit new_unit = new AdminUnit(name, adminLevel, population, area, density, null);



            units.add(new_unit);


        }


    }


    public void list(PrintStream out, int limit, int offset) {

        for(int i = offset; i < Math.min(offset+limit, units.size()); i++)
        {

            out.println(units.get(i).toString());

        }

    }


    public void list(PrintStream out){
        for(AdminUnit unit : units)
        {
            out.println(unit.toString());
        }

    }





    public void fixMissingValues() {

        for(AdminUnit unit : units)
        {

            if(unit.getDensity() == -1 && unit.parent != null)
            {

                unit.setDensity(unit.parent.getDensity());

                unit.setPopulation(unit.getArea() * unit.getDensity());


            }


        }

    }




}