package library.student.list;

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
import jdk.nashorn.internal.ir.WhileNode;
import library.Main;
import library.entities.Student;
import library.helper.Connector;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class StudentListController implements Initializable {
    public TableView<Student> tbStudents;
    public TableColumn<Student, Integer> tdId;
    public TableColumn<Student, String> tdName;
    public TableColumn<Student,String> tdEmail;
    public TableColumn<Student,String> tdTel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tdId.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
        tdName.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
        tdEmail.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));
        tdTel.setCellValueFactory(new PropertyValueFactory<Student, String>("tel"));

        ObservableList<Student> ls = FXCollections.observableArrayList();

        try {
            String sql_txt = "select * from students";
            Connector conn = Connector.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String tel = rs.getString("tel");
                Student s = new Student(id, name, email,tel);
                ls.add(s);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            tbStudents.setItems(ls);
        }
    }

    public void createNewStudent(ActionEvent actionEvent)  throws Exception{
        Parent listStudent = FXMLLoader.load(getClass().getResource("../create/create.fxml.fxml"));
        Main.rootStage.setTitle("Students");
        Main.rootStage.setScene(new Scene(listStudent,800,600));
    }
}
