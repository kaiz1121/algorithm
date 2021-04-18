package topk;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.UUID;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 *
 * @author kaiz
 * @date 下午3:38 2021/4/12.
 */
public class GaopinTopK {

	public static void main(String[] args) {
		int[] a = {1,1,1,2,2,3};
		topK(a, 2);
	}
	public static int[] topK(int[] nums, int k) {
		//统计字符出现的频率的map
		Map<Integer, Integer> count = new HashMap();
		for (int num : nums) {
			count.put(num, count.getOrDefault(num, 0) + 1);
		}

		//根据出现频率的map来构建k个元素的优先级队列
		PriorityQueue<Integer> heap =
				new PriorityQueue<>(k, (o1, o2) -> count.get(o1) - count.get(o2));

		for (int n : count.keySet()) {
			heap.add(n);
			if (heap.size() > k)
				heap.poll();
		}

		int[] result = new int[heap.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = heap.poll();
		}
		return result;

	}
}
