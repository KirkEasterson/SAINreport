////////////////////
// Kirk Easterson //
// CST 242 Final ///
////////////////////

package controller;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import model.CourseBag;
import model.Major;
import model.MajorBag;
import model.Student;
import model.StudentBag;
import view.SAINeditView;
import view.SAINeditViewEvent;
import view.SAINeditViewListener;

public class SAINeditViewController
{
	private TextInputDialog	editingDialog;
	private ChoiceDialog	choiceDialog;
	private Alert			alert;
	
	private Student			studentModel;
	private StudentBag		studentBag;
	private MajorBag		majorBag;
	private CourseBag		courseBag;
	
	private String			name;			// Name of student
	private Major			major;			// Major of student
	private String			userName;		// Username for student
	private String			password;		// Password for student
	private String			gpa;			// GPA for student
	
	public SAINeditViewController(Stage stage, Student studentModel, MajorBag majorBag, CourseBag courseBag)
	{
		// Set studentModel to argument studentModel
		this.studentModel = studentModel;
		this.majorBag = majorBag;
		this.courseBag = courseBag;
		
		SAINeditView window = new SAINeditView(stage, this);
		
		// Set listener method
		window.setSAINeditViewListener(new SAINeditViewListener()
		{
			
			// public void viewStudentButtonClicked()
			// {
			// // Instantiate new runnable
			// Platform.runLater(new Runnable()
			// {
			// // Override the run method
			// @Override
			// public void run()
			// {
			// // Insert methods to updates text fields
			//
			// }
			// });
			// }
			
			// // Update button clicked method
			// public void updateButtonClicked(SAINeditViewEvent ev)
			// {
			// // Get name from controller
			// name = ev.getName();
			// // Get major from controller
			// major = ev.getMajor();
			// // Get username from controller
			// userName = ev.getUserName();
			// // Get password from controller
			// password = ev.getPassword();
			// // Get GPA from controller
			// gpa = ev.getGpa();
			//
			// // If all data from form is valid
			// if ((name != null) && (major != null) && (userName != null) && (password != null) && (gpa != null))
			// {
			// // Set name
			// studentModel.setName(name);
			// // Set major
			// studentModel.setMajor(major);
			// }
			// }
			
			// @Override
			// public void nameSearchClicked()
			// {
			// studentModel = null;
			//
			// if (studentBag.isStudentValid(name))
			// {
			// // Get valid student
			// studentModel = studentBag.getValidStudent();
			//
			// } else
			// {
			// alert = new Alert(AlertType.ERROR);
			// alert.setTitle("Error");
			// alert.setHeaderText("Entered name is invalid");
			// alert.setContentText("Please enter a valid name");
			// alert.showAndWait();
			// }
			// }
			
			@Override
			public String updateNameClicked()
			{
				
				editingDialog = new TextInputDialog(studentModel.getName());
				editingDialog.setTitle("Edit Name");
				editingDialog.setHeaderText(null);
				editingDialog.setContentText("Name: ");
				Optional<String> result = editingDialog.showAndWait();
				
				if (result.isPresent())
				{
					if (!result.get().equals(studentModel.getName()))
					{
						return result.get();
					} else
					{
						alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Name error");
						alert.setHeaderText(null);
						alert.setContentText("Name is unchanged. Are you sure?");
						Optional<ButtonType> resultTwo = alert.showAndWait();
						if (resultTwo.get() == ButtonType.OK)
						{
							alert.close();
							editingDialog.close();
						} else
						{
							alert.close();
						}
					}
				}
				return null;
			}
			
			@Override
			public void updateMajorClicked()
			{
				
				choiceDialog = new ChoiceDialog(studentModel.getMajor().getTitle(), majorBag.getMajorStringList());
				choiceDialog.setTitle("Edit Major");
				choiceDialog.setHeaderText("Choose new major for student");
				choiceDialog.setContentText("Major: ");
				Optional<String> result = choiceDialog.showAndWait();
				result.ifPresent(e ->
				{
					if (!result.toString().equals(studentModel.getMajor().getTitle()))
					{
						Major tempMajor = majorBag.findByString(result.toString());
						studentModel.setMajor(tempMajor);
					} else
					{
						alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Major error");
						alert.setHeaderText(null);
						alert.setContentText("Major is unchanged. Are you sure?");
						Optional<ButtonType> resultTwo = alert.showAndWait();
						if (resultTwo.get() == ButtonType.OK)
						{
							alert.close();
							choiceDialog.close();
						} else
						{
							alert.close();
						}
					}
				});
			}
			
			@Override
			public String updateUserNameClicked()
			{
				editingDialog = new TextInputDialog(studentModel.getUserName());
				editingDialog.setTitle("Edit Username");
				editingDialog.setHeaderText(null);
				editingDialog.setContentText("Username: ");
				Optional<String> result = editingDialog.showAndWait();
				
				if (result.isPresent())
				{
					if (!result.get().equals(studentModel.getUserName()))
					{
						return result.get();
					} else
					{
						alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Username error");
						alert.setHeaderText(null);
						alert.setContentText("Username is unchanged. Are you sure?");
						Optional<ButtonType> resultTwo = alert.showAndWait();
						if (resultTwo.get() == ButtonType.OK)
						{
							alert.close();
							editingDialog.close();
						} else
						{
							alert.close();
						}
					}
				}
				return null;
				
			}
			
			@Override
			public String updatePasswordClicked()
			{
				editingDialog = new TextInputDialog(studentModel.getPassword());
				editingDialog.setTitle("Edit Password");
				editingDialog.setHeaderText(null);
				editingDialog.setContentText("Password: ");
				Optional<String> result = editingDialog.showAndWait();
				
				if (result.isPresent())
				{
					if (!result.get().equals(studentModel.getPassword()))
					{
						return result.get();
					} else
					{
						alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Password error");
						alert.setHeaderText(null);
						alert.setContentText("Password is unchanged. Are you sure?");
						Optional<ButtonType> resultTwo = alert.showAndWait();
						if (resultTwo.get() == ButtonType.OK)
						{
							alert.close();
							editingDialog.close();
						} else
						{
							alert.close();
						}
					}
				}
				return null;
			}
			
			@Override
			public double updateGpaClicked()
			{
				editingDialog = new TextInputDialog(Double.toString(studentModel.getGpa()));
				editingDialog.setTitle("Edit Student");
				editingDialog.setHeaderText("Enter new GPA of student");
				editingDialog.setContentText("GPA: ");
				Optional<String> result = editingDialog.showAndWait();
				
				if (result.isPresent())
				{
					try
					{
						double tempGpa = Double.parseDouble(result.toString());
						
						if (tempGpa != studentModel.getGpa())
						{
							return tempGpa;
						} else
						{
							alert = new Alert(AlertType.CONFIRMATION);
							alert.setTitle("GPA error");
							alert.setHeaderText(null);
							alert.setContentText("GPA is unchanged. Are you sure?");
							Optional<ButtonType> resultTwo = alert.showAndWait();
							if (resultTwo.get() == ButtonType.OK)
							{
								alert.close();
								editingDialog.close();
							} else
							{
								alert.close();
							}
						}
					} catch (Exception ex)
					{
						alert = new Alert(AlertType.ERROR);
						alert.setTitle("Input Error");
						alert.setHeaderText(null);
						alert.setContentText("Please enter a number");
						alert.showAndWait();
						updateGpaClicked();
					}
				}
				return 0;
			}
			
			@Override
			public void updateCoursesTookClicked()
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void updateCoursesTookOther()
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void updateCoursesTookFailed()
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void updateCoursesTookTaking()
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void saveButtonClicked(SAINeditViewEvent ev)
			{
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	// Get student model method
	public Student getModel()
	{
		// Return student model
		return studentModel;
	}
	
	public MajorBag getMajorBag()
	{
		return majorBag;
	}
	
}
