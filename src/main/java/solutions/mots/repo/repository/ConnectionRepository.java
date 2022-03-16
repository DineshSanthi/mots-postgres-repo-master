package solutions.mots.repo.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zaxxer.hikari.HikariDataSource;

@Repository
public class ConnectionRepository {

private final EntityManager entityManager;

@Autowired
public ConnectionRepository(EntityManager entityManager, DataSource dataSource) {
    this.entityManager = entityManager;
}

public Connection getConnection() throws SQLException {
    Map<String, Object> properties = entityManager.getEntityManagerFactory().getProperties();
    HikariDataSource dataSource = (HikariDataSource) properties.get("javax.persistence.nonJtaDataSource");
    return dataSource.getConnection();
}
}