package lab7.Administration;


import lab6.csv.CSVReader;

import java.io.PrintStream;
import java.util.*;
import java.util.function.Predicate;

public class AdminUnitList {
    private List<AdminUnit> units = new ArrayList<>();


    private Map<Long, AdminUnit> idToAdminUnit = new HashMap<>();

    private Map<Long, List<AdminUnit>> parent2children = new HashMap<>();




    public void add(AdminUnit unit)
    {
        units.add(unit);
    }


    public AdminUnit getAdminUnit(int index)
    {
        return units.get(index);
    }
    public int getSize() {return units.size(); }



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

            parent2children.put(id, new LinkedList<AdminUnit>());

        }




        reader = new CSVReader(filename,",",true);
        while(reader.next()){



            long id = reader.getLong("id", -1);
            long parentId = reader.getLong("parent", -1);



            if(parentId != -1)
            {
                idToAdminUnit.get(id).setParent(idToAdminUnit.get(parentId));

                parent2children.get(parentId).add(idToAdminUnit.get(id));

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




    public AdminUnitList getNeighbors(AdminUnit unit, double maxDistance){

        AdminUnitList neighbors = new AdminUnitList();

        for(AdminUnit other : units)
        {
            if(unit.getAdminLevel() == other.getAdminLevel())
            {

                if(unit.getBoundingBox().intersects(other.getBoundingBox()))
                {
                    neighbors.add(other);
                } else if (unit.getAdminLevel() == 8 && unit.getBoundingBox().distanceTo(other.getBoundingBox()) <= maxDistance)
                {
                    neighbors.add(other);
                }



            }



        }

//        throw new RuntimeException("Not implemented");
        return neighbors;
    }



    public AdminUnitList sortInPlaceByName()
    {

        class ComparatorByName implements Comparator<AdminUnit> {


            @Override
            public int compare(AdminUnit o1, AdminUnit o2) {
                return o1.getName().compareTo(o2.getName());
            }

        }

        units.sort(new ComparatorByName());
        return this;
    }


    public AdminUnitList sortInPlaceByArea() {

        units.sort(new Comparator<AdminUnit>(){


            @Override
            public int compare(AdminUnit o1, AdminUnit o2) {
                return Double.compare(o1.getArea(), o2.getArea());
            }

        });

        return this;
    }


    public AdminUnitList sortInPlaceByPopulation()
    {
        units.sort(Comparator.comparingDouble(AdminUnit::getPopulation));


        return this;
    }


    public AdminUnitList sortInPlace(Comparator<AdminUnit> cmp)
    {
        units.sort(cmp);
        return this;
    }



    public AdminUnitList filter(Predicate<AdminUnit> pred)
    {
        AdminUnitList toReturn =  new AdminUnitList();

        for(AdminUnit u : this.units)
        {
            if(pred.test(u))
            {
                toReturn.add(u);
            }
        }

        return toReturn;
    }



    public AdminUnitList filterByStartingLetter(String l) {
        Predicate<AdminUnit> p = new Predicate<AdminUnit>() {
            @Override
            public boolean test(AdminUnit adminUnit) {
                return adminUnit.getName().startsWith(l);
            }
        };
        return filter(p);
    }


    public AdminUnitList filterByAdminLevelAndParent(int adminLevel, String parentName) {
        Predicate<AdminUnit> p = new Predicate<AdminUnit>() {
            @Override
            public boolean test(AdminUnit adminUnit) {
                return adminUnit.getAdminLevel() == adminLevel && adminUnit.getParent().getName() == parentName;
            }
        };
        return filter(p);
    }


    public AdminUnitList filter(Predicate<AdminUnit> pred, int offset, int limit) {


        AdminUnitList toReturn =  new AdminUnitList();

        for(int i = offset; i < Math.min(offset + limit, units.size()); i++)
        {
            if(pred.test(units.get(i)))
            {
                toReturn.add(units.get(i));
            }
        }

        return toReturn;

    }





}