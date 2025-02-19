package com.example.geometry;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

@Epic("Тестирование геометрических фигур")
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class ShapeTest {

    @Test
    @Feature("Круг")
    @Story("Вычисление площади круга")
    @Description("Проверяет, правильно ли рассчитывается площадь круга")
    public void testCircleArea() {
        Circle circle = new Circle(5);
        double expectedArea = Math.PI * Math.pow(5, 2);
        logTestStep("Рассчитываем площадь круга");
        assertEquals(expectedArea, circle.calculateArea(), 0.001, "Площадь круга должна быть верной");
    }

    @Test
    @Feature("Круг")
    @Story("Вычисление периметра круга")
    public void testCirclePerimeter() {
        Circle circle = new Circle(5);
        double expectedPerimeter = 2 * Math.PI * 5;
        logTestStep("Рассчитываем периметр круга");
        assertEquals(expectedPerimeter, circle.calculatePerimeter(), 0.001, "Периметр круга должен быть верным");
    }

    @Test
    @Feature("Прямоугольник")
    @Story("Вычисление площади прямоугольника")
    public void testRectangleArea() {
        Rectangle rectangle = new Rectangle(5, 10);
        double expectedArea = 5 * 10;
        logTestStep("Рассчитываем площадь прямоугольника");
        assertEquals(expectedArea, rectangle.calculateArea(), 0.001, "Площадь прямоугольника должна быть верной");
    }

    @Test
    @Feature("Прямоугольник")
    @Story("Вычисление периметра прямоугольника")
    public void testRectanglePerimeter() {
        Rectangle rectangle = new Rectangle(5, 10);
        double expectedPerimeter = 2 * (5 + 10);
        logTestStep("Рассчитываем периметр прямоугольника");
        assertEquals(expectedPerimeter, rectangle.calculatePerimeter(), 0.001, "Периметр прямоугольника должен быть верным");
    }

    @ParameterizedTest
    @Feature("Квадрат")
    @Story("Параметризованный тест для квадратов")
    @ValueSource(doubles = {1.0, 2.0, 5.0, 10.0})
    public void testSquare(double side) {
        Square square = new Square(side);
        double expectedArea = side * side;
        double expectedPerimeter = 4 * side;
        logTestStep("Рассчитываем площадь и периметр квадрата");

        assertEquals(expectedArea, square.calculateArea(), 0.001, "Площадь квадрата должна быть верной");
        assertEquals(expectedPerimeter, square.calculatePerimeter(), 0.001, "Периметр квадрата должен быть верным");
    }

    @Test
    @Feature("Треугольник")
    @Story("Тест для треугольника")
    public void testTriangle() {
        Triangle triangle = new Triangle(3, 4, 5);
        double expectedArea = 6.0; // Площадь по формуле Герона
        double expectedPerimeter = 3 + 4 + 5;
        logTestStep("Рассчитываем площадь и периметр треугольника");

        assertEquals(expectedArea, triangle.calculateArea(), 0.001, "Площадь треугольника должна быть верной");
        assertEquals(expectedPerimeter, triangle.calculatePerimeter(), 0.001, "Периметр треугольника должен быть верным");
    }

    @Step("{0}")
    private void logTestStep(String message) {
        // Метод для логирования шагов в Allure
    }
}
