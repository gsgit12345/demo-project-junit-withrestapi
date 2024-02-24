package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class CalculatorTest {

    Calculator calculator;
    @Before
    public void setUp()
    {
        calculator=new Calculator();
    }
    @Test
    public void addNumberTest()
    {
        assertEquals(12,calculator.addNumber(3,4));
    }

}
