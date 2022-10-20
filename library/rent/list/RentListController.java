package library.rent.list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import library.Main;
import library.entities.Book;
import library.entities.Rent;
import library.helper.Connector;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class RentListController implements Initializable {
    public TableView<Rent> tbRents;
    public TableColumn<Rent,Integer> tdId;
    public TableColumn<Rent,String> tdBook;
    public TableColumn<Rent,String> tdStudent;
    public TableColumn<Rent,String> tdNgayMuon;
    public TableColumn<Rent,String> tdNgayTra;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tdId.setCellValueFactory(new PropertyValueFactory<Rent,Integer>("id"));
        tdBook.setCellValueFactory(new PropertyValueFactory<Rent,String>("sach"));
        tdStudent.setCellValueFactory(new PropertyValueFactory<Rent,String>("sinhvien"));
        tdNgayMuon.setCellValueFactory(new PropertyValueFactory<Rent,String>("ngaymuon"));
        tdNgayTra.setCellValueFactory(new PropertyValueFactory<Rent,String>("ngyatra"));

        ObservableList<Rent> ls = FXCollections.observableArrayList();

        // lay data from database
        try {
            String sql_txt = "select * from rents";
            Connector conn = Connector.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()){
                int id = rs.getInt("id");
                String book = rs.getString("sach");
                String student = rs.getString("sinhvien");
                String ngayMuon = rs.getString("ngaymuon");
                String ngayTra = rs.getString("ngaytra");

                Rent r = new Rent(id,book,student,ngayMuon,ngayTra);
                ls.add(r);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            tbRents.setItems(ls);
        }

    }

    public void createNewBook(ActionEvent actionEvent)  throws Exception{
        Parent listBook = FXMLLoader.load(getClass().getResource("../create/create.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }
}
