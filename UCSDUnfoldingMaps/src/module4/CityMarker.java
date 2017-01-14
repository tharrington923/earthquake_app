package module4;

import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import processing.core.PGraphics;

/** Implements a visual marker for cities on an earthquake map
 * 
 * @author UC San Diego Intermediate Software Development MOOC team
 * @author Thomas Harrington
 *
 */
public class CityMarker extends SimplePointMarker {
	
	// The size of the triangle marker
	// It's a good idea to use this variable in your draw method
	// public static final int TRI_SIZE = 5;
	// Will make it an equilateral triangle
	// cos(Pi/6) = sqrt(3)/2 and sin(Pi/6) = 1/2
	public static float TRI_SIZE = 10; //User sets this for the size of triangle
	public static float dx = (float) (TRI_SIZE*0.866);
	public static float dy = (float) (TRI_SIZE*0.5);
	
	public CityMarker(Location location) {
		super(location);
	}
	
	
	public CityMarker(Feature city) {
		super(((PointFeature)city).getLocation(), city.getProperties());
	}
	
	
	// HINT: pg is the graphics object on which you call the graphics
	// methods.  e.g. pg.fill(255, 0, 0) will set the color to red
	// x and y are the center of the object to draw. 
	// They will be used to calculate the coordinates to pass
	// into any shape drawing methods.  
	// e.g. pg.rect(x, y, 10, 10) will draw a 10x10 square
	// whose upper left corner is at position x, y
	/**
	 * Implementation of method to draw marker on the map.
	 */
	public void draw(PGraphics pg, float x, float y) {
		// Save previous drawing style
		pg.pushStyle();
		
		// TODO: Add code to draw a triangle to represent the CityMarker
		//We want to determine the locations of the corners of the triangle 
		//from the (x,y) of the center and the desired height of the 
		//triangle (distance from center to top point)
		pg.fill(128,0,0); //Maroon RGB value
		pg.triangle(x-dx,y+dy,x+dx,y+dy, x,y-TRI_SIZE);
		
		// Restore previous drawing style
		pg.popStyle();
	}
	
	/* Local getters for some city properties.  You might not need these 
	 * in module 4. 	 */
	public String getCity()
	{
		return getStringProperty("name");
	}
	
	public String getCountry()
	{
		return getStringProperty("country");
	}
	
	public float getPopulation()
	{
		return Float.parseFloat(getStringProperty("population"));
	}
	
}
