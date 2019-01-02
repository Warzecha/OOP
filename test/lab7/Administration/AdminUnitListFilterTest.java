package lab7.Administration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdminUnitListFilterTest {

    AdminUnitList list = new AdminUnitList();

    @BeforeEach
    public void init() {
        AdminUnit A = new AdminUnit("A", 5, 4, 45.6, 0.5, null, null);
        AdminUnit B = new AdminUnit("B", 5, 4, 45.6, 0.5, null, null);
        AdminUnit C = new AdminUnit("C", 5, 4, 45.6, 0.5, null, null);
        AdminUnit D = new AdminUnit("D", 5, 4, 45.6, 0.5, null, null);
        AdminUnit a1 = new AdminUnit("a1", 6, 4, 45.6, 0.5, A, null);
        AdminUnit a2 = new AdminUnit("a2", 6, 4, 45.6, 0.5, A, null);
        AdminUnit c1 = new AdminUnit("c1", 6, 4, 45.6, 0.5, C, null);
        AdminUnit d1 = new AdminUnit("d1", 6, 4, 45.6, 0.5, D, null);

        list.add(A);
        list.add(B);
        list.add(C);
        list.add(D);
        list.add(a1);
        list.add(a2);
        list.add(c1);
        list.add(d1);
    }

    @Test
    void filter()
    {
        AdminUnitList filtered = list.filter(o -> o.getName().startsWith("a"));
        assertEquals(2, filtered.getSize());
    }

    @Test
    void filterByStartingLetter()
    {
        AdminUnitList filtered = list.filterByStartingLetter("a");
        assertEquals(2, filtered.getSize());
    }


    @Test
    void filterByAdminLevelAndParent()
    {
        AdminUnitList filtered = list.filterByAdminLevelAndParent(6, "A");
        assertEquals(2, filtered.getSize());
    }


    @Test
    void filterWithLimitAndOffset()
    {
        AdminUnitList filtered = list.filter(o -> o.getPopulation() == 4, 5, 5);
        assertEquals(3, filtered.getSize());
    }


}
