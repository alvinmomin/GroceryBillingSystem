import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.application.Application;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Group;

public class appDemo extends Application
{
    private BorderPane bordPane = new BorderPane();
    private GridPane gridPaneOne = new GridPane();
    private GridPane gridPaneTwo = new GridPane();
    private FlowPane flowPane = new FlowPane();

    private VBox vBoxOne = new VBox();
    private VBox vBoxTwo = new VBox();
    private VBox vBoxThree = new VBox();

    private ObservableList<Item> data;

    public void start(Stage s)
    {
        TableView<Item> table;
        table = new TableView<>();
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        Alert errAlert = new Alert(Alert.AlertType.ERROR);

        Scene sceneOne, sceneTwo, sceneThree, sceneFour;

        sceneOne = new Scene(new Group());
        s.sizeToScene();

        Button buttonTwo = new Button(" Add ");
        Button buttonThree = new Button(" Update ");
        Button buttonFour = new Button(" Remove ");
        Button buttonFive = new Button(" Login ");
        Button buttonSix = new Button(" Print ");

        flowPane.getChildren().addAll(buttonFive, buttonTwo, buttonThree, buttonFour, buttonSix);
        data = FXCollections.observableArrayList();

        s.setWidth(1000);
        s.setHeight(700);

        final Label labelOne = new Label("                              Customer Data\n");

        labelOne.setFont(new Font("Impact", 30));

        TableColumn codeColumn = new TableColumn("Code"); codeColumn.setMinWidth(15);
        codeColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("Code"));

        TableColumn typeColumn = new TableColumn("Type"); typeColumn.setMinWidth(15);
        typeColumn.setCellValueFactory(new PropertyValueFactory<Item, Integer>("Type"));

        TableColumn nameColumn = new TableColumn("Name"); nameColumn.setMinWidth(15);
        nameColumn.setCellValueFactory(new PropertyValueFactory<Item, Integer>("Name"));

