package logic.controller.guicontroller.findliveevent;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import logic.controller.appcontroller.FindLiveEvent;
import logic.engclasses.bean.EventBean;

public class GuiControllerFindLiveEvent implements Initializable {
	//declarations
		@FXML
	    private Button eurPlace;

	    @FXML
	    private Button pignetoPlace;

	    @FXML
	    private Button villaPlace;

	    @FXML
	    private Button statuarioPlace;

	    @FXML
	    private Label nameLabel;

	    @FXML
	    private Label artistLabel;

	    @FXML
	    private Label descriptionLabel;
	    
	    FindLiveEvent mc = new FindLiveEvent();
		List<EventBean> list = mc.liveEventsList();
		
		String eurName;
		String eurArtist;
		String eurDesc;
		String pignetoName;
		String pignetoArtist;
		String pignetoDesc;
		String villaName;
		String villaArtist;
		String villaDesc;
		String statuarioName;
		String statuarioArtist;
		String statuarioDesc;
	    
	    
	    @FXML
	    void eurClick(ActionEvent event) {
	    	nameLabel.setText(eurName);
	    	artistLabel.setText(eurArtist);
	    	descriptionLabel.setText(eurDesc);
	    	}

	    @FXML
	    void pignetoClick(ActionEvent event) {
	    	nameLabel.setText(pignetoName);
	    	artistLabel.setText(pignetoArtist);
	    	descriptionLabel.setText(pignetoDesc);
	    }

	    @FXML
	    void statuarioClick(ActionEvent event) {
	    	nameLabel.setText(statuarioName);
	    	artistLabel.setText(statuarioArtist);
	    	descriptionLabel.setText(statuarioDesc);
	    }

	    @FXML
	    void villaClick(ActionEvent event) {
	    	nameLabel.setText(villaName);
	    	artistLabel.setText(villaArtist);
	    	descriptionLabel.setText(villaDesc);
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			//every button starts not visible
			eurPlace.setVisible(false);
			pignetoPlace.setVisible(false);
			villaPlace.setVisible(false);
			statuarioPlace.setVisible(false);
			//set visible a button if the corrisponding event is live
			for(int i = 0; i < list.size(); i++) {
				if (list.get(i).getPlace().equals("Eur")) {
					eurPlace.setVisible(true);
					eurName = list.get(i).getName();
					eurArtist = list.get(i).getArtist();
					eurDesc = list.get(i).getDescription();
				}
				else if (list.get(i).getPlace().equals("Pigneto")) {
					pignetoPlace.setVisible(true);
					pignetoName = list.get(i).getName();
					pignetoArtist = list.get(i).getArtist();
					pignetoDesc = list.get(i).getDescription();
				}
				else if (list.get(i).getPlace().equals("Villa")) {
					villaPlace.setVisible(true);
					villaName = list.get(i).getName();
					villaArtist = list.get(i).getArtist();
					villaDesc = list.get(i).getDescription();
				}
				else if (list.get(i).getPlace().equals("Statuario")) {
					statuarioPlace.setVisible(true);
					statuarioName = list.get(i).getName();
					statuarioArtist = list.get(i).getArtist();
					statuarioDesc = list.get(i).getDescription();
				}
				
			}
			
		}
		
}
