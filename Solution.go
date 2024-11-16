
package main

import "fmt"

const NOT_FOUND = -1

func resultsArray(input []int, targetSubarraySize int) []int {
    if targetSubarraySize == 1 {
        return input
    }

    powerOfSubarraysWithTargetSize := make([]int, len(input) - targetSubarraySize + 1)
    indexSubarrays := 0

    for i := 1; i < len(input); i++ {

        if input[i-1] + 1 == input[i] && i - indexSubarrays + 1 < targetSubarraySize {
            continue
        }
        if input[i - 1] + 1 == input[i] && i-indexSubarrays + 1 == targetSubarraySize {
            powerOfSubarraysWithTargetSize[indexSubarrays] = input[i]
            indexSubarrays++
            continue
        }

        for indexSubarrays < len(powerOfSubarraysWithTargetSize) && indexSubarrays < i {
            powerOfSubarraysWithTargetSize[indexSubarrays] = NOT_FOUND
            indexSubarrays++
        }
    }

    return powerOfSubarraysWithTargetSize
}
