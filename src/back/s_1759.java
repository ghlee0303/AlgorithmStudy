package back;

import java.io.*;
import java.util.*;

public class s_1759 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int l;
    static char[] alphabet;
    static Password password;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        l = Integer.parseInt(st.nextToken());
        alphabet = createCharacterList();

        password = new Password(l);

        solve(0);
    }

    public static void solve(int start) {
        if (password.size == l) {
            password.print();
            return;
        }

        for (int i = start; i < alphabet.length; i++) {
            if (!password.add(alphabet[i])) continue;

            solve(i + 1);
            password.remove();
        }
    }

    public static char[] createCharacterList() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        Set<Character> seen = new TreeSet<>();

        while (st.hasMoreTokens()) {
            seen.add(st.nextToken().charAt(0));
        }

        char[] result = new char[seen.size()];
        int i = 0;
        for (char c : seen) {
            result[i++] = c;
        }

        return result;
    }

    public static class Password {
        public char[] array;
        public int size = 0;
        public int vowelCount = 0;
        public int consonantCount = 0;
        public HashMap<Character, Boolean> visit = new HashMap<>();

        public Password(int maxSize) {
            array = new char[maxSize];
        }

        public boolean add(char value) {
            if (visitCheck(value)) return false;

            if (vowelCheck(value)) {
                vowelCount++;
            } else {
                consonantCount++;
            }

            array[size] = value;
            size++;

            return true;
        }

        public void remove() {
            size--;
            char value = array[size];
            if (vowelCheck(value)) {
                vowelCount--;
            } else {
                consonantCount--;
            }

            visit.put(value, false);
        }

        private boolean vowelCheck(char value) {
            switch (value) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    return true;
                default:
                    return false;
            }
        }

        private boolean visitCheck(char value) {
            return Boolean.TRUE.equals(visit.putIfAbsent(value, true));
        }

        public void print() {
            if (vowelCount < 1 || consonantCount < 2) return;

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            try {
                for (int i = 0; i < size; i++) {
                    bw.write(array[i] + "");
                }
                bw.write("\n");
                bw.flush();
            } catch (IOException e) {
                System.out.println("출력에러");
            }
        }
    }
}
