package com.animate;

import com.animate.service.AnimateService;
import org.junit.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AnimateTest {

    private final AnimateService service = new AnimateService();
    private List<String> expected;
    private List<String> result;

    @Test
    public void noParticlesTest() {
        expected = Collections.singletonList("...");
        result = service.animate(1, "...");
        assertEquals(expected, result);
    }

    @Test
    public void veryLittleSpaceTest() {
        expected = Arrays.asList("X", ".");
        result = service.animate(2, "R");
        assertEquals(expected, result);
    }

    @Test
    public void oneParticleSpeedOneTest() {
        expected = Arrays.asList(".X..", "..X.", "...X", "....");
        result = service.animate(1, ".R..");
        assertEquals(expected, result);
    }

    @Test
    public void oneParticleSpeedTwoTest() {
        expected = Arrays.asList(".X..", "...X", "....");
        result = service.animate(2, ".R..");
        assertEquals(expected, result);
    }

    @Test
    public void twoParticlesSpeedTwoTest() {
        expected = Arrays.asList(".X..X..", "..XX...", "X....X.", ".......");
        result = service.animate(2, ".R..L..");
        assertEquals(expected, result);
    }

    @Test
    public void callMethodTwice() {
        expected = Arrays.asList(".X..", "...X", "....");
        result = service.animate(2, ".R..");
        assertEquals(expected, result);

        expected = Arrays.asList(".X..", "..X.", "...X", "....");
        result = service.animate(1, ".R..");
        assertEquals(expected, result);
    }

}
