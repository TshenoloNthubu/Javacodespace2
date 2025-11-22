package com.banking.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainView extends Application {
    private BorderPane root;
    private MenuBar menuBar;
    private TabPane tabPane;

    // Tabs
    private Tab customerTab;
    private Tab accountTab;
    private Tab transactionTab;

    @Override
    public void start(Stage primaryStage) {
        initializeUI(primaryStage);
    }

    private void initializeUI(Stage primaryStage) {
        root = new BorderPane();

        // Create menu bar
        createMenuBar();

        // Create tabs
        createTabs();

        root.setTop(menuBar);
        root.setCenter(tabPane);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Banking System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void createMenuBar() {
        menuBar = new MenuBar();

        Menu fileMenu = new Menu("File");
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(e -> System.exit(0));
        fileMenu.getItems().add(exitItem);

        Menu helpMenu = new Menu("Help");
        MenuItem aboutItem = new MenuItem("About");
        helpMenu.getItems().add(aboutItem);

        menuBar.getMenus().addAll(fileMenu, helpMenu);
    }

    private void createTabs() {
        tabPane = new TabPane();

        // Customer Management Tab
        customerTab = new Tab("Customer Management");
        customerTab.setContent(createCustomerManagementPanel());
        customerTab.setClosable(false);

        // Account Management Tab
        accountTab = new Tab("Account Management");
        accountTab.setContent(createAccountManagementPanel());
        accountTab.setClosable(false);

        // Transaction Tab
        transactionTab = new Tab("Transactions");
        transactionTab.setContent(createTransactionPanel());
        transactionTab.setClosable(false);

        tabPane.getTabs().addAll(customerTab, accountTab, transactionTab);
    }

    private VBox createCustomerManagementPanel() {
        VBox panel = new VBox(10);
        panel.setPadding(new javafx.geometry.Insets(10));

        Label titleLabel = new Label("Customer Management");
        titleLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        // Form fields
        GridPane formGrid = new GridPane();
        formGrid.setHgap(10);
        formGrid.setVgap(10);

        TextField customerIdField = new TextField();
        TextField firstNameField = new TextField();
        TextField surnameField = new TextField();
        TextField addressField = new TextField();
        TextField phoneField = new TextField();
        TextField emailField = new TextField();

        formGrid.add(new Label("Customer ID:"), 0, 0);
        formGrid.add(customerIdField, 1, 0);
        formGrid.add(new Label("First Name:"), 0, 1);
        formGrid.add(firstNameField, 1, 1);
        formGrid.add(new Label("Surname:"), 0, 2);
        formGrid.add(surnameField, 1, 2);
        formGrid.add(new Label("Address:"), 0, 3);
        formGrid.add(addressField, 1, 3);
        formGrid.add(new Label("Phone:"), 0, 4);
        formGrid.add(phoneField, 1, 4);
        formGrid.add(new Label("Email:"), 0, 5);
        formGrid.add(emailField, 1, 5);

        // Buttons
        HBox buttonBox = new HBox(10);
        Button addButton = new Button("Add Customer");
        Button updateButton = new Button("Update Customer");
        Button deleteButton = new Button("Delete Customer");
        Button clearButton = new Button("Clear");

        buttonBox.getChildren().addAll(addButton, updateButton, deleteButton, clearButton);

        // Customer list
        TableView<Object> customerTable = new TableView<>();
        TableColumn<Object, String> idCol = new TableColumn<>("Customer ID");
        TableColumn<Object, String> nameCol = new TableColumn<>("Name");
        TableColumn<Object, String> addressCol = new TableColumn<>("Address");

        customerTable.getColumns().addAll(idCol, nameCol, addressCol);

        panel.getChildren().addAll(titleLabel, formGrid, buttonBox, new Label("Customers:"), customerTable);

        return panel;
    }

    private VBox createAccountManagementPanel() {
        VBox panel = new VBox(10);
        panel.setPadding(new javafx.geometry.Insets(10));

        Label titleLabel = new Label("Account Management");
        titleLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        // Account type selection
        HBox typeBox = new HBox(10);
        ToggleGroup accountTypeGroup = new ToggleGroup();
        RadioButton savingsRadio = new RadioButton("Savings");
        RadioButton investmentRadio = new RadioButton("Investment");
        RadioButton chequeRadio = new RadioButton("Cheque");

        savingsRadio.setToggleGroup(accountTypeGroup);
        investmentRadio.setToggleGroup(accountTypeGroup);
        chequeRadio.setToggleGroup(accountTypeGroup);

        typeBox.getChildren().addAll(savingsRadio, investmentRadio, chequeRadio);

        // Form fields
        GridPane formGrid = new GridPane();
        formGrid.setHgap(10);
        formGrid.setVgap(10);

        TextField customerIdField = new TextField();
        TextField accountNumberField = new TextField();
        TextField initialDepositField = new TextField();
        TextField branchField = new TextField();
        TextField employerField = new TextField();
        TextField companyAddressField = new TextField();

        formGrid.add(new Label("Customer ID:"), 0, 0);
        formGrid.add(customerIdField, 1, 0);
        formGrid.add(new Label("Account Number:"), 0, 1);
        formGrid.add(accountNumberField, 1, 1);
        formGrid.add(new Label("Initial Deposit:"), 0, 2);
        formGrid.add(initialDepositField, 1, 2);
        formGrid.add(new Label("Branch:"), 0, 3);
        formGrid.add(branchField, 1, 3);
        formGrid.add(new Label("Employer:"), 0, 4);
        formGrid.add(employerField, 1, 4);
        formGrid.add(new Label("Company Address:"), 0, 5);
        formGrid.add(companyAddressField, 1, 5);

        // Buttons
        HBox buttonBox = new HBox(10);
        Button openAccountButton = new Button("Open Account");
        Button closeAccountButton = new Button("Close Account");

        buttonBox.getChildren().addAll(openAccountButton, closeAccountButton);

        panel.getChildren().addAll(titleLabel, typeBox, formGrid, buttonBox);

        return panel;
    }

    private VBox createTransactionPanel() {
        VBox panel = new VBox(10);
        panel.setPadding(new javafx.geometry.Insets(10));

        Label titleLabel = new Label("Transactions");
        titleLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        GridPane formGrid = new GridPane();
        formGrid.setHgap(10);
        formGrid.setVgap(10);

        TextField accountNumberField = new TextField();
        TextField amountField = new TextField();
        TextArea transactionArea = new TextArea();

        formGrid.add(new Label("Account Number:"), 0, 0);
        formGrid.add(accountNumberField, 1, 0);
        formGrid.add(new Label("Amount:"), 0, 1);
        formGrid.add(amountField, 1, 1);

        HBox buttonBox = new HBox(10);
        Button depositButton = new Button("Deposit");
        Button withdrawButton = new Button("Withdraw");
        Button checkBalanceButton = new Button("Check Balance");

        buttonBox.getChildren().addAll(depositButton, withdrawButton, checkBalanceButton);

        panel.getChildren().addAll(titleLabel, formGrid, buttonBox,
                new Label("Transaction History:"), transactionArea);

        return panel;
    }

    public static void main(String[] args) {
        launch(args);
    }
}