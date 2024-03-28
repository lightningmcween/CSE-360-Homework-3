package application;
	
import javafx.application.Application;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import javafx.application.Application; 
import javafx.scene.Scene;
import javafx.scene.control.Button; 
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.*; 
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class hw3 extends Application {
	public static ArrayList<Integer> allIDS = new ArrayList<Integer>();
	public void start(Stage primaryStage) {
		try {
			StackPane r = new StackPane();
			Scene homePage = new Scene(r,400,400);
			homePage.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(homePage);
			primaryStage.show();
			
			Label title = new Label("Welcome to Heart Health Imaging and Recording System");
			r.getChildren().add(title);
			title.setTranslateY(-180);
			
			Button intake = new Button("Patient Intake");// creates the 3 buttons
			Button tView = new Button("CT Scan Tech View");
			Button pView = new Button("Patient View");
			
			intake.setTranslateY(-100);
			tView.setTranslateY(-50);
			
			r.getChildren().add(intake);
			r.getChildren().add(tView);
			r.getChildren().add(pView);
			
			intake.setOnAction(e->{
								
				StackPane r2 = new StackPane();
				Label iTitle = new Label("Patient Intake Form");
				r2.getChildren().add(iTitle);
				iTitle.setTranslateY(-280);
				
				Scene intakePage = new Scene(r2,600,600);
				Stage secondStage = new Stage();
				intakePage.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				secondStage.setScene(intakePage);
				secondStage.show();
				
				Label fnameL = new Label("First Name:");
				r2.getChildren().add(fnameL);
				fnameL.setTranslateX(-250);
				fnameL.setTranslateY(-200);
				TextField firstName = new TextField();
				r2.getChildren().add(firstName);
				firstName.setTranslateX(-50);
				firstName.setTranslateY(-200);
				firstName.setMaxWidth(300);
				
				Label lnameL = new Label("Last Name:");
				r2.getChildren().add(lnameL);
				lnameL.setTranslateX(-250);
				lnameL.setTranslateY(-150);
				TextField lastName = new TextField();
				r2.getChildren().add(lastName);
				lastName.setTranslateX(-50);
				lastName.setTranslateY(-150);
				lastName.setMaxWidth(300);
				
				Label emailL = new Label("Email:");
				r2.getChildren().add(emailL);
				emailL.setTranslateX(-250);
				emailL.setTranslateY(-100);
				TextField email = new TextField();
				r2.getChildren().add(email);
				email.setTranslateX(-50);
				email.setTranslateY(-100);
				email.setMaxWidth(300);
				
				Label pnumber = new Label("Phone Number:");
				r2.getChildren().add(pnumber);
				pnumber.setTranslateX(-250);
				pnumber.setTranslateY(-50);
				TextField phoneNumber = new TextField();
				r2.getChildren().add(phoneNumber);
				phoneNumber.setTranslateX(-50);
				phoneNumber.setTranslateY(-50);
				phoneNumber.setMaxWidth(300);
				
				Label hHistoryL = new Label("Health History:");
				r2.getChildren().add(hHistoryL);
				hHistoryL.setTranslateX(-250);
				TextField healthHistory = new TextField();
				r2.getChildren().add(healthHistory);
				healthHistory.setTranslateX(-50);
				healthHistory.setMaxWidth(300);
				
				Label iIDL = new Label("Insurance ID:");
				r2.getChildren().add(iIDL);
				iIDL.setTranslateX(-250);
				iIDL.setTranslateY(50);
				TextField insuranceID = new TextField();
				r2.getChildren().add(insuranceID);
				insuranceID.setTranslateX(-50);
				insuranceID.setTranslateY(50);
				insuranceID.setMaxWidth(300);
				
				Button save = new Button("Save");
				r2.getChildren().add(save);
				save.setTranslateX(250);
				save.setTranslateY(100);
				
				EventHandler<ActionEvent> saveEvent = new EventHandler<ActionEvent>(){
					public void handle(ActionEvent n)
					{
						try {

						Random random = new Random();
						int idDigit = random.nextInt(100000);
						String fivedigitID = Integer.toString(idDigit);
						if (allIDS.size() != 0)
						{
						
						while (allIDS.indexOf(idDigit) != -1)
						{
							idDigit = random.nextInt(100000);
							fivedigitID = Integer.toString(idDigit);
						}
						}
						if (idDigit >= 1000 && idDigit <= 9999)
						{
							idDigit = idDigit * 10;
							fivedigitID = Integer.toString(idDigit);

						}
						else if (idDigit >= 100 && idDigit <= 999)
						{
							idDigit = idDigit * 100;
							 fivedigitID = Integer.toString(idDigit);

						}
						else if (idDigit >= 10 && idDigit <= 99)
						{
							idDigit = idDigit * 1000;
							fivedigitID = Integer.toString(idDigit);

						}
						else if (idDigit >= 0 && idDigit <= 9)
						{
							idDigit = idDigit * 10000;
							fivedigitID = Integer.toString(idDigit);

						}
						allIDS.add(idDigit);
						FileWriter patient = new FileWriter(fivedigitID+"_PatientInfo.txt");
						patient.write(firstName.getText()+"\n"+lastName.getText()+"\n"+email.getText()+"\n"+phoneNumber.getText()+"\n"+healthHistory.getText()+"\n"+insuranceID.getText());
						patient.close();
						System.out.println(fivedigitID);
						}catch (IOException e)
						{
							System.out.println("An error has occurred.");
						}
					}
				};
				save.setOnAction(saveEvent);						
			
			});
			
			tView.setOnAction(e->{
				
				StackPane r3 = new StackPane();
				Label iTitle = new Label("CT Tech View");
				r3.getChildren().add(iTitle);
				iTitle.setTranslateY(-280);
				
				Scene techPage = new Scene(r3,600,600);
				Stage thirdStage = new Stage();
				techPage.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				thirdStage.setScene(techPage);
				thirdStage.show();
				
				Label pID = new Label("Patient ID:");
				r3.getChildren().add(pID);
				pID.setTranslateX(-250);
				pID.setTranslateY(-250);
				TextField patientID = new TextField();
				r3.getChildren().add(patientID);
				patientID.setTranslateX(100);
				patientID.setTranslateY(-250);
				patientID.setMaxWidth(300);
				
				Label totCACL = new Label("The total Agaston CAC score:");
				r3.getChildren().add(totCACL);
				totCACL.setTranslateX(-200);
				totCACL.setTranslateY(-200);
				TextField totalCAC = new TextField();
				r3.getChildren().add(totalCAC);
				totalCAC.setTranslateX(100);
				totalCAC.setTranslateY(-200);
				totalCAC.setMaxWidth(300);
				
				Label LML = new Label("LM:");
				r3.getChildren().add(LML);
				LML.setTranslateX(-250);
				LML.setTranslateY(-150);
				TextField lmScore = new TextField();
				r3.getChildren().add(lmScore);
				lmScore.setTranslateX(-50);
				lmScore.setTranslateY(-150);
				lmScore.setMaxWidth(300);
				
				Label LADL = new Label("LAD:");
				r3.getChildren().add(LADL);
				LADL.setTranslateX(-250);
				LADL.setTranslateY(-100);
				TextField ladScore = new TextField();
				r3.getChildren().add(ladScore);
				ladScore.setTranslateX(-50);
				ladScore.setTranslateY(-100);
				ladScore.setMaxWidth(300);
				
				Label LCXL = new Label("LCX:");
				r3.getChildren().add(LCXL);
				LCXL.setTranslateX(-250);
				LCXL.setTranslateY(-50);
				TextField lcxScore = new TextField();
				r3.getChildren().add(lcxScore);
				lcxScore.setTranslateX(-50);
				lcxScore.setTranslateY(-50);
				lcxScore.setMaxWidth(300);
				
				Label RCAL = new Label("RCA:");
				r3.getChildren().add(RCAL);
				RCAL.setTranslateX(-250);
				TextField rcaScore = new TextField();
				r3.getChildren().add(rcaScore);
				rcaScore.setTranslateX(-50);
				rcaScore.setMaxWidth(300);
				
				Label PDAL = new Label("PDA:");
				r3.getChildren().add(PDAL);
				PDAL.setTranslateX(-250);
				PDAL.setTranslateY(50);
				TextField pdaScore = new TextField();
				r3.getChildren().add(pdaScore);
				pdaScore.setTranslateX(-50);
				pdaScore.setTranslateY(50);
				pdaScore.setMaxWidth(300);
				
				Button save = new Button("Save");
				r3.getChildren().add(save );
				save.setTranslateX(250);
				save.setTranslateY(100);
				
				Label error = new Label("");
				r3.getChildren().add(error);
				error.setTranslateY(100);
				
				EventHandler<ActionEvent> saveEvent = new EventHandler<ActionEvent>(){
					public void handle(ActionEvent n)
					{
						try {
						
						if (patientID.getText().isEmpty() || totalCAC.getText().isEmpty() || lmScore.getText().isEmpty() || ladScore.getText().isEmpty() || lcxScore.getText().isEmpty() || rcaScore.getText().isEmpty() || pdaScore.getText().isEmpty()) {
							error.setText("Error: One or more of your fields is not filled out");
							}
						else {
						FileWriter patient = new FileWriter(patientID.getText()+"CTResults.txt");
						patient.write(totalCAC.getText()+"\n"+lmScore.getText()+"\n"+ladScore.getText()+"\n"+lcxScore.getText()+"\n"+rcaScore.getText()+"\n"+pdaScore.getText());
						patient.close();
						System.out.println(patientID.getText());
							}
						}
						catch (IOException e)
						{
							System.out.println("An error has occurred.");
						}
					}
				};
				save.setOnAction(saveEvent);	
			
			});
			
			pView.setOnAction(e->{
				
				StackPane r4 = new StackPane();
				Label iTitle = new Label("Enter your ID");
				r4.getChildren().add(iTitle);
				iTitle.setTranslateY(-200);
				
				Scene patientLogin = new Scene(r4,600,600);
				Stage thirdStage = new Stage();
				patientLogin.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				thirdStage.setScene(patientLogin);
				thirdStage.show();
				
				TextField login = new TextField();
				r4.getChildren().add(login);
				login.setTranslateY(-150);
				login.setMaxWidth(300);
				
				Label error = new Label("");
				r4.getChildren().add(error);
				error.setTranslateY(-50);
				
				Button Enter = new Button("Enter");
				r4.getChildren().add(Enter);
				Enter.setTranslateY(-100);
				
				EventHandler<ActionEvent> enterEvent = new EventHandler<ActionEvent>()
				{
					public void handle(ActionEvent n)
					{
						int ID =  Integer.valueOf(login.getText());
						int i = 0;
						for (i = 0; i < allIDS.size(); i++)
						{
							if (ID == allIDS.get(i))
							{	
								error.setText("");
								
								try {
								StackPane r5 = new StackPane();
								
								Scene patientPage = new Scene(r5,600,600);
								Stage fourthStage = new Stage();
									
								patientPage.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
								fourthStage.setScene(patientPage);
								fourthStage.show();	
								File patientInfo =  new File(login.getText()+"_PatientInfo.txt");
								Scanner infoReader = new Scanner(patientInfo);
								String fName = infoReader.nextLine();
								String lName = infoReader.nextLine();
								infoReader.close();
								
								Label pTitle = new Label("Hello "+fName+" "+lName);
								r5.getChildren().add(pTitle);
								pTitle.setTranslateY(-250);
								
								Label totCACL = new Label("The total Agaston CAC score:");
								r5.getChildren().add(totCACL);
								totCACL.setTranslateX(-200);
								totCACL.setTranslateY(-200);
								
								
								Label LML = new Label("LM:");
								r5.getChildren().add(LML);
								LML.setTranslateX(-250);
								LML.setTranslateY(-150);
								
								
								Label LADL = new Label("LAD:");
								r5.getChildren().add(LADL);
								LADL.setTranslateX(-250);
								LADL.setTranslateY(-100);
								
								
								Label LCXL = new Label("LCX:");
								r5.getChildren().add(LCXL);
								LCXL.setTranslateX(-250);
								LCXL.setTranslateY(-50);
								
								
								Label RCAL = new Label("RCA:");
								r5.getChildren().add(RCAL);
								RCAL.setTranslateX(-250);
								
								
								Label PDAL = new Label("PDA:");
								r5.getChildren().add(PDAL);
								PDAL.setTranslateX(-250);
								PDAL.setTranslateY(50);
								

								File patientCT = new File(login.getText()+"CTResults.txt");
								if (patientCT.exists())
								{
								Scanner resultsReader = new Scanner(patientCT);
								
								String totCAC = resultsReader.nextLine();
								String lm = resultsReader.nextLine();
								String lad = resultsReader.nextLine();
								String lcx = resultsReader.nextLine();
								String rca  = resultsReader.nextLine();
								String pda = resultsReader.nextLine();
								
								Label totResults = new Label(totCAC);
								r5.getChildren().add(totResults);
								totResults.setTranslateY(-200);
								
								Label lmResults = new Label(lm);
								r5.getChildren().add(lmResults);
								lmResults.setTranslateY(-150);
								
								Label ladResults = new Label(lad);
								r5.getChildren().add(ladResults);
								ladResults.setTranslateY(-100);
								
								Label lcxResults = new Label(lcx);
								r5.getChildren().add(lcxResults);
								lcxResults.setTranslateY(-50);
								
								Label rcaResults = new Label(rca);
								r5.getChildren().add(rcaResults);
								rcaResults.setTranslateY(0);
								
								Label pdaResults = new Label(pda);
								r5.getChildren().add(pdaResults);
								pdaResults.setTranslateY(50);
								resultsReader.close();
								}
								else {
									Label noData = new Label("Your CT results are not available yet");
									r5.getChildren().add(noData);
									System.out.println("no data");
								}
								}
								catch (FileNotFoundException e)
								{
									System.out.println("");
								}
								break;
							} 
						}
						if (i == allIDS.size())
						{
							error.setText("Invalid ID");
						} 
					}
				};
				Enter.setOnAction(enterEvent);

			});

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
