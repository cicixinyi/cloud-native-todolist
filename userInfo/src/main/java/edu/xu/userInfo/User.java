package edu.xu.userInfo;

@jakarta.persistence.Entity
public class User {
    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
	private String id;

    @jakarta.persistence.Column
    private String name;

    public User() {}

    public String getId() {
		return id;
	}

    public String getName() {
		return name;
	}
    
}
