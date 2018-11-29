package sample.Java;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.lang.*;



public class glownaController implements Initializable{


    ObservableList<String> stanowiskoList = FXCollections.observableArrayList("Kierownik", "Magazyn", "Pakownia", "Wysylka");
    public ChoiceBox<String> stanowiskoBox = new ChoiceBox<String>();

    @FXML
    public TextField imie;
    @FXML
    public TextField nazwisko;
    @FXML
    public TextField m_zamieszkania;

    public void buttonRejestracja(ActionEvent actionEvent) throws SQLException {
        String imieGet = imie.getText();
        String nazwiskoGet = nazwisko.getText();
        String mZamieszkaniaGet = m_zamieszkania.getText();
        String stanowiskoGet = stanowiskoBox.getValue();
        /*System.out.println("Imie:" +imieGet);
        System.out.println("Nazwisko:" +nazwiskoGet);
        System.out.println("Miejsce Zamieszkania:" +mZamieszkaniaGet);
        System.out.println("Stanowisko: " + stanowiskoGet);*/

        //Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        String url = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=root";
        Connection conn = DriverManager.getConnection(url);


        String sql = "INSERT INTO pracownicy(imie, nazwisko, m_zamieszkania, stanowisko) VALUES (?, ?, ?, ?);";
        //Connection conn = Connect.Connect();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString (1, imieGet);
        pstmt.setString (2, nazwiskoGet);
        pstmt.setString (3, mZamieszkaniaGet);
        pstmt.setString(4, stanowiskoGet);
        pstmt.execute();

        conn.close();
    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //stanowiskoBox.setValue("Kierownik");
        stanowiskoBox.setItems(stanowiskoList);

    }
}
