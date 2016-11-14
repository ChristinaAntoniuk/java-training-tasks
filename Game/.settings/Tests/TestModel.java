import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestModel {
	
    static Model testModel;

	@Before
    public void createModel(){
        testModel = new Model();
    }
	
	/**
	 * Testing of setSecretValue method
	 * @throws Exception
	 */
    @Test
    public void randomRangeTest() throws Exception {
    	testModel.setPrimaryBarrier(0, 100);
    	for (int i=0; i<1000; i++){
    		testModel.setSecretValue();
    		Assert.assertTrue(testModel.getSecretValue()>testModel.getMinBarrier());
    		Assert.assertTrue(testModel.getSecretValue()<testModel.getMaxBarrier());
    	}   		
    }
}
