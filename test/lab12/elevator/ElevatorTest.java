package lab12.elevator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElevatorTest {


    Elevator elevator = new Elevator();

    @BeforeAll
    static void setup() {
        Elevator.init();
    }

    @BeforeEach
    void reset() throws InterruptedException {
        Elevator.makeInternalCall(0);
        Thread.currentThread().sleep(100);
    }


    @Test
    void goToInternallyCalledFloor() throws InterruptedException {

        Elevator.makeInternalCall(7);
        Thread.currentThread().sleep(100);
        assertEquals(7, elevator.getCarFloor());
    }


    @Test
    void goToExternallyCalledFloor() throws InterruptedException {

        Elevator.makeExternalCall(7, true);
        Thread.currentThread().sleep(100);
        assertEquals(7, elevator.getCarFloor());
    }


    @Test
    void stopsAtAllStops() throws InterruptedException {

        Elevator.makeInternalCall(4);
        Elevator.makeInternalCall(7);
        assertEquals(2, Elevator.internalPanelAgent.input.size());
        Thread.currentThread().sleep(200);
//        assertEquals(7, elevator.getCarFloor());
        assertEquals(0, Elevator.internalPanelAgent.input.size());
    }

    @Test
    void reachesTopFloor() throws InterruptedException {
        Elevator.makeInternalCall(4);
        Elevator.makeExternalCall(7, false);
        Thread.currentThread().sleep(200);
        assertEquals(7, elevator.getCarFloor());
    }


    @Test
    void doesNotStopWhenGoingInDifferentDirection() throws InterruptedException {
        Elevator.makeInternalCall(4);
        Elevator.makeInternalCall(7);

        Elevator.makeExternalCall(5, false);
        Thread.currentThread().sleep(100);

        System.out.println(elevator.getCarFloor());
        assertEquals(5, elevator.getCarFloor());
        assertEquals(0, Elevator.internalPanelAgent.input.size());
    }




}