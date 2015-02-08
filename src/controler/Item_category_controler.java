/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.DBConnection;
import model.DBHandel;
import model.add_item_category_model;

/**
 *
 * @author Kasun
 */
public class Item_category_controler {

    public static void addItemCategory(add_item_category_model c) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "INSERT INTO item_catagery  VALUES ('" + c.getId() + "','" + c.getType() + "','" + c.getDescription() + "')";
            int res = DBHandel.setData(con, query);

            if (res != 0) {
                JOptionPane.showMessageDialog(null, "Category added successfully");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Adding Fail");
            e.printStackTrace();
        }
    }

    public static ArrayList<add_item_category_model> getItemCatageryByType(String Name) throws ClassNotFoundException, SQLException, Exception {
        String qry = "Select * from item_catagery where type LIKE '%" + Name + "%'";
        Connection con = DBConnection.getConnection();
        ResultSet rst = DBHandel.getData(con, qry);
        ArrayList<add_item_category_model> ar = new ArrayList<add_item_category_model>();
        while (rst.next()) {
            String code = rst.getString(1);
            String type = rst.getString(2);
            String discription = rst.getString(3);

            add_item_category_model i = new add_item_category_model(code, type, discription);
            ar.add(i);

        }
        return ar;
    }

    public static ArrayList<add_item_category_model> getItemCatageryByID(String Name) throws ClassNotFoundException, SQLException, Exception {
        String qry = "Select * from item_catagery where cat_id LIKE '%" + Name + "%'";
        Connection con = DBConnection.getConnection();
        ResultSet rst = DBHandel.getData(con, qry);
        ArrayList<add_item_category_model> ar = new ArrayList<add_item_category_model>();
        while (rst.next()) {
            String code = rst.getString(1);
            String type = rst.getString(2);
            String discription = rst.getString(3);

            add_item_category_model i = new add_item_category_model(code, type, discription);
            ar.add(i);

        }
        return ar;
    }

    public static void updateItemCategory(add_item_category_model i) throws ClassNotFoundException, SQLException {

        try {
            Connection con = DBConnection.getConnection();
            String qry = "UPDATE item_catagery set type='" + i.getType() + "',description='" + i.getDescription() + "' where cat_id='" + i.getId() + "'";
            int res = DBHandel.setData(con, qry);
            if (res != 0) {
                JOptionPane.showMessageDialog(null, "Update Category OK");
            } else {
                JOptionPane.showMessageDialog(null, "Update Error");
            }
        } catch (Exception e) {

            System.out.println(e);
        }
    }

    public static void deleteItemCategory(add_item_category_model c) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "DELETE FROM item_catagery   WHERE cat_id='" + c.getId() + "'";
            int res = DBHandel.setData(con, query);
            if (res != 0) {
                JOptionPane.showMessageDialog(null, "Delete category successfuly");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No category to delete");
        }
    }
}
