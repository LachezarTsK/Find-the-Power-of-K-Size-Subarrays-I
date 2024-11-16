
public class Solution {

    private static final int NOT_FOUND = -1;

    public int[] resultsArray(int[] input, int targetSubarraySize) {
        if (targetSubarraySize == 1) {
            return input;
        }

        int[] powerOfSubarraysWithTargetSize = new int[input.length - targetSubarraySize + 1];
        int indexSubarrays = 0;

        for (int i = 1; i < input.length; ++i) {

            if (input[i - 1] + 1 == input[i] && i - indexSubarrays + 1 < targetSubarraySize) {
                continue;
            }
            if (input[i - 1] + 1 == input[i] && i - indexSubarrays + 1 == targetSubarraySize) {
                powerOfSubarraysWithTargetSize[indexSubarrays] = input[i];
                ++indexSubarrays;
                continue;
            }

            while (indexSubarrays < powerOfSubarraysWithTargetSize.length && indexSubarrays < i) {
                powerOfSubarraysWithTargetSize[indexSubarrays] = NOT_FOUND;
                ++indexSubarrays;
            }
        }

        return powerOfSubarraysWithTargetSize;
    }
}
