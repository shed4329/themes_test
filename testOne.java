import javafx.application.Application;
import javafx.application.HostServices;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;

import java.util.concurrent.atomic.AtomicBoolean;


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

            AtomicBoolean everAbout= new AtomicBoolean(false);
            AtomicBoolean everThank= new AtomicBoolean(false);
            aboutOneZip.setOnAction(actionEvent1 -> {
                VBox vBox2 = new VBox();
                vBox2.getChildren().clear();
                aboutOneZip.setStyle("-fx-background-color:#afd0ec");
                thanks.setStyle("-fx-background-color:transparent");
                ImageView imageView1 = new ImageView("img/zip.png");
                Text text2 = new Text("Project OneZip");
                text2.setFont(Font.font("Microsoft YaHei",22));
                Button githubLink = new Button("see it on Github",new ImageView("img/github.png"));
                vBox2.getChildren().addAll(imageView1, text2, githubLink);
                vBox2.setAlignment(Pos.TOP_CENTER);
                if (everAbout.get()||everThank.get()) {
                    anchorPane.getChildren().remove(1);
                }
                anchorPane.getChildren().add(vBox2);

                vBox2.setLayoutX(125);
                vBox2.prefWidthProperty().bind(anchorPane.widthProperty().subtract(125));
                everAbout.set(true);
                githubLink.setOnAction(actionEvent2 -> {
                    HostServices host = getHostServices();
                    host.showDocument("https://github.com/shed4329/onezip_test");
                });
            });
            thanks.setOnAction(actionEvent1 -> {
                aboutOneZip.setStyle("-fx-background-color:transparent");
                thanks.setStyle("-fx-background-color:#afd0ec");
                VBox vBox2 = new VBox();
                vBox2.setLayoutX(125);
                vBox2.prefWidthProperty().bind(anchorPane.widthProperty().subtract(125));
                if (everThank.get()||everAbout.get()) {
                    anchorPane.getChildren().remove(1);
                }
                anchorPane.getChildren().add(vBox2);

                Hyperlink hyperlink1 = new Hyperlink("Zip4j - a java library for zip files");
                Hyperlink hyperlink2 = new Hyperlink("Welcome to 7-Zip-JBinding project");
                Hyperlink hyperlink3 = new Hyperlink("JavaFX中文官方网站");
                Hyperlink hyperlink4 = new Hyperlink("JavaFX");
                Hyperlink hyperlink5 = new Hyperlink("JMetro-A modern theme for JavaFX applications with light and dark style");
                Hyperlink hyperlink6 = new Hyperlink("unrar5-A uncompress and compress tool(unCompress rar,rar5,zip)");
                Hyperlink hyperlink7 = new Hyperlink("IntelliJ IDEA");
                vBox2.getChildren().addAll(hyperlink1,hyperlink2,hyperlink3,hyperlink4,hyperlink5,hyperlink6,hyperlink7);
                hyperlink1.setOnAction(actionEvent2 -> {
                    HostServices host = getHostServices();
                    host.showDocument("http://www.lingala.net/zip4j.html");
                });
                hyperlink2.setOnAction(actionEvent2 -> {
                    HostServices host = getHostServices();
                    host.showDocument("http://sevenzipjbind.sourceforge.net");
                });
                hyperlink3.setOnAction(actionEvent2 -> {
                    HostServices host = getHostServices();
                    host.showDocument("https://openjfx.cn");
                });
                hyperlink4.setOnAction(actionEvent2 -> {
                    HostServices host = getHostServices();
                    host.showDocument("https://openjfx.io");
                });
                hyperlink5.setOnAction(actionEvent2 -> {
                    HostServices host = getHostServices();
                    host.showDocument("https://pixelduke.com/java-javafx-theme-jmetro/");
                });
                hyperlink6.setOnAction(actionEvent2 -> {
                    HostServices host = getHostServices();
                    host.showDocument("https://github.com/sucat1997/unrar5#a-uncompress-and-compress-tooluncompress-rarrar5zip");
                });
                hyperlink7.setOnAction(actionEvent2 -> {
                    HostServices host = getHostServices();
                    host.showDocument("https://www.jetbrains.com/idea/");
                });
            });
            home.setOnAction(actionEvent1 -> {
                anchorPane.getChildren().clear();
                anchorPane.getChildren().add(vBox);
                stage.setOpacity(1);
            });
        });
        buttonLanguage.setOnAction(actionEvent -> {
            anchorPane.getChildren().clear();
            VBox vBox1 = new VBox();
            Button home = new Button("主页            ");
            home.setStyle("-fx-background-color:transparent");
            Text text1 = new Text("\n语言");
            text1.setFont(Font.font("Microsoft YaHei",18));
            Button setYourLanguage = new Button("设置语言");
            setYourLanguage.setStyle("-fx-background-color:transparent");
            vBox1.getChildren().addAll(home,text1,setYourLanguage);
            anchorPane.getChildren().addAll(vBox1);
            stage.setOpacity(0.85);
            setYourLanguage.setOnAction(actionEvent1 -> {
                setYourLanguage.setStyle("-fx-background-color:#afd0ec");
                VBox vBox2 = new VBox();
                vBox2.setLayoutX(125);
                vBox2.prefWidthProperty().bind(anchorPane.widthProperty().subtract(125));
                Text text2 = new Text("设置应用内语言");
                ChoiceBox choiceBox = new ChoiceBox(FXCollections.observableArrayList("简体中文", "繁體中文", "English"));
                vBox2.getChildren().addAll(text2,choiceBox);
                anchorPane.getChildren().add(vBox2);
            });
            home.setOnAction(actionEvent1 -> {
                anchorPane.getChildren().clear();
                anchorPane.getChildren().add(vBox);
                stage.setOpacity(1);
            });
        });
        buttonPersonalize.setOnAction(actionEvent -> {
            anchorPane.getChildren().clear();
            VBox vBox1 = new VBox();
            Button home = new Button("主页            ");
            home.setStyle("-fx-background-color:transparent");
            Text text1 = new Text("\n个性化");
            text1.setFont(Font.font("Microsoft YaHei",18));
            Button setYourBackground = new Button("设置背景");
            setYourBackground.setStyle("-fx-background-color:transparent");
            Button setYourUIMode = new Button("设置UI风格");
            setYourUIMode.setStyle("-fx-background-color:transparent");
            vBox1.getChildren().addAll(home,text1,setYourBackground,setYourUIMode);
            anchorPane.getChildren().addAll(vBox1);
            stage.setOpacity(0.85);
            setYourUIMode.setOnAction(actionEvent1 -> {
                setYourUIMode.setStyle("-fx-background-color:#afd0ec");
                Text text2 = new Text("设置UI启动模式");
                ChoiceBox choiceBox = new ChoiceBox(FXCollections.observableArrayList("JavaFX","Swing"));
                Text text3 = new Text("设置UI主题");
                ChoiceBox choiceBox2 = new ChoiceBox();
                VBox vBox2 = new VBox();
                vBox2.setLayoutX(125);
                vBox2.prefWidthProperty().bind(anchorPane.widthProperty().subtract(125));
                vBox2.getChildren().addAll(text2,choiceBox,text3,choiceBox2);
                anchorPane.getChildren().add(vBox2);
                choiceBox.getSelectionModel().selectedIndexProperty().addListener((observableValue, number, t1) -> {
                    String str = t1.toString();
                    System.out.println(str);
                    if (str.equals("0")){
                        choiceBox2.setItems(FXCollections.observableArrayList("normal","fluent","simple"));
                    }else {
                        choiceBox2.setItems(FXCollections.observableArrayList("metal","radius","system","color"));
                    }
                });
            });
            home.setOnAction(actionEvent1 -> {
                anchorPane.getChildren().clear();
                anchorPane.getChildren().add(vBox);
                stage.setOpacity(1);
            });
        });

    }
}
