package tests.controllers;

import controllers.HomeController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HomeControllerTest {

    HomeController homeController;

    @BeforeEach
    void setUp() {
        homeController = new HomeController(0);
    }

    @Test
    public void isInputValueValid_whenInputHasOnlyDigits_ReturnTrue(){

        Boolean result = homeController.isInputValueValid("123456");

        Assertions.assertTrue(result);
    }

    @Test
    public void isInputValueValid_whenInputHasDigitsAndComma_ReturnTrue(){

        Boolean result = homeController.isInputValueValid("123.456");

        Assertions.assertTrue(result);
    }

    @Test
    public void isInputValueValid_whenInputHasDigitsAndTwoCommas_ReturnFalse(){

        Boolean result = homeController.isInputValueValid("1.23.456");

        Assertions.assertFalse(result);
    }

    @Test
    public void isInputValueValid_whenInputHasDigitsAndLetters_ReturnFalse(){

        Boolean result = homeController.isInputValueValid("123aaa");

        Assertions.assertFalse(result);
    }

    @Test
    public void isInputValueValid_whenInputIsEmpty_ReturnFalse(){

        Boolean result = homeController.isInputValueValid("");

        Assertions.assertFalse(result);
    }

    @Test
    public void isInputValueValid_whenInputHasWhitespaces_ReturnFalse(){

        Boolean result = homeController.isInputValueValid("12   45");

        Assertions.assertFalse(result);
    }

    @Test
    public void isInputValueValid_whenInputIsNull_ReturnFalse(){

        Boolean result = homeController.isInputValueValid(null);

        Assertions.assertFalse(result);
    }

}