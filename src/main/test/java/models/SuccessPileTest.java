package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SuccessPileTest {

    @Test
    public void constructed() {
        // Assign a temporary variable to the constructor of Class SuccessPile
        SuccessPile temp = new SuccessPile();

        // Function only has a constructor, ensure that when we instantiate the variable
        // it is set to something other than null
        assertNotNull(temp);

    }

}