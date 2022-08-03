import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;


public class testOne extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();

        VBox vBox = new VBox();
        Text text = new Text("OneZip设置");
        text.setFont(Font.font("Microsoft YaHei", FontWeight.LIGHT,20));
        TextField textField = new TextField();
        textField.setMaxWidth(330);


        vBox.setAlignment(Pos.TOP_CENTER);

        FlowPane flowPane = new FlowPane();


        Button buttonUniversal = new Button("通用\n压缩偏好设置，预览偏好设置    ");
        Image universalImg = new Image("img/universal.png");
        ImageView imageView = new ImageView(universalImg);
        //给按钮设置图标
        buttonUniversal.setGraphic(imageView);
        buttonUniversal.setStyle("-fx-background-color:#ffffff");

        Button buttonLanguage = new Button("语言\n简体中文，繁體中文，English   ");
        Image languageImg = new Image("img/language.png");
        ImageView imageView2 = new ImageView(languageImg);
        //给按钮设置图标
        buttonLanguage.setGraphic(imageView2);
        buttonLanguage.setStyle("-fx-background-color:#ffffff");

        Button buttonPersonalize = new Button("个性化\n应用内鼠标偏好设置，背景设置");
        Image personalizeImg = new Image("img/personalize.png");
        ImageView imageView3 = new ImageView(personalizeImg);
        //给按钮设置图标
        buttonPersonalize.setGraphic(imageView3);
        buttonPersonalize.setStyle("-fx-background-color:#ffffff");
        Button buttonAbout = new Button("关于\n关于OneZip,鸣谢                      ");
        Image aboutImg = new Image("img/about.png");
        ImageView imageView4 = new ImageView(aboutImg);
        //给按钮设置图标
        buttonAbout.setGraphic(imageView4);
        buttonAbout.setStyle("-fx-background-color:#ffffff");


        flowPane.setAlignment(Pos.TOP_CENTER);
        flowPane.getChildren().addAll(buttonUniversal,buttonPersonalize,buttonLanguage,buttonAbout);



        vBox.getChildren().addAll(text,textField,flowPane);
        anchorPane.getChildren().add(vBox);
        vBox.prefWidthProperty().bind(anchorPane.widthProperty());
        Scene scene = new Scene(anchorPane);

        JMetro jMetro = new JMetro(Style.LIGHT);
        jMetro.setScene(scene);


        stage.setScene(scene);
        stage.initStyle(StageStyle.UNIFIED);
        stage.setWidth(750);
        stage.setHeight(400);
        stage.setTitle("设置");
        stage.getIcons().add(new Image("img/setting.png"));
        stage.show();
        buttonAbout.setOnAction(actionEvent -> {
            anchorPane.getChildren().clear();
            VBox vBox1 = new VBox();
            Button home = new Button("主页            ");
            home.setStyle("-fx-background-color:transparent");
            Text text1 = new Text("\n关于");
            text1.setFont(Font.font("Microsoft YaHei",18));
            Button aboutOneZip = new Button("关于OneZip");
            Button thanks = new Button("鸣谢            ");
            aboutOneZip.setStyle("-fx-background-color:transparent");
            thanks.setStyle("-fx-background-color:transparent");
            vBox1.getChildren().addAll(home,text1,aboutOneZip,thanks);
            anchorPane.getChildren().addAll(vBox1);
            stage.setOpacity(0.85);
            aboutOneZip.setOnAction(actionEvent1 -> {
                aboutOneZip.setStyle("-fx-background-color:#afd0ec");
                thanks.setStyle("-fx-background-color:transparent");
                VBox vBox2 = new VBox();
                ImageView imageView1 = new ImageView("img/zip.png");
                Text text2 = new Text("Project OneZip");
                vBox2.getChildren().addAll(imageView1,text2);
                vBox2.setAlignment(Pos.TOP_CENTER);
                anchorPane.getChildren().add(vBox2);
                vBox2.setLayoutX(125);
                vBox2.prefWidthProperty().bind(anchorPane.widthProperty().subtract(125));
            });
            thanks.setOnAction(actionEvent1 -> {
                aboutOneZip.setStyle("-fx-background-color:transparent");
                thanks.setStyle("-fx-background-color:#afd0ec");
            });
        });

    }
}
