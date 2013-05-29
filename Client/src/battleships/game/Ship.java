package game;


import java.util.TreeSet;

/**
 * 
 * @author Åsa Waldhe
 *
 */
public abstract class Ship {
	
	protected static final Integer HORIZONTAL=0;
	protected static final Integer VERTICAL=1;
	
	protected final String NAME; // Initiated in each subclass's constructor..
	protected final Integer LENGTH; // Initiated in each subclass's constructor.	
	
	protected TreeSet<Coordinate> coords;
	protected TreeSet<Coordinate> hits;
	protected Boolean sunk;
	
	protected Integer direction=null;
	
	/**
	 * 
	 * @param n
	 * @param l
	 */
	public Ship(String n, int l ){			// Kontrollera att koordinaterna ligger i rad?
		sunk = false;
		NAME = n;
		LENGTH = l;
	}
	
	/**
	 * 
	 */
	public String toString(){
		return "Abstract class Ship";
	}
	
	/**
	 * 
	 * @return name 			The name of ship-type, as a String.
	 */
	public String getName(){
		return NAME;
	}
	
	/**
	 * 
	 * @return 					First coordinate from TreeSet coord
	 */
	public Coordinate getFirstCoord(){
		return coords.first();
	}
	/**
	 * 
	 * @return
	 */
	public Integer getDirection(){
		return direction;
	}
	
	/**
	 * 
	 * @return
	 */
	public Integer getLength(){
		return LENGTH;
	}
	
	/**
	 * 
	 * @param coord
	 * @return
	 */
	public Boolean containsCoord(Coordinate coord){
		 return coords.contains(coord);
	}
	
	/**
	 * 
	 * @param c1
	 * @param c2
	 * @return
	 */
	protected Integer shipsDirection(Coordinate c1, Coordinate c2){
		if( c1.getY() == c2.getY() ){
			direction = HORIZONTAL;
			return direction;
		}
		else
		{
			direction = VERTICAL;
			return direction;
		}		
	}
	
	/**
	 * Returns whether the ship is hit by a shot by comparing the coord argument with the ships coordinates.
	 * Increments ads the coordinate to the array hits if true.
	 * 
	 * @param coord
	 * @return constant Integer 
	 * @throws
	 */
	public Boolean hitByShot(Coordinate coord){
		if(containsCoord(coord)){
			if(!hits.add(coord)){ // Throw exception?			
			}
			return true;
		}
		else
			return false;				
	}
	
	/**
	 * 
	 * @return	Boolean			Sunk or not
	 */
	public Boolean isSunk(){
		return hits.size()==LENGTH;		
	}
	
	/**
	 * 
	 * @return TreeSet<Coordinate>		All coordinates covered by the ship.
	 */
	public TreeSet<Coordinate> getCoords(){
		return coords;
		
	}
	
	/**
	 * 
	 * @param c
	 */
	public void setCoords(TreeSet<Coordinate> c){
		coords.clear();
		coords.addAll(c);
	}
	
	

}
