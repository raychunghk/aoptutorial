package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class HibernateDemo {
    public static void main(String[] args) {
        Session sess = getSession();
        Transaction tx = sess.getTransaction();
        tx.begin();
        Student st = (Student) sess.createQuery("from Student where id =3003").list().get(0);
        st.setEmail("raychung@live.hk");
        tx.commit();
        sess.close();


    }

    public void updateHQL() {
        Session sess = getSession();
        Transaction tx = sess.getTransaction();
        tx.begin();
        sess.createQuery("update Student set email = 'a@c.com' where id = 3003").executeUpdate();

        tx.commit();
        sess.close();

    }

    private static Session getSession() {
        SessionFactory sf = new Configuration().configure().addAnnotatedClass(Student.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
        return sf.getCurrentSession();
    }

    private static Session getSession(List<Class> lstclass) {
        Configuration conf = new Configuration().configure();
        for (Class c : lstclass) {
            conf.addAnnotatedClass(c);
        }
        SessionFactory sf = conf.buildSessionFactory();
        final Session sess = sf.openSession();
        return sess;
    }

    public void Delete1() {
        Session sess = getSession();
        Transaction tx = sess.getTransaction();
        tx.begin();
        Student stu = sess.get(Student.class, 3003);
        sess.delete(stu);
        tx.commit();


    }

    public void DoInstructorDetailRelation() {
        Session ses = getSession();
        try {
            int id = 55;

            Transaction tx = ses.getTransaction();
            tx.begin();
            InstructorDetail isd = ses.get(InstructorDetail.class, id);
            System.out.println(isd);
            System.out.println(isd.getInstructor());
            tx.commit();
        } catch (Exception ex) {

            ex.printStackTrace();
        } finally {
            ses.close();
            ses.getSessionFactory().close();

        }

    }

    public void DeleteFromInstructorDetailToInstructor() {
        Session ses = getSession();
        try {
            int id = 5;

            Transaction tx = ses.getTransaction();
            tx.begin();
            InstructorDetail isd = ses.get(InstructorDetail.class, id);
            isd.getInstructor().setInstructorDetail(null);
            ses.delete(isd);
            tx.commit();
        } catch (Exception ex) {

            ex.printStackTrace();
        } finally {
            ses.close();
            ses.getSessionFactory().close();

        }

    }

    public void onetoMany1() {
        Session sess = getSession(Arrays.asList(Instructor.class, InstructorDetail.class, Course.class));
        //   Session sess = getSession();
        try {
            Transaction tx = sess.getTransaction();
            tx.begin();
            Instructor tempInstructor =
                    new Instructor("ray", "chung", "darby@luv2code.com");

            InstructorDetail tempInstructorDetail =
                    new InstructorDetail(
                            "http://www.luv2code.com/youtube",
                            "Luv 22 game!!!");
            Course c = new Course("tt1");
            tempInstructor.add(c);
            c.setInstructor(tempInstructor);

            tempInstructor.setInstructorDetail(tempInstructorDetail);
            sess.save(tempInstructor);
            // sess.save(tempInstructorDetail);
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            sess.close();
            sess.getSessionFactory().close();
        }
    }

    public void onetoMany2() {
        Session sess = getSession(Arrays.asList(Instructor.class, InstructorDetail.class, Course.class));
        //   Session sess = getSession();
        try {
            Transaction tx = sess.getTransaction();
            sess.beginTransaction();
            Instructor tempInstructor = sess.get(Instructor.class, 5);
            tempInstructor.add(new Course("111"));
            tempInstructor.add(new Course("222"));

            sess.save(tempInstructor);
            // sess.save(tempInstructorDetail);
            sess.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            sess.close();
            sess.getSessionFactory().close();
        }
    }

    public void onetoMany3() {
        Session sess = getSession(Arrays.asList(Instructor.class, InstructorDetail.class, Course.class));
        //   Session sess = getSession();
        try {
            Transaction tx = sess.getTransaction();
            sess.beginTransaction();
            Instructor tempInstructor =
                    new Instructor("rayx", "chungx", "darby@luv2code.com");

            InstructorDetail tempInstructorDetail =
                    new InstructorDetail(
                            "http://www.icando.com/youtubex",
                            "Luv 22 game!!!");
            tempInstructor.setInstructorDetail(tempInstructorDetail);
            tempInstructor.add(new Course("111"));
            tempInstructor.add(new Course("222"));

            sess.save(tempInstructor);
            // sess.save(tempInstructorDetail);
            sess.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            sess.close();
            sess.getSessionFactory().close();
        }
    }

    public void onetoManyGetCourse() {
        Session sess = getSession(Arrays.asList(Instructor.class, InstructorDetail.class, Course.class));
        //   Session sess = getSession();
        try {
            Transaction tx = sess.getTransaction();
            sess.beginTransaction();
            Instructor ist = sess.get(Instructor.class, 8);
            System.out.println("Courses:" + ist.getCourses());
            // sess.save(tempInstructorDetail);
            sess.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            sess.close();
            sess.getSessionFactory().close();
        }
    }

    public void onetoManyDelCourse() {
        Session sess = getSession(Arrays.asList(Instructor.class, InstructorDetail.class, Course.class));
        //   Session sess = getSession();
        try {
            Transaction tx = sess.getTransaction();
            sess.beginTransaction();
            //    Instructor ist = sess.get(Instructor.class, 8);
            //  sess.delete(ist.getCourses().stream().filter((x) -> x.getId() == 5).findFirst() );

            Course c = sess.get(Course.class, 5);
            System.out.println("course:" + c);
            sess.delete(c);

            // sess.save(tempInstructorDetail);
            sess.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            sess.close();
            sess.getSessionFactory().close();
        }
    }

    public void oneToManyLazy() {
        Session sess = getSession(Arrays.asList(Instructor.class, InstructorDetail.class, Course.class));
        //   Session sess = getSession();
        try {
            Transaction tx = sess.getTransaction();
            sess.beginTransaction();
            //    Instructor ist = sess.get(Instructor.class, 8);
            //  sess.delete(ist.getCourses().stream().filter((x) -> x.getId() == 5).findFirst() );
            Instructor i = sess.get(Instructor.class, 7);
            System.out.println("Ray instructor:" + i);

            System.out.println("course:" + i.getCourses());


            // sess.save(tempInstructorDetail);
            sess.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            sess.close();
            sess.getSessionFactory().close();
        }
    }

    public void tryLazyLoadingHQL() {
        Session sess = getSession(Arrays.asList(Instructor.class, InstructorDetail.class, Course.class, Review.class));
        //   Session sess = getSession();
        try {
            Transaction tx = sess.getTransaction();
            sess.beginTransaction();
            //    Instructor ist = sess.get(Instructor.class, 8);
            //  sess.delete(ist.getCourses().stream().filter((x) -> x.getId() == 5).findFirst() );
            Query<Instructor> q = sess.createQuery("select i from Instructor  i join fetch i.courses  "
                    + "c where i.id = :theinstructorid  ", Instructor.class);

            q.setParameter("theinstructorid", 7);
            Instructor ist = q.getSingleResult();
            // sess.save(tempInstructorDetail);
            System.out.println("instructor:" + ist);
            System.out.println("Courses:" + ist.getCourses());
            sess.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            sess.close();
            sess.getSessionFactory().close();
        }
    }

    public void testUniDirectional() {
        Session sess = getSession(Arrays.asList(Instructor.class, InstructorDetail.class, Course.class, Review.class));
        //   Session sess = getSession();
        int courseid = 4;

        try {
            Transaction tx = sess.getTransaction();
            sess.beginTransaction();
            Course c = sess.get(Course.class, courseid);
            System.out.println("course?" + c);
            c.addReview(new Review("good"));
            c.addReview(new Review("vgood"));
            sess.save(c);
            sess.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            sess.close();
            sess.getSessionFactory().close();
        }
    }

    public void testUniDirectiona2() {
        Session sess = getSession(Arrays.asList(Instructor.class, InstructorDetail.class, Course.class, Review.class));
        //   Session sess = getSession();
        int courseid = 4;

        try {
            Transaction tx = sess.getTransaction();
            sess.beginTransaction();
            Course c = sess.get(Course.class, courseid);
            System.out.println("course:" + c);
            System.out.println("reviews" + c.getReviews());

            sess.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            sess.close();
            sess.getSessionFactory().close();
        }
    }

    public void testUniDirectionaDelete() {
        Session sess = getSession(Arrays.asList(Instructor.class, InstructorDetail.class, Course.class, Review.class));
        //   Session sess = getSession();
        int courseid = 4;

        try {
            Transaction tx = sess.getTransaction();
            sess.beginTransaction();
            Course c = sess.get(Course.class, courseid);
            sess.delete(c);
            System.out.println("course deleted");
            sess.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            sess.close();
            sess.getSessionFactory().close();
        }
    }

    public void testManyToMany() {
        Session sess = getSession(Arrays.asList(Instructor.class, InstructorDetail.class, Course.class, Review.class, Student.class));
        //   Session sess = getSession();
        int courseid = 3;

        try {
            Transaction tx = sess.getTransaction();
            sess.beginTransaction();
            Course c = new Course("Hibernate course");
            sess.save(c);
            Student stu1 = new Student("peter first name", "peter name", "3@com");
            Student stu2 = new Student("paul first name", "pau name", "4@com");
            Student stu3 = new Student("mary first name", "mary name", "5@com");
            c.addStudent(stu1);
            c.addStudent(stu2);
            c.addStudent(stu3);

            sess.save(stu1);
            sess.save(stu2);
            sess.save(stu3);


            System.out.println("Saving Students");


            sess.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            sess.close();
            sess.getSessionFactory().close();
        }
    }

    public void testManyToMany2() {
        Session sess = getSession(Arrays.asList(Instructor.class, InstructorDetail.class, Course.class, Review.class, Student.class));
        //   Session sess = getSession();
        int courseid = 3;

        try {
            Transaction tx = sess.getTransaction();
            sess.beginTransaction();
            Course c = sess.get(Course.class, 11);
            Student stu = sess.get(Student.class, 3015);//mary
            System.out.println("student mary?:" + stu);
            System.out.println("Mary's courses?" + stu.getCourses());
            Course cr = new Course("Rubik's cube");
            Course cr2 = new Course("Chess");
            cr.addStudent(stu);
            cr2.addStudent(stu);
            sess.save(cr);
            sess.save(cr2);

            sess.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            sess.close();
            sess.getSessionFactory().close();
        }
    }

    public void testManyToManyRead() {
        Session sess = getSession(Arrays.asList(Instructor.class, InstructorDetail.class, Course.class, Review.class, Student.class));
        //   Session sess = getSession();
        int courseid = 3;

        try {
            Transaction tx = sess.getTransaction();
            sess.beginTransaction();
            //  Course c = sess.get(Course.class, 11);
            Student mary = sess.get(Student.class, 3015);//mary
            System.out.println("student:" + mary);
            System.out.println("courses:" + mary.getCourses());

            sess.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            sess.close();
            sess.getSessionFactory().close();
        }
    }

    public void testManyToManyDelete() {
        Session sess = getSession(Arrays.asList(Instructor.class, InstructorDetail.class, Course.class, Review.class, Student.class));
        //   Session sess = getSession();
        int courseid = 3;

        try {
            Transaction tx = sess.getTransaction();
            sess.beginTransaction();
            Course c = sess.get(Course.class, 11);
            //       Student mary = sess.get(Student.class, 3015);//mary
            //  System.out.println("student:" + mary);
            // System.out.println("courses:" + mary.getCourses());
            System.out.println("Delete course:" + c);
            sess.delete(c);
            sess.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            sess.close();
            sess.getSessionFactory().close();
        }
    }

    public void testManyToManyDeleteSudent() {
        Session sess = getSession(Arrays.asList(Instructor.class, InstructorDetail.class, Course.class, Review.class, Student.class));
        //   Session sess = getSession();
        int courseid = 3;

        try {
            Transaction tx = sess.getTransaction();
            sess.beginTransaction();
            int studentid = 3015;

            Student mary = sess.get(Student.class, 3015);//mary
            System.out.println("student:" + mary);
            System.out.println("courses:" + mary.getCourses());

            sess.delete(mary );
            sess.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            sess.close();
            sess.getSessionFactory().close();
        }
    }
}

