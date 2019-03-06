public class List_inArraySlots{
	
	private int[] refArray;
	private int len;
	
	public List_inArraySlots(int len){
		this.refArray = new int[len + 10];
		this.len = len;
	}
	
	public int getLen(){
		return len;
	}
	
}
		