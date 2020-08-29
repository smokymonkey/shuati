import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RevealCards_950 {
    public int[] deckRevealedIncreasing(int[] deck) {
        int l = deck.length;
        List<Integer> s = new ArrayList<Integer>();
        Arrays.sort(deck);
        while (l >= 1) {
            s.add((l + 1) / 2);
            l -= (l + 1) / 2;
        }

        int[] rt = new int[0];
        l = deck.length;
        for (int i = s.size() - 1; i >= 0; i--)
            rt = helper(deck, l - s.get(i) - rt.length, l - rt.length - 1, rt);
        return rt;
    }

    public int[] helper(int[] nums, int startIdx, int endIdx, int[] partialRt) {
        int count = endIdx - startIdx + 1;
        int[] rt = new int[count + partialRt.length];

        for (int i = 0,j=startIdx; j <= endIdx; i += 2,j++)
            rt[i] = nums[j];
        if (partialRt.length > 0) {
            int j = 0;
            if (partialRt.length == count) {
                rt[rt.length - 1] = partialRt[partialRt.length - 1];
                j = 1;
            } else {
                rt[1] = partialRt[partialRt.length - 1];
                j = 3;
            }
            for (int i = 0; i < partialRt.length - 1; i++) {
                rt[j] = partialRt[i];
                j += 2;
            }
        }
        return rt;

    }

    public static void main(String[] args) {

        int[] ret = new RevealCards_950().deckRevealedIncreasing(new int[]{2,3,5,7,11,13,17,19});


    }
}
