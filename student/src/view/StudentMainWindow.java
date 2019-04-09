/* 
Student's quiz selection view
@author Sakshi/Subhradeep 
@version 1.2
@date 04/09/2019
*/

package student.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import student.model.StudentModel;
import student.view.TakeQuiz;
import student.controller.StudentController;

import java.awt.*;
import java.awt.event.ActionListener;

public class StudentMainWindow extends JFrame {

	private String[] choices = { "Select Quiz","Quiz1","Quiz2", "Quiz3","Quiz4","Quiz 5","Quiz 6"};

    private final JComboBox<String> cb = new JComboBox<String>(choices);
	private JButton okBtn = new JButton("OK");

    public StudentMainWindow() {
    	
    	JPanel contentPane = new JPanel();
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(25, 25, 1020, 500);
        setTitle("Student Window For Quiz Application");
        setResizable(false);

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        cb.setVisible(true);
        contentPane.add(cb);
        
        okBtn.setEnabled(false);
        contentPane.add(okBtn);
        
        cb.setFont(new Font("Courier", Font.BOLD, 25));
        cb.setBounds(250, 200, 420, 50);
        cb.setForeground(Color.BLACK);
        cb.setBackground(new Color(51, 204, 204));
        cb.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        okBtn.setFont(new Font("Courier", Font.BOLD, 25));
        okBtn.setBounds(250, 320, 420, 50);
        okBtn.setForeground(Color.BLACK);
        okBtn.setBackground(new Color(51, 204, 204));
        okBtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        okBtn.setEnabled(true);
        contentPane.add(cb);

        JLabel welcomeLabel = new JLabel("Hello Student!");
        welcomeLabel.setFont(new Font("Courier", Font.BOLD, 50));
        welcomeLabel.setBounds(250, 80, 900, 80);
        welcomeLabel.setForeground(Color.BLACK);
        contentPane.add(welcomeLabel);
    }
    
    public String getQuizName(){
        return cb.getSelectedItem().toString();
    }

    public void selectQuizListener(ActionListener listenForOkButton){
    	okBtn.addActionListener(listenForOkButton);
    }
    
    public void displayErrorMessage(String errorMessage){
    	        JOptionPane.showMessageDialog(this, errorMessage);
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run() {
                try {
                    StudentMainWindow frame = new StudentMainWindow();
                    frame.setVisible(true);
                    frame.getContentPane().setBackground(new Color(255, 255, 204));
                    TakeQuiz theView = new TakeQuiz();
                    StudentModel theModel = new StudentModel();
                    StudentController theController = new StudentController(theModel, frame, theView);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
