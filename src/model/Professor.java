package model;

/**
 *
 * @author Luo(Jack) Feng
 */
public class Professor {
    
    // instance variable: name, email, course, proId 
    private String name;
    private String email;
    private String course;
    private Integer proId;
    
    // Professor constructor
    public Professor(String name, String email, String course, Integer proId) {
        this.name = name;
        this.email = email;
        this.course = course;
        this.proId = proId;
    }

    // get and set method for name, email, course, proId
    
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
