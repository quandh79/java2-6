package library.book.create;

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

public class BookCreateController {
    public TextField txtName;
    public TextField txtAuthor;
    public TextField txtQty;

    public void submit(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String author = txtAuthor.getText();
            Integer qty = Integer.parseInt(txtQty.getText());
            String sql_txt = "insert into books(name,author,qty) values(?,?,?)";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(name);
            arr.add(author);
            arr.add(qty);
            if(conn.execute(sql_txt,arr)){
                backToList();
            }else {
                System.out.println("Error");
            }

//            String sql_txt2 = "select * from books where id = ?";
//            ArrayList pr = new ArrayList();
//            pr.add(1);
//            ResultSet bookwithid1 = conn.executeQuery(sql_txt2,pr);
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
