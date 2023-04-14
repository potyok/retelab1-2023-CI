package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.sensor.TrainSensorImpl;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainSensorTest {
    TrainController mockController;
    TrainUser mockUser;
    TrainSensor sensor;

    @Before
    public void before() {
        mockController = mock(TrainControllerImpl.class);
        mockUser = mock(TrainUserImpl.class);

        Sensor = new TrainSensorImpl(mockController, mockUser);
    }

    @Test
    public void TestNegativeLimitAlert() {
        when(mockController.getReferenceSpeed()).thenReturn(100);
        sensor.setSpeedLimit(-1);
        verify(mockUser, times(1)).setAlarmState(true);
        verify(mockUser, times(0)).setAlarmState(false);
    }

    @Test
    public void TestVeryHighLimitAlert() {
        when(mockController.getReferenceSpeed()).thenReturn(100);
        sensor.setSpeedLimit(501);
        verify(mockUser, times(1)).setAlarmState(true);
        verify(mockUser, times(0)).setAlarmState(false);
    }

    @Test
    public void TestTooBigLimitChangeAlert() {
        when(mockController.getReferenceSpeed()).thenReturn(150);
        sensor.setSpeedLimit(50);
        verify(mockUser, times(1)).setAlarmState(true);
        verify(mockUser, times(0)).setAlarmState(false);
    }

    @Test
    public void TestNormalLimitChangeNoAlert() {
        when(mockController.getReferenceSpeed()).thenReturn(150);
        sensor.setSpeedLimit(100);
        verify(mockUser, times(0)).setAlarmState(true);
        verify(mockUser, times(1)).setAlarmState(false);
    }
}
