package ro.tuc.tp.dao;


import ro.tuc.tp.connection.ConnectionFactory;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Generic class that defines the common operation for a database
 * @author Petricele Mihaela
 */

public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    protected Class<T> type;

    /**
     * Constructor that obtains the class of the generic type T
     */
    @SuppressWarnings("Uncheked!")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * Method that contains the Mysql SELECT query for a specific field
     * @param field from the WHERE clause
     * @return a Mysql query
     */
    private String createSelectQuery(String field) {
        String query = "";
        query = " SELECT " + " * " + " FROM " + type.getSimpleName() + " WHERE " + field + " =?";
        return query;
    }

    /**
     * Method that contains the Mysql SELECT query
     * @return a Mysql query
     */
    private String createSelectQueryAll() {
        String query = "";
        query = " SELECT * FROM " + type.getSimpleName();
        return query;
    }

    /**
     * Method that contains de Mysql DELETE query
     * @param field from the WHERE clause
     * @return a Mysql query
     */
    private String createDeleteQuery(String field) {
        String query = "";
        query = " DELETE FROM " + type.getSimpleName() + " WHERE " + field + "=?";
        return query;
    }

    /**
     * Method that with reflection technique obtain a list of object of type T by a given result set
     * @param resultSet obtained by performing a query
     * @return a list of objects of type T
     */

    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (Constructor constructor : ctors) {
            ctor = constructor;
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                assert ctor != null;
                ctor.setAccessible(true);
                T instance = (T)ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException | IllegalArgumentException | IllegalAccessException | InvocationTargetException | SecurityException | SQLException | IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Method that return a list of objects of type T for a specific id
     * @param id of the object
     * @return a list of objects
     */
    public T findById(int id) {
        Connection connection;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("id" + type.getSimpleName());
        connection = ConnectionFactory.getConnection();
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            resultSet = statement.executeQuery();
            return createObjects(resultSet).get(0);
        } catch (SQLException throwables) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:FindById" + throwables.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Method that return all the elements from the database for a specific object of type T
     * @return a list of objects of type T
     */
    public List<T> findAll() {
        Connection connection;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQueryAll();
        connection = ConnectionFactory.getConnection();
        try {
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            return createObjects(resultSet);
        } catch (SQLException throwables) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:FindAll" + throwables.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Method that insert a new row into the table
     * @param obj to be inserted
     * @return 1 if the row was inserted and 0 otherwise
     */
    public int insert(T obj) {
        Connection connection = null;
        PreparedStatement insertStatement = null;
        String query = "";
        query = "INSERT INTO " + type.getSimpleName() + " VALUES(";
        int insertedId = -1;
        int l = type.getDeclaredFields().length;
        for (int k = 0; k < l; k++) {
            if (k != l - 1) {
                query += "?,";
            } else {
                query += "?)";
            }
        }
        try {
            int nr = 1;
            connection = ConnectionFactory.getConnection();
            insertStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            for (Field field : obj.getClass().getDeclaredFields()) {
                PropertyDescriptor propertyeDescriptor = new PropertyDescriptor(field.getName(), type);
                Method method = propertyeDescriptor.getReadMethod();
                insertStatement.setObject(nr++, method.invoke(obj));
            }
            assert insertStatement != null; insertedId = insertStatement.executeUpdate();
        } catch (SQLException | IntrospectionException | IllegalAccessException | InvocationTargetException throwables) {
            LOGGER.log(Level.WARNING, "DAO:insert " + throwables.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);ConnectionFactory.close(connection);
        }
        return insertedId;
    }

    /**
     * Method that update a row which has a specific id into the table
     * @param obj to be updated
     * @param id of the object to be inserted
     * @return 1 if the row was updated and 0 otherwise
     */
    public int update(T obj, int id)
    {
        String query = "";
        query = " UPDATE " + type.getSimpleName() + " SET ";
        Connection connection = null;
        PreparedStatement updateStatement = null;
        int updateId = -1;
            try {
                connection = ConnectionFactory.getConnection();
                for(Field field : type.getDeclaredFields())
                {
                    field.setAccessible(true);
                    query += field.getName() + "='" + field.get(obj) + "',";
                }
                if(query.endsWith(",")) {

                    query= query.substring(0, query.length() - 1);
                }
                query += " WHERE id" + type.getSimpleName() + "=" + id;
                updateStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                updateId = updateStatement.executeUpdate();
            } catch (SQLException throwables) {
                LOGGER.log(Level.WARNING, "DAO:update " + throwables.getMessage());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } finally {
                ConnectionFactory.close(updateStatement);
                ConnectionFactory.close(connection);
            }
            return updateId;
    }

    /**
     * Method that delete a row from a table
     * @param id of the object that is delete
     * @return 1 if the row was deleted and 0 otherwise
     */
    public int delete(int id) {
        Connection connection;
        PreparedStatement statement = null;
        int resultSet;
        String query = createDeleteQuery("id" + type.getSimpleName());
        connection = ConnectionFactory.getConnection();
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            resultSet = statement.executeUpdate();
            return resultSet;
        } catch (SQLException throwables) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:Delete" + throwables.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return 0;
    }

}
