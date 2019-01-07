package LeastInterval;

import java.util.Arrays;

public class LeastInterval {
    public int leastInterval(char[] tasks, int n) {
        int []freqs = new int[26];
        for (char c :tasks) {
            freqs[c-'A']++;
        }
        Arrays.sort(freqs);
        int max_freq = freqs[25];
        int i=24;
        while(i>=0){
            if (freqs[i]!=freqs[25]) break;
            i--;
        }
        return Math.max((max_freq-1)*(n+1)+25-i,tasks.length);
    }
}
