package Milk_Dairy;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Brundavana {
	@Id
	int pid;
	String pname;
	Double liter;
	double fat;
	double amount;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Double getLiter() {
		return liter;
	}
	public  Double setLiter(Double liter) {
		return this.liter = liter;
	}
	public double getFat() {
		return fat;
	}
	public void setFat(double fat) {
		this.fat = fat;
	}
	public double getAmount() {
		return amount;
	}
	public double setAmount(double amount) {
		return this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "Brundavana [pid=" + pid + ", pname=" + pname + ", liter=" + liter + ", fat=" + fat + ", amount="
				+ amount + "]";
	}
	
	
	

}
