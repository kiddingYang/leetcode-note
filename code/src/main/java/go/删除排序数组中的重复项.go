package main

import "fmt"

func main() {

	nums1 := []int{1, 2, 2}
	duplicates := removeDuplicates(nums1)
	fmt.Print(duplicates)
}

func removeDuplicates(nums []int) int {
	if len(nums) <= 1 {
		return len(nums)
	}

	if len(nums) == 2 {
		if nums[0] == nums[1] {
			return 1
		}
		return 2
	}

	//fast := 1
	slow := 0

	for i := 1; i < len(nums); i++ {
		if nums[i] == nums[slow] {
			continue
		}
		slow ++
		nums[slow] = nums[i]
	}
	return slow + 1
}
