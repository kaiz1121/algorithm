package topk;

import java.util.PriorityQueue;

/**
 * <p>Title: 数组的前K大值</p>
 * <p>Description: 优先级队列解决Top K问题</p>
 *
 * @author kaiz
 * @date 下午3:28 2021/4/12.
 */
public class TopK {

	//找出前k个最大数，采用小顶堆实现
	public static int[] findKMax(int[] nums, int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<>(k);//队列默认自然顺序排列，小顶堆，不必重写compare

		for (int num : nums) {
			if (pq.size() < k) {
				pq.offer(num);
				//如果堆顶元素 < 新数，则删除堆顶，加入新数入堆,保持堆中存储着大值
			} else if (pq.peek() < num) {
				pq.poll();
				pq.offer(num);
			}
		}

		int[] result = new int[k];
		for (int i = 0; i < k && !pq.isEmpty(); i++) {
			result[i] = pq.poll();
		}
		return result;
	}

	public static void main(String[] args) {
		int[] a = {3,2,1,5,6,7};
		findKMax(a, 2);
	}
}
