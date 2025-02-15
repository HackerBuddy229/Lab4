package lab4.gui;


import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import lab4.data.GameGrid;


/**
 * A panel providing a graphical view of the game board
 * @author Wilma
 * @author Noora
 * @author Rasmus
 */

public class GamePanel extends JPanel implements Observer{

	private final int UNIT_SIZE = 20;
	private GameGrid grid;
	
	public int getUNIT_SIZE() {
		return UNIT_SIZE;
	}
	
	/**
	 * The constructor
	 * 
	 * @param grid The grid that is to be displayed
	 */
	public GamePanel(GameGrid grid){
		this.grid = grid;
		grid.addObserver(this);
		Dimension d = new Dimension(grid.getSize()*UNIT_SIZE+1, grid.getSize()*UNIT_SIZE+1);
		this.setMinimumSize(d);
		this.setPreferredSize(d);
		this.setBackground(Color.WHITE);
	}

	/**
	 * Returns a grid position given pixel coordinates
	 * of the panel
	 * 
	 * @param x the x coordinates
	 * @param y the y coordinates
	 * @return an integer array containing the [x, y] grid position
	 */
	public int[] getGridPosition(int x, int y){
		int positionX = (x/UNIT_SIZE);
		int positionY = (y/UNIT_SIZE);
		return new int[] {positionX, positionY};
	}
	
	 /**
	   * Method predefined by H�kan to repaint the grid when an update is received
	   * 
	   * @param arg0
	   * @param arg1
	   */
	public void update(Observable arg0, Object arg1) {
		this.repaint();
	}
	
	  /**
	   * Called when the JPanel GUI object is to be redrawn
	   */
	public void paintComponent(Graphics g){
		super.paintComponent(g); //goes to a superclass. 
		int gSize =  grid.getSize();

		for(int x = 0; x < gSize; x++){
			for(int y = 0; y < gSize; y++){
				
			switch(grid.getLocation(x, y)){

				case GameGrid.ME: 
					g.setColor(Color.GREEN); //set color to "me"
				break;

				case GameGrid.OTHER:
					g.setColor(Color.RED); //set color to "other"
				break;

				default:
					g.setColor(Color.BLACK); //sets color to unclaimed
			}

			//fills the rectangle
			g.fillRect(x*UNIT_SIZE, y*UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);


			}
		}
		}
	

	
}
