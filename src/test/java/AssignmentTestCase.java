import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import application.Assignment;


class AssignmentTestCase {
	Assignment test = new Assignment(1, 2, 2022, 3, 1, "testing assignment", "example assignment");
//	@BeforeAll
//	public void initialize() {
//		
//	}
	@Test
	public void testClassSetGet() {

		assertEquals("example assignment", test.getAssignmentName());
		assertEquals("testing assignment", test.getDescription());
		test.setAssignmentName("second assignment");
		test.setDescription("testing assignment2");
		assertEquals("second assignment", test.getAssignmentName());
		assertEquals("testing assignment2", test.getDescription());
		
	}
	
}
