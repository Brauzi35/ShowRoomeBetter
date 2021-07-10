package logic.engclasses.utils;

import java.net.URL;

public enum TypeException {
	
	TOOLONG(0, "/logic/boundary/ErrorDescriptionWindow.fxml"),
	DOUBREV(1, "/logic/boundary/ErrorDoubleReview.fxml"),
	EMPTYF(2, "/logic/boundary/ErrorEmptyField.fxml"),
	SSQUEUE(3,"/logic/boundary/ErrorSSQueue.fxml");
	
	

	private final int type;
	private final String path;
	
	private TypeException(int t, String p){
		this.type = t;
		this.path = p;
	}
	public static TypeException getView(int type) {
		for(TypeException subview : TypeException.values()) 
			if(subview.type == type) 
				return subview;
		throw new IllegalArgumentException("Unable to find the requested view("+type+")");
	}

	public int getType() {
		return type;
	}

	public static URL getUrl(TypeException subview){
		return TypeException.class.getResource(subview.path);
	}
}
