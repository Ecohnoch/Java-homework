public class Array {
	public static int indexOf(int data, int[] array) {
		for(int i = 0; i < array.length; i++){
			if(array[i] == data){
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] array = { 1, 3, -1, 9, 7, 3 };
		System.out.println(indexOf(3, array));
		System.out.println(indexOf(5, array));
	}

}
