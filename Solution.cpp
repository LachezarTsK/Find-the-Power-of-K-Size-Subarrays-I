
#include <vector>
using namespace std;

class Solution {

    static const int NOT_FOUND = -1;

public:
    vector<int> resultsArray(const vector<int>& input, int targetSubarraySize) const {
        if (targetSubarraySize == 1) {
            return input;
        }

        vector<int> powerOfSubarraysWithTargetSize(input.size() - targetSubarraySize + 1);
        int indexSubarrays = 0;

        for (size_t i = 1; i < input.size(); ++i) {

            if (input[i - 1] + 1 == input[i] && i - indexSubarrays + 1 < targetSubarraySize) {
                continue;
            }
            if (input[i - 1] + 1 == input[i] && i - indexSubarrays + 1 == targetSubarraySize) {
                powerOfSubarraysWithTargetSize[indexSubarrays] = input[i];
                ++indexSubarrays;
                continue;
            }

            while (indexSubarrays < powerOfSubarraysWithTargetSize.size() && indexSubarrays < i) {
                powerOfSubarraysWithTargetSize[indexSubarrays] = NOT_FOUND;
                ++indexSubarrays;
            }
        }

        return powerOfSubarraysWithTargetSize;
    }
};
