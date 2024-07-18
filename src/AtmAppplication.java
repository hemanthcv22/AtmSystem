import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.text.Font; 
import javafx.scene.text.FontPosture; 
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text; 
import javafx.scene.paint.Color;
import javafx.scene.control.PasswordField;
  


public class AtmAppplication extends Application {
	Stage window;
	Scene MainScene , OptionsScene , DepositScene , WithdrawScene , BalanceScene , HistoryScene;
	
	ATM myAtm;
	
	public static void main (String[] args) {
		launch (args);
		
	}
	@Override
	public void start(Stage primaryStage) throws Exception{
		window = primaryStage;
		
		

        //MAINSCENE
		PasswordField readmain = new PasswordField();
		readmain.setMaxWidth(200);
		readmain.setPrefHeight(30);
		readmain.setTranslateX(0);
		readmain.setTranslateY(140);
		Text welcome = new Text("WELCOME");
		Text please = new Text("Please enter your card pin number ");
		please.setTranslateX(0);
		please.setTranslateY(100);
		please.setFont(Font.font("century gothic", FontWeight.BOLD, FontPosture.REGULAR, 25));
		please.setFill(Color.CORAL); 
		please.setStroke(Color.CORAL);
		StackPane layout1 = new StackPane();
		layout1.setStyle("-fx-background-color: darkred");
		welcome.setTranslateX(0);
		welcome.setTranslateY(-200);
		welcome.setFont(Font.font("century gothic", FontWeight.BOLD, FontPosture.REGULAR, 40));
		welcome.setFill(Color.CORAL); 
		welcome.setStroke(Color.DARKRED); 
		layout1.getChildren().add(welcome);
		layout1.getChildren().add(readmain);
        for (int i = 1; i <= 9; i++) {
			Button button1 = new Button(Integer.toString(i));
	        button1.setPrefWidth(40);
	        button1.setPrefHeight(40);
	        button1.setTextFill(Color.DARKRED);
	        button1.setFont(Font.font("century gothic", FontWeight.BOLD, FontPosture.REGULAR, 20));
		    button1.setStyle("-fx-background-color: coral ");
	        if (i % 3 == 1) {
	        	button1.setTranslateX(-50);
	        } else if (i % 3 == 2) {
	        	button1.setTranslateX(-50 + 50);
	        } else if (i % 3 == 0) {
	        	button1.setTranslateX(-50 + 100);
	        }
			
			if (i <= 3) {
				button1.setTranslateY(-100);
			} else if (i <= 6) {
				button1.setTranslateY(-100 + 50);
			} else if (i <= 9) {
				button1.setTranslateY(-100 + 100);
			}
			button1.setOnAction(e -> readmain.setText(readmain.getText() + button1.getText()));
			layout1.getChildren().add(button1);
		}

		Button donemain = new Button("Done");
		Button zeromain = new Button ("0");
		zeromain.setPrefWidth(40);
		zeromain.setPrefHeight(40);
		zeromain.setTranslateX(0);
		zeromain.setTranslateY(50);
		zeromain.setTextFill(Color.DARKRED);
		zeromain.setFont(Font.font("century gothic", FontWeight.BOLD, FontPosture.REGULAR, 20));
		zeromain.setStyle("-fx-background-color: coral");
		zeromain.setOnAction(e -> readmain.setText(readmain.getText() + zeromain.getText()));
	    donemain.setPrefWidth(75);
	    donemain.setPrefHeight(25);
	    donemain.setTranslateX(180);
	    donemain.setTranslateY(180);
	    donemain.setTextFill(Color.DARKRED);
		donemain.setFont(Font.font("century gothic", FontWeight.BOLD, FontPosture.REGULAR, 15));
		donemain.setStyle("-fx-background-color: coral");
	    donemain.setOnAction(e -> {
    		myAtm = new ATM(readmain.getText());
    		readmain.setText("");
    		if(myAtm.authorize()==true) 
    		window.setScene(OptionsScene);
    	else {
    	 readmain.setText("");
    	Text incorrect = new Text("INCORRECT NUMBER");
    	incorrect.setTranslateX(0);
		incorrect.setTranslateY(200);
		incorrect.setFont(Font.font("century gothic", FontWeight.BOLD, FontPosture.REGULAR, 20));
		incorrect.setFill(Color.CORAL); 
		incorrect.setStroke(Color.RED);
		layout1.getChildren().add(incorrect);
    	  }});
    	layout1.getChildren().addAll(donemain , zeromain , please);
    	MainScene = new Scene(layout1 , 500 , 500);
		
    	
    	//SECOND SCENE
		//Label label3 = new Label("Choose");
		Button deposit= new Button("Deposit");
		deposit.setPrefSize(220,50);
		deposit.setTranslateX(0);
		deposit.setTranslateY(-100);
		deposit.setTextFill(Color.DARKRED);
	    deposit.setFont(Font.font("century gothic", FontWeight.BOLD, FontPosture.REGULAR, 20));
		deposit.setStyle("-fx-background-color: coral");
		Button withdraw= new Button("Withdraw");
		withdraw.setPrefSize(220,50);
		withdraw.setTranslateX(0);
		withdraw.setTranslateY(-30);
		withdraw.setTextFill(Color.DARKRED);
		withdraw.setFont(Font.font("century gothic", FontWeight.BOLD, FontPosture.REGULAR, 20));
		withdraw.setStyle("-fx-background-color: coral");
		Button balance= new Button("Balance Inquiry");
		balance.setPrefSize(220,50);
		balance.setTranslateX(0);
		balance.setTranslateY(40);
		balance.setTextFill(Color.DARKRED);
		balance.setFont(Font.font("century gothic", FontWeight.BOLD, FontPosture.REGULAR, 20));
		balance.setStyle("-fx-background-color: coral");
		Button history= new Button("Account History");
		history.setPrefSize(220,50);
		history.setTranslateX(0);
		history.setTranslateY(110);
		history.setTextFill(Color.DARKRED);
		history.setFont(Font.font("century gothic", FontWeight.BOLD, FontPosture.REGULAR, 20));
		history.setStyle("-fx-background-color: coral");
		StackPane layout2 = new StackPane();
		layout2.getChildren().addAll(deposit , withdraw , balance , history);
		layout2.setStyle("-fx-background-color: darkred");
		OptionsScene = new Scene(layout2 , 500 , 500);
		
		
		//DEPOSITSCENE
		deposit.setOnAction(e -> window.setScene(DepositScene));
		Text deposittext = new Text("Enter the amount you want to deposit");
		deposittext.setTranslateX(0);
		deposittext.setTranslateY(100);
		deposittext.setFont(Font.font("century gothic", FontWeight.BOLD, FontPosture.REGULAR, 25));
		deposittext.setFill(Color.CORAL); 
		deposittext.setStroke(Color.CORAL);
		Text depositlabel = new Text("DEPOSIT");
		depositlabel.setTranslateX(0);
		depositlabel.setTranslateY(-180);
		depositlabel.setFont(Font.font("century gothic", FontWeight.BOLD, FontPosture.REGULAR, 40));
		depositlabel.setFill(Color.CORAL); 
		depositlabel.setStroke(Color.DARKRED);
		TextField readdeposit = new TextField("");
		readdeposit.setMaxWidth(200);
		readdeposit.setMaxHeight(30);
		readdeposit.setTranslateX(0);
		readdeposit.setTranslateY(140);
		Button donedeposit= new Button("Done");
		Button zerodeposit= new Button("0");
		zerodeposit.setPrefWidth(40);
		zerodeposit.setPrefHeight(40);
		zerodeposit.setTranslateX(0);
		zerodeposit.setTranslateY(50);
		zerodeposit.setTextFill(Color.DARKRED);
		zerodeposit.setFont(Font.font("century gothic", FontWeight.BOLD, FontPosture.REGULAR, 20));
		zerodeposit.setStyle("-fx-background-color: coral");
		zerodeposit.setOnAction(e -> readdeposit.setText(readdeposit.getText() + zerodeposit.getText()));
	    donedeposit.setPrefWidth(75);
	    donedeposit.setPrefHeight(25);
	    donedeposit.setTranslateX(180);
	    donedeposit.setTranslateY(180);
	    donedeposit.setTextFill(Color.DARKRED);
	  	donedeposit.setFont(Font.font("century gothic", FontWeight.BOLD, FontPosture.REGULAR, 15));
	  	donedeposit.setStyle("-fx-background-color: coral");
	    donedeposit.setOnAction(e -> {
    		myAtm.deposit(Double.parseDouble(readdeposit.getText()));
    		readdeposit.setText("");
    		window.setScene(OptionsScene);
    	});
    	Button back = new Button("Back");
    	back.setPrefWidth(75);
 		back.setPrefHeight(25);
     	back.setTranslateX(-180);
     	back.setTranslateY(180);
     	back.setTextFill(Color.DARKRED);
  		back.setFont(Font.font("century gothic", FontWeight.BOLD, FontPosture.REGULAR, 15));
  		back.setStyle("-fx-background-color: coral");
    	back.setOnAction(e ->{
    	readdeposit.setText("");
    	window.setScene(OptionsScene);});
	    StackPane DepositLayout = new StackPane();
		DepositLayout.setStyle("-fx-background-color: darkred");
		for (int i = 1; i <= 9; i++) {
			Button button1 = new Button(Integer.toString(i));
	        button1.setPrefWidth(40);
	        button1.setPrefHeight(40);
	        button1.setTextFill(Color.DARKRED);
	        button1.setFont(Font.font("century gothic", FontWeight.BOLD, FontPosture.REGULAR, 20));
		    button1.setStyle("-fx-background-color: coral ");
	        if (i % 3 == 1) {
	        	button1.setTranslateX(-50);
	        } else if (i % 3 == 2) {
	        	button1.setTranslateX(-50 + 50);
	        } else if (i % 3 == 0) {
	        	button1.setTranslateX(-50 + 100);
	        }
			
			if (i <= 3) {
				button1.setTranslateY(-100);
			} else if (i <= 6) {
				button1.setTranslateY(-100 + 50);
			} else if (i <= 9) {
				button1.setTranslateY(-100 + 100);
			}
			button1.setOnAction(e -> readdeposit.setText(readdeposit.getText() + button1.getText()));
			DepositLayout.getChildren().add(button1);
		}
		
		DepositLayout.getChildren().addAll(donedeposit , zerodeposit , deposittext , readdeposit , depositlabel , back);
		DepositScene = new Scene (DepositLayout , 500 ,500);
		
		
		
		//WITHDRAW SCENE
		withdraw.setOnAction(e -> window.setScene(WithdrawScene));
		Text withdrawtext = new Text("Enter the amount you want to withdraw");
		withdrawtext.setTranslateX(0);
		withdrawtext.setTranslateY(100);
		withdrawtext.setFont(Font.font("century gothic", FontWeight.BOLD, FontPosture.REGULAR, 25));
		withdrawtext.setFill(Color.CORAL); 
		withdrawtext.setStroke(Color.CORAL);
		Text withdrawlabel = new Text("WITHDRAW");
		withdrawlabel.setTranslateX(0);
		withdrawlabel.setTranslateY(-180);
		withdrawlabel.setFont(Font.font("century gothic", FontWeight.BOLD, FontPosture.REGULAR, 40));
		withdrawlabel.setFill(Color.CORAL); 
		withdrawlabel.setStroke(Color.DARKRED);
		TextField readwithdraw = new TextField("");
		readwithdraw.setMaxWidth(200);
		readwithdraw.setMaxHeight(30);
		readwithdraw.setTranslateX(0);
		readwithdraw.setTranslateY(140);
		Button backwithdraw = new Button("Back");
		backwithdraw.setPrefWidth(75);
 		backwithdraw.setPrefHeight(25);
     	backwithdraw.setTranslateX(-180);
     	backwithdraw.setTranslateY(180);
     	backwithdraw.setTextFill(Color.DARKRED);
  		backwithdraw.setFont(Font.font("century gothic", FontWeight.BOLD, FontPosture.REGULAR, 15));
  		backwithdraw.setStyle("-fx-background-color: coral");
		StackPane WithdrawLayout = new StackPane();
		WithdrawLayout.setStyle("-fx-background-color: darkred");
		for (int i = 1; i <= 9; i++) {
			Button button1 = new Button(Integer.toString(i));
	        button1.setPrefWidth(40);
	        button1.setPrefHeight(40);
	        button1.setTextFill(Color.DARKRED);
	        button1.setFont(Font.font("century gothic", FontWeight.BOLD, FontPosture.REGULAR, 20));
		    button1.setStyle("-fx-background-color: coral ");
	        if (i % 3 == 1) {
	        	button1.setTranslateX(-50);
	        } else if (i % 3 == 2) {
	        	button1.setTranslateX(-50 + 50);
	        } else if (i % 3 == 0) {
	        	button1.setTranslateX(-50 + 100);
	        }
			
			if (i <= 3) {
				button1.setTranslateY(-100);
			} else if (i <= 6) {
				button1.setTranslateY(-100 + 50);
			} else if (i <= 9) {
				button1.setTranslateY(-100 + 100);
			}
			button1.setOnAction(e -> readwithdraw.setText(readwithdraw.getText() + button1.getText()));
			WithdrawLayout.getChildren().add(button1);
		}
		backwithdraw.setOnAction(e -> {
			Text successback = new Text("INSUFFICIENT BALANCE");
			successback.setTranslateX(0);
			successback.setTranslateY(200);
			successback.setFont(Font.font("century gothic", FontWeight.BOLD, FontPosture.REGULAR, 20));
			successback.setFill(Color.DARKRED); 
			successback.setStroke(Color.DARKRED);
			WithdrawLayout.getChildren().add(successback);

    		readwithdraw.setText(" ");
    	    window.setScene(OptionsScene);});
		Button donewithdraw= new Button("Done");
		Button zerowithdraw= new Button("0");
		zerowithdraw.setPrefWidth(40);
		zerowithdraw.setPrefHeight(40);
		zerowithdraw.setTranslateX(0);
		zerowithdraw.setTranslateY(50);
		zerowithdraw.setTextFill(Color.DARKRED);
		zerowithdraw.setFont(Font.font("century gothic", FontWeight.BOLD, FontPosture.REGULAR, 20));
		zerowithdraw.setStyle("-fx-background-color: coral");
		zerowithdraw.setOnAction(e -> readwithdraw.setText(readwithdraw.getText() + zerowithdraw.getText()));
	    donewithdraw.setPrefWidth(75);
	    donewithdraw.setPrefHeight(25);
	    donewithdraw.setTranslateX(180);
	    donewithdraw.setTranslateY(180);
	    donewithdraw.setTextFill(Color.DARKRED);
	  	donewithdraw.setFont(Font.font("century gothic", FontWeight.BOLD, FontPosture.REGULAR, 15));
	  	donewithdraw.setStyle("-fx-background-color: coral");
	    donewithdraw.setOnAction(e -> {
    		if(myAtm.withdraw(Double.parseDouble(readwithdraw.getText()))==true) {
    			readwithdraw.setText(" ");
    			Text successdone = new Text("INSUFFICIENT BALANCE");
    			successdone.setTranslateX(0);
    			successdone.setTranslateY(200);
    			successdone.setFont(Font.font("century gothic", FontWeight.BOLD, FontPosture.REGULAR, 20));
    			successdone.setFill(Color.DARKRED); 
    			successdone.setStroke(Color.DARKRED);
    			WithdrawLayout.getChildren().add(successdone);
        		window.setScene(OptionsScene);		
    	}
    		else {
    			readwithdraw.setText(" ");
    			Text error = new Text("INSUFFICIENT BALANCE");
    			error.setTranslateX(0);
    			error.setTranslateY(200);
    			error.setFont(Font.font("century gothic", FontWeight.BOLD, FontPosture.REGULAR, 20));
    			error.setFill(Color.CORAL); 
    			error.setStroke(Color.DARKRED);
    			WithdrawLayout.getChildren().add(error);
    			}
    				});
    	WithdrawLayout.getChildren().addAll(donewithdraw , 	zerowithdraw , withdrawtext , readwithdraw , withdrawlabel , backwithdraw);
		WithdrawScene = new Scene (WithdrawLayout , 500 ,500);
		
		
	
		
		//BALANCE SCENE
		Text balancelabel = new Text("");
		balance.setOnAction(e -> {
			window.setScene(BalanceScene);
			balancelabel.setText("Your balance now is \n" + Double.toString(myAtm.getBalance()) + " INR");
		});
		balancelabel.setTranslateX(0);
		balancelabel.setTranslateY(0);
		Button backbalance = new Button("Back");
		backbalance.setPrefWidth(75);
 		backbalance.setPrefHeight(25);
     	backbalance.setTranslateX(-180);
     	backbalance.setTranslateY(180);
     	backbalance.setTextFill(Color.DARKRED);
  		backbalance.setFont(Font.font("century gothic", FontWeight.BOLD, FontPosture.REGULAR, 15));
  		backbalance.setStyle("-fx-background-color: coral");
	    backbalance.setOnAction(e -> window.setScene(OptionsScene));
		balancelabel.setFont(Font.font("century gothic", FontWeight.BOLD, FontPosture.REGULAR, 30));
	    balancelabel.setFill(Color.CORAL); 
		balancelabel.setStroke(Color.CORAL);
		StackPane BalanceLayout = new StackPane();
		BalanceLayout.getChildren().addAll(balancelabel,backbalance);
		BalanceLayout.setStyle("-fx-background-color: darkred");
		BalanceScene = new Scene (BalanceLayout , 500 ,500);
		
	
		
		//HISTORY SCENE
		Text historylabel = new Text("");
		history.setOnAction(e -> {
			window.setScene(HistoryScene);
			if (myAtm.currentTransactionIndex == -1) {
				historylabel.setText("No Transcations yet");
			} else {
				Transaction currentTransaction = myAtm.getCurrentTransaction();
				historylabel.setText(currentTransaction.type + " " + Double.toString(currentTransaction.value)+" INR");
			}
		});
		Button previous = new Button("Previous");
		Button next = new Button("Next");
		next.setPrefWidth(85);
		next.setPrefHeight(25);
		next.setTranslateX(180);
		next.setTranslateY(180);
		next.setTextFill(Color.DARKRED);
  		next.setFont(Font.font("century gothic", FontWeight.BOLD, FontPosture.REGULAR, 15));
  		next.setStyle("-fx-background-color: coral");
		previous.setPrefWidth(85);
	    previous.setPrefHeight(25);
	    previous.setTranslateX(-180);
	    previous.setTranslateY(180);
	    previous.setTextFill(Color.DARKRED);
  		previous.setFont(Font.font("century gothic", FontWeight.BOLD, FontPosture.REGULAR, 15));
  		previous.setStyle("-fx-background-color: coral");
		previous.setOnAction(e -> {
			if(myAtm.currentTransactionIndex>=0) {
				myAtm.previous();
			Transaction currentTransaction = myAtm.getCurrentTransaction();
			historylabel.setText(currentTransaction.type + " " + Double.toString(currentTransaction.value)+" INR");
		}});
		next.setOnAction(e -> {
			if(myAtm.currentTransactionIndex>=0) {
			myAtm.next();
			Transaction currentTransaction = myAtm.getCurrentTransaction();
			historylabel.setText(currentTransaction.type + " " + Double.toString(currentTransaction.value)+" INR");
		}});
		historylabel.setTranslateX(0);
		historylabel.setTranslateY(0);
	    Button backhistory = new Button("Back");
	    backhistory.setPrefWidth(85);
	    backhistory.setPrefHeight(25);
	    backhistory.setTranslateX(-180);
	    backhistory.setTranslateY(-190);
	    backhistory.setTextFill(Color.DARKRED);
  		backhistory.setFont(Font.font("century gothic", FontWeight.BOLD, FontPosture.REGULAR, 15));
  		backhistory.setStyle("-fx-background-color: coral");
	    backhistory.setOnAction(e -> window.setScene(OptionsScene));
	    historylabel.setFont(Font.font("century gothic", FontWeight.BOLD, FontPosture.REGULAR, 30));
	    historylabel.setFill(Color.CORAL); 
	    historylabel.setStroke(Color.CORAL);
		StackPane HistoryLayout = new StackPane();
		HistoryLayout.getChildren().addAll(historylabel, backhistory, previous, next);
		HistoryLayout.setStyle("-fx-background-color: darkred");
		HistoryScene = new Scene (HistoryLayout , 500 ,500);
		
		
		window.setScene(MainScene);
		window.setTitle("ATM Machine");
		window.show();
	}
	
	void donePress(Label lbl) {
		myAtm = new ATM(lbl.getText());
		
		}
	
}
