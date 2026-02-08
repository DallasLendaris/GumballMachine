package cmpe187;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class GumballMachineTest {

    private GumballMachine machine;

    @BeforeEach
    void setUp() {
        machine = new GumballMachine();
    }

    @Test
    void testInitialState() {
        assertEquals(0, machine.getBalance());
    }

    @Test
    void testInsertNickel() {
        machine.insertCoin("nickel");
        assertEquals(0.05, machine.getBalance());
    }

    @Test
    void testInsertQuarter() {
        machine.insertCoin("quarter");
        assertEquals(0.25, machine.getBalance());
    }

}


