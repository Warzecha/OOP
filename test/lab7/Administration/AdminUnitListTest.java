package lab7.Administration;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class ComparatorByName implements Comparator<AdminUnit> {


    @Override
    public int compare(AdminUnit o1, AdminUnit o2) {
        return o1.getName().compareTo(o2.getName());
    }

}



class AdminUnitListSortingTest {


    AdminUnitList list = new AdminUnitList();

    @BeforeEach
    public void init() {
            list.add(new AdminUnit("B", 8, 4, 45.6, 0.5, null, null));
            list.add(new AdminUnit("A", 8, 6, 17, 0.5, null, null));
            list.add(new AdminUnit("Z", 8, 1, 23, 0.5, null, null));
            list.add(new AdminUnit("D", 8, 25.3, 11.909, 0.5, null, null));
            list.add(new AdminUnit("A", 8, 3.33, 1.56, 0.5, null, null));
            list.add(new AdminUnit("G", 8, 7.08, 1234, 0.5, null, null));
            list.add(new AdminUnit("Q", 8, 6.00, 1.56, 0.5, null, null));


    }



    @Test
    void sortInPlaceByName() {

        list.sortInPlaceByName();

        for(int i = 0; i < list.getSize() - 1; i++)
        {
            assertTrue(list.getAdminUnit(i).getName().compareTo(list.getAdminUnit(i+1).getName()) < 1);
        }
    }

    @Test
    void sortInPlaceByArea() {
        list.sortInPlaceByArea();

        for(int i = 0; i < list.getSize() - 1; i++)
        {
            assertTrue(list.getAdminUnit(i).getArea() <= list.getAdminUnit(i+1).getArea());
        }
    }

    @Test
    void sortInPlaceByPopulation() {
        list.sortInPlaceByPopulation();

        for(int i = 0; i < list.getSize() - 1; i++)
        {
            assertTrue(list.getAdminUnit(i).getPopulation() <= list.getAdminUnit(i+1).getPopulation());
        }
    }

    @Test
    void sortInPlace() {

        list.sortInPlace(new ComparatorByName());

        for(int i = 0; i < list.getSize() - 1; i++)
        {
            assertTrue(list.getAdminUnit(i).getName().compareTo(list.getAdminUnit(i+1).getName()) < 1);
        }


    }
}