package fxml;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class SettingHome {
    @FXML
    Text text;
    public void FxmlController(){
    }

    @FXML
    private void initialize(){
        System.out.println(text.getText()); //打印按钮上的文本
    }
}
