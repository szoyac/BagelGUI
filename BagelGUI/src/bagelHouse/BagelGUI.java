package bagelHouse;

import java.text.DecimalFormat;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
/**
 * BagelGUI.java
 * @author Stephen Zoyac
 * @Version 4/11/21
 * Builds the GUI for a Bagel Shop, with different bread, toppings,
 * and Coffee. It also calculates the cost of all the items including sales tax.
 */

public class BagelGUI extends Application {

	BagelBox bagelBox = new BagelBox();
	CostBox costBox = new CostBox();
	ToppingBox toppingBox = new ToppingBox();
	CoffeeBox coffeeBox = new CoffeeBox();
	
	public final double TAX_RATE = 0.07;
	
	public static void main(String[] args) {
		/* static method inherited from Application class that creates
		 * an instance of the Application class and starts the JavaFX lifecycle. */
		launch(args);
	}

	@Override
	public void init() {
	}

	@Override public void start(Stage mainStage) throws InterruptedException {
		BorderPane mainPane = new BorderPane();     // make layout to hold controls
		setupControls(mainPane);                    // initialize and place controls
		Scene scene = new Scene(mainPane);	        // Setup the main scene
		setStage(mainStage, scene);                 // Finalize and show the stage
	}

	@Override
	public void stop() {
	}

	private void setupControls(BorderPane mainPane) {
		mainPane.setTop(new GreetingBox());
		mainPane.setLeft(bagelBox);
		mainPane.setBottom(costBox);
		mainPane.setCenter(toppingBox);
		mainPane.setRight(coffeeBox);

		
		// Set action listener on Calculate button
		costBox.getBtnCalc().setOnAction(e -> calculate());
	}

	private void setStage(Stage stage, Scene scene) {
		stage.setTitle("Della's House of Bagels");
		stage.setScene(scene);
		stage.show();
	}
	
	private void calculate(){
	
        double subtotal = 0;  // The order subtotal
        double tax;       // The amount of sales tax
        double total;     // The order total


        // Calculate the subtotal.
        subtotal += bagelBox.getBagelCost();
        subtotal += toppingBox.getToppingCost();
        subtotal += coffeeBox.getCoffeeCost();
        

        // Calculate the sales tax.
        tax = subtotal * TAX_RATE;

        // Calculate the total.
        total = subtotal + tax;

        // Create a DecimalFormat object to format
        // the total as a dollar amount.
        DecimalFormat dollar = new DecimalFormat("0.00");

        // Display the charges.
        costBox.getTxtSub().setText("$" + dollar.format(subtotal));
        costBox.getTxtTax().setText("$" + dollar.format(tax));
        costBox.getTxtTotal().setText("$" + dollar.format(total));
     }
	
}


