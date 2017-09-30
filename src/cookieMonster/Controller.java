package cookieMonster;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.util.Duration;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Controller implements Initializable{

	@FXML
	private Label b1,b2,b3,b4, bNr1, bNr2, bNr3, bNr4, b1c, b2c,b3c,b4c,amount,moneyC;
	
	@FXML
	private Button b1B,b2B,b3B,b4B,clicker;
	
	static int GRANPRICE = 50;
	static int BAKPRICE = 500;
	static int FACPRICE = 5000;
	static int AKWPRICE = 50000;
	
	static int money, grandma = 0, bake = 0, fact = 0, atom = 0;
	

	//private MenuItem about;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
//		bNr1.setText(String.valueOf(0));
//		bNr2.setText(String.valueOf(0));
//		bNr3.setText(String.valueOf(0));
//		bNr4.setText(String.valueOf(0));
//		
		amount.setText(String.valueOf(0));
		clicker.requestFocus();
		
		b1c.setText("Price: "+GRANPRICE+" Clicks (1 C/sec)");
		b2c.setText("Price: "+BAKPRICE+" Clicks (10C/sec)");
		b3c.setText("Price: "+FACPRICE+" Clicks (100C/sec)");
		b4c.setText("Price: "+AKWPRICE+" Clicks (1000C/sec)");
		
		bindToTime();
	}
	
	
	
	
	@FXML
	public void Click(){
		clicker.setOnAction(e ->{
//			int money = Integer.parseInt(amount.getText());
			money++;
			amount.setText(String.valueOf(money));
		});
	}
	@FXML
	private void Help(){
		helper();
	}
	private void helper(){
		
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL); 		//Blocks User Interaction with other windows
		window.setTitle("HELP");
		window.setMinWidth(200);
		window.setMinHeight(200);
		Label label = new Label();
		label.setText("         PLAY\n no help for you!");
		
		Button ok = new Button("ok I'm nub");
		
		ok.setOnAction(e-> window.close());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, ok);
		layout.setAlignment(Pos.CENTER);
		
		//Scene
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		}
	
//	@FXML
//	public void buyGranny(){
//		b1B.setOnAction(e -> {
//			int granny = Integer.parseInt(bNr1.getText());
//			int money = Integer.parseInt(amount.getText());
//			if (money>=GRANPRICE){
//			granny++;
//			money=money-GRANPRICE;
//			bNr1.setText(String.valueOf(granny));
//			amount.setText(String.valueOf(money));
//			bindToTime();
//			}else{System.out.println("not enough money");}
//			});
//	}
	
		
	@FXML
	private void granny() {
		if (money >= GRANPRICE) {
			money -= GRANPRICE;
			grandma++;
			bNr1.setText(""+grandma);
			GRANPRICE=GRANPRICE+5;
			b1c.setText("Price: "+GRANPRICE+" Clicks (1 C/sec)");
			
		}
	}
	
	@FXML
	private void bake() {
		if (money >= BAKPRICE) {
			money -= 500;
			bake++;
			bNr2.setText(""+bake);
			BAKPRICE=BAKPRICE+50;
			b2c.setText("Price: "+BAKPRICE+" Clicks (10C/sec)");
		}
	}
	
	@FXML
	private void fact() {
		if (money >= FACPRICE) {
			money -= 5000;
			fact++;
			bNr3.setText(""+fact);
			FACPRICE=FACPRICE+500;
			b3c.setText("Price: "+FACPRICE+" Clicks (100C/sec)");
		}
	}
	
	@FXML
	private void atom() {
		if (money >= AKWPRICE) {
			money -= 50000;
			atom++;
			bNr4.setText(""+atom);
			AKWPRICE=AKWPRICE+5000;
			b4c.setText("Price: "+AKWPRICE+" Clicks (1000C/sec)");
		}
	}
	
	@FXML
	private void close() {
		Platform.exit();
	}
	
	@FXML
	private void restart() {
		money = 0;
		grandma = 0;
		bake = 0;
		fact = 0;
		atom = 0;
		bNr1.setText(""+0);
		bNr2.setText(""+0);
		bNr3.setText(""+0);
		bNr4.setText(""+0);
	}
	
	private void bindToTime() {
	    Timeline timeline = new Timeline(
	      new KeyFrame(Duration.seconds(0),
	        new EventHandler<ActionEvent>() {
	          @Override public void handle(ActionEvent actionEvent) {
//	            Calendar time = Calendar.getInstance();
	            			
	            
//	            int granny = Integer.parseInt(bNr1.getText());
//	    		int money = Integer.parseInt(amount.getText());
//	    										//diese schleife jede sekunde ausführen
	            
	    			money = money + (grandma*1 + bake*10 + fact*100 + atom*1000); 
	    			amount.setText(""+money);
	          }
	        }
	      ),
	      new KeyFrame(Duration.seconds(1))
	    );
	    timeline.setCycleCount(Animation.INDEFINITE);
	    timeline.play();
	  }
	
	
}


class StringUtilities {
	  /**
	   * Creates a string left padded to the specified width with the supplied padding character.
	   * @param fieldWidth the length of the resultant padded string.
	   * @param padChar a character to use for padding the string.
	   * @param s the string to be padded.
	   * @return the padded string.
	   */
	  public static String pad(int fieldWidth, char padChar, String s) {
	    StringBuilder sb = new StringBuilder();
	    for (int i = s.length(); i < fieldWidth; i++) {
	      sb.append(padChar);
	    }
	    sb.append(s);

	    return sb.toString();
	  }
	}
