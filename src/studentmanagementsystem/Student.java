package studentmanagementsystem;

/**
 *
 * @author Luo(Jack) Feng
 */
public class Student {
    
    private String name;
    private String email;
    private Integer stuId = -1;
    
    public Student(String name, String email, Integer stuId) {
        this.name = name;
        this.email = email;
        this.stuId = stuId;
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

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }
}
