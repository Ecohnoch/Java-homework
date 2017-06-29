public class FractionalDigit {

	public static void main(String[] args) {
		int res = 130, ans = 0;
		for(int i = 0; i < 100; ++i){		
			ans = res / 17;
			res = res % 17;
			res = res * 10;
		}
		System.out.println(13.0/17);
		System.out.println(ans);
	}
}
