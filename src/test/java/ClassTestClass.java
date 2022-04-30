import static org.junit.jupiter.api.Assertions.*;

import javafx.scene.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.jupiter.api.Test;

import application.Assignment;
import application.Class;

class ClassTestClass {
    Class c = new Class();

    @Test
    public void testClassName() {
        String expected = "COMP-129";
        c.setClassName(expected);
        String actual = c.getClassName();
        assertEquals(expected, actual);
    }
    @Test
    public void testClassAssignments() {
        Assignment a1 = new Assignment();
        Assignment a2 = new Assignment();
        ArrayList<Assignment> list = new ArrayList<Assignment>();
        list.add(a1);
        list.add(a2);
        
        c.setAssignments(list);
        assertEquals(list, c.getAssignments());
    }
    @Test
    public void testClassLocation() {
        String expected = "CTC 113";
        c.setMeetingLoc(expected);
        String actual = c.getMeetingLoc();
        assertEquals(expected, actual);
    }
    @Test
    public void testClassIcon() {
        //String expected = "1";
        //c.setIcon(expected);
        //String actual = c.getIcon();
       // assertEquals(expected, actual);
    }
    @Test
    public void testClassColor() {
        Color col = Color.RED;
        c.setColor(col);
        Color col2 = c.getColor();
        assertEquals(col, col2);
    }
    @Test
    public void testClassDuration() {
        int expected = 75;
        c.setClassDuration(expected);
        int actual = c.getClassDuration();
        assertEquals(expected, actual);
    }
    @Test
    public void testClassTimes() {
        Calendar calendar = Calendar.getInstance();
        ArrayList<Calendar> list = new ArrayList<Calendar>();
        list.add(calendar);
        //c.setMeetingTimes(list);
        //ArrayList<Calendar> actual = c.getMeetingTimes();
       // assertEquals(list, actual);
    }

}