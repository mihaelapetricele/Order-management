package ro.tuc.tp.presentation;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Class that contain the method for obtain the JTable for the elements of the tables
 * @author Petricele Mihaela
 */
public class TableView {
    /**
     * Method that receive a list of objects and use reflection techniques to generate the header
     * and populates the table with the values of the elements from the list
     * @param object list of object
     * @param <T> generic type T
     * @return the generated TableModel
     */
    public static <T> TableModel retrieveProperties(List<T> object) {
        int nr = 0;
        for (Object object1 : object) {
            nr = 0;
            for (Field ignored : object1.getClass().getDeclaredFields()) {
                nr++;
            }
        }
        Object[] columnNames = new Object[nr];
        Object[][] data = new Object[100][nr];
       try {
            for (int i = 0; i < object.size(); i++) {
                Object object1 = object.get(i);
                int counter = 0;
                for (Field field : object1.getClass().getDeclaredFields()) {
                    field.setAccessible(true);
                    Object value;
                    try {
                        columnNames[counter] = field.getName();
                        value = field.get(object1);
                        data[i][counter] = value;
                        counter++;
                    }catch (NullPointerException exception) {
                        exception.printStackTrace();
                    }
                    }
                }
            }catch(IllegalArgumentException | IllegalAccessException e){
                     e.printStackTrace();
         }
        TableModel tableModel = new DefaultTableModel(data, columnNames);
        return tableModel;
    }
}

