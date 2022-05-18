/*
Given a string paragraph and a string array of the banned words banned, return the most frequent 
word that is not banned. It is guaranteed there is at least one word that is not banned, and that 
the answer is unique.

The words in paragraph are case-insensitive and the answer should be returned in lowercase.

Constraints:
    1 <= paragraph.length <= 1000
    paragraph consists of English letters, space ' ', or one of the symbols: "!?',;.".
    0 <= banned.length <= 100
    1 <= banned[i].length <= 10
    banned[i] consists of only lowercase English letters.
*/
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().split("[ !?',;.]+");
        //System.out.print(Arrays.toString(words));
        List<String> uniques = new ArrayList<String>();
        List<Integer> counts = new ArrayList<Integer>();
        
        int index = 0;
        boolean isBanned;
        for (int i = 0; i < words.length; i++) {
            isBanned = false;
            for (int j = 0; j < banned.length; j++) {
                if (words[i].equals(banned[j])) isBanned = true;
            }
            if (isBanned) continue;
            else if (!uniques.contains(words[i])) {
                uniques.add(words[i]);
                counts.add(1);
            } else {
                index = uniques.indexOf(words[i]);
                counts.set(index, counts.get(index)+1);
            } 
        }
        
        int max = 0;
        for (int i = 0; i < counts.size(); i++) {
            if(counts.get(i) > max) {
                max = counts.get(i);
                index = i;
            }
        }
        
        return uniques.get(index);
    }
}
