package bagelHouse;

import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
/**
 * CoffeeBox.java
 * @author Stephen Zoyac
 * Version 4/11/21
 * Creates the Coffee Part of the GUI, includes buttons
 * for No coffee, Regular, Decaf, and Cappuccino, as well as
 * their prices.
 *
 */
public class CoffeeBox extends VBox{
	//prices
	public final double None = 0.0;
	public final double RegDecaf = 1.25;
	public final double Capu = 2.00;

	//buttons
	private RadioButton Non;
	private RadioButton Reg;
	private RadioButton Decaf;
	private RadioButton Cap;
	
	private ToggleGroup tg;
	
	
	
	public CoffeeBox() {
		
		tg = new ToggleGroup();
		
		Non = new RadioButton("None");
		Reg = new RadioButton("Regular coffee");
		Decaf = new RadioButton("Decaf coffee");
		Cap = new RadioButton("Cappuccino");
		
		//size of box
		VBox vbox = new VBox(15);
		
		//adds color
		vbox.setStyle("-fx-background-color: BlanchedAlmond;");
		this.setStyle("-fx-background-color: BlanchedAlmond;");  // so outer VBox same color
		
		//toggle option
		Non.setToggleGroup(tg);
		Reg.setToggleGroup(tg);
		Decaf.setToggleGroup(tg);
		Cap.setToggleGroup(tg);
		
		//adds buttons
		vbox.getChildren().add(Non);
		vbox.getChildren().add(Reg);
		vbox.getChildren().add(Decaf);
		vbox.getChildren().add(Cap);
		
		//Pane
		TitledPane tp = new TitledPane("Coffee", vbox);
		tp.setCollapsible(false);
		this.getChildren().add(tp);
		
	}
	/**
	 * Controls the total cost of the coffee option selected
	 * @return coffeeCost
	 */
	public double getCoffeeCost() {
		
		double coffeeCost = 0.0;
		
		//If a button is selected, it will add 
		if (Non.isSelected()) {
			coffeeCost = None;
		} else if(Cap.isSelected()) {
			coffeeCost = Capu;
		} else if(Reg.isSelected() || Decaf.isSelected()) {
			coffeeCost = RegDecaf;
		}
		
		return coffeeCost;
	}
}

