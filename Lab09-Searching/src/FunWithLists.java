
public class FunWithLists {
	final static int arrSize = 25;
	final static int NOT_FOUND = -1;
	public static void main(String[] args) {
		int[] list = new int[arrSize];
		int n = 100;
		for(int i = 0; i < list.length; i++) {
			list[i] = (int)(Math.random() * n + 1);
			System.out.print(list[i] + ", ");
		}
		
		System.out.println();
//		System.out.println(list[0]);
//		System.out.println(list[arrSize/2]);
//		System.out.println(list[arrSize-1]);
	System.out.println(linearSearch(list, list[0]));
		
	}
	public static int linearSearch(int[] list, int key) {
		
		for(int i = 0; i < list.length; i++) {
			
			if(key == list[i]) {
				return i;
			}
		}
		return NOT_FOUND;
	}
}
	
