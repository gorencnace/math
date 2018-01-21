public class Combinatorics {
    
    protected long number;
    
    Combinatorics() {
        makenull();
    }
    
    public void makenull() {
        number = 0;
    }
    
    
    public long binomial(int n, int m) {
        long[][] t = new long[n+1][m+1];
        
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                if (i < j)
                    t[i][j] = 0;
                else if (i == j)
                    t[i][j] = 1;
                else if (j == 0)
                    t[i][j] = 1;
                else
                    t[i][j] = t[i-1][j] + t[i-1][j-1];
            }
        }
        return t[n][m];
    }
    
    public long factorial(int n) {
        if (n == 0)
            return 1;
        return n * factorial(n-1);
    }
    
    public long stirlingFirst(int n, int m) {
        long[][] t = new long[n+1][m+1];
        
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                if (j > i)
                    t[i][j] = 0;
                else if (i == j)
                    t[i][j] = 1;
                else if (j == 0)
                    t[i][j] = 0;
                else if (j == 1)
                    t[i][j] = factorial(i-1);
                else
                    t[i][j] = t[i-1][j-1] + (i-1) * t[i-1][j];
            }
        }
        return t[n][m];
    }
    
    public long stirlingSecond(int n, int m) {
        long[][] t = new long[n+1][m+1];
        
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                if (j > i)
                    t[i][j] = 0;
                else if (i == j)
                    t[i][j] = 1;
                else if (j == 0)
                    t[i][j] = 0;
                else if (j == 1)
                    t[i][j] = 1;
                else
                    t[i][j] = t[i-1][j-1] + j * t[i-1][j];
            }
        }
        return t[n][m];
    }
    
    public long lahDynamic(int n, int m) {
        long[][] t = new long[n+1][m+1];
        
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                if (j > i)
                    t[i][j] = 0;
                else if (j == 0)
                    t[i][j] = 0;
                else if (j == i)
                    t[i][j] = 1;
                else
                    t[i][j] = t[i-1][j-1] + (i + j - 1) * t[i-1][j];
            }
        }
        return t[n][m];
    }
    
    public long lah(int n, int m) {
        return binomial(n-1, m-1) * factorial(n) / factorial(m);
    }
    
    public long bells(int n) {
        long a = 0;
        for (int i = 0; i <= n; i++) {
            a += stirlingSecond(n, i);
        }
        return a;
    }
    
    public long bell(int n) {
        long[] b = new long[n+1];
        b[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                b[i+1] += binomial(i, j) * b[j];
            }
        }
        return b[n];
    }
    
    public int eulersFunctionPhi(int n) {
        int count = 0;
        for (int i = 1; i < n+1; i++) {
            if (gcd(n, i) == 1)
                count++;
        }
        return count;
    }
    
    public int gcd(int a, int b) {
        if (a < b) {
            int t = a;
            a = b;
            b = t;
        }
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
    
    public long padajocePotence(int n, int k) {
        long a = n;
        for (int i = 1; i < k; i++) {
            a *= (n - i);
        }
        return a;
    }
    
    public long narascajocePotence(int n, int k) {
        long a = n;
        for (int i = 1; i < k; i++) {
            a *= (n + i);
        }
        return a;
    }
    
    public long multinomial(int n, int[] k) {
        long l = 1;
        for (int i = 0; i < k.length; i++) {
            l *= factorial(k[i]);
        }
        return factorial(n) / l;
    }
}
