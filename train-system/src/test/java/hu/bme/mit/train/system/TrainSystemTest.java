package hu.bme.mit.train.system;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.system.TrainSystem;
import hu.bme.mit.train.tachograph.Tachograph; 
import java.util.Date; 
import java.util.Map; 

public class TrainSystemTest {

	TrainController controller;
	TrainSensor sensor;
	TrainUser user;
	Tachograph tachograph; 

	
	@Before
	public void before() {
		TrainSystem system = new TrainSystem();
		controller = system.getController();
		sensor = system.getSensor();
		user = system.getUser();
		tachograph = system.getTachograph(); 

		sensor.overrideSpeedLimit(50);
	}
	
	@Test
	public void OverridingJoystickPosition_IncreasesReferenceSpeed() {
		sensor.overrideSpeedLimit(10);

		Assert.assertEquals(0, controller.getReferenceSpeed());
		
		user.overrideJoystickPosition(5);

		controller.followSpeed();
		Assert.assertEquals(5, controller.getReferenceSpeed());
		controller.followSpeed();
		Assert.assertEquals(10, controller.getReferenceSpeed());
		controller.followSpeed();
		Assert.assertEquals(10, controller.getReferenceSpeed());
	}

	@Test
	public void OverridingJoystickPositionToNegative_SetsReferenceSpeedToZero() {
		user.overrideJoystickPosition(4);
		controller.followSpeed();
		user.overrideJoystickPosition(-5);
		controller.followSpeed();
		Assert.assertEquals(0, controller.getReferenceSpeed());
	}

	@Test
	public void CheckEmergencyBreakingPush(){
		user.overrideJoystickPosition(4);
		controller.followSpeed();  
		user.pushEmergencyBreaking();
		Assert.assertEquals(0, controller.getReferenceSpeed());  
	} 	
   @Test
   public void CheckEmergencyBreakingPush_WhenJoystickisNegative(){
	    user.overrideJoystickPosition(4);
	    controller.followSpeed();
		user.overrideJoystickPosition(-5);
		user.pushEmergencyBreaking();
		Assert.assertEquals(0, controller.getReferenceSpeed());  
   }  

  @Test
  public void TestTachoGraph (){
	  Date current = new Date(System.currentTimeMillis());
	  user.overrideJoystickPosition(4);
	  controller.followSpeed();
	  int refSpeed = controller.getReferenceSpeed();
	  tachograph.addNewData(current, 4, refSpeed);
	  Map<Integer, Integer> timeMap = tachograph.getJoystickPositionAndRefSpeedByTime(current);
	  Map.Entry<Integer, Integer>  lastData = timeMap.entrySet().iterator().next(); 
	  int joystickPosition = lastData.getKey(); 
	  int referenceSpeed = lastData.getValue(); 
	  Assert.assertEquals(4, joystickPosition); 
	  Assert.assertEquals(refSpeed, referenceSpeed); 
  }  


	
}
