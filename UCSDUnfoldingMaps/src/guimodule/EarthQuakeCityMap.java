package guimodule;

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;

public class EarthQuakeCityMap extends PApplet {
	
	private UnfoldingMap map;
	
	public void setup() {
		size(950,600,OPENGL);
		map = new UnfoldingMap(this,200,50,700,500, new Google.GoogleMapProvider());
		map.zoomToLevel(2);
		MapUtils.createDefaultEventDispatcher(this, map);
		Location valLoc = new Location(-38.14f,-73.03f);
		Feature valEq = new PointFeature(valLoc);
		valEq.addProperty("title", "Valdivia, Chile");
		valEq.addProperty("magnitude", "9.5");
		valEq.addProperty("date", "May 22, 1960");
		valEq.addProperty("year", "1960");
		
		Location alaskaLoc = new Location(61.02f,-147.65f);		
		Feature alaskaEq = new PointFeature(alaskaLoc);
		alaskaEq.addProperty("title", "1964 Great Alaska Earthquake");
		alaskaEq.addProperty("magnitude", "9.2");
		alaskaEq.addProperty("date", "Marach 28, 1964");
		alaskaEq.addProperty("year", "1964");
		
		Location sumatraLoc = new Location(3.30f,95.78f);
		Feature sumatraEq = new PointFeature(sumatraLoc);
		sumatraEq.addProperty("title", "Off the West Coast of Northern Sumatra");
		sumatraEq.addProperty("magnitude", "9.1");
		sumatraEq.addProperty("date", "December 26, 2004");
		sumatraEq.addProperty("year", "2004");
		
		Location japanLoc = new Location(38.322f,142.369f);
		Feature japanEq = new PointFeature(japanLoc);
		japanEq.addProperty("title", "Near the East Coast of Honshu, Japan");
		japanEq.addProperty("magnitude", "9.0");
		japanEq.addProperty("date", "March 11, 2011");
		japanEq.addProperty("year", "2011");
		
		Location kamchatkaLoc = new Location(-38.14f,-73.03f);
		Feature kamchatkaEq = new PointFeature(kamchatkaLoc);
		kamchatkaEq.addProperty("title", "Kamchatka");
		kamchatkaEq.addProperty("magnitude", "9.0");
		kamchatkaEq.addProperty("date", "November 04, 1952");
		kamchatkaEq.addProperty("year", "1952");
		
		
		Marker valMk = new SimplePointMarker(valLoc,valEq.getProperties());
		map.addMarker(valMk);
		
		List<PointFeature> bigEqs = new ArrayList<PointFeature>();
		bigEqs.add((PointFeature) valEq);
		bigEqs.add((PointFeature) alaskaEq);
		bigEqs.add((PointFeature) sumatraEq);
		bigEqs.add((PointFeature) japanEq);
		bigEqs.add((PointFeature) kamchatkaEq);
		List<Marker> markers = new ArrayList<Marker>();
		for (PointFeature eq: bigEqs) {
			markers.add(new SimplePointMarker(eq.getLocation(),eq.getProperties()));
		}
	}
	
	public void draw() {
		background(10);
		map.draw();
		
	}

}
