package library.student.create;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import library.Main;
import library.helper.Connector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentCreateController {
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtTel;

    public void submit(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            String tel = txtTel.getText();
            String sql_txt = "insert into students(name,email,tel) values(?,?,?)";
            Connector conne = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(name);
            arr.add(email);
            arr.add(tel);
            if(conne.execute(sql_txt,arr)){
                backToList();
            }else {
                System.out.println("Error");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void backToList() throws Exception{
        Parent listBook = FXMLLoader.load(getClass().getResource("../list/list.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }
}
