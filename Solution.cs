
using System;

public class Solution
{
    private static readonly int NOT_FOUND = -1;

    public int[] ResultsArray(int[] input, int targetSubarraySize)
    {
        if (targetSubarraySize == 1)
        {
            return input;
        }

        int[] powerOfSubarraysWithTargetSize = new int[input.Length - targetSubarraySize + 1];
        int indexSubarrays = 0;

        for (int i = 1; i < input.Length; ++i)
        {
            if (input[i - 1] + 1 == input[i] && i - indexSubarrays + 1 < targetSubarraySize)
            {
                continue;
            }
            if (input[i - 1] + 1 == input[i] && i - indexSubarrays + 1 == targetSubarraySize)
            {
                powerOfSubarraysWithTargetSize[indexSubarrays] = input[i];
                ++indexSubarrays;
                continue;
            }

            while (indexSubarrays < powerOfSubarraysWithTargetSize.Length && indexSubarrays < i)
            {
                powerOfSubarraysWithTargetSize[indexSubarrays] = NOT_FOUND;
                ++indexSubarrays;
            }
        }

        return powerOfSubarraysWithTargetSize;
    }
}
