package org.example.lesson_4;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {
    private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);
    @BeforeAll
    static void beforeAll() {
        System.out.println("Выполнится 1 раз перез всеми тестами"); // Загрузка данных в базу
        // TRACE, DEBUG, INFO, ERROR
        logger.info("log data");
        logger.trace("trace log data");
        logger.error("error log data");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Выполнится 1 раз перед каждым тестом");
    }

    @Test
    @DisplayName("Проверка площади треугольника")
    void checkAreaOfTriangle() throws Exception {
        assertEquals(6.0, AreaOfTriangle.triangleArea(3,4,5));
    }

    @Test
    @DisplayName("Проверка валидности треугольника")
    void isTriangleValidate() {
        boolean result = AreaOfTriangle.isTriangleValid(10,10,12);
        assertTrue(result);
    }

    @Test
    @DisplayName("Проверка невалидности сторон треугольника")
    void isTriangleInValid() {
        assertAll(() -> assertFalse(AreaOfTriangle.isTriangleValid(-1, 2, 3)),
                () -> assertFalse(AreaOfTriangle.isTriangleValid(1, -2, 3)),
                () -> assertFalse(AreaOfTriangle.isTriangleValid(1, 2, -3)),
                () -> assertFalse(AreaOfTriangle.isTriangleValid(0, 2, 3)),
                () -> assertFalse(AreaOfTriangle.isTriangleValid(1, 0, 3)),
                () -> assertFalse(AreaOfTriangle.isTriangleValid(1, 2, 0)));
    }

    @Test
    @DisplayName("Проверка невалидности треугольника")
    void isTriangleInValid1() {
        boolean result = AreaOfTriangle.isTriangleValid(0,5,4);
        assertFalse(result);
    }

    @AfterEach
    void afterEach() {
        System.out.println("Выполнится 1 раз после каждого теста"); // Закрытие браузера
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Выполнится 1 раз после всех тестов");
    }
}
