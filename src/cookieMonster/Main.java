package cookieMonster;


import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	public void start(Stage primaryStage) {
		try {
			URL fxmlUrl = getClass().getResource("Cookies.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl);
			fxmlLoader.setController(new Controller());
			Parent root = fxmlLoader.load();
			Scene scene = new Scene(root,600, 400);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Cookie Clicker");
			root.requestFocus();
			primaryStage.show();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}