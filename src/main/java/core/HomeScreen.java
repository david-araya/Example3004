package core;

import javafx.application.Application;
import javafx.event.*; //Makes EventHandler work
import javafx.scene.Scene; // for Line 24
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label; // for Line 20
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane; // for Line 15
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage; 

public class HomeScreen extends Application{

	private Button solnBtn;
	private TextField leftOperandTxtBox;
	private TextField rightOperandTxtBox;
	private TextField answerTxtBox;
	private ComboBox<String> operatorDropdown;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		initUI(primaryStage);
	}
	
	public void initUI (Stage primaryStage){

		Pane canvas = new Pane();
		//canvas.setStyle("-fx-background-color: black");
		
		addControlToCanvas(canvas);
		
		Scene scene = new Scene(canvas, 320, 200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Simple Calculator App");
		primaryStage.show();
	}

	private void addControlToCanvas(Pane canvas) {
		int row1 = 20;
		int row2 = 60;
		int txtBoxWidth = 50;
		
		Label label = new Label("Simple Calculator using JavaFX");
		label.setFont(Font.font("Serif", FontWeight.NORMAL, 20));
		label.relocate(20, row1);
		
		//Creates the left text box
		leftOperandTxtBox = new TextField();
		leftOperandTxtBox.setMaxWidth(txtBoxWidth);
		leftOperandTxtBox.relocate(20, row2);
		
		//Creates a dropdown
		operatorDropdown = new ComboBox<String>();
		operatorDropdown.getItems().addAll("+", "-", "x","/","%");
		operatorDropdown.setValue("+");
		operatorDropdown.relocate(80, row2);
		
		//Creates the right text box
		rightOperandTxtBox = new TextField();
		rightOperandTxtBox.setMaxWidth(txtBoxWidth);
		rightOperandTxtBox.relocate(150, row2);
		
		solnBtn = new Button("=");
		solnBtn.relocate(210, row2);
		
		//Creates textfield for Solution
		answerTxtBox = new TextField();
		answerTxtBox.setMaxWidth(txtBoxWidth);
		answerTxtBox.setEditable(false);// means you can't add values to the textbox
		answerTxtBox.relocate(250, row2);
		
		setSolnBtnClickHandler();
		
		//Arguments include the label, both textboxes, dropdown and button)
		canvas.getChildren().addAll(label, leftOperandTxtBox, rightOperandTxtBox, operatorDropdown, solnBtn, answerTxtBox);
	}

	private void setSolnBtnClickHandler() {
		//makes the application talk to itself
		//Solution button
		solnBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Double leftOperand = Double.valueOf(leftOperandTxtBox.getText());
				Double rightOperand = Double.valueOf(rightOperandTxtBox.getText());
				String operator = operatorDropdown.getValue();
				
				ArithmeticSolver solver = new ArithmeticSolver();
				String answer = String.valueOf(solver.solve(operator, leftOperand, rightOperand));
				
				answerTxtBox.setText(answer);
			}
		});
		
	}
}
