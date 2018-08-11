package com.socks.api.models.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;


@ToString
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class NewUserRequestBody{

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("password")
	private String password;

	@JsonProperty("email")
	private String email;

	@JsonProperty("username")
	private String username;

//	@Override
// 	public String toString(){
//		return
//			"NewUserRequestBody{" +
//			"firstName = '" + firstName + '\'' +
//			",lastName = '" + lastName + '\'' +
//			",password = '" + password + '\'' +
//			",email = '" + email + '\'' +
//			",username = '" + username + '\'' +
//			"}";
//		}
}