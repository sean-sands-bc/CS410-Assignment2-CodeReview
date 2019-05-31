package sensorAdapter;

import java.awt.Color;	//	used for bar color

import sensor.RadiationSensor;

public class RadiationSensorAdapter implements SensorAdapter {
	
	RadiationSensor sensor;
	int barProgress = 0;	//	fill level of bar, defaulted to empty
	
	public RadiationSensorAdapter(RadiationSensor rs)
	{
		sensor = rs;
	}

	@Override
	public double getSensorValue() {
		double value = sensor.getRadiationValue();	//	get value
		barProgress = (int) (100*value/5);	//	use value to determine bar fill, Empty at 0, filled at 5+
		return value;
	}

	@Override
	public String getSensorStatus() {
		
		return sensor.getStatusInfo();
	}

	@Override
	public String getSensorName() {
		
		return sensor.getName();
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
