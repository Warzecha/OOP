package lab7.Administration;


import lab6.csv.CSVReader;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminUnitList {
    List<AdminUnit> units = new ArrayList<>();


    Map<Long, AdminUnit> idToAdminUnit = new HashMap<>();









    public void read(String filename) {


//        "/home/damian/IdeaProjects/OOP/src/lab7/admin-units.csv"

        CSVReader reader = new CSVReader(filename,",",true);
        while(reader.next()){






            long id = reader.getLong("id", -1);
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

            BoundingBox bbox = new BoundingBox(new double[]{x1, x2, x3, x4}, new double[]{y1, y2, y3, y4});



            AdminUnit new_unit = new AdminUnit(name, adminLevel, population, area, density, null, bbox);



            units.add(new_unit);
            idToAdminUnit.put(id, new_unit);


        }




        reader = new CSVReader(filename,",",true);
        while(reader.next()){



            long id = reader.getLong("id", -1);
            long parentId = reader.getLong("parent", -1);


            if(parentId != -1)
            {
                idToAdminUnit.get(id).setParent(idToAdminUnit.get(parentId));

            }


        }




        for(AdminUnit unit : units)
        {
            unit.fixMissingValues();
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








}