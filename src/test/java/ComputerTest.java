import behaviours.IInput;
import behaviours.IOutput;
import device_management.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ComputerTest {
    Computer computer;
    Monitor monitor;
    Keyboard keyboard;
    Mouse mouse;
    ArrayList<IInput> arrayList;

    @Before
    public void before() {
        monitor = new Monitor(22, 786432);
        keyboard = new Keyboard("regular", 101);
        mouse = new Mouse("wired", 3);
        arrayList = new ArrayList<>();
        arrayList.add(mouse);
        arrayList.add(keyboard);
        computer = new Computer(8, 512, monitor, arrayList);
    }

    @Test
    public void hasRam() {
        assertEquals(8, computer.getRam());
    }

    @Test
    public void hasHddSize() {
        assertEquals(512, computer.getHddSize());
    }

//    @Test
////    public void hasMonitor() {
////        assertEquals(22, computer.getMonitor().getScreenSize());
////        assertEquals(786432, computer.getMonitor().getPixels());
////    }

    @Test
    public void hasOutputDevice(){
        IOutput outputDevice = computer.getOutputDevice();
        assertNotNull(outputDevice);
    }

    @Test
    public void canOutputData() {
        assertEquals("space invaders is now on screen", computer.outputData("space invaders"));
    }

//    @Test
//    public void canOutputDataViaPrinter(){
//        Printer printer = new Printer("Epson", "Stylus", 120, 4);
//        Computer computer = new Computer(8, 512, printer, keyboard);
//        assertEquals("printing: space invaders", computer.outputData("space invaders"));
//    }
//
//    @Test
//    public void canOutputViaSpeaker(){
//        Speaker speaker = new Speaker(10);
//        computer = new Computer(16, 1024, speaker, keyboard);
//        assertEquals("playing: Mozart", computer.outputData("Mozart"));
//    }

    @Test
    public void canSetOutputDevice(){
        Printer printer = new Printer("Epson", "Stylus", 120, 4);
        computer.setOutputDevice(printer);
        assertEquals("printing: space invaders", computer.outputData("space invaders"));
    }

//    @Test
//    public void canGetInputDataKeyboard(){
//        assertEquals("You typed and sent Hello World", computer.getinputData("Hello World"));
//    }
//
//    @Test
//    public void canGetInputDataMouse(){
//        Mouse mouse = new Mouse("wired", 3);
//        computer.setInputDevice(mouse);
//        assertEquals("You clicked and sent Hello World", computer.getinputData("Hello World"));
//    }

//    @Test
//    public void canGetKeyboardInputDataFromArrayList(){
//        assertEquals("You typed and sent blah", computer.getinputDataKeyboard("blah"));
//    }

    @Test
    public void canGetInputDataFromArrayList(){
        assertEquals("You clicked and sent hello", computer.getinputData("hello", Mouse.class));
    }
}
