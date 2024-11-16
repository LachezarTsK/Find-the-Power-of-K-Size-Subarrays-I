
class Solution {

    private companion object {
        const val NOT_FOUND = -1
    }

    fun resultsArray(input: IntArray, targetSubarraySize: Int): IntArray {
        if (targetSubarraySize == 1) {
            return input
        }

        val powerOfSubarraysWithTargetSize = IntArray(input.size - targetSubarraySize + 1)
        var indexSubarrays = 0

        for (i in 1..<input.size) {

            if (input[i - 1] + 1 == input[i] && i - indexSubarrays + 1 < targetSubarraySize) {
                continue
            }
            if (input[i - 1] + 1 == input[i] && i - indexSubarrays + 1 == targetSubarraySize) {
                powerOfSubarraysWithTargetSize[indexSubarrays] = input[i]
                ++indexSubarrays
                continue
            }

            while (indexSubarrays < powerOfSubarraysWithTargetSize.size && indexSubarrays < i) {
                powerOfSubarraysWithTargetSize[indexSubarrays] = NOT_FOUND
                ++indexSubarrays
            }
        }

        return powerOfSubarraysWithTargetSize
    }
}
