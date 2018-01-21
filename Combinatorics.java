public class Combinatorics {
    
    protected long number;
    
    Combinatorics() {
        makenull();
    }
    
    public void makenull() {
        number = 0;
    }
    
    // binomski koeficient rekurzivno - dinamicno
    public long binomialDynamic(int n, int m) {
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
    
    // binomski koeficient iz formule
    public long binomial(int n, int m) {
        return fallingFactorial(n, m) / factorial(m);
    }
    
    // faktoriela rekurzivno
    public long factorial(int n) {
        if (n == 0)
            return 1;
        return n * factorial(n-1);
    }
    
    // Stirlingovo stevilo prve vrste iz rekurzije - dinamicno 
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
    
    // Stirlingovo stevilo druge vrste iz rekurzije - dinamicno 
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
    
    // Lahovo stevilo iz rekurzije - dinamicno
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
    
    // Lahovo stevilo iz formule
    public long lah(int n, int m) {
        return binomial(n-1, m-1) * factorial(n) / factorial(m);
    }
    
    // Bellovo stevilo iz Stirlingovega stevila druge vrste
    public long bells(int n) {
        long a = 0;
        for (int i = 0; i <= n; i++) {
            a += stirlingSecond(n, i);
        }
        return a;
    }
    
    // Bellovo stevilo po izreku
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
    
    // Eulerjeva funkcija phi
    public int eulersFunctionPhi(int n) {
        int count = 0;
        for (int i = 1; i < n+1; i++) {
            if (gcd(n, i) == 1)
                count++;
        }
        return count;
    }
    
    // greatest common divisor EA
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
    
    // padajoce potence iterativno
    public long fallingFactorial(int n, int k) {
        long a = n;
        for (int i = 1; i < k; i++) {
            a *= (n - i);
        }
        return a;
    }
    
    // narascajoce potence iterativno
    public long risingFactorial(int n, int k) {
        long a = n;
        for (int i = 1; i < k; i++) {
            a *= (n + i);
        }
        return a;
    }
    
    // multinomski koeficient
    public long multinomial(int n, int[] k) {
        long l = 1;
        for (int i = 0; i < k.length; i++) {
            l *= factorial(k[i]);
        }
        return factorial(n) / l;
    }
}
