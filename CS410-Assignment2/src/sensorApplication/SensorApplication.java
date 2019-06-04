package sensorApplication;

import java.awt.Color;	//	bar color
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;	//	used by SensorApplication
import javax.swing.JLabel;	//	sensor readouts
import javax.swing.JPanel;	//	used by SensorPanel
import javax.swing.border.TitledBorder;	//	used for panel border names
import javax.swing.JProgressBar;	//	used for bar levels

import sensorAdapter.*;
import sensor.*;

//	Adapted from example code
public class SensorApplication extends JFrame {
	
	//	JPanel used by each sensor
	public class SensorPanel extends JPanel {
		public SensorPanel(SensorAdapter sa)	//	constructor, sets visuals of panel
		{
			setLayout(new GridLayout(2,1));	//	status bar and readout string
			setBorder(new TitledBorder(sa.getSensorName()));	//	set border name to sensor name
			String value = Double.toString(sa.getSensorValue());	//	set value to sensor value
			String status = sa.getSensorStatus();	//	set status to sensor status

			JProgressBar bar = new JProgressBar();
			bar.setForeground(sa.getBarColor());	//	set bar color to status color
			bar.setBackground(Color.GRAY);
			bar.setValue(sa.getBarProgress());	//	set bar level
			add(bar);	//	add bar to panel
			JLabel readout = new JLabel(status+" ==> "+value);	//	set readout to status and value
			readout.setHorizontalAlignment(JLabel.CENTER);	//	center readout
			add(readout);	//	add readout to panel
		}
	}
	
	//	JFrame with all sensor panels
	public SensorApplication() {
		setTitle("Sensor Tracker");
		setLayout(new GridLayout(3,1));	//	3 sensor panels
		
		JPanel  pressurePnl = new SensorPanel(new PressureSensorAdapter(new PressureSensor()));	//	tie first panel to a pressure sensor
		add(pressurePnl);	//	add panel to frame
		
		JPanel  radiationPnl = new SensorPanel(new RadiationSensorAdapter(new RadiationSensor()));	//	tie second panel to a rad sensor
		add(radiationPnl);	//	add panel to frame
	
		JPanel  temperaturePnl = new SensorPanel(new TemperatureSensorAdapter(new TemperatureSensor()));	//	tie third panel to a temp sensor
		add(temperaturePnl);	//	add panel to frame
		
		setPreferredSize(new Dimension(600,600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();
	}

	public static void main(String[] args) {
		SensorApplication app = new SensorApplication();	//	create gui
	}

}
