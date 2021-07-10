package logic.engclasses.utils;

public class SessionArtist {
	//****Singleton****//
			private static SessionArtist instance = null;
			
			private SessionArtist() {}

			public static synchronized SessionArtist getInstance() {
				if(instance == null)
					instance = new SessionArtist();
					
				return instance;
			}
			//fine singleton
			
			//attributi
			private String username;
			private String password;
			private String email;
			private String description;
			private String talent;

			//metodi
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

			public String getEmail() {
				return email;
			}

			public void setEmail(String email) {
				this.email = email;
			}

			public String getDescription() {
				return description;
			}

			public void setDescription(String description) {
				this.description = description;
			}

			public String getTalent() {
				return talent;
			}

			public void setTalent(String talent) {
				this.talent = talent;
			}
}
