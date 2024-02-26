import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	static long n, m, k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Long.parseLong(st.nextToken());
		m = Long.parseLong(st.nextToken());
		k = Long.parseLong(st.nextToken());

		long[] arr;
		double arrLength;

		// 배열 크기 구하기
		long i = 0;
		while (true) {
			if (n > Math.pow(2, i)) {
				i++;
			} else {
				arrLength = Math.pow(2, i + 1);
				break;
			}
		}

		// 배열 생성 및 초기화
		arr = new long[(int) arrLength];
		for (int j = 0; j < arr.length; j++) {
			arr[j] = 0; // 각 요소를 0으로 초기화
		}

		// 입력된 값들로 배열 초기화
		for (i = arr.length / 2; i < arr.length / 2 + n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[(int) i] = Long.parseLong(st.nextToken());
		}

		// 배열 채우기
		for (i = arr.length - 1; i > 1; i--) {
			arr[(int) (i / 2)] += arr[(int) i];
		}

		// 연산 수행
		for (i = 0; i < m + k; i++) {
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			long c = Long.parseLong(st.nextToken());

			// 업데이트 하기
			if (a == 1) {
				long tmp = c - arr[(int) (arr.length / 2 + b - 1)];
				arr[(int) (arr.length / 2 + b - 1)] = c;
				long j = arr.length / 2 + b - 1;
				while (j > 1) {
					j = j / 2;
					arr[(int) j] += tmp;
				}
			}

			// 구간 합 구하기
			if (a == 2) {
				long sum = 0;
				long left = b + arr.length / 2 - 1;
				long right = c + arr.length / 2 - 1;

				while (left <= right) {
					if (left % 2 != 0) {
						sum += arr[(int) left];
					}
					if (right % 2 == 0) {
						sum += arr[(int) right];
					}
					left = (left + 1) / 2;
					right = (right - 1) / 2;
				}
				System.out.println(sum);
			}
		}
	}
}
