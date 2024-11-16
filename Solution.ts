
function resultsArray(input: number[], targetSubarraySize: number): number[] {
    if (targetSubarraySize === 1) {
        return input;
    }

    const NOT_FOUND = -1;
    const powerOfSubarraysWithTargetSize: number[] = new Array(input.length - targetSubarraySize + 1);
    let indexSubarrays = 0;

    for (let i = 1; i < input.length; ++i) {

        if (input[i - 1] + 1 === input[i] && i - indexSubarrays + 1 < targetSubarraySize) {
            continue;
        }
        if (input[i - 1] + 1 === input[i] && i - indexSubarrays + 1 === targetSubarraySize) {
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
};
