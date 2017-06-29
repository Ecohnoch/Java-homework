import java.util.Arrays;
import java.util.ArrayList;

public class Catalan {

	public static int answers = 0;

	// 请实现go函数
	public static void go(Deque from, Deque to, Stack s) {
		int length = from.size();
		Deque from1 = from.clone(), to1 = to.clone();
		Stack s1 = s.clone();

		boolean flag = false;
		int[] tmpNum = new int[2 * length];
		int num = 1;
		for (int i = 0; i < 2 * length; ++i) {
			if (i < length) {
				tmpNum[i] = 1;
			} else {
				tmpNum[i] = 0;
			}
		}
		from1 = from.clone();
		to1 = to.clone();
		s1 = s.clone();

		for (int k = 0; k < 2 * length; ++k) {
			if (tmpNum[k] == 1) {
				s1.push(from1.getFirst());
				from1.removeFirst();
			} else {
				to1.addLast(s1.pop());
			}
		}
		answers = answers + 1;
		for (int i = 0; i < 7; ++i) {
			System.out.print(to1.getFirst());
			to1.removeFirst();
		}
		System.out.println(" ");

		// list.add(tmpNum);
		do {
			int pos1 = 0, sum = 0;
			for (int i = 0; i < (2 * length - 1); ++i) {
				if (tmpNum[i] == 1 && tmpNum[i + 1] == 0) {
					tmpNum[i] = 0;
					tmpNum[i + 1] = 1;
					pos1 = i;
					break;
				}
			}
			num = num + 1;
			for (int i = 0; i < pos1; ++i) {
				if (tmpNum[i] == 1)
					sum++;
			}
			for (int i = 0; i < pos1; ++i) {
				if (i < sum)
					tmpNum[i] = 1;
				else
					tmpNum[i] = 0;
			}

			flag = false;
			for (int i = length; i < 2 * length; ++i) {
				if (tmpNum[i] == 0)
					flag = true;
			}
			

			from1 = from.clone();
			to1 = to.clone();
			s1 = s.clone();

			boolean ff = false;
			for (int k = 0; k < 2 * length; ++k) {
				if (tmpNum[k] == 1) {
					if(s1.size() == 4){
						ff = true;
						break;
					}
					s1.push(from1.getFirst());
					from1.removeFirst();
				} else {
					if (s1.empty()) {
						ff = true;
						break;
					}
					to1.addLast(s1.pop());
				}
			}
			if (ff) {
			} else {
				answers = answers + 1;
				int tl = to1.size();
				for (int i = 0; i < tl; ++i) {
					System.out.print(to1.getFirst());
					to1.removeFirst();
				}
				System.out.println(" ");
			}
		} while (flag);
		System.out.println(num);

	}
	
	public static void main(String[] args) {
		Deque from = new Deque();
		Deque to = new Deque();
		Stack s = new Stack();

		for (int i = 1; i <= 7; i++) {
			from.addLast(i);
		}

		go(from, to, s);

		System.out.println(answers);
	}

}
