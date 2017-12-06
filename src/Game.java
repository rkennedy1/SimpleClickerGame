
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.Timer;
import javax.swing.border.*;
 

public class Game extends JFrame {
	Buying buy = new Buying();
	//creates an instance of SMUQuest
	private int roundNumber = 1;
	
	//widgets
	
	//for money handling
	JLabel money, moneyPerSecond, moneyPerClick;
	JButton clicker, upgradeClicker;
	
	//for first purchases
	JLabel firstPurchase, firstPurchase$PS, firstPerSecond;
	JButton firstPurchasePrice;
	
	//for second purchases
	JLabel secondPurchase, secondPurchase$PS, secondPerSecond;
	JButton secondPurchasePrice;
	
	//for third purchases
	JLabel thirdPurchase, thirdPurchase$PS, thirdPerSecond;
	JButton thirdPurchasePrice;

	//for fourth purchases
	JLabel fourthPurchase, fourthPurchase$PS, fourthPerSecond;
	JButton fourthPurchasePrice;
	
	//for fifth purchases
	JLabel fifthPurchase, fifthPurchase$PS, fifthPerSecond;
	JButton fifthPurchasePrice;
	
	//for sixth purchases
	JLabel sixthPurchase, sixthPurchase$PS, sixthPerSecond;
	JButton sixthPurchasePrice;
	
	//for a future capability
	JLabel emptySpace; //for something else when I decide what to do....
	
	Border blackline;
	GridBagConstraints gbc = new GridBagConstraints();
	
	public Game() {
		
		super("Clicker Game");
		setLayout(new GridBagLayout());
		checkSaveFile();
		
		
		firstPurchase = new JLabel("First Property!");
	    firstPurchase.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
	    add(firstPurchase,makeGbc30(0,0));
	    
	    firstPurchase$PS = new JLabel("" + buy.getFirstBuy$PS());
	    firstPurchase$PS.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
	    add(firstPurchase$PS,makeGbc20(0,1));
	    
	    firstPurchasePrice = new JButton("$" + buy.getFirstBuyPrice() + " to buy first prop");
	    add(firstPurchasePrice,makeGbc50(0,2));
	    firstPurchasePrice.addActionListener(new MyInner());
	    
	    secondPurchase = new JLabel("Second Property!");
	    secondPurchase.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
	    add(secondPurchase,makeGbc30(0,3));
	    
	    secondPurchase$PS = new JLabel("" + buy.getFirstBuy$PS());
	    secondPurchase$PS.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
	    add(secondPurchase$PS,makeGbc20(0,4));
	    
	    secondPurchasePrice = new JButton("$" + buy.getFirstBuyPrice() + " to buy second prop");
	    add(secondPurchasePrice,makeGbc50(0,5));
	    secondPurchasePrice.addActionListener(new MyInner());
	    
	    thirdPurchase = new JLabel("Third Property!");
	    thirdPurchase.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
	    add(thirdPurchase,makeGbc30(0,6));
	    
	    thirdPurchase$PS = new JLabel("" + buy.getFirstBuy$PS());
	    thirdPurchase$PS.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
	    add(thirdPurchase$PS,makeGbc20(0,7));
	    
	    thirdPurchasePrice = new JButton("$" + buy.getFirstBuyPrice() + " to buy second prop");
	    add(thirdPurchasePrice,makeGbc50(0,8));
	    thirdPurchasePrice.addActionListener(new MyInner());
	    
	    money = new JLabel("Money: $" + buy.getMoney());
	    money.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
	    add(money,makeGbc50(1,0));
	    
	    moneyPerSecond = new JLabel("$" + buy.getAll$PS() + "per second!" );
	    moneyPerSecond.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
	    add(moneyPerSecond,makeGbc25(1,1));
	    
	    moneyPerClick = new JLabel("$" + buy.getClickerStrength() + "per click!" );
	    moneyPerClick.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
	    add(moneyPerClick,makeGbc25(1,2));
	    
	    upgradeClicker = new JButton("Add 1 to your clicking power for $" + buy.getClickerPrice());
		add(upgradeClicker, makeGbc20(1,3));
	    upgradeClicker.addActionListener(new MyInner());
	    
	    clicker = new JButton("CLICK ME FOR 1 POINT!");
	    add(clicker, makeGbc80(1,4));
		clicker.addActionListener(new MyInner());
		
	    emptySpace = new JLabel("EMPTY");
	    emptySpace.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
	    add(emptySpace, makeGbc100(1,5));
	    
	    fourthPurchase = new JLabel("Fourth Property!");
	    fourthPurchase.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
	    add(fourthPurchase,makeGbc30(2,0));
	    
	    fourthPurchase$PS = new JLabel("" + buy.getFirstBuy$PS());
	    fourthPurchase$PS.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
	    add(fourthPurchase$PS,makeGbc20(2,1));
	    
	    fourthPurchasePrice = new JButton("$" + buy.getFirstBuyPrice() + " to buy second prop");
	    add(fourthPurchasePrice,makeGbc50(2,2));
	    fourthPurchasePrice.addActionListener(new MyInner());
	    
	    fifthPurchase = new JLabel("Fifth Property!");
	    fifthPurchase.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
	    add(fifthPurchase,makeGbc30(2,3));
	    
	    fifthPurchase$PS = new JLabel("" + buy.getFirstBuy$PS());
	    fifthPurchase$PS.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
	    add(fifthPurchase$PS,makeGbc20(2,4));
	    
	    fifthPurchasePrice = new JButton("$" + buy.getFirstBuyPrice() + " to buy second prop");
	    add(fifthPurchasePrice,makeGbc50(2,5));
	    fifthPurchasePrice.addActionListener(new MyInner());
	    
	    sixthPurchase = new JLabel("Sixth Property!");
	    sixthPurchase.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
	    add(sixthPurchase,makeGbc30(2,6));
	    
	    sixthPurchase$PS = new JLabel("" + buy.getFirstBuy$PS());
	    sixthPurchase$PS.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
	    add(sixthPurchase$PS,makeGbc20(2,7));
	    
	    sixthPurchasePrice = new JButton("$" + buy.getFirstBuyPrice() + " to buy second prop");
	    add(sixthPurchasePrice,makeGbc50(2,8));
	    sixthPurchasePrice.addActionListener(new MyInner());
	    
		/*clicker = new JButton("CLICK ME FOR 1 POINT!");
	    c.weightx = 0.5;
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 1;
	    c.gridy = 0;
	    c.ipady = 200;
	    c.ipadx = 200;
	    add(clicker, c);
		clicker.addActionListener(new MyInner());
		
		upgradeClicker = new JButton("Add 1 to your clicking power for $" + buy.getClickerPrice());
		c.fill = GridBagConstraints.HORIZONTAL;
	    c.weightx = 0.5;
	    c.gridx = 2;
	    c.gridy = 0;
	    c.ipady = 200;
	    c.ipadx = 200;
	    add(upgradeClicker, c);
	    upgradeClicker.addActionListener(new MyInner());
	    */
		/*
		clicker = new JButton("CLICK ME FOR 1 POINT!");
		add(clicker);
		clicker.addActionListener(new MyInner());
		upgradeClicker = new JButton("Add 1 to your clicking power for $" + buy.getClickerPrice());
		add(upgradeClicker);
		upgradeClicker.addActionListener(new MyInner());
		money = new JLabel("" + buy.getMoney());
		add(money);
		firstPurchasePrice = new JLabel("" + buy.getFirstBuyPrice());
		add(firstPurchasePrice);
		firstPurchase = new JButton("First Property!");
		add(firstPurchase);
		firstPurchase.addActionListener(new MyInner());	
		firstPurchase$PS = new JLabel("" + buy.getFirstBuy$PS());
		add(firstPurchase$PS);	
		*/
		
		//timer to add money every second
		Timer t = new Timer();
		t.schedule(new TimerTask() {
		    @Override
		    public void run() {
		       buy.moneyPS();
		       money.setText("You have $" + buy.getMoney());
		    }
		}, 0, 1000);
	}
	
