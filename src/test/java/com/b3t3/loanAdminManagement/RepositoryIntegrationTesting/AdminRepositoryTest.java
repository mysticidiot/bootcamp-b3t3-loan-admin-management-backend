package com.b3t3.loanAdminManagement.RepositoryIntegrationTesting;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.b3t3.loanAdminManagement.dao.Admin_dao;
import com.b3t3.loanAdminManagement.model.Admin;

@RunWith(SpringRunner.class)
@DataJpaTest
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class AdminRepositoryTest {
	
	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private Admin_dao repository;
	
	@Test
	public void whenFindByUserName_thenReturnAdmin() {
		Admin admin = new Admin("Shreayaas","12345");
        entityManager.persistAndFlush(admin);

        Admin found = repository.findById(admin.getUsername()).get();
        assertEquals(found.getUsername(), admin.getUsername());
    }

}
