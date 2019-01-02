package lab7.Administration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class AdminUnitQueryTest {

    AdminUnitList list = new AdminUnitList();

    @BeforeEach
    public void init() {
        AdminUnit A = new AdminUnit("A", 5, 4, 45.6, 0.5, null, null);
        AdminUnit B = new AdminUnit("B", 5, 4, 45.6, 0.5, null, null);
        AdminUnit C = new AdminUnit("C", 5, 4, 100.6, 0.5, null, null);
        AdminUnit D = new AdminUnit("D", 5, 4, 45.6, 0.5, null, null);
        AdminUnit a1 = new AdminUnit("a1", 6, 4, 15.45, 0.5, A, null);
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
    void execute() {
        AdminUnitQuery query = new AdminUnitQuery()
                .selectFrom(list)
                .where(a->a.getArea()>100)
                .or(a->a.getName().startsWith("a"))
                .sort(Comparator.comparingDouble(AdminUnit::getArea));

        AdminUnitList result = query.execute();

        assertEquals(3, result.getSize());


    }
}