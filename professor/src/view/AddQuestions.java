package src.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import utils.Question;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.BevelBorder;

public class AddQuestions extends JFrame {

	protected static final String MouseEvent = null;
	private JPanel contentPane;
	private JTextField questionField;
	private JTextField answerField;
	private JTextField option1Field;
	private JTextField option2Field;
	private JTextField option3Field;
	private JTextField option4Field;
	
	// this is the list which has questions..
	ProfMainWindow mwobject = new ProfMainWindow();
	private static ArrayList<Question> questionsList = new ArrayList<Question>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddQuestions frame = new AddQuestions();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddQuestions() {
		getContentPane().setLayout(null);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(490, 50, 900, 950);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Professor Window For Quiz Application");
		setResizable(false);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		
		JLabel lblAddQuestionDetails = new JLabel("Add Question Details Here");
		lblAddQuestionDetails.setFont(new Font("Courier", Font.BOLD, 40));
		lblAddQuestionDetails.setBounds(144, 120, 607, 80);
		lblAddQuestionDetails.setForeground(new Color(255, 255, 255));
		contentPane.add(lblAddQuestionDetails);
		
		JLabel lblOption_1 = new JLabel("Option1");
		lblOption_1.setForeground(new Color(255, 255, 255));
		lblOption_1.setFont(new Font("Monospaced", Font.BOLD, 25));
		lblOption_1.setBounds(144, 317, 125, 38);
		contentPane.add(lblOption_1);
		
		questionField = new JTextField();
		questionField.setBounds(393, 239, 358, 35);
		contentPane.add(questionField);
		questionField.setColumns(10);
		
		option1Field = new JTextField();
		option1Field.setBounds(393, 320, 358, 38);
		contentPane.add(option1Field);
		option1Field.setColumns(10);
		
		option2Field = new JTextField();
		option2Field.setBounds(393, 405, 358, 38);
		contentPane.add(option2Field);
		option2Field.setColumns(10);
		
		option3Field = new JTextField();
		option3Field.setBounds(393, 489, 358, 38);
		contentPane.add(option3Field);
		option3Field.setColumns(10);
		
		option4Field = new JTextField();
		option4Field.setBounds(393, 571, 358, 38);
		contentPane.add(option4Field);
		option4Field.setColumns(10);
		
		answerField = new JTextField();
		answerField.setBounds(393, 648, 358, 38);
		contentPane.add(answerField);
		answerField.setColumns(10);
		
		JButton btnAddMoreQuestions = new JButton("Add Question");
		btnAddMoreQuestions.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnAddMoreQuestions.setFont(new Font("Monospaced", Font.BOLD, 24));
		btnAddMoreQuestions.setForeground(new Color(255, 255, 255));
		btnAddMoreQuestions.setBackground(new Color(129, 207, 224));
		btnAddMoreQuestions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String strQuestionField = questionField.getText();
				String strOption1Field = option1Field.getText();
				String strOption2Field = option1Field.getText();
				String strOption3Field = option1Field.getText();
				String strOption4Field = option1Field.getText();
				String strAnswerField = answerField.getText();
				
				List<String> optionsList = new ArrayList<String>();
				optionsList.add(strOption1Field);
				optionsList.add(strOption2Field);
				optionsList.add(strOption3Field);
				optionsList.add(strOption4Field);
			
				Question q1 =  new Question(strQuestionField, optionsList, strAnswerField);
				
				questionsList.add(q1);
				dispose();
			    new AddQuestions().setVisible(true);
				JOptionPane.showMessageDialog(null,"Question has been successfully Added!","Message", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAddMoreQuestions.setBounds(144, 745, 305, 49);
		contentPane.add(btnAddMoreQuestions);
		
		JButton btnDeleteQuestions = new JButton("Delete Question");
		btnDeleteQuestions.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDeleteQuestions.setFont(new Font("Monospaced", Font.BOLD, 24));
		btnDeleteQuestions.setBackground(new Color(129, 207, 224));
		btnDeleteQuestions.setForeground(new Color(255, 255, 255));
		btnDeleteQuestions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO: actions to be performed on delete button clicked..
				
				// building the current question to be deleted..
				String strQuestionField = questionField.getText();
				String strOption1Field = option1Field.getText();
				String strOption2Field = option1Field.getText();
				String strOption3Field = option1Field.getText();
				String strOption4Field = option1Field.getText();
				String strAnswerField = answerField.getText();
				
				List<String> optionsList = new ArrayList<String>();
				optionsList.add(strOption1Field);
				optionsList.add(strOption2Field);
				optionsList.add(strOption3Field);
				optionsList.add(strOption4Field);
			
				// creating a new question object to be deleted..
				Question q1 =  new Question(strQuestionField, optionsList, strAnswerField);
				
				// removing the question object to arraylist of questions whenever add button is clicked
				if (questionsList != null) {
					questionsList.remove(q1);
				}else {
					System.out.print("You cannot delete as there are no questions left to delete");
				}
							
				// creating temp list of questions.
				//System.out.println("Creating temp list for delete functionality");
				
				List<String> tempQ1Options = new ArrayList<String>();
				tempQ1Options.add("OptionQ1 1");
				tempQ1Options.add("OptionQ1 2");
				tempQ1Options.add("OptionQ1 3");
				tempQ1Options.add("OptionQ1 4");
				
				List<String> tempQ2Options = new ArrayList<String>();
				tempQ2Options.add("OptionQ2 1");
				tempQ2Options.add("OptionQ2 2");
				tempQ2Options.add("OptionQ2 3");
				tempQ2Options.add("OptionQ2 4");

				List<String> tempQ3Options = new ArrayList<String>();
				tempQ2Options.add("OptionQ3 1");
				tempQ2Options.add("OptionQ3 2");
				tempQ2Options.add("OptionQ3 3");
				tempQ2Options.add("OptionQ3 4");
				
				
				//Question q1 = new Question("Ques 1", tempQ1Options, "OptionQ1 2");
				Question q2 = new Question("Ques 2", tempQ2Options, "OptionQ2 4");
				Question q3 = new Question("Ques 3", tempQ3Options, "OptionQ3 3");
				ArrayList<Question> tempList  = new ArrayList<Question>();
				
				//tempList.add(q1);
				tempList.add(q2);
				tempList.add(q3);
				
				for (Question q : tempList) {
					//System.out.println(q.getTitle());
				}
				//System.out.println("After Deleting the selected question.....");
				//System.out.println("Assuming to delete ques2 from the list");
				
				// get quest2
				
				// when delete button is clicked.. delete the question from this templist list
				
				tempList.remove(q2);
				for (Question q : tempList) {
					//System.out.println(q.getTitle());
				}
				
			}
		});
		btnDeleteQuestions.setBounds(459, 745, 292, 49);
		contentPane.add(btnDeleteQuestions);
		
		JLabel label = new JLabel("");
		label.setBounds(509, 704, 46, 14);
		contentPane.add(label);
		
		JLabel lblOption = new JLabel("Option2");
		lblOption.setForeground(new Color(255, 255, 255));
		lblOption.setFont(new Font("Monospaced", Font.BOLD, 25));
		lblOption.setBounds(144, 405, 125, 38);
		contentPane.add(lblOption);
		
		JLabel lblQuestion = new JLabel("Question");
		lblQuestion.setForeground(new Color(255, 255, 255));
		lblQuestion.setFont(new Font("Monospaced", Font.BOLD, 25));
		lblQuestion.setBounds(144, 234, 125, 38);
		contentPane.add(lblQuestion);
		
		JLabel lblOption_2 = new JLabel("Option3");
		lblOption_2.setForeground(new Color(255, 255, 255));
		lblOption_2.setFont(new Font("Monospaced", Font.BOLD, 25));
		lblOption_2.setBounds(144, 486, 125, 38);
		contentPane.add(lblOption_2);
		
		JLabel lblOption_3 = new JLabel("Option4");
		lblOption_3.setForeground(new Color(255, 255, 255));
		lblOption_3.setFont(new Font("Monospaced", Font.BOLD, 25));
		lblOption_3.setBounds(144, 568, 125, 38);
		contentPane.add(lblOption_3);
		
		JLabel lblCorrectAnswer = new JLabel("Correct Answer");
		lblCorrectAnswer.setForeground(new Color(255, 255, 255));
		lblCorrectAnswer.setFont(new Font("Monospaced", Font.BOLD, 25));
		lblCorrectAnswer.setBounds(144, 645, 210, 38);
		contentPane.add(lblCorrectAnswer);
		
		JButton btnNewButton2 = new JButton("  Quiz Desktop Application - Professor Window");
		btnNewButton2.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton2.setFont(new Font("Monospaced", Font.BOLD, 20));
		btnNewButton2.setBackground(new Color(89, 171, 227));
		btnNewButton2.setForeground(new Color(255, 255, 255));
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton2.setBounds(0, 0, 823, 41);
		contentPane.add(btnNewButton2);
		
		JButton btnNewButton_2 = new JButton("X");
		btnNewButton_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(255, 102, 102));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(822, 0, 78, 41);
		contentPane.add(btnNewButton_2);
		
		JButton btnCreateQuizAnd = new JButton("Create Quiz And Exit");
		btnCreateQuizAnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String strQuestionField = questionField.getText();
				String strOption1Field = option1Field.getText();
				String strOption2Field = option1Field.getText();
				String strOption3Field = option1Field.getText();
				String strOption4Field = option1Field.getText();
				String strAnswerField = answerField.getText();
				
				List<String> optionsList = new ArrayList<String>();
				optionsList.add(strOption1Field);
				optionsList.add(strOption2Field);
				optionsList.add(strOption3Field);
				optionsList.add(strOption4Field);
			
				
				Question q1 =  new Question(strQuestionField, optionsList, strAnswerField);
				questionsList.add(q1);
				JOptionPane.showMessageDialog(null,"Quiz has been successfully Created!","Message", JOptionPane.INFORMATION_MESSAGE);
				dispose();	
			}
		});
		btnCreateQuizAnd.setForeground(Color.WHITE);
		btnCreateQuizAnd.setFont(new Font("Monospaced", Font.BOLD, 24));
		btnCreateQuizAnd.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnCreateQuizAnd.setBackground(new Color(129, 207, 224));
		btnCreateQuizAnd.setBounds(144, 810, 607, 49);
		contentPane.add(btnCreateQuizAnd);
		}
}
