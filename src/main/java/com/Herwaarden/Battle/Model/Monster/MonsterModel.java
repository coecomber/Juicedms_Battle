package com.Herwaarden.Battle.Model.Monster;

public class MonsterModel {
    private String name;
    private int floor;
    private int goldreward;
    private int health;

    public MonsterModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getGoldreward() {
        return goldreward;
    }

    public void setGoldreward(int goldreward) {
        this.goldreward = goldreward;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
