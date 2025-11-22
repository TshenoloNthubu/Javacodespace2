package com.banking.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainView extends Application {


    @Override
    public void start(Stage primaryStage) {
        initializeUI(primaryStage);
    }

    private void initializeUI(Stage primaryStage) {


        primaryStage.setScene(scene);
        primaryStage.show();
    }


        Menu fileMenu = new Menu("File");
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(e -> System.exit(0));

        Menu helpMenu = new Menu("Help");
        MenuItem aboutItem = new MenuItem("About");
        helpMenu.getItems().add(aboutItem);

        menuBar.getMenus().addAll(fileMenu, helpMenu);
    }


        customerTab.setContent(createCustomerManagementPanel());

        accountTab.setClosable(false);

        transactionTab.setClosable(false);

        tabPane.getTabs().addAll(customerTab, accountTab, transactionTab);
    }

    private VBox createCustomerManagementPanel() {
        VBox panel = new VBox(10);


        GridPane formGrid = new GridPane();
        formGrid.setHgap(10);
        formGrid.setVgap(10);

        TextField surnameField = new TextField();
        TextField addressField = new TextField();

        formGrid.add(new Label("Customer ID:"), 0, 0);
        formGrid.add(new Label("First Name:"), 0, 1);
        formGrid.add(new Label("Surname:"), 0, 2);
        formGrid.add(surnameField, 1, 2);
        formGrid.add(new Label("Address:"), 0, 3);
        formGrid.add(addressField, 1, 3);






        return panel;
    }

    private VBox createAccountManagementPanel() {
        VBox panel = new VBox(10);






        TextField branchField = new TextField();
        TextField employerField = new TextField();





        return panel;
    }

    private VBox createTransactionPanel() {
        VBox panel = new VBox(10);



        TextField amountField = new TextField();





        return panel;
    }

    public static void main(String[] args) {
        launch(args);
    }
}