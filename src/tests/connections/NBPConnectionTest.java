package tests.connections;

import connections.NBPConnection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NBPConnectionTest {

    NBPConnection connection;

    @BeforeEach
    void setUp() {
        connection = new NBPConnection();
    }


    @Test
    public void getCurrentExchangeRate_whenCurrencyIsValid_ReturnProperRate(){

        double result = connection.getCurrentExchangeRate("gbp");

        Assertions.assertTrue(0<=result);
    }

    @Test
    public void getCurrentExchangeRate_whenCurrencyIsNotValid_ReturnMinusOne(){

        double result = connection.getCurrentExchangeRate("invalid");

        Assertions.assertEquals(-1, result);
    }
}