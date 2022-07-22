7.22

757. 设置交集大小至少为2
https://leetcode.cn/problems/set-intersection-size-at-least-two/

452. 用最少数量的箭引爆气球
https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/

	找区间集合中的交集或共线
	按右值排序，指针从最小右值开始，遍历区间。

137. 只出现一次的数字 II
https://leetcode.cn/problems/single-number-ii/

	其他数字出现三次
	位运算，a = ~b & (a & i)

219. 存在重复元素 II
https://leetcode.cn/problems/contains-duplicate-ii/
	
	nums[i] == nums[j] 且 abs(i - j) <= k
	滑动窗口+HashSet

220. 存在重复元素 III
https://leetcode.cn/problems/contains-duplicate-iii/

	abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k
	滑动窗接 + HashMap， 桶排序，注意窗口细节