package bonuspunkte;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

	public static void main(String[] args) {
		
		  Application.launch(args);
	}
			ComboBox<String> readme;	  
			Stage window;
			Scene gameScene;
			private String chosen;
			Label amount = new Label();
			private int GRANPRICE = 50;
			private int BAKPRICE = 500;
			private int FACPRICE = 5000;
			private int AKWPRICE = 50000;
			private int ALIENPRICE = 500000;
			
			private int money, grandma = 0, baker = 0, factory = 0, atom = 0, alien=0;
			
			 public void start (Stage primaryStage) throws Exception{
				 window = primaryStage;
				 window.setTitle("Cookie Clicker");
				 
				 BorderPane border = new BorderPane();
				 
				 HBox hbox = new HBox();
				 StackPane stacky= new StackPane();
				 VBox vbox = new VBox(10);
				 
				 vbox.setPadding(new Insets(10));
				 vbox.setSpacing(8);
				 
				 border.setCenter(vbox);
				 
				 
				 Text Tcookie = new Text(25, 25,"COOKIE MONSTER");
				 Tcookie.setFill(Color.CHOCOLATE);
				 Tcookie.setFont(Font.font(java.awt.Font.MONOSPACED, 100));
			      
			      Effect glow = new Glow(1.0);
			      Tcookie.setEffect(glow);
				 
				 
				 
				Button playB = new Button("Play!");
				playB.setPrefSize(100, 30);
				playB.setOnAction(e -> window.setScene(gameScene));
				
				
				readme = new ComboBox<>();
			    readme.getItems().addAll(
			                "Deutsch",
			                "English"
			        );
			    readme.setPromptText("Anleitung / Instructions");
			    readme.setOnAction( e -> checkReadme());
			    
			    
//				Button readme = new Button("Anleitung");
				readme.setPrefHeight(30);
				
				
				Button end = new Button ("Quit");
				end.setPrefSize(100, 30);
				end.setOnAction(e-> Platform.exit());
				
				Label leer = new Label();
				leer.setPrefHeight(300);
				
				
				hbox.setPadding(new Insets(15, 12, 15, 12));
				hbox.setSpacing(60);
				
				hbox.getChildren().addAll(stacky); 
				hbox.getChildren().addAll(playB,readme,end);
				
				
				vbox.getChildren().addAll(Tcookie,leer,hbox);
				
				vbox.setAlignment(Pos.CENTER);
				hbox.setAlignment(Pos.CENTER);     
			
				 
				 Scene scene = new Scene(border, 1000,700);
				 window.setScene(scene);
				 
				 window.show();
				 
//--------------------from here on Game Code				 
			 
				 
				 GridPane grid = new GridPane();
				 //grid.setPadding(new Insets(10,10,10,10)); //10/10/10/10
				 grid.setVgap(6); //8
				 grid.setHgap(6); //10
				 
				 bindToTime();
				 
				
				 
				
				 amount.setFont(Font.font(50));
				 amount.setText(String.valueOf(0));
				 GridPane.setConstraints(amount,90,20);
				 
				 Label ccount = new Label("Number of Cookies:");
				 ccount.setFont(Font.font(15));
				 GridPane.setConstraints(ccount,90,10);
				 	 
				 Button clicker = new Button("CLICK ME!");
				 GridPane.setConstraints(clicker, 90,60);
				 clicker.setPrefHeight(70);
				 clicker.setOnAction(e ->{
						money++;
						amount.setFont(Font.font(50));
						amount.setText(String.valueOf(money));
					});
				
				 //TOP-Label
				 
				 Label producer = new Label("Producer");
				 producer.setFont(Font.font(20));
				 GridPane.setConstraints(producer,10,3);
				 Label buy =new Label("Buy");
				 buy.setFont(Font.font(20));
				 GridPane.setConstraints(buy,20,3);
				 Label count=new Label("#");
				 count.setFont(Font.font(20));
				 GridPane.setConstraints(count,25,3);
				 Label costings=new Label("Price List!");
				 costings.setFont(Font.font(20));
				 GridPane.setConstraints(costings,50,3);
				 
				 //Labels für Producers
				 
				 Label grandmaL = new Label("Grandma");
				 GridPane.setConstraints(grandmaL, 10,10);
				 
				 Label bakerL = new Label("Baker");
				 GridPane.setConstraints(bakerL, 10, 20);
				 
				 Label factoryL = new Label ("Factory");
				 GridPane.setConstraints(factoryL, 10,30);
				 
				 Label atomL = new Label("AKW");
				 GridPane.setConstraints(atomL, 10,45);
				 
				 Label alienL = new Label("Alien-Power");
				 GridPane.setConstraints(alienL,10,55);
					
				 
				 //TextLabels
				 
				 Label grandmaText=new Label("Price: "+GRANPRICE+" Clicks (1 C/sec)");
				 GridPane.setConstraints(grandmaText,50,10);
				 Label bakerText=new Label("Price: "+BAKPRICE+" Clicks (10C/sec)");
				 GridPane.setConstraints(bakerText, 50,20);
				 Label factoryText=new Label("Price: "+FACPRICE+" Clicks (100C/sec)");
				 GridPane.setConstraints(factoryText,50,30);
				 Label atomText=new Label("Price: "+AKWPRICE+" Clicks (1000C/sec)");
				 GridPane.setConstraints(atomText,50,45);
				 Label alienText=new Label("Price: "+ALIENPRICE+" Clicks(10'000/sec");
				 GridPane.setConstraints(alienText,50,55);
				 
				
				 
				 
				//Grandma
				 
				 Button grandmaB = new Button("+1");
				 GridPane.setConstraints(grandmaB, 20,10);
				 Label grandmaCount = new Label("0");
				 GridPane.setConstraints(grandmaCount, 25,10);
				 
				 grandmaB.setOnAction(e-> {
				 if (money >= GRANPRICE) {
						money -= GRANPRICE;
						grandma++;
						grandmaCount.setText(""+grandma);
						GRANPRICE=GRANPRICE+5;
						grandmaText.setText("Price: "+GRANPRICE+" Clicks (1 C/sec)");
				}});
				
				
				 //Baker
				 Button bakerB = new Button("+1");
				 GridPane.setConstraints(bakerB,20,20);
				 Label bakerCount=new Label("0");
				 GridPane.setConstraints(bakerCount,25,20); 
		
				 bakerB.setOnAction(e-> {
					 if (money >= BAKPRICE) {
							money -= BAKPRICE;
							baker++;
							bakerCount.setText(""+baker);
							BAKPRICE=BAKPRICE+50;
							bakerText.setText("Price: "+BAKPRICE+" Clicks (10 C/sec)");
					}});
				 
				 //Factory
				 Button factoryB = new Button("+1");
				 GridPane.setConstraints(factoryB,20,30);
				 Label factoryCount=new Label("0");
				 GridPane.setConstraints(factoryCount,25,30); 
		
				 factoryB.setOnAction(e-> {
					 if (money >= FACPRICE) {
							money -= FACPRICE;
							factory++;
							factoryCount.setText(""+factory);
							FACPRICE=FACPRICE+500;
							factoryText.setText("Price: "+FACPRICE+" Clicks (100 C/sec)");
					}});
				 
				 //AKW
				 Button atomB = new Button("+1");
				 GridPane.setConstraints(atomB,20,45);
				 Label atomCount=new Label("0");
				 GridPane.setConstraints(atomCount,25,45); 
		
				 atomB.setOnAction(e-> {
					 if (money >= AKWPRICE) {
							money -= AKWPRICE;
							atom++;
							atomCount.setText(""+atom);
							AKWPRICE=AKWPRICE+5000;
							atomText.setText("Price: "+AKWPRICE+" Clicks (1000 C/sec)");
					}});
				 
				 //ALIEN
				 Button alienB = new Button("+1");
				 GridPane.setConstraints(alienB,20,55);
				 Label alienCount=new Label("0");
				 GridPane.setConstraints(alienCount,25,55); 
		
				 alienB.setOnAction(e-> {
					 if (money >= ALIENPRICE) {
							money -= ALIENPRICE;
							alien++;
							alienCount.setText(""+alien);
							ALIENPRICE=ALIENPRICE+50000;
							alienText.setText("Price: "+ALIENPRICE+" Clicks (10000 C/sec)");
					}});
				 
				 
				 grid.getChildren().addAll(ccount,amount,clicker,grandmaL,bakerL,factoryL,atomL,alienL,
						 grandmaText,bakerText,factoryText,atomText,alienText,grandmaB,grandmaCount,bakerB,bakerCount,
						 factoryB,factoryCount,atomB,atomCount,alienB,alienCount,producer,buy,costings,count);
				 
				 gameScene = new Scene(grid,1100, 700);
				 
				
		

	}
			 
			 private void checkReadme(){
				 chosen = readme.getValue();
				 if(chosen.equals("Deutsch")){
					 System.out.println("D"); 				//anstatt Prints hier dokument öffnen mit anleitung auf D
				 }if(chosen.equals("English")){
				 	System.out.println("E");}				//auf E
			 }
			
	//-------------------------Copy StackOverflow------- Für SekundenUpdate		 
			 private void bindToTime() {
				    Timeline timeline = new Timeline(
				      new KeyFrame(Duration.seconds(0),
				        new EventHandler<ActionEvent>() {
				          @Override public void handle(ActionEvent actionEvent) {

				            							            
				    			money = money + (grandma*1 + baker*10 + factory*100 + atom*1000 + alien*10000); 
				    			System.out.println(money);
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
