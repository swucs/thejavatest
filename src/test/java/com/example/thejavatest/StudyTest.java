package com.example.thejavatest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;

import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(FindSlowTestExtension.class)  //선언적 확장팩?
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudyTest {

    int value = 1;

    @RegisterExtension
    static FindSlowTestExtension findSlowTestExtension =
            new FindSlowTestExtension(1000L);

    @Test
    @Order(1)
    @DisplayName("스터디만들기")
    @SlowTest
    void create() throws Exception  {
        Thread.sleep(1005L);
        System.out.println(value++);
        Study study = new Study();
        assertNotNull(study);
    }

}