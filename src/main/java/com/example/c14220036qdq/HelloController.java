package com.example.c14220036qdq;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.time.LocalDate;

public class HelloController {
    @FXML
    private Label savedLabel;
    @FXML
    private TableView<Mahasiswa> tblMhs;
    @FXML
    private TableColumn<Mahasiswa, String> tblNrp;
    @FXML
    private TableColumn<Mahasiswa, String> tblNama;
    @FXML
    private TableColumn<Mahasiswa, String> tblEmail;

    @FXML
    private DatePicker tanggalLahir;
    @FXML
    private TextField nrpField;
    @FXML
    private TextField namaField;
    @FXML
    private TextField emailField;
    @FXML
    private Button saveButton;
    @FXML
    private Button clearbutton ;
    @FXML
    ObservableList<Mahasiswa> listMhs = FXCollections.observableArrayList();

    @FXML
    private String nrp;
    @FXML
    private String nama;
    @FXML
    private String email;
@FXML
int index1 = -1;
    @FXML
    protected void onHelloButtonClick() {
        savedLabel.setText("Your data has been saved! \n " +
                " NRP : " + nrp +"\n " +
                " NAMA : " + nama + "\n " +
                " Email : " + email + "\n " +
                " DOB : " + tanggalLahir.getValue());
        clearbutton.setVisible(false);
    }
    @FXML
  protected void dateOnSelect(){


  }
    @FXML
  protected void onSaveBtn(){
        int index = tblMhs.getSelectionModel().getSelectedIndex();
        this.nrp = nrpField.getText();
        this.nama = namaField.getText();
        this.email = emailField.getText();


        nrpField.setText("");
        namaField.setText("");
        emailField.setText("");
        tanggalLahir.setValue(null);

        if (clearbutton.isVisible()){
            if (nrp.equalsIgnoreCase("") && nama.equalsIgnoreCase("") && email.equalsIgnoreCase("")){
                listMhs.remove(index);
            }
            else{
                listMhs.set(index, new Mahasiswa(nrp, nama, email));
            }
            clearbutton.setVisible(false);

        }
        else{
            listMhs.add(new Mahasiswa(nrp, nama, email));
            tblMhs.setItems(listMhs);
            nrp = "";
            nama = "";
            email = "";
        }
        savedLabel.setText("Your data has been saved!");
    }

    @FXML
    protected void getSelected(){
        int index = -1;
        index = tblMhs.getSelectionModel().getSelectedIndex();
        if(index <= -1){
            return;
        }
        namaField.setText(tblNama.getCellData(index));
        nrpField.setText(tblNrp.getCellData(index));
        emailField.setText(tblEmail.getCellData(index));
        clearbutton.setVisible(true);
    }
    @FXML
    public void initialize(){
    clearbutton.setVisible(false);
    tblNama.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("NRP"));
        tblNrp.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("NAMA"));
        tblEmail.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("EMAIL"));

    }
    @FXML
    protected void onClearBtn(){
    nrpField.setText("");
    namaField.setText("");
    emailField.setText("");
}

    int index = -1;
@FXML
    protected void getSelected(MouseEvent event){
    index = tblMhs.getSelectionModel().getSelectedIndex();
    if (index <= -1){
        return;
    }
    namaField.setText(tblNama.getCellData(index)+ "");
    emailField.setText(tblEmail.getCellData(index) + "");
    nrpField.setText(tblNrp.getCellData(index) + "");
    clearbutton.setVisible(true);


}
  }

