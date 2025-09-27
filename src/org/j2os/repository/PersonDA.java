package org.j2os.repository;

import org.j2os.common.JDBC;
import org.j2os.entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDA implements AutoCloseable{
    private Connection connection;
    private PreparedStatement preparedStatement;

    public PersonDA() throws SQLException {
        this.connection = JDBC.getConnection();
    }

    public void insert(Person person) throws SQLException {
        preparedStatement = connection.prepareStatement("select person_seq.nextval id from dual");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        person.setId(resultSet.getLong("id"));

        preparedStatement = connection.prepareStatement("insert into person (id, name, family) values (?,?,?)");
        preparedStatement.setLong(1, person.getId());
        preparedStatement.setString(2, person.getName());
        preparedStatement.setString(3, person.getFamily());

        preparedStatement.executeUpdate();
    }

    public void update(Person person) throws  Exception{
        preparedStatement = connection.prepareStatement("update person set name=?, family = ? where id = ?");
        preparedStatement.setString(1, person.getName());
        preparedStatement.setString(2, person.getFamily());
        preparedStatement.setLong(3, person.getId());

        preparedStatement.executeUpdate();
    }

    public void delete(Person person) throws Exception {
        preparedStatement = connection.prepareStatement("delete person where id = ?");
        preparedStatement.setLong(1, person.getId());

        preparedStatement.executeUpdate();
    }

    public List<Person> selectAll() throws Exception {
        preparedStatement = connection.prepareStatement("select * from person");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Person> list = new ArrayList<>();
        while ((resultSet.next())) {
            Person person = new Person().setId(resultSet.getLong("id")).setName(resultSet.getString("name")).setFamily(resultSet.getString("family"));
            list.add(person);
        }

        return  list;
    }


    public void commit() throws Exception {
        connection.commit();
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
