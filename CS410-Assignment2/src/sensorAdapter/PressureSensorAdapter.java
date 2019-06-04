package sensorAdapter;

import java.awt.Color;	//	used for bar color

import sensor.PressureSensor;

public class PressureSensorAdapter implements SensorAdapter {
	
	PressureSensor sensor;
	int barProgress = 0;	//	fill level of bar, defaulted to empty
	
	public PressureSensorAdapter(PressureSensor ps)
	{
		sensor = ps;
	}

	@Override
	public double getSensorValue() {
		double value = sensor.readValue();	//	get value
		barProgress = (int) (100*value/10);	//	use value to determine bar fill, Empty at 0, filled at 10+
		return value;
	}

	@Override
	public String getSensorStatus() {
		return sensor.getReport();
	}

	@Override
	public String getSensorName() {
		return sensor.getSensorName();
	}

	@Override
	public Color getBarColor() {
		String status = getSensorStatus();
		if(status=="OK") { return Color.GREEN; }
		if(status=="CRITICAL") { return Color.YELLOW; }
		if(status=="DANGER") { return Color.RED; }
		
		return null;
	}

	@Override
	public int getBarProgress() {
		return barProgress;
	}

}
