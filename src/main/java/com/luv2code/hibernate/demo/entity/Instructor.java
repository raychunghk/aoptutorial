package com.luv2code.hibernate.demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    public Instructor() {
        super();
    }

    public Instructor(String name, String first_name, String last_name) {
        this.name = name;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    /*
        public Instructor(String name, String first_name, String last_name, String email, InstructorDetail instructordetail) {
            super();
            this.name = name;
            this.first_name = first_name;
            this.last_name = last_name;
            this.email = email;
            this.instructordetail = instructordetail;
        }
    */
    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", instructordetail=" + instructorDetail +
            //    ",\n courses=" + courses +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InstructorDetail getInstructorDetail() {
        return instructorDetail;
    }

    public void setInstructorDetail(InstructorDetail instructordetail) {
        this.instructorDetail = instructordetail;
    }

    String first_name;
    String last_name;
    String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    InstructorDetail instructorDetail;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
    }, mappedBy = "instructor", fetch = FetchType.LAZY )
    List<Course> courses;

    public void add(Course _course) {
        if (courses == null) {
            courses = new ArrayList<Course>();
        }
        courses.add(_course);
        _course.setInstructor(this);

    }
}
