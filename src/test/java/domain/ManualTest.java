package domain;

import domain.Manual;
import logic.Validator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ManualTest {
//CHECKSTYLE:OFF
    private Manual instance;
    private final String[] mockValues = {"Mornom Random", 
                                        "Uni. Madagaskar", 
                                        "Too bad C 23", 
                                        "Sovietlux", 
                                        "February", 
                                        "2099",
                                        "the key"};
//CHECKSTYLE:ON  
    @Before
    public void setUp() {
        instance = new Manual();
    }
    
    public Manual createMockManual() {
        Manual manual = new Manual();
        manual.setTitle("Prediction and real-time compensation of qubit "
                + "decoherence via machine learning");
        
        for (int i = 0; i < this.mockValues.length; i++) {
            manual.setField(manual.getOptionalFields().get(i), mockValues[i]);
        }
        return manual;
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setAuthor method, of class Manual.
     */
    @Test
    public void testSetTitle() {
        String title = "Manual of Cooperation: Sixth sense for code smells";
        instance.setTitle(title);
        assertEquals(instance.getField("title"), title);
    }

    @Test
    public void testEqualsMethodTrueWithSameTitles() {
        Manual manual = createMockManual();
        Manual manualIdentical = createMockManual();
        assertTrue(manual.equals(manualIdentical));
    }
    
    @Test
    public void testEqualsMethodFalseWithDifferentTitles() {
        Manual manual = createMockManual();
        Manual manualTest = createMockManual();
        manualTest.setField("title", "Prediction and real-time "
                + "compensation of qubitons");
        assertFalse(manual.equals(manualTest));
    }
    
    @Test
    public void testEqualsMethodTrueWithSameButWithOtherHavingCapitals() {
        Manual manual = createMockManual();
        Manual manualTest = createMockManual();
        String titleUpperCase = manualTest.getField("title").toUpperCase();
        manualTest.setTitle(titleUpperCase);
        assertTrue(manual.equals(manualTest));
    }
    
    @Test
    public void testEqualsMethodTrueWithSameAndWithOptionalFields() {
        Manual manual = createMockManual();
        Manual manualWithOptional = createMockManual();
        manualWithOptional.setField("author", "222");
        
        assertTrue(manual.equals(manualWithOptional));
    }

    /**
     * Test of hasRequiredFields method, of class Manual.
     */
    @Test
    public void testHasRequiredFields() {
        boolean expResult = false;
        boolean result = instance.hasRequiredFields();
        assertEquals(expResult, result);
        instance.setTitle("testT");
        assertEquals(true, instance.hasRequiredFields());
    }
    
    /**
     * Test of hasRequiredFields method when all fields are set, 
     * of class Manual.
     */
    @Test
    public void testHasRequiredFieldsWhenFieldsAreSet() {
        instance = new Manual();
        instance.setTitle("My doctoral dissertation: never getting it ready");
        boolean expResult = true;
        boolean result = instance.hasRequiredFields();
        assertEquals(expResult, result);
    }
    
    @Test
    public void getFieldReturnsNull() {
        instance = new Manual();
        instance.setTitle(null);
        boolean result = false;
        if(instance.getField("author") == null) {
            result = true;
        }
        assertTrue(result);
    }
    
    @Test
    public void setFieldFailsWithInvalidFieldType() {
        instance = new Manual();
        instance.setField("invaliidi", "I won't be used");
        
        String expResult = null;
        assertEquals(expResult, instance.getField("invaliidi"));
    }
    
    @Test
    public void setOptionalFieldsWorksOnRightTypes() {
        instance = new Manual();
        
        instance.setField("author", "1");
        instance.setField("organization", "2");
        instance.setField("address", "Jollantie 22");
        instance.setField("month", "march");
        instance.setField("year", "2055");
        instance.setField("note", "helloworld");
        instance.setField("key", "ABCD1234");
        
        assertEquals("1", instance.getField("author"));
        assertEquals("2", instance.getField("organization"));
        assertEquals("2055", instance.getField("year"));
        assertEquals("march", instance.getField("month"));
        assertEquals("Jollantie 22", instance.getField("address"));
        assertEquals("helloworld", instance.getField("note"));
        assertEquals("ABCD1234", instance.getField("key"));
    }
}

