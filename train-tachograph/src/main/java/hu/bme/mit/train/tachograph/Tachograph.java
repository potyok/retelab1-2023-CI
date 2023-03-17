package hu.bme.mit.train.tachograph; 

import java.util.Map; 
import java.util.Date; 
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class Tachograph{
    private Table<Date, Integer, Integer> dataTable = HashBasedTable.create();

    public void addNewData(Date currentTime, int joystickPosition, int referenceSpeed){
        dataTable.put(currentTime, joystickPosition, referenceSpeed); 
    } 

    public Map<Integer,Integer> getJoystickPositionAndRefSpeedByTime(Date time){
        return dataTable.row(time); 
    } 
}