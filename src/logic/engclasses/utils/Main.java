package logic.engclasses.utils;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import logic.controller.guicontroller.login.GuiControllerLogin;
import javafx.scene.Scene;


public class Main extends Application {
	
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		primaryStage.setTitle("ShowRoome");
		GuiControllerLogin gcl = new GuiControllerLogin();
		FXMLLoader loader=new FXMLLoader(getClass().getResource("/logic/view/login/Login.fxml"));
		loader.setController(gcl);
		Scene scene=new Scene(loader.load());
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
}
