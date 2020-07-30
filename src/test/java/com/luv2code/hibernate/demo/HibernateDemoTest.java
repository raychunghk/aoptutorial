package com.luv2code.hibernate.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HibernateDemoTest {

    @Test
    void onetoManyDelCourse() {

    }

    HibernateDemo dm = new HibernateDemo();

    @Test
    void testUniDirectional() {
        dm.testUniDirectional();
    }

    @Test
    void testUniDirectionalRead() {
        dm.testUniDirectiona2();
    }

    @Test
    void testUniDirectionalDelete() {
        dm.testUniDirectionaDelete();
    }

    @Test
    void testManytoMany() {
        dm.testManyToMany();
    }

    @Test
    void testManytoMany2() {
        dm.testManyToMany2();
    }

    @Test
    void testManytoManyRead() {
        dm.testManyToManyRead();
    }
    @Test
    void testManyToManyDeleteSudent() {
        dm.testManyToManyDeleteSudent();
    }
    @Test
    void testManytoManyDelete() {
        dm.testManyToManyDelete();
    }
}