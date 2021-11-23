package algorithmsmax;

public class Plane {

    public int getLongestOcean(String map) {
        char[] charMap = map.toCharArray();
        int maxSumOfOcean = 0;
        int sumOfOcean = 0;
        for (char c : charMap) {
            if (c == '0') {
                sumOfOcean++;
            } else {
                if (sumOfOcean > maxSumOfOcean) {
                    maxSumOfOcean = sumOfOcean;
                }
                sumOfOcean = 0;
            }
        }
        return maxSumOfOcean;
    }

    public int getLongestOceanAlternative(String map) {
        String[] splitMap = map.split("1+");
        int maxOcean = 0;
        for (String ocean : splitMap) {
            if (ocean.length() > maxOcean) {
                maxOcean = ocean.length();
            }
        }
        return maxOcean;
    }

}
