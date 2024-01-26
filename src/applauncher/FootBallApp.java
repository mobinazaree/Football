package applauncher;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;



public class FootballApp extends JFrame{
    
    private JSONArray leagueData;
    
    public FootballApp() {
        
	super("footBall app");
		
	setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	setSize(600,950);
		
	setLocationRelativeTo(null);
		
        setLayout(null);
		
	setResizable(false);
        
        getContentPane().setBackground(new Color(255, 186, 98));
		
	addGuiComponents();
	}   
	

    private void addGuiComponents(){
        
        // set main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255, 186, 98));
        mainPanel.setLayout(new GridLayout(0, 1,10,10));
        add(mainPanel);
        
        // set scroll for panel
        JScrollPane scroll = new JScrollPane(mainPanel);
        scroll.setBounds(40, 200, 510, 670);
        getContentPane().add(scroll);
        

        // button for Italy
        JButton italyBtn = new JButton("Italy");
        italyBtn.setBounds(40, 30, 150, 40);
        italyBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));			
        italyBtn.setFont(new Font("Arial", Font.BOLD, 14));
        
        italyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                // remove all components form main panel
                mainPanel.removeAll();
                
                // get league Data
                leagueData = FootballAppAPI.getLeagueData("italy");
                
                for (Object object : leagueData) {
                    
                    JSONObject fixtureObject = (JSONObject) object;
                    
                    // get fixture,league,team,goals
                    JSONObject fixture = (JSONObject) fixtureObject.get("fixture");
                    JSONObject league = (JSONObject) fixtureObject.get("league"); 
                    JSONObject teams = (JSONObject) fixtureObject.get("teams"); 
                    JSONObject goals = (JSONObject) fixtureObject.get("goals");

                    // get home and away
                    JSONObject homeTeam = (JSONObject) teams.get("home");
                    JSONObject awayTeam = (JSONObject) teams.get("away");

                    // add row panel
                    JPanel rowPanel = new JPanel();
                    rowPanel.setLayout(null);
                    rowPanel.setPreferredSize(new Dimension(200, 150));
                    rowPanel.setBackground(Color.white);
                    mainPanel.add(rowPanel);

                    // add date
                    JLabel dateLabel = new JLabel((String)fixture.get("date"));
                    dateLabel.setFont(new Font("Arial", Font.PLAIN, 12));
                    dateLabel.setBounds(180, 30, 300, 50); 
                    rowPanel.add(dateLabel);

                    // add home name
                    JLabel homeNameLabel = new JLabel((String)homeTeam.get("name"));
                    homeNameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
                    homeNameLabel.setBounds(50, 80, 250, 50);
                    rowPanel.add(homeNameLabel);

                    // add home goals
                    JLabel homeGoalsLabel = new JLabel(String.valueOf((Long)goals.get("home")));
                    homeGoalsLabel.setFont(new Font("Arial", Font.BOLD, 21));
                    homeGoalsLabel.setBounds(230, 80, 30, 50);
                    rowPanel.add(homeGoalsLabel);

                    // add away goals
                    JLabel awayGoalsLabel = new JLabel(String.valueOf((Long)goals.get("away")));
                    awayGoalsLabel.setFont(new Font("Arial", Font.BOLD, 21));
                    awayGoalsLabel.setBounds(270, 80, 30, 50);
                    rowPanel.add(awayGoalsLabel); 

                    // add away name
                    JLabel awayNameLabel = new JLabel((String)awayTeam.get("name"));
                    awayNameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
                    awayNameLabel.setBounds(350, 80, 180, 50); 
                    rowPanel.add(awayNameLabel);

                    // add round
                    JLabel roundLabel = new JLabel((String)league.get("round"));
                    roundLabel.setFont(new Font("Arial", Font.PLAIN, 12));
                    roundLabel.setBounds(210, 1, 200, 50);  
                    rowPanel.add(roundLabel);

                    // reset
                    mainPanel.revalidate();
                    mainPanel.repaint();
                }           
            }          
        }); 
        add(italyBtn);
        // button for Germany
           JButton germanyBtn = new JButton("germany");      
           germanyBtn.setBounds(220, 30, 150, 40);
           germanyBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));			
           germanyBtn.setFont(new Font("Arial", Font.BOLD, 14));
           
           germanyBtn.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   
                   // remove all components form main panel
                   mainPanel.removeAll();
                   
                   // get league Data
                   leagueData = FootballAppAPI.getLeagueData("germany");
                   
                   for (Object object : leagueData) {
                       
                       JSONObject fixtureObject = (JSONObject) object;
                       
                       // get fixture,league,team,goals
                       JSONObject fixture = (JSONObject) fixtureObject.get("fixture");
                       JSONObject league = (JSONObject) fixtureObject.get("league"); 
                       JSONObject teams = (JSONObject) fixtureObject.get("teams"); 
                       JSONObject goals = (JSONObject) fixtureObject.get("goals");

                       // get home and away
                       JSONObject homeTeam = (JSONObject) teams.get("home");
                       JSONObject awayTeam = (JSONObject) teams.get("away");

                       // add row panel
                       JPanel rowPanel = new JPanel();
                       rowPanel.setLayout(null);
                       rowPanel.setPreferredSize(new Dimension(200, 150));
                       rowPanel.setBackground(Color.white);
                       mainPanel.add(rowPanel);

                       // add date
                       JLabel dateLabel = new JLabel((String)fixture.get("date"));
                       dateLabel.setFont(new Font("Arial", Font.PLAIN, 12));
                       dateLabel.setBounds(180, 30, 300, 50); 
                       rowPanel.add(dateLabel);

                       // add home name
                       JLabel homeNameLabel = new JLabel((String)homeTeam.get("name"));
                       homeNameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
                       homeNameLabel.setBounds(50, 80, 250, 50);
                       rowPanel.add(homeNameLabel);

                       // add home goals
                       JLabel homeGoalsLabel = new JLabel(String.valueOf((Long)goals.get("home")));
                       homeGoalsLabel.setFont(new Font("Arial", Font.BOLD, 21));
                       homeGoalsLabel.setBounds(230, 80, 30, 50);
                       rowPanel.add(homeGoalsLabel);

                       // add away goals
                       JLabel awayGoalsLabel = new JLabel(String.valueOf((Long)goals.get("away")));
                       awayGoalsLabel.setFont(new Font("Arial", Font.BOLD, 21));
                       awayGoalsLabel.setBounds(270, 80, 30, 50);
                       rowPanel.add(awayGoalsLabel); 

                       // add away name
                       JLabel awayNameLabel = new JLabel((String)awayTeam.get("name"));
                       awayNameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
                       awayNameLabel.setBounds(350, 80, 180, 50); 
                       rowPanel.add(awayNameLabel);

                       // add round
                       JLabel roundLabel = new JLabel((String)league.get("round"));
                       roundLabel.setFont(new Font("Arial", Font.PLAIN, 12));
                       roundLabel.setBounds(210, 1, 200, 50);  
                       rowPanel.add(roundLabel);

                       // reset
                       mainPanel.revalidate();
                       mainPanel.repaint();
                   }           
               }          
           });
           add(germanyBtn);
           

           // button for Iran
           JButton iranBtn = new JButton("Iran"); 
           iranBtn.setBounds(400, 30, 150, 40);
           iranBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));			
           iranBtn.setFont(new Font("Arial", Font.BOLD, 14));
           
           iranBtn.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   
                   // remove all components form main panel
                   mainPanel.removeAll();
                   
                   // get league Data
                   leagueData = FootballAppAPI.getLeagueData("iran");
                   
                   for (Object object : leagueData) {
                       
                       JSONObject fixtureObject = (JSONObject) object;
                       
                       // get fixture,league,team,goals
                       JSONObject fixture = (JSONObject) fixtureObject.get("fixture");
                       JSONObject league = (JSONObject) fixtureObject.get("league"); 
                       JSONObject teams = (JSONObject) fixtureObject.get("teams"); 
                       JSONObject goals = (JSONObject) fixtureObject.get("goals");

                       // get home and away
                       JSONObject homeTeam = (JSONObject) teams.get("home");
                       JSONObject awayTeam = (JSONObject) teams.get("away");

                       // add row panel
                       JPanel rowPanel = new JPanel();
                       rowPanel.setLayout(null);
                       rowPanel.setPreferredSize(new Dimension(200, 150));
                       rowPanel.setBackground(Color.white);
                       mainPanel.add(rowPanel);

                       // add date
                       JLabel dateLabel = new JLabel((String)fixture.get("date"));
                       dateLabel.setFont(new Font("Arial", Font.PLAIN, 12));
                       dateLabel.setBounds(180, 30, 300, 50); 
                       rowPanel.add(dateLabel);

                       // add home name
                       JLabel homeNameLabel = new JLabel((String)homeTeam.get("name"));
                       homeNameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
                       homeNameLabel.setBounds(50, 80, 250, 50);
                       rowPanel.add(homeNameLabel);

                       // add home goals
                       JLabel homeGoalsLabel = new JLabel(String.valueOf((Long)goals.get("home")));
                       homeGoalsLabel.setFont(new Font("Arial", Font.BOLD, 21));
                       homeGoalsLabel.setBounds(230, 80, 30, 50);
                       rowPanel.add(homeGoalsLabel);

                       // add away goals
                       JLabel awayGoalsLabel = new JLabel(String.valueOf((Long)goals.get("away")));
                       awayGoalsLabel.setFont(new Font("Arial", Font.BOLD, 21));
                       awayGoalsLabel.setBounds(270, 80, 30, 50);
                       rowPanel.add(awayGoalsLabel); 

                       // add away name
                       JLabel awayNameLabel = new JLabel((String)awayTeam.get("name"));
                       awayNameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
                       awayNameLabel.setBounds(350, 80, 180, 50); 
                       rowPanel.add(awayNameLabel);

                       // add round
                       JLabel roundLabel = new JLabel((String)league.get("round"));
                       roundLabel.setFont(new Font("Arial", Font.PLAIN, 12));
                       roundLabel.setBounds(210, 1, 200, 50);  
                       rowPanel.add(roundLabel);

                       // reset
                       mainPanel.revalidate();
                       mainPanel.repaint();
                   }           
               }          
           });
           add(iranBtn);
           
           
           // button for Spain
           JButton spainBtn = new JButton("Spain");
           spainBtn.setBounds(40, 80, 150, 40);
           spainBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));			
           spainBtn.setFont(new Font("Arial", Font.BOLD, 14));
           
           spainBtn.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   
                   // remove all components form main panel
                   mainPanel.removeAll();
                   
                   // get league Data
                   leagueData = FootballAppAPI.getLeagueData("spain");
                   
                   for (Object object : leagueData) {
                       
                       JSONObject fixtureObject = (JSONObject) object;
                       
                       // get fixture,league,team,goals
                       JSONObject fixture = (JSONObject) fixtureObject.get("fixture");
                       JSONObject league = (JSONObject) fixtureObject.get("league"); 
                       JSONObject teams = (JSONObject) fixtureObject.get("teams"); 
                       JSONObject goals = (JSONObject) fixtureObject.get("goals");

                       // get home and away
                       JSONObject homeTeam = (JSONObject) teams.get("home");
                       JSONObject awayTeam = (JSONObject) teams.get("away");

                       // add row panel
                       JPanel rowPanel = new JPanel();
                       rowPanel.setLayout(null);
                       rowPanel.setPreferredSize(new Dimension(200, 150));
                       rowPanel.setBackground(Color.white);
                       mainPanel.add(rowPanel);

                       // add date
                       JLabel dateLabel = new JLabel((String)fixture.get("date"));
                       dateLabel.setFont(new Font("Arial", Font.PLAIN, 12));
                       dateLabel.setBounds(180, 30, 300, 50); 
                       rowPanel.add(dateLabel);

                       // add home name
                       JLabel homeNameLabel = new JLabel((String)homeTeam.get("name"));
                       homeNameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
                       homeNameLabel.setBounds(50, 80, 250, 50);
                       rowPanel.add(homeNameLabel);

                       // add home goals
                       JLabel homeGoalsLabel = new JLabel(String.valueOf((Long)goals.get("home")));
                       homeGoalsLabel.setFont(new Font("Arial", Font.BOLD, 21));
                       homeGoalsLabel.setBounds(230, 80, 30, 50);
                       rowPanel.add(homeGoalsLabel);

                       // add away goals
                       JLabel awayGoalsLabel = new JLabel(String.valueOf((Long)goals.get("away")));
                       awayGoalsLabel.setFont(new Font("Arial", Font.BOLD, 21));
                       awayGoalsLabel.setBounds(270, 80, 30, 50);
                       rowPanel.add(awayGoalsLabel); 

                       // add away name
                       JLabel awayNameLabel = new JLabel((String)awayTeam.get("name"));
                       awayNameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
                       awayNameLabel.setBounds(350, 80, 180, 50); 
                       rowPanel.add(awayNameLabel);

                       // add round
                       JLabel roundLabel = new JLabel((String)league.get("round"));
                       roundLabel.setFont(new Font("Arial", Font.PLAIN, 12));
                       roundLabel.setBounds(210, 1, 200, 50);  
                       rowPanel.add(roundLabel);

                       // reset
                       mainPanel.revalidate();
                       mainPanel.repaint();
                   }           
               }          
           });
           add(spainBtn);
           
                   
           // button for France
           JButton franceBtn = new JButton("France");
           franceBtn.setBounds(220, 80, 150, 40);
           franceBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));			
           franceBtn.setFont(new Font("Arial", Font.BOLD, 14));
           
           franceBtn.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   
                   // remove all components form main panel
                   mainPanel.removeAll();
               } } 
       