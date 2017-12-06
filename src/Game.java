//Ryan Kennedy 47486469 Fall 2017-Lab 8

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.Timer;

public class Game extends JFrame {
	Buying buy = new Buying();
	//creates an instance of SMUQuest
	private int roundNumber = 1;
	
	//widgets
	JLabel money;
	JButton clicker;
	JButton upgradeClicker;
	JButton firstPurchase;
	JButton secondPurchase;
	JButton thirdPurchase;
	JButton fourthPurchase;
	JButton fifthPurchase;
	JButton sixthPurchase;
	JLabel firstPurchase$PS;
	JLabel firstPurchasePrice;
	JLabel firstPerSecond;
	
	
	
	public Game() {
		super("Clicker Game");
		checkSaveFile();
		setLayout(new FlowLayout());
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
			if (e.getSource() == firstPurchase) {
				if(buy.getMoney() >= buy.getFirstBuyPrice()) {
				buy.subtractMoney(buy.getFirstBuyPrice());
				buy.setFirstBuy$PS(1);
				buy.setFirstBuyPrice(2);
				firstPurchase$PS.setText("$" + buy.getFirstBuy$PS());		
				firstPurchasePrice.setText("$" + buy.getFirstBuyPrice());	
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