	private class MyInner implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == firstPurchasePrice) {
				if(buy.getMoney() >= buy.getFirstBuyPrice()) {
				buy.subtractMoney(buy.getFirstBuyPrice());
				buy.setFirstBuy$PS(1);
				buy.setFirstBuyPrice(2);
				firstPurchase$PS.setText("$" + buy.getFirstBuy$PS());		
				firstPurchasePrice.setText("$" + buy.getFirstBuyPrice() + " to buy first prop");	
				money.setText("You have $" + buy.getMoney());
				}
			}
			if (e.getSource() == clicker) {
				buy.addMoney(buy.getClickerStrength());
				money.setText("You have $" + buy.getMoney());
			}
			if (e.getSource() == upgradeClicker) {
				if(buy.getMoney() >= buy.getClickerPrice()) {
				buy.subtractMoney(buy.getClickerPrice());
				buy.setClickerPrice();
				upgradeClicker.setText("Add 1 to your clicking power for $" + buy.getClickerPrice());
				buy.setClickerStrength();
				}
			}
		}	
	}
    private GridBagConstraints makeGbc30(int x, int y) {
        gbc.ipadx = 100;
        gbc.ipady = 30;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.fill = GridBagConstraints.BOTH;
        return gbc;
    }
    private GridBagConstraints makeGbc25(int x, int y) {
        gbc.ipadx = 100;
        gbc.ipady = 25;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.fill = GridBagConstraints.BOTH;
        return gbc;
    }
    private GridBagConstraints makeGbc50(int x, int y) {
        gbc.ipadx = 100;
        gbc.ipady = 50;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.fill = GridBagConstraints.BOTH;
        return gbc;
    }
    private GridBagConstraints makeGbc80(int x, int y) {
        gbc.ipadx = 100;
        gbc.ipady = 80;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.fill = GridBagConstraints.BOTH;
        return gbc;
    }
    private GridBagConstraints makeGbc20(int x, int y) {
        gbc.ipadx = 100;
        gbc.ipady = 20;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.fill = GridBagConstraints.BOTH;
        return gbc;
    }
    private GridBagConstraints makeGbc100(int x, int y) {
        gbc.ipadx = 100;
        gbc.ipady = 100;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.fill = GridBagConstraints.BOTH;
        return gbc;
    }
	public void checkSaveFile() {
		File inputFile = new File("SaveGame.txt");
		try {
			Scanner input = new Scanner(inputFile);
				int line = input.nextInt();
				if(line > 0) 
					buy.setMoney(line);
		}
		catch(FileNotFoundException exp) {
			System.out.println("File not Found Exception. Make sure the input file exists.");
		}
	}
	public void createSaveFile() {
		File outputFile = new File("SaveGame.txt");//creates a new file
		try {
			PrintWriter pWriter = new PrintWriter(outputFile); 
			pWriter.println(buy.getMoney());
			pWriter.close();
		}
		catch(FileNotFoundException exp) {
			System.out.println("File not found.");
		}
	}
}