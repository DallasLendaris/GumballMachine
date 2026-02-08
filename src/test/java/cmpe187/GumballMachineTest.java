package cmpe187;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class GumballMachineTest {

    private GumballMachine machine;

    @BeforeEach
    void setUp() {
        machine = new GumballMachine();
    }

    // Does a default machine have a balance of $0
    @Test
    void testInitialState() {
        assertEquals(0, machine.getBalance());
    }

    // Does inserting nickel update to correct balance
    @Test
    void testInsertNickel() {
        machine.insertCoin("nickel");
        assertEquals(0.05, machine.getBalance());
    }

    // Does inserting dime update to correct balance
    @Test
    void testInsertDime(){
        machine.insertCoin("dime");
        assertEquals(0.1, machine.getBalance());
    }

    // Does inserting quarter update to correct balance
    @Test
    void testInsertQuarter() {
        machine.insertCoin("quarter");
        assertEquals(0.25, machine.getBalance());
    }

    //Will YGM dispense with enough funds
    @Test
    void testDisenseYGM0(){
        machine.insertCoin("dime");
        assertEquals(true, machine.dispenseGumball("yellow"));
    }

    //Will YGM dispense without enough funds
    @Test
    void testDisenseYGM1(){
        assertEquals(false, machine.dispenseGumball("yellow"));
    }

    // Will RGM dispense with enough funds
    @Test
    void testDisenseRGM0(){
        machine.insertCoin("nickel");
        assertEquals(true, machine.dispenseGumball("red"));
    }

    // Will RGM dispense with enough funds
    @Test
    void testDisenseRGM1(){
        assertEquals(false, machine.dispenseGumball("red"));
    }

    // Does return change empty the balance
    @Test
    void testReturnChange(){
        machine.insertCoin("quarter");
        assertEquals(0.25, machine.getBalance());
        machine.returnChange();
        assertEquals(0, machine.getBalance());
    }

    // Does the string verification work for insertCoin()
    @Test
    void testInsertCoinVerification(){
        machine.insertCoin("sldkfjdslfjk");
        assertEquals(0, machine.getBalance());
    }

    // Does printHelp() work?
    @Test
    void testPrintHelp(){
        assertEquals(true, machine.printHelp());
    }

    

    

}


