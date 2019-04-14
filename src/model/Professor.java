/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Luo(Jack) Feng
 */
public class Professor {
    
    private String name;
    private String email;
    private String course;
    private Integer proId = -1;
    
    public Professor(String name, String email, String course, Integer proId) {
        this.name = name;
        this.email = email;
        this.course = course;
        this.proId = proId;
    }
    
    public Professor() {}

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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }
}
