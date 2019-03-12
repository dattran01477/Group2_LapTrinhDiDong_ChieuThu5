package com.example.calculator;

import com.example.calculator.MathImpl.Operation;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    Operation ope = new Operation();
    @Test
    public void addition_isCorrect() {
        assertEquals(5, 3 + 2);
    }
    @Test
    public void addition() {
        assertEquals(5,2+3);
    }
}