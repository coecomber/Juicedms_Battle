package com.Herwaarden.Battle.Model.Character;

public class CharacterModel {
    private int id;
    private String active;
    private String createdAt;
    private String lastLoggedInAt;
    private String gender;
    private String name;
    private String email;
    private int floor;
    private int power;
    private int gold;

    public CharacterModel() {
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getLastLoggedInAt() {
        return lastLoggedInAt;
    }

    public void setLastLoggedInAt(String lastLoggedInAt) {
        this.lastLoggedInAt = lastLoggedInAt;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
