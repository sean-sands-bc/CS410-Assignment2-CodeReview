package sensorAdapter;

import java.awt.Color;	//	for color associated with status

public interface SensorAdapter {
	
	public double getSensorValue();	//	Value of Sensor
	public String getSensorStatus();	//	Status of Sensor
	public String getSensorName();	//	Name of Sensor
	public Color getBarColor();	//	Color of bar based on status
	public int getBarProgress();	//	Size of bar

}
