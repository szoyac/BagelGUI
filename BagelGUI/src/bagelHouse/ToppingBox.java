package bagelHouse;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
/**
 * ToppingBox.java
 * @author Stephen Zoyac
 * Version 4/11/21
 * Creates the Topping Part of the GUI, includes buttons
 * for Cream Cheese, Butter, Peach jelly, and Blueberry jam , as well as
 * their prices.
 *
 */

public class ToppingBox extends VBox{
	
	public final double CreamCheese = 0.50;
	public final double Butter = 0.25;
	public final double PJelly = 0.75;
	public final double BJelly = 0.75;

	private CheckBox CC;
	private CheckBox Btr;
	private CheckBox PeachJ;
	private CheckBox BBJ;
	
	private ToggleGroup tg;
	
	
	
	public ToppingBox() {
		
		tg = new ToggleGroup();
		//Checkboxes
		CC = new CheckBox("Cream Cheese");
		Btr = new CheckBox("Butter");
		PeachJ = new CheckBox("Peach jelly");
		BBJ = new CheckBox("Blueberry jam");
		
		VBox vbox = new VBox(15);
		//background
		vbox.setStyle("-fx-background-color: #F9F4DF;");
		this.setStyle("-fx-background-color: #F9F4DF;");  // so outer VBox same color
		
		vbox.getChildren().add(CC);
		vbox.getChildren().add(Btr);
		vbox.getChildren().add(PeachJ);
		vbox.getChildren().add(BBJ);
		
		TitledPane tp = new TitledPane("Toppings", vbox);
		tp.setCollapsible(false);
		this.getChildren().add(tp);
		
	}
	/**
	 * Gets the prices for each topping and adds it to the total cost.
	 * @return toppingCost
	 */
	public double getToppingCost() {
		
		double toppingCost = 0.0;
		
		if (CC.isSelected()) {
			toppingCost += CreamCheese;
		} 
		if(Btr.isSelected()) {
			toppingCost += Butter;
		} 
		if(PeachJ.isSelected()){
			toppingCost += PJelly;
		} 
		if(BBJ.isSelected()) {
			toppingCost += BJelly;
		}
		
		return toppingCost;
	}
}
