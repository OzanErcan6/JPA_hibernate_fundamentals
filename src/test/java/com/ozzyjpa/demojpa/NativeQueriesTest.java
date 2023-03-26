package com.ozzyjpa.demojpa;

import com.ozzyjpa.demojpa.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Queue;


@SpringBootTest
public class NativeQueriesTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    @Test
    void native_query_basic() {
        List resultList = entityManager.createNativeQuery("SELECT * FROM COURSE where is_deleted = false", Course.class).getResultList();
        logger.info("result list {}", resultList.get(0).toString());
    }

    @Test
    void native_query_with_parameter_basic() {
        Query query = entityManager.createNativeQuery("SELECT * FROM COURSE where id = :id", Course.class);
        query.setParameter("id",10);
        List resultList = query.getResultList();
        logger.info("result list {}", resultList.get(0).toString());
    }

    @Test
    @Transactional
    void native_query_to_update() {
        Query query = entityManager.createNativeQuery("update COURSE set last_updated = CURRENT_TIMESTAMP", Course.class);
        int numOfRowsUpdated = query.executeUpdate();
        logger.info("result list {}", numOfRowsUpdated);
    }
}
