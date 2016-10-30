import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestModel {
	
    static Model testModel;

	@Before
    public void createModel(){
        testModel = new Model();
    }

    @Test
    public void randomRangeTest() throws Exception {
        // Testing of random number's range
    	int min = 12, max = 45;
        int value = testModel.getRandomNumber(min,max);
        Assert.assertTrue(value >= min);
        Assert.assertTrue(value <= max);
    }

    @Test
    public void compareValuesTest() throws Exception {
        // Testing of compareValues method
    	testModel.value = 10;
    	
    	Assert.assertEquals(testModel.compareValues(12), 2);
    	Assert.assertEquals(testModel.compareValues(5), 1);
    	Assert.assertEquals(testModel.compareValues(10), 0);
    }
}
