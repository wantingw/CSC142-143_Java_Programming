
public class SomeClass {
	private int myNum=5;
	private boolean setIsTrue;
	
	public void setMyNum(int myNum) {
		
		//this.myNum=myNum
		//myNum=anotherNum;
		//System.out.println(anotherNum);
		System.out.println("Enter setmyNum method");
		System.out.println(this.myNum+ "- this.myNum");
		System.out.println(myNum+"-this.myNum");
		this.myNum=myNum;
		System.out.println(this.myNum+ "- this.myNum");
		System.out.println("Exit setMyNum Method");
	}
	
	public void setIsTrue(boolean isTrue) {
			this.setIsTrue= isTrue;
	}
	
	public boolean getIsTrue() {
		return isTrue;
	}
}
