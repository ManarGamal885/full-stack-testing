package chapter3AutomatedFunctionalTesting.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"email", "password"})
public class LoginDetails {
    private String email;
    private String password;

    public LoginDetails(String email, String password){
        this.email = email;
        this.password = password;
    }

    @JsonProperty("email")
    public String getEmail(){
        return email;
    }

    @JsonProperty("password")
    public String getPassword(){
        return password;
    }
}
