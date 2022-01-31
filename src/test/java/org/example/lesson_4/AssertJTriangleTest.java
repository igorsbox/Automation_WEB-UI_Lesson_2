package org.example.lesson_4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTriangleTest {
    @Test
    void assertJTest1() {
        assertThat(AreaOfTriangle.isTriangleValid( 2,3,4)).isTrue().isEqualTo(true);
    }

    @Test
    void assertJTest2() throws Exception {
        assertThat(AreaOfTriangle.triangleArea(30,50,40)).isEqualTo(600);
    }
}
