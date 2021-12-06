import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class RegisterFrame extends JFrame{
	
	JTable regionsTable = new JTable();
	JScrollPane regionScrollPane = new JScrollPane(regionsTable);
	//===
	JTable responsible_personsTable = new JTable();
	JScrollPane responsible_personScrollPane = new JScrollPane(responsible_personsTable);
	//===
	JTable reservoirsTable = new JTable();
	JScrollPane reservoirScrollPane = new JScrollPane(reservoirsTable);
	//===
	JTable searchRegionPersonJTable = new JTable();
	JScrollPane regionpersonJScrollPane = new JScrollPane(searchRegionPersonJTable);
	
	private java.sql.Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	
	private int id=-1;
	
	JTabbedPane tab = new JTabbedPane();
	JPanel regionsPanel = new JPanel();
	JPanel reservoirsPanel = new JPanel();
	JPanel responsiblePersonsPanel = new JPanel();
	JPanel searchRegionPersonPanel = new JPanel();
	
	//създаване на панели 
	//===
	JPanel upRegionsPanel = new JPanel();
	JPanel midRegionsPanel = new JPanel();
	JPanel downRegionsPanel = new JPanel();
	//===
	JPanel upReservoirsPanel = new JPanel();
	JPanel midReservoirsPanel = new JPanel();
	JPanel downReservoirsPanel = new JPanel();
	//===
	JPanel upResposnsiblePersonsPanel = new JPanel();
	JPanel midResposnsiblePersonsPanel = new JPanel();
	JPanel downResposnsiblePersonsPanel = new JPanel();
	
	JPanel upRegionPersonPanel = new JPanel();
	JPanel midRegionPersonPanel = new JPanel();
	JPanel downRegionPersonPanel = new JPanel();
	
	
	//създаване на лайбъл за всяко едно поле от формуляра с цел разяснение към потребителя за попълването
	//===
	JLabel nameRegionLabel = new JLabel("Наименование на областта:");
	JLabel areaRegionLabel = new JLabel("Площ:");
	JLabel populationRegionLabel = new JLabel("Население:");
	//===
	JLabel nameReservoirLabel = new JLabel("Наименование на водоема:");
	JLabel areaReservoirLabel = new JLabel("Площ:");
	JLabel depthReservoirLabel = new JLabel("Дълбочина:");
	JLabel regionReservoirLabel = new JLabel("Област в която се намира водоема:");
	JLabel responsiblePersonReservoirLabel = new JLabel("Отговорник на водоема:");
	//===
	JLabel fnameResponsiblePersonLabel = new JLabel("Име:");
	JLabel lnameResponsiblePersonLabel = new JLabel("Фамилия:");
	JLabel ageResponsiblePersonLabel = new JLabel("Години:");
	JLabel commentResponsiblePersonLabel = new JLabel("Коментар:");
	
	JLabel regionReservoirSearchLabel = new JLabel("Област в която се намира водоема:");
	JLabel responsiblePersonReservoirSearchLabel = new JLabel("Отговорник на водоема:");
	
	JLabel regionReservoirSearchLabelTwo = new JLabel("Област в която се намира водоема:");
	JLabel responsiblePersonReservoirSearchLabelTwo = new JLabel("Отговорник на водоема:");
	
	//създаване на текстовите полета за вземане на вписаните данни от потребителя
	//===
	JTextField nameRegionField = new JTextField();
	JTextField areaRegionField = new JTextField();
	JTextField populationRegionField = new JTextField();

	//===
	JTextField fnameResponsiblePersonField = new JTextField();
	JTextField lnameResponsiblePersonField = new JTextField();
	JTextField ageResponsiblePersonField = new JTextField();
	JTextArea commentResponsiblePersonField = new JTextArea();
	
	
	//===
	JTextField nameReservoirField = new JTextField();
	JTextField areaReservoirField = new JTextField();
	JTextField depthReservoirField = new JTextField();
		
	
	JComboBox<String> regionsComboBox = new JComboBox<String>();		
	
	JComboBox<String> responsiblePersonsComboBox = new JComboBox<String>();
	
	
	JComboBox<String> regionsSearchComboBox = new JComboBox<String>();		
	
	JComboBox<String> responsiblePersonsSearchComboBox = new JComboBox<String>();
	
	//cъздаване на бутоните за прихващане на действие от страна на потребителя
	//===
	JButton addRegionButton = new JButton("Добавяне");
	JButton deleteRegionButton = new JButton("Изтриване");
	JButton editRegionButton = new JButton("Редактиране");
	JButton refreshRegionButton = new JButton("Обновяване");
	JComboBox<String> searchRegionComboBox = new JComboBox<String>();
	JButton searchRegiionButton = new JButton("Търсене");
	//===
	JButton addReservoirButton = new JButton("Добавяне");
	JButton deleteReservoirButton = new JButton("Изтриване");
	JButton editReservoirButton = new JButton("Редактиране");
	JButton refreshReservoirButton = new JButton("Обновяване");
	JComboBox<String> searchReservoirComboBox = new JComboBox<String>();
	JButton searchReservoirButton = new JButton("Търсене");
	
	JComboBox<String> searchRegionReservoirComboBox = new JComboBox<String>();
	JComboBox<String> searchRPersonReservoirComboBox = new JComboBox<String>();
	
	
	//===
	JButton addResponsiblePersonButton = new JButton("Добавяне");
	JButton deleteResponsiblePersonButton = new JButton("Изтриване");
	JButton editResponsiblePersonButton = new JButton("Редактиране");
	JButton refreshResponsiblePersonButton = new JButton("Обновяване");
	JComboBox<String> searchResponsiblePersonComboBox = new JComboBox<String>();
	JButton searchResponsiblePersonButton = new JButton("Търсене");
	
	//===
	
	JButton searchRegionPersonButton = new JButton("Търсене");
	JButton refreshRegionPersonButton = new JButton("Обновяване");
	
	
	public RegisterFrame() {
		//фиксиран размер на рамката
		this.setSize(800, 600);
		
		//стопиране на програмата при затваряне на приложението
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			
		//===============regionsPanel======================
		tab.add(regionsPanel,"Области");
		//използвам grid layout за да разположа компонентите в 3 реда и 1 колона (1-формуляр,2-действия,3-визуализиране в таблицата)
		regionsPanel.setLayout(new GridLayout(3,1));
		
		
		//---------------------upPanel---------------------
			
		//задавам разположението на панела за формуляр да е с 3 реда и 2 колони
		upRegionsPanel.setLayout(new GridLayout(3,2));
		//добавям сега лейбълите и текстовите полета
		upRegionsPanel.add(nameRegionLabel);
		upRegionsPanel.add(nameRegionField);
		upRegionsPanel.add(areaRegionLabel);
		upRegionsPanel.add(areaRegionField);
		upRegionsPanel.add(populationRegionLabel);
		upRegionsPanel.add(populationRegionField);
		
		//добавям и самия панел за да се визуализират всички компоненти в него
		regionsPanel.add(upRegionsPanel);
		
		
		//---------------------midPanel--------------------
		midRegionsPanel.setLayout(new GridLayout(1,6));
		//добавям бутоните
		midRegionsPanel.add(addRegionButton);
		addRegionButton.addActionListener(new AddRegionAction());
		midRegionsPanel.add(deleteRegionButton);
		deleteRegionButton.addActionListener(new DeleteRegionAction());
		midRegionsPanel.add(editRegionButton);
		editRegionButton.addActionListener(new EditRegionsAction());
		midRegionsPanel.add(refreshRegionButton);
		refreshRegionButton.addActionListener(new RefreshRegionsAction());
		midRegionsPanel.add(searchRegionComboBox);
		midRegionsPanel.add(searchRegiionButton);
		DBHelp.fillComboSerachRegions(searchRegionComboBox);
		searchRegiionButton.addActionListener(new SearchRegionAction());
		
		//добавям и самия панел за да се визуализират всички компоненти в него
		regionsPanel.add(midRegionsPanel);
		
		
		//---------------------downPanel-------------------
		
		//добавям и самия панел за да се визуализират всички компоненти в него
		
		regionsPanel.add(downRegionsPanel);
		downRegionsPanel.add(regionScrollPane);
		regionScrollPane.setPreferredSize(new Dimension(750,160));
		regionsTable.setModel(DBHelp.getAllData("REGIONS"));
		regionsTable.addMouseListener(new TableListenerRegions());

		
		
		//=================================================
		
		
		
		//=====================reservoirsPanel=============
		
		tab.add(reservoirsPanel,"Водоеми");
		//използвам grid layout за да разположа компонентите в 3 реда и 1 колона (1-формуляр,2-действия,3-визуализиране в таблицата)
		reservoirsPanel.setLayout(new GridLayout(3,1));
		
		//---------------------upReservoirsPanel---------------------
		
		//задавам разположението на панела за формуляр да е с 3 реда и 2 колони
		upReservoirsPanel.setLayout(new GridLayout(5,2));
				//добавям сега лейбълите и текстовите полета
				upReservoirsPanel.add(nameReservoirLabel);
				upReservoirsPanel.add(nameReservoirField);
				upReservoirsPanel.add(areaReservoirLabel);
				upReservoirsPanel.add(areaReservoirField);
				upReservoirsPanel.add(depthReservoirLabel);
				upReservoirsPanel.add(depthReservoirField);
				
				
				upReservoirsPanel.add(regionReservoirLabel);
				upReservoirsPanel.add(regionsComboBox);
				DBHelp.fillComboRegions(regionsComboBox);
				
				upReservoirsPanel.add(responsiblePersonReservoirLabel);
				upReservoirsPanel.add(responsiblePersonsComboBox);
				DBHelp.fillComboResponsiblePersons(responsiblePersonsComboBox);

				
		//добавям и самия панел за да се визуализират всички компоненти в него
		reservoirsPanel.add(upReservoirsPanel);
				
				
		//---------------------midPanel--------------------
		midReservoirsPanel.setLayout(new GridLayout(1,6));
				//добавям бутоните
				midReservoirsPanel.add(addReservoirButton);
				addReservoirButton.addActionListener(new AddReservoirAction());
				midReservoirsPanel.add(deleteReservoirButton);
				deleteReservoirButton.addActionListener(new DeleteReservoirAction());
				midReservoirsPanel.add(editReservoirButton);
				editReservoirButton.addActionListener(new EditReservoirsAction());
				midReservoirsPanel.add(refreshReservoirButton);
				refreshReservoirButton.addActionListener(new RefreshReservoirsAction());
				midReservoirsPanel.add(searchReservoirComboBox);
				midReservoirsPanel.add(searchReservoirButton);
				DBHelp.fillComboSerachReservoirs(searchReservoirComboBox);
				searchReservoirButton.addActionListener(new SearchReservoirsAction());
				
				
				
		//добавям и самия панел за да се визуализират всички компоненти в него
		reservoirsPanel.add(midReservoirsPanel);
				
				
		//---------------------downPanel-------------------
		reservoirsPanel.add(downReservoirsPanel);
		downReservoirsPanel.add(reservoirScrollPane);
		reservoirScrollPane.setPreferredSize(new Dimension(750,160));
		reservoirsTable.setModel(DBHelp.getAllData("RESERVOIRS"));
		reservoirsTable.addMouseListener(new TableListenerReservoirs());
		
				
				
		//добавям и самия панел за да се визуализират всички компоненти в него
		reservoirsPanel.add(downReservoirsPanel);
		
		//=================================================
		
		
		
		//=====================responsiblePersonsPanel=============
		
		tab.add(responsiblePersonsPanel,"Отговорници");
		//използвам grid layout за да разположа компонентите в 3 реда и 1 колона (1-формуляр,2-действия,3-визуализиране в таблицата)
		responsiblePersonsPanel.setLayout(new GridLayout(3,1));
				
		
		//---------------------upResponsiblePeoplesPanel---------------------
		
		//задавам разположението на панела за формуляр да е с 3 реда и 2 колони
		upResposnsiblePersonsPanel.setLayout(new GridLayout(4,2));
		//добавям сега лейбълите и текстовите полета
				upResposnsiblePersonsPanel.add(fnameResponsiblePersonLabel);
				upResposnsiblePersonsPanel.add(fnameResponsiblePersonField);
				upResposnsiblePersonsPanel.add(lnameResponsiblePersonLabel);
				upResposnsiblePersonsPanel.add(lnameResponsiblePersonField);
				upResposnsiblePersonsPanel.add(ageResponsiblePersonLabel);
				upResposnsiblePersonsPanel.add(ageResponsiblePersonField);
				upResposnsiblePersonsPanel.add(commentResponsiblePersonLabel);
				upResposnsiblePersonsPanel.add(commentResponsiblePersonField);
				
		//добавям и самия панел за да се визуализират всички компоненти в него
		responsiblePersonsPanel.add(upResposnsiblePersonsPanel);
				
				
		//---------------------midPanel--------------------

		midResposnsiblePersonsPanel.setLayout(new GridLayout(1,6));
		//добавям бутоните

				midResposnsiblePersonsPanel.add(addResponsiblePersonButton);
				addResponsiblePersonButton.addActionListener(new AddResponsiblePersonAction());
				midResposnsiblePersonsPanel.add(deleteResponsiblePersonButton);
				deleteResponsiblePersonButton.addActionListener(new DeleteResponsiblePersonAction());
				midResposnsiblePersonsPanel.add(editResponsiblePersonButton);
				editResponsiblePersonButton.addActionListener(new EditResponsiblePersonsAction());
				midResposnsiblePersonsPanel.add(refreshResponsiblePersonButton);
				refreshResponsiblePersonButton.addActionListener(new RefreshResponsiblePersonsAction());
				midResposnsiblePersonsPanel.add(searchResponsiblePersonComboBox);
				midResposnsiblePersonsPanel.add(searchResponsiblePersonButton);
				DBHelp.fillComboSerachResponsiblePerson(searchResponsiblePersonComboBox);
				searchResponsiblePersonButton.addActionListener(new SearchResponsiblePersonsAction());
				
		//добавям и самия панел за да се визуализират всички компоненти в него
		responsiblePersonsPanel.add(midResposnsiblePersonsPanel);
				
				
		//---------------------downPanel-------------------
				
				
				
		//добавям и самия панел за да се визуализират всички компоненти в него
				responsiblePersonsPanel.add(downResposnsiblePersonsPanel);
				
				downResposnsiblePersonsPanel.add(responsible_personScrollPane);
				responsible_personScrollPane.setPreferredSize(new Dimension(750,160));
				responsible_personsTable.setModel(DBHelp.getAllData("RESPONSIBLE_PERSONS"));
				responsible_personsTable.addMouseListener(new TableListenerResponsiblePersons());
				
		//=================================================
		
				
		//===============regionsPersonPanel======================
				tab.add(searchRegionPersonPanel,"Търсене");
				//използвам grid layout за да разположа компонентите в 3 реда и 1 колона (1-формуляр,2-действия,3-визуализиране в таблицата)
				searchRegionPersonPanel.setLayout(new GridLayout(3,1));
					
					
				//---------------------upPanel---------------------
						
				//задавам разположението на панела за формуляр да е с 3 реда и 2 колони
				upRegionPersonPanel.setLayout(new GridLayout(3,2));
				//добавям сега лейбълите и текстовите полета
				upRegionPersonPanel.add(regionReservoirSearchLabelTwo);
				upRegionPersonPanel.add(regionsSearchComboBox);
				DBHelp.fillComboRegions(regionsSearchComboBox);
				upRegionPersonPanel.add(responsiblePersonReservoirSearchLabelTwo);
				upRegionPersonPanel.add(responsiblePersonsSearchComboBox);
				DBHelp.fillComboResponsiblePersons(responsiblePersonsSearchComboBox);
					
					
				//добавям и самия панел за да се визуализират всички компоненти в него
				searchRegionPersonPanel.add(upRegionPersonPanel);
					
				//---------------------midPanel--------------------
				midRegionPersonPanel.setLayout(new GridLayout(1,2));
				
				DBHelp.fillComboRegions(regionsSearchComboBox);
				DBHelp.fillComboResponsiblePersons(responsiblePersonsSearchComboBox);
				midRegionPersonPanel.add(searchRegionPersonButton);
				searchRegionPersonButton.addActionListener(new SearchRegionPersonAction());
				midRegionPersonPanel.add(refreshRegionPersonButton);
				refreshRegionPersonButton.addActionListener(new RefreshRegionPersonAction());
				
				searchRegionPersonPanel.add(midRegionPersonPanel);
				
				//---------------------downPanel-------------------
					
				//добавям и самия панел за да се визуализират всички компоненти в него
					
				
				downRegionPersonPanel.add(regionpersonJScrollPane);
				regionpersonJScrollPane.setPreferredSize(new Dimension(750,160));
				searchRegionPersonJTable.setModel(DBHelp.getAllData("RESERVOIRS"));
				searchRegionPersonJTable.addMouseListener(new TableListenerSearchRegionPersons());
				
				searchRegionPersonPanel.add(downRegionPersonPanel);
				
				
				
				//=================================================
					
					
				
				
		this.add(tab);
		//винаги долу (видимост на рамката)
		this.setVisible(true);
	}
	
	//метод за зачистване на полетата
	public void clearRegionForm() {
		
		nameRegionField.setText("");
		areaRegionField.setText("");
		populationRegionField.setText("");
		
	}
	public void clearReservoirForm() {
		
		nameReservoirField.setText("");
		areaReservoirField.setText("");
		depthReservoirField.setText("");
		
	}
	public void clearResponsiblePersonForm() {
		
		fnameResponsiblePersonField.setText("");
		lnameResponsiblePersonField.setText("");
		ageResponsiblePersonField.setText("");
		commentResponsiblePersonField.setText("");
		
	}
	

	
	class TableListenerRegions implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			int row = regionsTable.getSelectedRow();
			id = Integer.parseInt(regionsTable.getValueAt(row, 0).toString());	
			if(e.getClickCount()>1) {
				nameRegionField.setText(regionsTable.getValueAt(row, 1).toString());
				areaRegionField.setText(regionsTable.getValueAt(row, 2).toString());
				populationRegionField.setText(regionsTable.getValueAt(row, 3).toString());
				}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class DeleteRegionAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			connection = DBHelp.getConnection();
			try {
				statement = connection.prepareStatement("DELETE FROM REGIONS WHERE REGION_ID=?");
				statement.setInt(1, id);
				statement.execute();
				regionsTable.setModel(DBHelp.getAllData("REGIONS"));
				DBHelp.fillComboRegions(regionsComboBox);
				DBHelp.fillComboSerachRegions(searchRegionComboBox);
				DBHelp.fillComboRegions(searchRegionReservoirComboBox);
				DBHelp.fillComboRegions(regionsSearchComboBox);
				
				id = -1;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
	
	class AddRegionAction implements ActionListener{	
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String REGION_NAME = nameRegionField.getText();
			float REGION_AREA= Float.parseFloat(areaRegionField.getText());
			int REGION_POPULATION = Integer.parseInt(populationRegionField.getText());
			
			
			connection=DBHelp.getConnection();
			try {
				statement = connection.prepareStatement("INSERT INTO REGIONS VALUES(null,?,?,?);");
				statement.setString(1, REGION_NAME);
				statement.setFloat(2, REGION_AREA);
				statement.setInt(3, REGION_POPULATION);
				
				statement.execute();
				
				regionsTable.setModel(DBHelp.getAllData("REGIONS"));
				DBHelp.fillComboRegions(regionsComboBox);
				DBHelp.fillComboSerachRegions(searchRegionComboBox);
				DBHelp.fillComboRegions(searchRegionReservoirComboBox);
				DBHelp.fillComboRegions(regionsSearchComboBox);
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			clearRegionForm();
		}
		
	}
	class RefreshRegionsAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			regionsTable.setModel(DBHelp.getAllData("REGIONS"));
		}
		
	}
	
	class SearchRegionAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String itemString = searchRegionComboBox.getSelectedItem().toString();
			String[] contentStrings = itemString.split(" ");
			int REGION_ID=Integer.parseInt(contentStrings[0]);
			
			connection=DBHelp.getConnection();
			String sql="SELECT * FROM REGIONS WHERE REGION_ID=?";
			try {
				statement=connection.prepareStatement(sql);
				statement.setInt(1, REGION_ID);
				resultSet=statement.executeQuery();
				regionsTable.setModel(new MyModel(resultSet));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	class EditRegionsAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String REGION_NAME = nameRegionField.getText();
			float REGION_AREA= Float.parseFloat(areaRegionField.getText());
			int REGION_POPULATION = Integer.parseInt(populationRegionField.getText());

			
			String sql="UPDATE REGIONS SET REGION_NAME=?, REGION_AREA=?, REGION_POPULATION=? WHERE REGION_ID=?;";
			connection = DBHelp.getConnection();
			
			try {
				statement = connection.prepareStatement(sql);
				
				statement.setString(1, REGION_NAME);
				statement.setFloat(2, REGION_AREA);
				statement.setInt(3, REGION_POPULATION);
				statement.setInt(4, id);
				
				statement.executeUpdate();
				id=-1;
				regionsTable.setModel(DBHelp.getAllData("REGIONS"));
				DBHelp.fillComboRegions(regionsComboBox);
				DBHelp.fillComboSerachRegions(searchRegionComboBox);

				clearRegionForm();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}
	

	
	class TableListenerReservoirs implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			int row = reservoirsTable.getSelectedRow();
			id = Integer.parseInt(reservoirsTable.getValueAt(row, 0).toString());
			
			if(e.getClickCount()>1) {
				nameReservoirField.setText(reservoirsTable.getValueAt(row, 1).toString());
				areaReservoirField.setText(reservoirsTable.getValueAt(row, 2).toString());
				depthReservoirField.setText(reservoirsTable.getValueAt(row, 3).toString());
				if(reservoirsTable.getValueAt(row, 4).toString() != null) {
					regionsComboBox.setSelectedIndex(row);
				}
				if(reservoirsTable.getValueAt(row, 5).toString() != null) {
					responsiblePersonsComboBox.setSelectedIndex(row);
				}
			}
	
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class DeleteReservoirAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			connection = DBHelp.getConnection();
			try {
				statement = connection.prepareStatement("DELETE FROM RESERVOIRS WHERE RESERVOIR_ID=?");
				statement.setInt(1, id);
				statement.execute();
				reservoirsTable.setModel(DBHelp.getAllData("RESERVOIRS"));
				DBHelp.fillComboSerachReservoirs(searchReservoirComboBox);
				id = -1;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
	
	class AddReservoirAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String RESERVOIR_NAME = nameReservoirField.getText();
			float RESERVOIR_AREA=  Float.parseFloat(areaReservoirField.getText());
			float RESERVOIR_DEPTH1 = Float.parseFloat(depthReservoirField.getText());
				
			String REGION_ID = regionsComboBox.getSelectedItem().toString();
			String RESPONSIBLE_PERSON_ID = responsiblePersonsComboBox.getSelectedItem().toString();
			
			
			connection=DBHelp.getConnection();
			try {
				statement=connection.prepareStatement("INSERT INTO RESERVOIRS VALUES(null,?,?,?,?,?);");
				statement.setString(1, RESERVOIR_NAME);
				statement.setFloat(2, RESERVOIR_AREA);
				statement.setFloat(3, RESERVOIR_DEPTH1);
				statement.setString(4, REGION_ID);
				statement.setString(5, RESPONSIBLE_PERSON_ID);
				
				statement.execute();
				reservoirsTable.setModel(DBHelp.getAllData("RESERVOIRS"));
				DBHelp.fillComboSerachReservoirs(searchReservoirComboBox);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			clearReservoirForm();
		}
		
	}
	class RefreshReservoirsAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			reservoirsTable.setModel(DBHelp.getAllData("RESERVOIRS"));
		}
		
	}
	
	class SearchReservoirsAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String itemString = searchReservoirComboBox.getSelectedItem().toString();
			String[] contentStrings = itemString.split(" ");
			int RESERVOIR_ID=Integer.parseInt(contentStrings[0]);
			
			connection=DBHelp.getConnection();
			String sql="SELECT * FROM RESERVOIRS WHERE RESERVOIR_ID=?";
			try {
				statement=connection.prepareStatement(sql);
				statement.setInt(1, RESERVOIR_ID);
				resultSet=statement.executeQuery();
				reservoirsTable.setModel(new MyModel(resultSet));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	class EditReservoirsAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String RESERVOIR_NAME = nameReservoirField.getText();
			float RESERVOIR_AREA=  Float.parseFloat(areaReservoirField.getText());
			float RESERVOIR_DEPTH = Float.parseFloat(depthReservoirField.getText());
				
			String REGION_NAME = regionsComboBox.getSelectedItem().toString();
			String RESPONSIBLE_PERSON_NAME = responsiblePersonsComboBox.getSelectedItem().toString();
			
			String sql1="SELECT REGION_NAME,RESPONSIBLE_PERSON_NAME FROM RESERVOIRS WHERE RESERVOIR_ID=?;";
			
			String sql3="UPDATE RESERVOIRS SET RESERVOIR_NAME = ?, RESERVOIR_AREA = ?,"
					+ " RESERVOIR_DEPTH = ?,REGION_NAME=? ,RESPONSIBLE_PERSON_NAME=? WHERE RESERVOIR_ID=?;";
			connection = DBHelp.getConnection();
			
			
			
			
			try {
				statement = connection.prepareStatement(sql1);
				statement = connection.prepareStatement(sql3);
				statement.setString(1, RESERVOIR_NAME);
				statement.setFloat(2, RESERVOIR_AREA);
				statement.setFloat(3, RESERVOIR_DEPTH);
				statement.setString(4, REGION_NAME);
				statement.setString(5, RESPONSIBLE_PERSON_NAME);
				statement.setInt(6, id);

				statement.executeUpdate();
				id=-1;
				reservoirsTable.setModel(DBHelp.getAllData("RESERVOIRS"));
				DBHelp.fillComboRegions(regionsComboBox);
				DBHelp.fillComboResponsiblePersons(responsiblePersonsComboBox);
				DBHelp.fillComboSerachReservoirs(searchReservoirComboBox);
				clearReservoirForm();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}

	
	class TableListenerResponsiblePersons implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			int row = responsible_personsTable.getSelectedRow();
			id = Integer.parseInt(responsible_personsTable.getValueAt(row, 0).toString());
			
			if(e.getClickCount()>1) {
				fnameResponsiblePersonField.setText(responsible_personsTable.getValueAt(row, 1).toString());
				lnameResponsiblePersonField.setText(responsible_personsTable.getValueAt(row, 2).toString());
				ageResponsiblePersonField.setText(responsible_personsTable.getValueAt(row, 3).toString());
				commentResponsiblePersonField.setText(responsible_personsTable.getValueAt(row, 4).toString());
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class DeleteResponsiblePersonAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			connection = DBHelp.getConnection();
			try {
				statement = connection.prepareStatement("DELETE FROM RESPONSIBLE_PERSONS WHERE RESPONSIBLE_PERSON_ID=?");
				statement.setInt(1, id);
				statement.execute();
				responsible_personsTable.setModel(DBHelp.getAllData("RESPONSIBLE_PERSONS"));
				DBHelp.fillComboResponsiblePersons(responsiblePersonsComboBox);
				DBHelp.fillComboSerachResponsiblePerson(searchResponsiblePersonComboBox);
				DBHelp.fillComboResponsiblePersons(searchRPersonReservoirComboBox);
				DBHelp.fillComboResponsiblePersons(responsiblePersonsSearchComboBox);
				id = -1;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
	
	class AddResponsiblePersonAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String RESPONSIBLE_PERSON_FNAME = fnameResponsiblePersonField.getText();
			String RESPONSIBLE_PERSON_LNAME = lnameResponsiblePersonField.getText();
			byte RESPONSIBLE_PERSON_AGE = Byte.parseByte(ageResponsiblePersonField.getText());
			String RESPONSIBLE_PERSON_COMMENT = commentResponsiblePersonField.getText();
					
			connection = DBHelp.getConnection();
			try {
				statement = connection.prepareStatement("INSERT INTO RESPONSIBLE_PERSONS VALUES(null,?,?,?,?);");
				statement.setString(1, RESPONSIBLE_PERSON_FNAME);
				statement.setString(2, RESPONSIBLE_PERSON_LNAME);
				statement.setByte(3, RESPONSIBLE_PERSON_AGE);
				statement.setString(4, RESPONSIBLE_PERSON_COMMENT);
				statement.execute();
				
				responsible_personsTable.setModel(DBHelp.getAllData("RESPONSIBLE_PERSONS"));
				DBHelp.fillComboResponsiblePersons(responsiblePersonsComboBox);
				DBHelp.fillComboSerachResponsiblePerson(searchResponsiblePersonComboBox);
				DBHelp.fillComboResponsiblePersons(searchRPersonReservoirComboBox);
				DBHelp.fillComboResponsiblePersons(responsiblePersonsSearchComboBox);
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			clearResponsiblePersonForm();
		}
		
	}
	class RefreshResponsiblePersonsAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			responsible_personsTable.setModel(DBHelp.getAllData("RESPONSIBLE_PERSONS"));
		}
		
	}
	
	class SearchResponsiblePersonsAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String itemString = searchResponsiblePersonComboBox.getSelectedItem().toString();
			String[] contentStrings = itemString.split(" ");
			int PERSON_ID=Integer.parseInt(contentStrings[0]);
			
			connection=DBHelp.getConnection();
			String sql="SELECT * FROM RESPONSIBLE_PERSONS WHERE RESPONSIBLE_PERSON_ID=?";
			try {
				statement=connection.prepareStatement(sql);
				statement.setInt(1, PERSON_ID);
				resultSet=statement.executeQuery();
				responsible_personsTable.setModel(new MyModel(resultSet));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	
	}
	
	class EditResponsiblePersonsAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String RESPONSIBLE_PERSON_FNAME = fnameResponsiblePersonField.getText();
			String RESPONSIBLE_PERSON_LNAME = lnameResponsiblePersonField.getText();
			byte RESPONSIBLE_PERSON_AGE = Byte.parseByte(ageResponsiblePersonField.getText());
			String RESPONSIBLE_PERSON_COMMENT = commentResponsiblePersonField.getText();
			
			String sql="UPDATE RESPONSIBLE_PERSONS SET RESPONSIBLE_PERSON_FNAME = ?, RESPONSIBLE_PERSON_LNAME = ?,"
					+ " RESPONSIBLE_PERSON_AGE = ?, RESPONSIBLE_PERSON_COMMENT = ? WHERE RESPONSIBLE_PERSON_ID=?;";
			connection = DBHelp.getConnection();
			
			
			try {
				statement = connection.prepareStatement(sql);
				statement.setString(1, RESPONSIBLE_PERSON_FNAME);
				statement.setString(2, RESPONSIBLE_PERSON_LNAME);
				statement.setByte(3, RESPONSIBLE_PERSON_AGE);
				statement.setString(4, RESPONSIBLE_PERSON_COMMENT);
				statement.setInt(5, id);

				statement.executeUpdate();
				id=-1;
				responsible_personsTable.setModel(DBHelp.getAllData("RESPONSIBLE_PERSONS"));
				DBHelp.fillComboResponsiblePersons(responsiblePersonsComboBox);
				DBHelp.fillComboSerachResponsiblePerson(searchResponsiblePersonComboBox);
				//DBHelp.fillComboResponsiblePersonsReservoirs(searchRPersonReservoirComboBox);
				clearResponsiblePersonForm();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		
		}
	}
	
	
	class TableListenerSearchRegionPersons implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			int row = searchRegionPersonJTable.getSelectedRow();
			id = Integer.parseInt(searchRegionPersonJTable.getValueAt(row, 0).toString());
	
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		
		
	}
	
	class RefreshRegionPersonAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			searchRegionPersonJTable.setModel(DBHelp.getAllData("RESPONSIBLE_PERSONS"));
		}
		
	}
	
	class SearchRegionPersonAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String REGION_NAME = regionsSearchComboBox.getSelectedItem().toString();
			String RESPONSIBLE_PERSON_NAME = responsiblePersonsSearchComboBox.getSelectedItem().toString();
			
			connection=DBHelp.getConnection();
			String sql="SELECT * FROM RESERVOIRS WHERE REGION_NAME =? AND RESPONSIBLE_PERSON_NAME=?";
			try {
				statement=connection.prepareStatement(sql);
				
				statement.setString(1, REGION_NAME);
				statement.setString(2, RESPONSIBLE_PERSON_NAME);
				resultSet=statement.executeQuery();
				searchRegionPersonJTable.setModel(new MyModel(resultSet));
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	
	      
}

//мейнджър на разположение Grid Layout разпределя ги на редове и колони 1 клетка -> 1 компонент освен ако не добавим панел в него може да слагаме няколко елемента(той е като фрейма но няма бутони за изход минимализиране...)


//мейнджър на разположение Flow Layout за позициониране на компоненти центрира ги горе посредата когато се запълни реда минава на следващ
//мейнджър на разположение Border Layout разделя на 5 части в 1 клетка -> 1 компонент освен ако не добавим панел в него може да слагаме няколко елемента(той е като фрейма но няма бутони за изход минимализиране...)
//мейнджър на разположение Grid Bag Layout площа се дели на клетки редове и колони като обекта може да се разполага навсякъде из кледката както и да се шири и към други клетки
//мейнджър на разположение Card Layout имаме един панел с информация ->Next ->друг панел с информация
