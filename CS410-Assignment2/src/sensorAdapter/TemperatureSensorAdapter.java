package sensorAdapter;

import java.awt.Color;	//	used for bar color

import sensor.TemperatureSensor;

public class TemperatureSensorAdapter implements SensorAdapter {
	
	TemperatureSensor sensor;
	int barProgress = 0;	//	fill level of bar, defaulted to empty
	
	public TemperatureSensorAdapter(TemperatureSensor ts)
	{
		sensor = ts;
	}

	@Override
	public double getSensorValue() {
		double value = sensor.senseTemperature();	//	get value
		barProgress = (int) (100*value/400);	//	use value to determine bar fill, Empty at 0, filled at 400+
		return value;
	}

	@Override
	public String getSensorStatus() {
		return sensor.getTempReport();
	}

	@Override
	public String getSensorName() {
		return sensor.getSensorType();
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
