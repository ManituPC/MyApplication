package com.example.fitness_application.objects;

/**
 * Created by Денис on 31.05.2017.
 */

public class Exercise {

    private int id;
    private int birth;
    private String name;
    private int reiteration1, reiteration2, reiteration3, reiteration4, reiteration5;
    private int weight1, weight2, weight3, weight4, weight5;

    public Exercise(int id, int birth, String name, int reiteration1, int reiteration2, int reiteration3, int reiteration4, int reiteration5,
                    int weight1, int weight2, int weight3, int weight4, int weight5) {
        this.id = id;
        this.birth = birth;
        this.name = name;
        this.reiteration1 = reiteration1;
        this.reiteration2 = reiteration2;
        this.reiteration3 = reiteration3;
        this.reiteration4 = reiteration4;
        this.reiteration5 = reiteration5;
        this.weight1 = weight1;
        this.weight2 = weight2;
        this.weight3 = weight3;
        this.weight4 = weight4;
        this.weight5 = weight5;
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReiteration1() {
        return reiteration1;
    }

    public void setReiteration1(int reiteration1) {
        this.reiteration1 = reiteration1;
    }

    public int getReiteration2() {
        return reiteration2;
    }

    public void setReiteration2(int reiteration2) {
        this.reiteration2 = reiteration2;
    }

    public int getReiteration3() {
        return reiteration3;
    }

    public void setReiteration3(int reiteration3) {
        this.reiteration3 = reiteration3;
    }

    public int getReiteration4() {
        return reiteration4;
    }

    public void setReiteration4(int reiteration4) {
        this.reiteration4 = reiteration4;
    }

    public int getReiteration5() {
        return reiteration5;
    }

    public void setReiteration5(int reiteration5) {
        this.reiteration5 = reiteration5;
    }

    public int getWeight1() {
        return weight1;
    }

    public void setWeight1(int weight1) {
        this.weight1 = weight1;
    }

    public int getWeight2() {
        return weight2;
    }

    public void setWeight2(int weight2) {
        this.weight2 = weight2;
    }

    public int getWeight3() {
        return weight3;
    }

    public void setWeight3(int weight3) {
        this.weight3 = weight3;
    }

    public int getWeight4() {
        return weight4;
    }

    public void setWeight4(int weight4) {
        this.weight4 = weight4;
    }

    public int getWeight5() {
        return weight5;
    }

    public void setWeight5(int weight5) {
        this.weight5 = weight5;
    }
}
