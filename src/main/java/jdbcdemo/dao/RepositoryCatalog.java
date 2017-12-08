package jdbcdemo.dao;

import java.sql.Connection;
import java.sql.SQLException;

import jdbcdemo.dao.mappers.PersonResultMapper;
import jdbcdemo.domain.Person;

public class RepositoryCatalog {
    
	Connection connection;
	
	public RepositoryCatalog(Connection connection) {
		this.connection = connection;
	}

	public Repository<Person> people(){
		try {
			return new PersonRepository(connection, new PersonResultMapper());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
