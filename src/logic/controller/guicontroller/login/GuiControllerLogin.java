package logic.controller.guicontroller.login;

import java.io.IOException;

import javax.security.auth.login.LoginException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import logic.controller.appcontroller.login.Login;
import logic.controller.guicontroller.navbars.LoggedArtistController;
import logic.controller.guicontroller.navbars.LoggedSponsorController;
import logic.controller.guicontroller.navbars.LoggedUserController;


public class GuiControllerLogin {

	@FXML
	private AnchorPane loginroot;
	 
	@FXML
    private Button loginButton;
	@FXML
    private PasswordField passwordBox;
	@FXML
    private TextField usernameTextField;
	@FXML
    private MenuButton typeMenuButton;

    @FXML
    private MenuItem standardUserButton;

    @FXML
    private MenuItem artistButton;

    @FXML
    private MenuItem sponsorButton;
	
	int identity = 0; //used for understanding which dao to activate, it cannot be 0 -> develop a custom exception! 

	  
	 @FXML
	 public void loginClicked(ActionEvent event) throws LoginException, IOException{

		 if (identity==0) {
			 //the user did not select any identity, implement an exception
		 }
		 else if (identity==1) {
			 //std user selected
			 Login lc = new Login();
			 lc.setupSessionUser(identity, this.usernameTextField.getText(), this.passwordBox.getText());
			 FXMLLoader loader=new FXMLLoader(getClass().getResource("/logic/view/LoggedUser.fxml"));
			 LoggedUserController luc = new LoggedUserController();
			 loader.setController(luc);
			 Scene scene=this.usernameTextField.getScene();
			 scene.setRoot(loader.load());
			 
		 }
		 else if (identity==2) {
			 //artist selected
			 Login lc = new Login();
			 lc.setupSessionUser(identity, this.usernameTextField.getText(), this.passwordBox.getText());
			 FXMLLoader loader=new FXMLLoader(getClass().getResource("/logic/view/viewprofile/ViewYourProfile.fxml"));
			 LoggedArtistController lac = new LoggedArtistController();
			 loader.setController(lac);
			 Scene scene=this.usernameTextField.getScene();
			 scene.setRoot(loader.load());
		 }
		 else if (identity==3) {
			 //sponsor selected
			 Login lc = new Login();
			 lc.setupSessionUser(identity, this.usernameTextField.getText(), this.passwordBox.getText());
			 FXMLLoader loader=new FXMLLoader(getClass().getResource("/logic/view/editcommercialactivity/EditCommercialActivity.fxml"));
			 LoggedSponsorController lsc = new LoggedSponsorController();
			 loader.setController(lsc);
			 Scene scene=this.usernameTextField.getScene();
			 scene.setRoot(loader.load());
		 }
	    }
	 
	 @FXML
	 public void caricaregistrazione() throws IOException {
		 
		 AnchorPane pane =FXMLLoader.load(getClass().getResource("/logic/boundary/Registrazione.fxml"));
		 loginroot.getChildren().setAll(pane);
		  
	 }
	 
	 
	 @FXML
	    void artistButtonClick(ActionEvent event) {
		 	typeMenuButton.setText("Artist");
		 	identity=2; //2 is for artist
		 	
	    }
	 
	 @FXML
	    void sponsorButtonClick(ActionEvent event) {
		 	typeMenuButton.setText("Sponsor");
		 	identity=3; //3 is for sponsor
	    }

	 @FXML
	    void standardUserButtonClick(ActionEvent event) {
		 	typeMenuButton.setText("Standard User");
		 	identity=1; //1 is for std user
	    }
	
}
