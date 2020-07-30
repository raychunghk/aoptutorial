import com.luv2code.hibernate.demo.HibernateDemo;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class HibernateTest {

    @Test
    void testUppdateHQL() {
        HibernateDemo upd = getHibernateDemo();
        upd.updateHQL();
        Assert.assertTrue(1 == 1);
    }

    private HibernateDemo getHibernateDemo() {
        return new HibernateDemo();
    }

    @Test
    void testDelete() {
        HibernateDemo upd = getHibernateDemo();
        upd.Delete1();
        Assert.assertTrue(1 == 1);
    }

    @Test
    void testone2one1() {
        HibernateDemo upd = getHibernateDemo();
        upd.DoInstructorDetailRelation();
        Assert.assertTrue(1 == 1);
    }

    @Test
    void testDeleteFromInstructorDetailToInstructor() {
        HibernateDemo upd = getHibernateDemo();
        upd.DeleteFromInstructorDetailToInstructor();
        Assert.assertTrue(1 == 1);
    }

    @Test
    void testOneToMany() {
        HibernateDemo upd = getHibernateDemo();
        upd.onetoMany1();
        Assert.assertTrue(1 == 1);
    }

    @Test
    void testOneToMany2() {
        HibernateDemo upd = getHibernateDemo();
        upd.onetoMany2();
        Assert.assertTrue(1 == 1);
    }

    @Test
    void testOneToMany3() {
        HibernateDemo upd = getHibernateDemo();
        upd.onetoMany3();
        Assert.assertTrue(1 == 1);
    }

    @Test
    void testOneToManygetCourse() {
        HibernateDemo upd = getHibernateDemo();
        upd.onetoManyGetCourse();
        Assert.assertTrue(1 == 1);
    }

    @Test
    void testOneToManyDelCourse() {
        HibernateDemo upd = getHibernateDemo();
        upd.onetoManyDelCourse();
        Assert.assertTrue(1 == 1);
    }

    @Test
    void testOneToManyLazyCourse() {
        HibernateDemo upd = getHibernateDemo();
        upd.oneToManyLazy();
        Assert.assertTrue(1 == 1);
    }

    @Test
    void testLazyLoadingHQL() {
        HibernateDemo upd = getHibernateDemo();
        upd.tryLazyLoadingHQL();
        Assert.assertTrue(1 == 1);
    }
}
