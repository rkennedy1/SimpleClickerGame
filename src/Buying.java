
public class Buying {
	private int firstBuy$PS;
	private int firstBuyPrice;
	private int money = 1;
	private int clickerStrength = 1;
	private int clickerPrice =10;
	
	public int getFirstBuy$PS() {
		return firstBuy$PS;
	}

	public void setFirstBuy$PS(int x) {
		firstBuy$PS += x;
	}

	public int getFirstBuyPrice() {
		return firstBuyPrice;
	}

	public void setFirstBuyPrice(int x) {
		firstBuyPrice += x;
	}
	public void moneyPS() {
		money += getFirstBuy$PS();
	}
	public int getMoney() {
		return money;
	}
	public void subtractMoney(int x) {
		money -= x;
	}
	public void addMoney(int x) {
		money += x;
	}
	public void setMoney(int x) {
		money = x;
	}
	public void setClickerStrength() {
		clickerStrength += 1; 
	}
	public int getClickerStrength() {
		return clickerStrength;
	}
	public int getClickerPrice() {
		return clickerPrice;
	}
	public void setClickerPrice() {
		clickerPrice*=1.2323452;
	}
}
