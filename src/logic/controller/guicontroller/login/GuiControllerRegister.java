package logic.controller.guicontroller.login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import logic.controller.appcontroller.login.Register;
import logic.engclasses.exceptions.DuplicateUsernameException;


public class GuiControllerRegister implements Initializable{

	@FXML
    private AnchorPane cavallo2;

    @FXML
    private Button userButton;

    @FXML
    private Button artistButton;

    @FXML
    private Button sponsorButton;

    @FXML
    private AnchorPane artistPane;

    @FXML
    private TextField usernameBoxArtist;

    @FXML
    private TextField passwordBoxArtist;

    @FXML
    private TextField emailBoxArtist;

    @FXML
    private TextField descriptionBoxArtist;

    @FXML
    private TextField talentBoxArtist;

    @FXML
    private Button registerArtistButton;

    @FXML
    private AnchorPane sponsorPane;

    @FXML
    private TextField usernameBoxSponsor;

    @FXML
    private TextField passwordBoxSponsor;

    @FXML
    private TextField activityBox;

    @FXML
    private TextField descriptionBoxSponsor;

    @FXML
    private TextField capacityBoxSponsor;

    @FXML
    private Button registerSponsorButton;

    @FXML
    private AnchorPane usersPane;

    @FXML
    private TextField usernameBoxUser;

    @FXML
    private TextField passwordBoxUser;

    @FXML
    private Button registerUserButton;

    @FXML
    void artistClicked(ActionEvent event) {
    	artistPane.setVisible(true);
    }

    @FXML
    void registerArtist(ActionEvent event) {
    	Register rac = new Register();
    	rac.artistReg(usernameBoxArtist.getText(), passwordBoxArtist.getText(), emailBoxArtist.getText(), descriptionBoxArtist.getText(), talentBoxArtist.getText());
    }

    @FXML
    void registerSponsor(ActionEvent event) {
    	//to do
    }

    @FXML
    void registerUser(ActionEvent event) throws DuplicateUsernameException {
    	Register rac = new Register();
    	rac.userReg(usernameBoxUser.getText(), passwordBoxUser.getText());
    }

    @FXML
    void sponsorClicked(ActionEvent event) {
    	sponsorPane.setVisible(true);
    }

    @FXML
    void userClicked(ActionEvent event) {
    	usersPane.setVisible(true);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//at firts every *pane is not visible
		usersPane.setVisible(false);
		artistPane.setVisible(false);
		sponsorPane.setVisible(false);
		
	}
}
