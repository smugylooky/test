package com.confirming.test.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.confirming.test.util.Constants;

public class ProveedorService  {
	
	public void setUpConnection(String idCliente) {
		try {
            Connection connection = DriverManager.getConnection(
                    Constants.MYSQL_ROUTE, Constants.MYSQL_USERNAME, ""
            );
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Proveedores WHERE id_cliente = '".concat(idCliente).concat("'"));
            if(resultSet.next()) {
            	writeProveedoresList(idCliente, resultSet);
            } else {
            	System.out.println("No hay resultados");
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
	}

	private void writeProveedoresList(String idCliente, ResultSet resultSet) throws SQLException {
		 try {
		      FileWriter myWriter = new FileWriter("C:\\TestEjercicio\\proveedores_cliente_" + idCliente +".txt");
		      myWriter.write("Proveedores para cliente con id: " + idCliente + "\n");
		      myWriter.write("Id proveedor | Nombre | Fecha de alta | \n");
		      myWriter.write(getRowInString(resultSet));
		      while (resultSet.next()) {
		    	  myWriter.write(getRowInString(resultSet));
		      }
		      myWriter.close();
		      System.out.println("Fichero creado con éxito");
		    } catch (IOException e) {
		      System.out.println("Ha habido un error.");
		      e.printStackTrace();
		    }
	}
	
	private String getRowInString(ResultSet p) throws SQLException {
		return new StringBuilder().append(p.getString(1)).append(Constants.SEPARATOR)
				.append(p.getString(2)).append(Constants.SEPARATOR)
				.append(p.getString(3).toString()).append(Constants.SEPARATOR).append("\n")
				.toString();
	}
}
