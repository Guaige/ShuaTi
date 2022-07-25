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

2343. 裁剪数字后查询第 K 小的数字
第 302 场周赛 #3
https://leetcode.cn/submissions/detail/341564198/
比赛思路：转int排序 -> 转long （没时间）
结果：RE，设计（思路）问题
反思：为什么没想到用string字典序直接比较？
后一周周赛，用对象排序。
7.25再总结：String类的自定义排序，可以创二维String数组，index转String表示。
7.25解法：String表示，这里不用考虑前置的0， 因为裁剪的位数是一样的，直接字典序compareTo。index转String做第二排序。
总结：两场周赛，其实都是设计和思路的问题。一个正确的想法可以节省很多时间！