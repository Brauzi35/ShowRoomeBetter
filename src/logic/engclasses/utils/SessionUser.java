package logic.engclasses.utils;


//class to manage various user sessions

public class SessionUser {
	
	//****Singleton****//
			private static SessionUser instance = null;
			
			private SessionUser() {}

			public static synchronized SessionUser getInstance() {
				if(instance == null)
					instance = new SessionUser();
					
				return instance;
			}
			//fine singleton
			
			//attributi
			private int id = 0; //1=user, 2= artist, 3=sponsor
			private String username;
			private String password;

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public String getUsername() {
				return username;
			}

			public void setUsername(String username) {
				this.username = username;
			}

			public String getPassword() {
				return password;
			}

			public void setPassword(String password) {
				this.password = password;
			}
			
			
	} 

	