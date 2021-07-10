package logic.engclasses.utils;

import java.io.IOException;

import logic.engclasses.exceptions.DescTooLongExceptionView;
import logic.engclasses.exceptions.DuplicateReviewExceptionView;
import logic.engclasses.exceptions.EmptyFieldView;
import logic.engclasses.exceptions.ExceptionView;
import logic.engclasses.exceptions.PendingRequestExceptionView;

public class ExceptionFactory {
	//***Singleton***/
		private static ExceptionFactory instance = null;
		private ExceptionFactory() {}
		
		public static synchronized ExceptionFactory getInstance() {
			if(instance == null) {
				instance = new ExceptionFactory();
			}
			return instance;
		}
		
		public ExceptionView createView(TypeException ex) throws IOException{
			
			switch(ex.getType()) {   
			case 0:
				return new DescTooLongExceptionView(ex);
			case 1: 
				return new DuplicateReviewExceptionView(ex);
			case 2: 
				return new EmptyFieldView(ex);
			case 3:
				return new PendingRequestExceptionView(ex);
			
			
			default:
				return new DescTooLongExceptionView(ex);
			}
		}
	}

