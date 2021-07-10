package logic.engclasses.exceptions;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import logic.engclasses.utils.TypeException;


public class ExceptionView {

private Parent root;
	
	protected ExceptionView(TypeException view) {
		FXMLLoader loader = new FXMLLoader(TypeException.getUrl(view));
        try {
            setRoot(loader.load());
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }

    public Parent getRoot() {
        return root;
    }

    public void setRoot(Parent root) {
        this.root = root;
    }
	
    
}
