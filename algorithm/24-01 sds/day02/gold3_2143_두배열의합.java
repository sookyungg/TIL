import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static long t;
    static Long[] a;
    static long n, m;
    static Long[] b;

public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    t = Long.parseLong(br.readLine());
    n = Long.parseLong(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    a = new Long[(int) n];

    for (int i = 0; i < n; i++) {
        a[i] = Long.parseLong(st.nextToken());
    }

    m = Long.parseLong(br.readLine());
    b = new Long[(int) m];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
        b[i] = Long.parseLong(st.nextToken());
    }

    List<Long> subA = new ArrayList<>();
    List<Long> subB = new ArrayList<>();

    //subA
    long sum;
    for (int i = 0; i < n; i++) {
        sum = 0;
        for (int j = i; j < n; j++) {
            sum += a[j];
            subA.add(sum);
        }
    }

    //subB
    for (int i = 0; i < m; i++) {
        sum = 0;
        for (int j = i; j < m; j++) {
            sum += b[j];
            subB.add(sum);
        }
    }

    Collections.sort(subA);
    Collections.sort(subB, Collections.reverseOrder());


    //System.out.print(subA.toString());
    //System.out.print(subB.toString());
    long s = 0, e = 0;
    long cnt = 0;
    while (s < subA.size() && e < subB.size()) {
        long result = subA.get((int) s) + subB.get((int) e);

        if (result == t) {
            long valA = subA.get((int) s);
            long valB = subB.get((int) e);
            long countA = 0;
            long countB = 0;
            while (s < subA.size() && subA.get((int) s) == valA) {
                countA++;
                s++;
            }
            while (e < subB.size() && subB.get((int) e) == valB) {
                countB++;
                e++;
            }
            cnt += countA * countB;
        } else if (result < t) {
            s++;
        } else if (result > t) {
            e++;
        }
    }

    System.out.print(cnt);
}
}
