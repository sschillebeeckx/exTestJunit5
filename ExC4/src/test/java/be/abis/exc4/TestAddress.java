package be.abis.exc4;


import be.abis.exc4.model.Address;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TestAddress {

    Address a;
    @BeforeEach
    public void setUp(){
        a = new Address("Diestsevest","32 bus 4B","3000","Leuven","Belgium","BE");
    }

    @Test
    public void testThatBelgianZipCodeIsNumeric() {
        //arrange
        //done in setUp()

        //act
        boolean b = a.checkBelgianZipCode();

        //assert
        Assert.assertTrue(b);
    }

    @Test
    public void appendingAddressToFileShouldReturnExtraLineInFile() throws IOException {
        Path path = Address.getFilePath();
        int countBeforeWrite=0;
        if (Files.exists(path)) {
            path.toFile().setWritable(true);
            countBeforeWrite = Files.readAllLines(path).size();
        }
        a.writeToFile();
        int countAfterWrite = Files.readAllLines(path).size();
        int linesAdded=countAfterWrite - countBeforeWrite;
        assertEquals(1,linesAdded);
    }

    @Test
    public void appendingAddressToExistingReadOnlyFileShouldThrowIOException() throws IOException {
        Path path = Address.getFilePath();
        File file = path.toFile();
        if (!Files.exists(path)) {
            file.createNewFile();
        }
        file.setReadOnly();
        assertThrows(IOException.class, () -> a.writeToFile());
    }

    @Disabled
    @Test
    //@Ignore  /*Junit4, doesn't work together with JUnit 5 @Test!!!)*/
    public void noIdeaYetWhatWeAreGoingToTest(){

    }
}
