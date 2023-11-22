package com.example.tddminiprojekt1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    Triangle triangle = new Triangle();
    @Test
    @DisplayName("testConstructor")
    void testConstructor() {
        Triangle triangle = new Triangle(2, 3, 4);
        assertEquals(Triangle.TYPE.SCALENE, triangle.getCurrent_type());
    }
    @Test
    @DisplayName("testConstructor2")
    void testConstructor2() {
        String[] in = new String[]{"2", "3", "4"};
        Triangle triangle = new Triangle(in);
        assertEquals(Triangle.TYPE.SCALENE, triangle.getCurrent_type());
    }
    @Test
    @DisplayName("almostTooBigSide")
    void testAlmostTooBigSideIsTriangle() {
        String userInput = "5999, 2999, 2999";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        triangle.getUserInput();
        assertNull(triangle.getCurrent_type());
    }
    @Test
    @DisplayName("123IsScalene")
    void testIsScalene() {
        String userInput = "2,4,3";

        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        triangle.getUserInput();
        assertEquals(Triangle.TYPE.SCALENE, triangle.getCurrent_type());
    }
    @Test
    @DisplayName("464IsIsosceles")
    void testIsIsosceles() {
        String userInput = "4,6,4";

        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        triangle.getUserInput();
        assertEquals(Triangle.TYPE.ISOSCELES, triangle.getCurrent_type());
    }
    @Test
    @DisplayName("233IsIsosceles")
    void testIsIsosceles2() {
        String userInput = "2,3,3";

        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        triangle.getUserInput();
        assertEquals(Triangle.TYPE.ISOSCELES, triangle.getCurrent_type());
    }
    @Test
    @DisplayName("778IsIsosceles")
    void testIsIsosceles3() {
        String userInput = "7,7,8";

        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        triangle.getUserInput();
        assertEquals(Triangle.TYPE.ISOSCELES, triangle.getCurrent_type());
    }
    @Test
    @DisplayName("444IsEquilateral")
    void testIsEquilateral() {
        String userInput = "4,4,4";

        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        triangle.getUserInput();
        assertEquals(Triangle.TYPE.EQUILATERAL, triangle.getCurrent_type());
    }
    @Test
    @DisplayName("bigNumbersIsEquilateral")
    void testBigNumIsEquilateral() {
        String userInput = Integer.MAX_VALUE + "," + Integer.MAX_VALUE + "," + Integer.MAX_VALUE;

        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        triangle.getUserInput();
        assertEquals(Triangle.TYPE.EQUILATERAL, triangle.getCurrent_type());
    }
    @Test
    @DisplayName("TooBigNumber")
    void testTooBigNumIsNull() {
        String userInput =  (Long.parseLong(Integer.MAX_VALUE + "") + 1) + "," + Integer.MAX_VALUE + "," + Integer.MAX_VALUE;
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        triangle.getUserInput();
        assertNull(triangle.getCurrent_type());
    }
    @Test
    @DisplayName("IsoscelesOutput")
    void testIsIsoscelesOutput() {
        String userInput = "4,6,4";

        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        triangle.getUserInput();
        assertEquals("4, 6, 4, This is a Isosceles triangle", triangle.toString());
    }
    @Test
    @DisplayName("EquilateralOutput")
    void testIsEquilateralOutput() {
        String userInput = "6,6,6";

        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        triangle.getUserInput();
        assertEquals("6, 6, 6, This is a Equilateral triangle", triangle.toString());
    }
    @Test
    @DisplayName("ScaleneOutput")
    void testIsScaleneOutput() {
        String userInput = "5,6,7";

        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        triangle.getUserInput();
        assertEquals("5, 6, 7, This is a Scalene triangle", triangle.toString());
    }
    @Test
    @DisplayName("NullOutput")
    void testIsNullOutput() {
        String userInput = "5,fgh,7";

        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        triangle.getUserInput();
        assertEquals("0, 0, 0, This is not a triangle", triangle.toString());
    }


    @Test
    @DisplayName("testConstructor3")
    void testConstructorIsNotTriangle() {
        String[] in = new String[]{"2", "3"};
        Triangle triangle = new Triangle(in);
        assertNull(triangle.getCurrent_type());
    }
    @Test
    @DisplayName("testConstructor3")
    void testConstructorIsNotTriangle2() {
        String[] in = new String[]{"2", "3", "4", "5"};
        Triangle triangle = new Triangle(in);
        assertNull(triangle.getCurrent_type());
    }
    @Test
    @DisplayName("testConstructor4")
    void testConstructorIsNotTriangle3() {
        String[] in = new String[]{"2", "3", "bla"};
        Triangle triangle = new Triangle(in);
        assertNull(triangle.getCurrent_type());
    }
    @Test
    @DisplayName("tooBigSide")
    void testTooBigSideIsNotTriangle() {
        String userInput = "333,333,666";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        triangle.getUserInput();
        assertNull(triangle.getCurrent_type());
    }
    @Test
    @DisplayName("tooBigSide2")
    void testTooBigSideIsNotTriangle2() {
        String userInput = "5000,4,4";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        triangle.getUserInput();
        assertNull(triangle.getCurrent_type());
    }
    @Test
    @DisplayName("tooBigSide3")
    void testTooBigSideIsNotTriangle3() {
        String userInput = "1,2,1";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        triangle.getUserInput();
        assertNull(triangle.getCurrent_type());
    }
    @Test
    @DisplayName("NotEnoughNumbers")
    void testTooFewNumbersIsNotTriangle() {
        String userInput = "2,2";

        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        triangle.getUserInput();
        assertNull(triangle.getCurrent_type());
    }
    @Test
    @DisplayName("OneSideNegative")
    void testOneSideNegativeIsNotTriangle() {
        String userInput = "-4,4,4";

        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        triangle.getUserInput();
        assertNull(triangle.getCurrent_type());
    }
    @Test
    @DisplayName("OneSideNegative2")
    void testOneSideNegativeIsNotTriangle2() {
        String userInput = "4,-4,4";

        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        triangle.getUserInput();
        assertNull(triangle.getCurrent_type());
    }
    @Test
    @DisplayName("OneSideNegative3")
    void testOneSideNegativeIsNotTriangle3() {
        String userInput = "4,4,-4";

        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        triangle.getUserInput();
        assertNull(triangle.getCurrent_type());
    }
    @Test
    @DisplayName("ZeroIsNotTriangle")
    void testOneSideZeroIsNotTriangle() {
        String userInput = "0,1,1";

        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        triangle.getUserInput();
        assertNull(triangle.getCurrent_type());
    }
    @Test
    @DisplayName("ZeroIsNotTriangle2")
    void testOneSideZeroIsNotTriangle2() {
        String userInput = "1,0,1";

        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        triangle.getUserInput();
        assertNull(triangle.getCurrent_type());
    }
    @Test
    @DisplayName("ZeroIsNotTriangle2")
    void testOneSideZeroIsNotTriangle3() {
        String userInput = "1,1,0";

        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        triangle.getUserInput();
        assertNull(triangle.getCurrent_type());
    }

}