        TableColumn quantityColumn = new TableColumn("Quantity"); quantityColumn.setMinWidth(15);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Item, Integer>("Quantity"));

        TableColumn priceColumn = new TableColumn("Item Price"); priceColumn.setMinWidth(15);
        priceColumn.setCellValueFactory(new PropertyValueFactory<Item, Integer>("Price"));

        TableColumn discountColumn = new TableColumn("Discount"); discountColumn.setMinWidth(15);
        discountColumn.setCellValueFactory(new PropertyValueFactory<Item, Integer>("Discount"));

        table.setEditable(true);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setItems(data);
        table.getColumns().addAll(codeColumn, typeColumn,nameColumn,quantityColumn,priceColumn,discountColumn);
        vBoxOne.getChildren().addAll(labelOne, table);

        //add

        Label label1 = new Label();
        label1.setText("Item Code");

        Label labelTwo = new Label();
        labelTwo.setText("Type");

        Label labelThree = new Label();
        labelThree.setText("Customer Name");

        Label labelFour = new Label();
        labelFour.setText("Quantity");

        Label labelFive = new Label();
        labelFive.setText("Item Price");

        Label labelSix = new Label();
        labelSix.setText("Day");

        Label labelSev = new Label();
        labelSev.setText("Departments");

        TextField tfCode = new TextField();
        TextField tfType = new TextField();
        TextField tfName = new TextField();
        TextField tfQuant = new TextField();
        TextField tfPrice = new TextField();
        TextField tfDisc = new TextField();

        ComboBox comboBox = new ComboBox();
        comboBox.getItems().addAll("Grocery", "Food", "Meat", "Soda", "Home improvement", "Fruit");

        Button bOne = new Button("Add");

        gridPaneOne.add(labelSix, 0, 0);gridPaneOne.add(tfDisc, 1, 0);gridPaneOne.add(label1, 0, 1);gridPaneOne.add(tfCode, 1, 1);
        gridPaneOne.add(labelTwo, 0, 2);gridPaneOne.add(tfType, 1, 2);gridPaneOne.add(labelThree, 0, 3);gridPaneOne.add(tfName, 1, 3);gridPaneOne.add(labelFour, 0, 4);
        gridPaneOne.add(tfQuant, 1, 4);gridPaneOne.add(labelFive, 0, 5);gridPaneOne.add(tfPrice, 1, 5);gridPaneOne.add(labelSev,0,6);gridPaneOne.add(comboBox,1,6);

        gridPaneOne.setPadding(new Insets(12, 12, 12, 12));
        gridPaneOne.setHgap(110);
        gridPaneOne.setVgap(60);

        vBoxTwo.setSpacing(5);
        vBoxTwo.setPadding(new Insets(12, 12, 12, 12));
        vBoxTwo.getChildren().addAll(gridPaneOne, bOne);
        vBoxTwo.setVisible(false);

        bordPane.setPadding(new Insets(20, 20, 10, 10));
        bordPane.setLeft(vBoxTwo);
        bordPane.setRight(vBoxOne);
        bordPane.setTop(flowPane);

        EventHandler<ActionEvent> eventOne = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                vBoxTwo.setVisible(true);
            }
        };

        buttonTwo.setOnAction(eventOne);

        ArrayList<Item> iList=new ArrayList<Item>();
        final Item[] objectTwo = {new Item()};

        EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
            @Override
            //Add
            public void handle(ActionEvent event) {
                objectTwo[0] = new Item(tfCode.getText(), tfType.getText(), tfName.getText(),
                        Integer.parseInt(tfQuant.getText()), Integer.parseInt(tfPrice.getText()),
                        tfDisc.getText(), (String)comboBox.getValue());

                iList.add(objectTwo[0]);
                data.add(objectTwo[0]);

                tfCode.clear(); tfType.clear(); tfName.clear(); tfQuant.clear(); tfPrice.clear();
            }
        };

        bOne.setOnAction(event2);
        ((Group) sceneOne.getRoot()).getChildren().add(bordPane);
        s.setScene(sceneOne);
        s.show();

        //Update
        Label enter_information = new Label("Enter Information");
        enter_information.setFont(new Font("Impact", 20));
        Label labCode = new Label("Code");
        Label labType = new Label("Type");
        Label labName = new Label("Name");
        Label labQuantity = new Label("Quantity");
        Label labPrice = new Label("Price");
        Label labDay = new Label("Day");
        Label labDep= new Label("Departments");

        TextField tfC = new TextField();
        TextField tfB = new TextField();
        TextField tfN = new TextField();
        TextField tfQ = new TextField();
        TextField tfP = new TextField();
        TextField tfD = new TextField();


        ComboBox comboBox1 = new ComboBox();

        comboBox1.getItems().addAll("Grocery", "Food","Meat","Soda",
                "Home Improvement", "Fruit");

        Button buttonTwelve = new Button("Update");

        gridPaneTwo.add(labDay, 0, 0); gridPaneTwo.add(tfD, 0, 1); gridPaneTwo.add(labCode,0,2); gridPaneTwo.add(tfC, 0, 3);
        gridPaneTwo.add(labType, 0, 4); gridPaneTwo.add(tfB, 0, 5); gridPaneTwo.add(labName, 0, 6);
        gridPaneTwo.add(tfN, 0, 7); gridPaneTwo.add(labQuantity, 0, 8); gridPaneTwo.add(tfQ, 0, 9); gridPaneTwo.add(labPrice, 0, 10);
        gridPaneTwo.add(tfP, 0, 11); gridPaneTwo.add(labDep,0,12); gridPaneTwo.add(comboBox1,0,13);

        Label labUp = new Label();
        gridPaneTwo.setPadding(new Insets(12, 12, 12, 12));
        gridPaneTwo.setHgap(12);
        gridPaneTwo.setVgap(7);
        vBoxThree.getChildren().addAll(enter_information, gridPaneTwo, buttonTwelve, labUp);
        vBoxThree.setSpacing(10);
        vBoxThree.setPadding(new Insets(15, 15, 15, 15));

        //Update
        EventHandler<ActionEvent> event22 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                String input = tfC.getText();
                boolean flse = false;

                for (int i = 0; i < table.getItems().size(); i++)
                {
                    if (((String) table.getItems().get(i).getCode()).equals(input))
                    {
                        Item ge = new Item(tfC.getText(),tfB.getText(),tfN.getText(),Integer.parseInt(tfQ.getText()),
                                Integer.parseInt(tfP.getText()),tfD.getText(),(String)comboBox1.getValue().toString());
                        table.getItems().set(i,ge);
                        flse = true;
                    }
                }

                if (flse)
                {
                    infoAlert.setTitle("Update"); infoAlert.setHeaderText(null);
                    infoAlert.setContentText("Transaction Updated");
                    infoAlert.showAndWait();
                }
                else
                    {
                    errAlert.setTitle("Error"); errAlert.setHeaderText(null);
                    errAlert.setContentText("Code not found.");
                    errAlert.showAndWait();
                }

                tfC.clear(); tfB.clear(); tfN.clear(); tfQ.clear(); tfP.clear();
                s.setScene(sceneOne);

                //returns to first scene
            }
        };

        //ub

        buttonTwelve.setOnAction(event22);
        sceneTwo = new Scene(vBoxThree, 410, 560);

        EventHandler<ActionEvent> event3 = new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event) {
                s.setScene(sceneTwo);
            }
        };

        buttonThree.setOnAction(event3);

        //delete row

        VBox vBoxFoure = new VBox();

        Label remLabel = new Label("Enter Item code to remove transaction");
        TextField remTF = new TextField();

        Button delButton = new Button("Remove");

        vBoxFoure.getChildren().addAll(remLabel, remTF, delButton);
        vBoxFoure.setPadding(new Insets(12, 12, 12, 12));
        vBoxFoure.setSpacing(11);
        sceneThree = new Scene(vBoxFoure, 320, 220);

        //delete

        EventHandler<ActionEvent> eventSC = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                String kbInput = remTF.getText();
                boolean delF = false;

                for (int i = 0; i < table.getItems().size(); i++)
                {
                    if (((String) table.getItems().get(i).getCode()).equals(kbInput))
                    {
                        table.getItems().remove(i);
                        delF = true;
                    }
                }

                if (delF)
                {
                    infoAlert.setTitle("Delete"); infoAlert.setHeaderText(null);
                    infoAlert.setContentText("Transaction removed");
                    infoAlert.showAndWait();
                    //
                }
                else
                {
                    errAlert.setTitle("Error"); errAlert.setHeaderText(null);
                    errAlert.setContentText("Code does not exist.");
                    errAlert.showAndWait();
                    //
                }

                tfCode.clear(); tfType.clear(); tfName.clear(); tfQuant.clear(); tfPrice.clear();
                s.setScene(sceneOne);
                //returns to scene one
            }
        };

        delButton.setOnAction(eventSC);
        EventHandler<ActionEvent> eventFour = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                s.setScene(sceneThree);
            }
        };

        buttonFour.setOnAction(eventFour);

        //login
        VBox loginBox = new VBox();

        Label labEPN = new Label("Enter Your Phone Number: ");
        Label labPN = new Label("Phone Number");
        TextField tfPN = new TextField();
        Button buttOne = new Button("Login");

        loginBox.getChildren().addAll(labEPN, labPN, tfPN, buttOne);
        loginBox.setPadding(new Insets(12, 12, 12, 12));
        loginBox.setSpacing(12);

        sceneFour = new Scene(loginBox, 610, 320);

        EventHandler<ActionEvent> eventFive = new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event) {
                s.setScene(sceneFour);
            }
        };

        buttonFive.setOnAction(eventFive);

        EventHandler<ActionEvent> eventLg = new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event) {
                Item phgt = new Item(tfPN.getText());
                tfPN.clear();
                s.setScene(sceneOne);
            }
        };

        buttOne.setOnAction(eventLg);

        //prints calculations

        EventHandler<ActionEvent> eventSix = new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event) {
                for(int i = 0; i < table.getItems().size(); i++)
                {

                    System.out.println(" ");
                    System.out.println(iList.get(i).createString());
                    System.out.println(" \n");
                    System.out.print(iList.get(i).calcFinalTotal()+"\n");
                }
            }
        };

        //****************^^^^^^^^^^^^^^^^^^^^^^^^^^^^ fix code not printing all transactions***********

        buttonSix.setOnAction(eventSix);
    }

    //launches application

    public static void main(String[] args) {
        launch(args);
    }
}
