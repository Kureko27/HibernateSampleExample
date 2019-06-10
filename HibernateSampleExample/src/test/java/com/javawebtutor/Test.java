package com.javawebtutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.Date;
import javafx.application.Application;
//import static javafx.application.Application.launch;

//import org.hibernate.Session;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



public class Test extends Application {
	@Override
	 public void start(Stage stage){

		GridPane okno = new GridPane(); //layout of application is a grid format
		
		Label login = new Label("Login: ");
		okno.add(login,0,0,1,1);
		
		Label password = new Label("Password: ");
		okno.add(password,0,1,1,1);
		
		Label bd = new Label("Baza Danych: ");
		okno.add(bd,0,2,1,1);
		
		TextField loginField = new TextField();
		loginField.setMaxWidth(200);
		okno.add(loginField,1,0,1,1);
		
		PasswordField passField = new PasswordField(); //hides the password as ****
		passField.setMaxWidth(200);
		okno.add(passField,1,1,1,1);
		
		TextField bdField = new TextField();
		bdField.setMaxWidth(200);
		okno.add(bdField,1,2,1,1);
		
		Button polacz = new Button("Połącz"); //button który łączy się z bazą
		okno.add(polacz,1,3,1,1);//dodaje przycisk do applikacji 
		//(obiekt, kolumna, wiersz, ile zajmuje kolumn, ile zajmuje wierszy)
		
		Label wynik=new Label("Połączono z Bazą Danych");
		Label error=new Label("Błąd połączenia z bazą danych");
		Label errorSterownik =new Label("Brak Połączenia ze sterownikiem");
		
		polacz.setOnAction(e->
		{
			okno.getChildren().remove(wynik);
			okno.getChildren().remove(error);
			okno.getChildren().remove(errorSterownik);
			
			Label loginWynik = new Label();
			loginWynik.setText(loginField.getText());
			String login1 =loginWynik.getText();
			
			Label passWynik = new Label();
			passWynik.setText(passField.getText());
			String password1 = passWynik.getText();
			
			Label bdWynik = new Label();
			bdWynik.setText(bdField.getText());
			String bd1 = bdWynik.getText();
			
			Connection con;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection("jdbc:sqlserver://"+ 
				"153.19.7.13:1401;"	+
				"databaseName="+bd1+";"+ //zkulesza
				"user="+login1+";"+		//zkulesza
				"password="+password1+";");	//250992
				
				//Example of showing all data in a single table 
				//need to implement visuals
				Statement zapytanie = con.createStatement();
				String sql="select count(*) from adres";
				ResultSet wynik_zapytania =zapytanie.executeQuery(sql);
				ResultSetMetaData wynik2 = wynik_zapytania.getMetaData();
				int ile_kolumn = wynik2.getColumnCount();
				wynik_zapytania.next();
				
				
				while(wynik_zapytania.next()) {
					for(int i=1;i<=ile_kolumn;i++) {
						System.out.print(wynik_zapytania.getString(i)+"-");
					}
					System.out.println("<koniec>");
				}
				//--------ends here
				okno.add(wynik,1,4,1,1);
				con.close();
			}
			catch(SQLException error_polaczenie) {
				okno.add(error,1,4,1,1);
			}
			catch(ClassNotFoundException error_sterownik) {
				okno.add(errorSterownik,1,4,1,1);
			}
		}
		);
		
		
		Scene scena = new Scene(okno, 400, 300);
		stage.setTitle("Baza Danych");
		stage.setScene(scena);
		stage.show();
		}
	
	
    public static void main(String[] args) {
    	
    	launch(args);
    	
        /*Session session = HibernateUtil.getSessionFactory().openSession();
 
        session.beginTransaction();
        Userr user = new Userr();
 
        user.setUserId(3);
        user.setUsername("Mukesh");
        user.setCreatedBy("Google");
        user.setCreatedDate(new Date());
 
        session.save(user);
        session.getTransaction().commit();*/
 
    }
 
}