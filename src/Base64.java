import java.util.Arrays;
public class Base64 {
	private static final byte[] encodingTable = { (byte) 'A', (byte) 'B', (byte) '5', (byte) '6', (byte) '7',
			(byte) '8', (byte) '9', (byte) 'H', (byte) 'I', (byte) 'J', (byte) 'K', (byte) 'L', (byte) 'v', (byte) 'w',
			(byte) 'x', (byte) 'y', (byte) 'z', (byte) 'R', (byte) 'S', (byte) 'T', (byte) 'U', (byte) 'V', (byte) 'W',
			(byte) 'X', (byte) 'Y', (byte) 'Z', (byte) 'a', (byte) 'q', (byte) 'r', (byte) 's', (byte) 't', (byte) 'u',
			(byte) 'C', (byte) 'D', (byte) 'E', (byte) 'F', (byte) 'G', (byte) 'g', (byte) 'h', (byte) 'i', (byte) 'j',
			(byte) 'k', (byte) 'M', (byte) 'N', (byte) 'O', (byte) 'P', (byte) 'Q', (byte) 'b', (byte) 'c', (byte) 'd',
			(byte) 'e', (byte) 'f', (byte) '0', (byte) '1', (byte) '2', (byte) '3', (byte) '4', (byte) 'l', (byte) 'm',
			(byte) 'n', (byte) 'o', (byte) 'p', (byte) '+', (byte) '/' };

	public static String encode(byte[] binaryData) {

		StringBuffer realAns = new StringBuffer();
		int allByte[] = new int[500];
		int start = 0;
		for (int i = 0; i < binaryData.length; ++i) {
			for (int j = 7; j >= 0; --j) {
				int shiftleft = (binaryData[i] >> j) & 0x01;
				allByte[start] = shiftleft;
				start++;
			}
		}
		if (binaryData.length % 3 == 1) {
			for (int i = 0; i < 16; ++i) {
				allByte[start] = 0;
				start++;
			}
		} else if (binaryData.length % 3 == 2) {
			for (int i = 0; i < 8; ++i) {
				allByte[start] = 0;
				start++;
			}
		}

		byte[] tmpAns = new byte[400];
		for (int i = 0; i < (start + 1) / 6; ++i) {
			int ans = 0;
			for (int j = 0; j < 6; ++j) {
				ans = ans + allByte[6 * i + j] * (int) Math.pow(2, 5 - j);
			}
			tmpAns[i] = encodingTable[ans];
		}
		realAns.append(new String(tmpAns));
		return realAns.toString();
	}

	public static byte[] decode(String code) {
		StringBuffer allBytes = new StringBuffer();
		
		for (int i = 0; i < code.length(); ++i)
			for (int j = 0; j < encodingTable.length; ++j)
				if ((byte) code.charAt(i) == encodingTable[j]) {
					String tmp = Integer.toBinaryString(j);
					StringBuffer tmp2 = new StringBuffer();
					for (int k = 0; k < 6 - tmp.length(); ++k) {
						tmp2.append("0");
					}
					tmp2.append(tmp);
					allBytes.append(tmp2.toString());
				}
		String bytes = allBytes.toString();
		byte[] ans = new byte[bytes.length()/8];
		for(int i = 0; i < bytes.length()/8; ++i){
			int tmp = 0;
			for(int j = 0; j < 8; ++j){
				tmp = tmp + (int)(bytes.charAt(8 * i + j) - '0') * (int)Math.pow(2, 7 - j);
			}
			ans[i] = (byte)tmp;
		}
		return ans;
	}

	public static void main(String[] args) {
		byte[] a = { 1};
		System.out.println(a[0]);
		String s = encode(a);
		System.out.println(s);
		byte[] b = decode(s);
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println();

	}
}
