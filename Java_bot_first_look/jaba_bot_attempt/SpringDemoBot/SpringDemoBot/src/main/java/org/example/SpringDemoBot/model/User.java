package org.example.SpringDemoBot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Timestamp;
import java.util.Calendar;

@Entity(name = "usersDataTable")
public class User {

    @Id
    private Long chatID;

    private String firstName;

    private String lastName;

    private String userName;

    private Timestamp registeredAt;

    public Long getChatID() {
        return chatID;
    }

    public void setChatID(Long chatID) {
        this.chatID = chatID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Timestamp getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(Timestamp registeredAt) {
        this.registeredAt = registeredAt;
    }

    public String date (Timestamp registeredAt){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(registeredAt.getTime());
        return String.valueOf(calendar.getTime());
    }

    @Override
    public String toString() {
        return  "\nchatID = " + chatID + "\n\n" +
                "firstName = " + firstName + "\n\n" +
                "lastName = " + lastName + "\n\n" +
                "userName = " + userName + "\n\n" +
                "registeredAt = " + date(registeredAt) + "\n\n";
    }
}
