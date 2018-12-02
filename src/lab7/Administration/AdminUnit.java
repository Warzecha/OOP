package lab7.Administration;

import java.io.PrintStream;

public class AdminUnit {
    String name;
    int adminLevel;
    double population;
    double area;
    double density;
    AdminUnit parent;
    BoundingBox bbox;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAdminLevel() {
        return adminLevel;
    }

    public void setAdminLevel(int adminLevel) {
        this.adminLevel = adminLevel;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public AdminUnit getParent() {
        return parent;
    }

    public void setParent(AdminUnit parent) {
        this.parent = parent;
    }

    public AdminUnit(String name, int adminLevel, double population, double area, double density, AdminUnit parent, BoundingBox bbox) {
        this.name = name;
        this.adminLevel = adminLevel;
        this.population = population;
        this.area = area;
        this.density = density;
        this.parent = parent;
        this.bbox = bbox;
    }



    public double fixMissingValues()
    {
        if(density != -1)
        {
            return density;
        }
        else
        {

            if(parent == null)
            {
                return -1;
            }
            else
            {
                density = parent.fixMissingValues();
                population = density * area;
                return density;
            }


        }

    }





    @Override
    public String toString() {

        String parentName = "none";
        if(parent != null)
        {
            parentName = parent.name;
        }

        return "AdminUnit{" +
                "name='" + name + '\'' +
                ", adminLevel=" + adminLevel +
                ", population=" + population +
                ", area=" + area +
                ", density=" + density +
                ", parent= " + parentName +
                '}';
    }
}

