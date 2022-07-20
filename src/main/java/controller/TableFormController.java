package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.CustomerTM;

import java.util.Optional;

public class TableFormController {

    public TableView<CustomerTM> tblCustomers;
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public Button btnSaveCustomer;
    public Button btnNewCustomer;
    public Button btnDeleteCustomer;


    public void initialize() {
        btnDeleteCustomer.setDisable(true);
        tblCustomers.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CustomerTM>() {
            @Override
            public void changed(ObservableValue<? extends CustomerTM> observableValue, CustomerTM previoslySelectedCustomer, CustomerTM newlySelectedCustomer) {
                if (newlySelectedCustomer==null) {
                    btnDeleteCustomer.setDisable(true);
                    txtAddress.clear();
                    txtId.clear();
                    txtName.clear();
                    txtId.setEditable(true);
                    btnSaveCustomer.setText("Save Customer");
                    return;
                }
                txtId.setEditable(false);
                btnDeleteCustomer.setDisable(false);
                txtId.setText(newlySelectedCustomer.getCustomerId());
                txtName.setText(newlySelectedCustomer.getCustomerName());
                txtAddress.setText(newlySelectedCustomer.getCustomerAddress());
                btnSaveCustomer.setText("Update Customer");

            }
        });
/*        btnDeleteCustomer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ObservableList<CustomerTM> olCustomer = tblCustomers.getItems();
                CustomerTM selectedItem = tblCustomers.getSelectionModel().getSelectedItem();
                if (selectedItem==null) return;
                Optional<ButtonType> selectedOption = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete",
                        ButtonType.YES,ButtonType.NO).showAndWait();
                if (selectedOption.get()==ButtonType.YES) olCustomer.remove(selectedItem);
            }
        })*/;
       /* btnNewCustomer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                tblCustomers.getSelectionModel().clearSelection();
                txtId.requestFocus();
            }
        });*/
        tblCustomers.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("customerId"));
        tblCustomers.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("customerName"));
        tblCustomers.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
/*        btnSaveCustomer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ObservableList<CustomerTM> olCustomer = tblCustomers.getItems();
                String id = txtId.getText();
                String Name = txtName.getText();
                String Address = txtAddress.getText();
                if (id.isBlank()) {
                    new Alert(Alert.AlertType.ERROR, "Customer id cannot be empty").showAndWait();
                    txtId.requestFocus();
                    return;
                } else if (Name.isBlank()) {
                    new Alert(Alert.AlertType.ERROR, "Customer Name cannot be empty").showAndWait();
                    txtName.requestFocus();
                    return;

                } else if (Address.isBlank()) {
                    new Alert(Alert.AlertType.ERROR, "Customer Address cannot be empty").showAndWait();
                    txtAddress.requestFocus();
                    return;

                }
                for (CustomerTM customer : olCustomer
                ) {
                    if (customer.getCustomerId().equals(txtId.getText())) {
                        new Alert(Alert.AlertType.ERROR, "Customer Id already available").showAndWait();
                        txtId.requestFocus();
                        return;
                    }

                }
                CustomerTM newCustomer = new CustomerTM(id, Name, Address);
                olCustomer.add(newCustomer);
                txtAddress.clear();
                txtId.clear();
                txtName.clear();
                txtId.requestFocus();
            }
        })*/;


    }

    public void btnSaveCustomer_OnAction(ActionEvent actionEvent) {
        ObservableList<CustomerTM> olCustomer = tblCustomers.getItems();
        String id = txtId.getText();
        String Name = txtName.getText();
        String Address = txtAddress.getText();
        if (id.isBlank()) {
            new Alert(Alert.AlertType.ERROR, "Customer id cannot be empty").showAndWait();
            txtId.requestFocus();
            return;
        } else if (Name.isBlank()) {
            new Alert(Alert.AlertType.ERROR, "Customer Name cannot be empty").showAndWait();
            txtName.requestFocus();
            return;

        } else if (Address.isBlank()) {
            new Alert(Alert.AlertType.ERROR, "Customer Address cannot be empty").showAndWait();
            txtAddress.requestFocus();
            return;

        }
        for (CustomerTM customer : olCustomer
        ) {
            if (customer.getCustomerId().equals(txtId.getText())) {
                new Alert(Alert.AlertType.ERROR, "Customer Id already available").showAndWait();
                txtId.requestFocus();
                return;
            }

        }
        CustomerTM newCustomer = new CustomerTM(id, Name, Address);
        olCustomer.add(newCustomer);
        txtAddress.clear();
        txtId.clear();
        txtName.clear();
        txtId.requestFocus();

    }

    public void btnNewCustomer_OnAction(ActionEvent actionEvent) {
        tblCustomers.getSelectionModel().clearSelection();
        txtId.requestFocus();
    }

    public void btnDeleteCustomer_OnAction(ActionEvent actionEvent) {
        ObservableList<CustomerTM> olCustomer = tblCustomers.getItems();
        CustomerTM selectedItem = tblCustomers.getSelectionModel().getSelectedItem();
        if (selectedItem==null) return;
        Optional<ButtonType> selectedOption = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete",
                ButtonType.YES,ButtonType.NO).showAndWait();
        if (selectedOption.get()==ButtonType.YES) olCustomer.remove(selectedItem);

    }
}
