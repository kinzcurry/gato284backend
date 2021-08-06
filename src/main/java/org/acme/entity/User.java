package org.acme.entity;

import io.quarkus.security.identity.SecurityIdentity;

public class User {

	private final String userName;
	
	 public User(SecurityIdentity identity) {
         this.userName = identity.getPrincipal().getName();
     }
	 
	 public String getUserName() {
         return userName;
     }

}
