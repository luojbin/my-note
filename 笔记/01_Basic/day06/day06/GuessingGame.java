package day06;
import java.util.Scanner;

public class GuessingGame {
	public static void main(String[] args) {
		// ��ʾ��Ҳ²�Ĵ���
		int count = 0;
		// ���ڱ����жϵĽ��
		int[] result = new int[2];
		Scanner scanner = new Scanner(System.in);
		System.out.println("GuessingGame>��ӭ���Բ���ĸ��Ϸ��");
		// ��ʾ�²���ַ���
		char[] chs = generate();
		System.out.println(chs);
		System.out.println("GuessingGame>��Ϸ��ʼ�������������µ�5����ĸ���У���exit�����˳���");
		while (true) {
			String inputStr = scanner.next().trim().toUpperCase();
			if ("EXIT".equals(inputStr)) {
				System.out.println("GuessingGame>лл��ĳ��ԣ��ټ���");
				break;
			}

			char[] input = inputStr.toCharArray();
			result = check(chs, input);
			if (result[0] == chs.length) {// ��ȫ�¶Ե����
				int score = 100 * chs.length - count * 10;
				System.out.println("GuessingGame>��ϲ��¶��ˣ���ĵ÷��ǣ�" + score);
				break;
			} else {
				count++;
				System.out.println("GuessingGame>��¶�" + result[1] + "���ַ�������"
						+ result[0] + "���ַ���λ����ȷ�����ܴ���=" + count + "��exit�����˳���");
			}
		}
		scanner.close();
	}

	/**
	 * ���������Ҫ�²����ĸ����
	 * 
	 * @return �洢����ַ�������
	 */
	public static char[] generate() {
		
		char[] letters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z' };
		boolean[] flags = new boolean[letters.length];
		char[] chs = new char[5];
		for (int i = 0; i < chs.length; i++) {
			int index;
			do {
				index = (int) (Math.random() * (letters.length));
			} while (flags[index]);// �ж����ɵ��ַ��Ƿ��ظ�
			chs[i] = letters[index];
			flags[index] = true;
		}
		return chs;
	}

	/**
	 * �Ƚ�����������ĸ���кͳ��������ɵ���ĸ���У���һ�Ƚ��ַ�����λ�ã������رȽϽ��
	 * 
	 * @param chs
	 *            �������ɵ��ַ�����
	 * @param input
	 *            ���������ַ�����
	 * @return �洢�ȽϵĽ��������ֵint���� �ĳ���Ϊ2�����У�����Ϊ0��λ��
	 *         ���ڴ����ȫ�¶Ե���ĸ����(�ַ���λ�þ���ȷ)������Ϊ1��λ�����ڴ�Ų¶Ե���ĸ����(�ַ���ȷ������λ�ò���ȷ)��
	 */
	public static int[] check(char[] chs, char[] input) {
		int[] result = new int[2];
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < chs.length; j++) {
				if (input[i] == chs[j]) {// �ж��ַ��Ƿ���ȷ
					result[1]++;
					if (i == j) {// �ж�λ���Ƿ���ȷ
						result[0]++;
					}
					break;
				}
			}
		}
		return result;
	}
}
