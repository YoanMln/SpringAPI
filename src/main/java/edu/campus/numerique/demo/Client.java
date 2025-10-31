package edu.campus.numerique.demo;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Client entity representing a customer")
public class Client {
    @Schema(description = "Unique identifier of the client", example = "1")
    private int id;

    @Schema(description = "Name of the client", example = "John")
    private String name;

    @Schema(description = "Email address of the client")
    private String email;

    @Schema(description = "Phone number of the client", example = "+1234567890")
    private String phone;

    public Client() {

    }


    public Client(int id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}