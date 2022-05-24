package com.example.wargames;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Controller {


    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextArea armyEnemyView;

    @FXML
    private TextField typeEnemyDelete;

    @FXML
    private TextField noEnemyCreate;

    @FXML
    private TextField noEnemyDelete;

    @FXML
    private TextField typeEnemyCreate;

    @FXML
    private Button btnEnemyCreate;

    @FXML
    private TextField healthEnemyCreate;

    @FXML
    private TextArea armyView;

    @FXML
    private TextField nameEnemyCreate;

    @FXML
    private TextField nameEnemyDelete;

    @FXML
    private TextField healthEnemyDelete;

    @FXML
    private Button btnEnemyDelete;

    @FXML
    private Button btnNextBattle;

    @FXML
    private TextField typeDelete;

    @FXML
    private TextField noCreate;

    @FXML
    private TextField healthDelete;

    @FXML
    private Button btnDelete;

    @FXML
    private TextField typeCreate;

    @FXML
    private Button btnNext;

    @FXML
    private Button btnCreate;

    @FXML
    private TextField nameCreate;

    @FXML
    private TextField healthCreate;

    @FXML
    private TextField nameDelete;

    @FXML
    private TextField noDelete;

    @FXML
    private TextArea BattleView;

    @FXML
    private TextArea enemyArymyBattle;

    @FXML
    private TextArea myArmyBattle;


    @FXML
    void createUnit(ActionEvent event) {
        UnitFactory UnitRegister = new UnitFactory("UnitRegister");
        Army army = new Army("MyArmy");
        FileController checker = new FileController();


        String result = checker.readFile(army);
        String[] saved = result.split("\\s+");

        for(int i = 1; i < saved.length; i++){
            String laved = saved[i];
            String[] splitSave = laved.split(",");

            String stHealth = splitSave[2];
            int savedHealth = Integer.parseInt(stHealth);
            System.out.println(savedHealth);

            Unit nUnit = UnitRegister.createUnit(splitSave[0], splitSave[1], savedHealth);
            army.add(nUnit);
        }

        System.out.println(army.toString());


        String strHealth = healthCreate.getText();
        int health = Integer.parseInt(strHealth);

        String strNumber = noCreate.getText();
        int number = Integer.parseInt(strNumber);



        for(int i = 0; i < number; i++){
            Unit newUnit = UnitRegister.createUnit(typeCreate.getText(), nameCreate.getText(), health);
            army.add(newUnit);
        }

        FileController write = new FileController();
        write.writeFile(army);

        armyView.setText(army.toString());



    }

    @FXML
    void deleteUnit(ActionEvent event) {

        UnitFactory UnitRegister = new UnitFactory("UnitRegister");
        Army army = new Army("MyArmy");
        FileController checker = new FileController();


        String result = checker.readFile(army);
        String[] saved = result.split("\\s+");

        for(int i = 1; i < saved.length; i++){
            String laved = saved[i];
            String[] splitSave = laved.split(",");

            String stHealth = splitSave[2];
            int savedHealth = Integer.parseInt(stHealth);
            System.out.println(savedHealth);

            Unit nUnit = UnitRegister.createUnit(splitSave[0], splitSave[1], savedHealth);
            army.add(nUnit);
        }



        String strHealth = healthDelete.getText();
        int health = Integer.parseInt(strHealth);

        String strNumber = noDelete.getText();
        int number = Integer.parseInt(strNumber);


        List<Unit> unitList = UnitRegister.unitSearch(typeDelete.getText(), nameDelete.getText(), health);

        for(int i = 0; i < number; i++){
            army.remove(unitList.get(0));

        }

        FileController write = new FileController();
        write.writeFile(army);

        armyView.setText(army.toString());


    }

    @FXML
    void createEnemyUnit(ActionEvent event) {
        UnitFactory UnitRegister = new UnitFactory("UnitRegister");
        Army army = new Army("EnemyArmy");
        FileController checker = new FileController();


        String result = checker.readFile(army);
        String[] saved = result.split("\\s+");

        for(int i = 1; i < saved.length; i++){
            String laved = saved[i];
            String[] splitSave = laved.split(",");

            String stHealth = splitSave[2];
            int savedHealth = Integer.parseInt(stHealth);
            System.out.println(savedHealth);

            Unit nUnit = UnitRegister.createUnit(splitSave[0], splitSave[1], savedHealth);
            army.add(nUnit);
        }

        System.out.println(army.toString());


        String strHealth = healthEnemyCreate.getText();
        int health = Integer.parseInt(strHealth);

        String strNumber = noEnemyCreate.getText();
        int number = Integer.parseInt(strNumber);



        for(int i = 0; i < number; i++){
            Unit newUnit = UnitRegister.createUnit(typeEnemyCreate.getText(), nameEnemyCreate.getText(), health);
            army.add(newUnit);
        }

        FileController write = new FileController();
        write.writeFile(army);

        armyEnemyView.setText(army.toString());



    }

    @FXML
    void deleteEnemyUnit(ActionEvent event) {

        UnitFactory UnitRegister = new UnitFactory("UnitRegister");
        Army army = new Army("EnemyArmy");
        FileController checker = new FileController();


        String result = checker.readFile(army);
        String[] saved = result.split("\\s+");

        for(int i = 1; i < saved.length; i++){
            String laved = saved[i];
            String[] splitSave = laved.split(",");

            String stHealth = splitSave[2];
            int savedHealth = Integer.parseInt(stHealth);
            System.out.println(savedHealth);

            Unit nUnit = UnitRegister.createUnit(splitSave[0], splitSave[1], savedHealth);
            army.add(nUnit);
        }



        String strHealth = healthEnemyDelete.getText();
        int health = Integer.parseInt(strHealth);

        String strNumber = noEnemyDelete.getText();
        int number = Integer.parseInt(strNumber);

        List<Unit> unitList = UnitRegister.unitSearch(typeEnemyDelete.getText(), nameEnemyDelete.getText(), health);

        for(int i = 0; i < number; i++){
            army.remove(unitList.get(0));

        }

        FileController write = new FileController();
        write.writeFile(army);

        armyEnemyView.setText(army.toString());


    }

    @FXML
    void battleBegin(ActionEvent event) {
        UnitFactory UnitRegisterEnemy = new UnitFactory("UnitRegisterEnemy");
        Army enemyArmy = new Army("EnemyArmy");
        FileController checker = new FileController();


        String result = checker.readFile(enemyArmy);
        String[] saved = result.split("\\s+");

        for(int i = 1; i < saved.length; i++){
            String laved = saved[i];
            String[] splitSave = laved.split(",");

            String stHealth = splitSave[2];
            int savedHealth = Integer.parseInt(stHealth);
            System.out.println(savedHealth);

            Unit nUnit = UnitRegisterEnemy.createUnit(splitSave[0], splitSave[1], savedHealth);
            enemyArmy.add(nUnit);
        }

        UnitFactory UnitRegister = new UnitFactory("UnitRegister");
        Army army = new Army("MyArmy");
        FileController checkerMe = new FileController();


        String resultMe = checker.readFile(army);
        String[] savedMe = result.split("\\s+");

        for(int i = 1; i < saved.length; i++){
            String laved = savedMe[i];
            String[] splitSave = laved.split(",");

            String stHealth = splitSave[2];
            int savedHealth = Integer.parseInt(stHealth);
            System.out.println(savedHealth);

            Unit nUnit = UnitRegister.createUnit(splitSave[0], splitSave[1], savedHealth);
            army.add(nUnit);
        }

        myArmyBattle.setText(army.toString());
        enemyArymyBattle.setText(enemyArmy.toString());


        Battle battle = new Battle(army, enemyArmy);
        Army winner = battle.simulate();
        if(winner.equals(army)){
            BattleView.setText("Victory!");
        }
        if(winner.equals(enemyArmy)){
            BattleView.setText("You lose :(");
        }





    }


    public void switchToMyArmy(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MyArmy.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }


    public void switchToEnemy(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EnemyArmy.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

    public void switchToBattleScene(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("BattleScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

    public void switchToMenu(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
