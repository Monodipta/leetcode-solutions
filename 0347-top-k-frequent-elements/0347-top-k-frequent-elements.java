class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freqMap=new HashMap<>();

        for(int num:nums){
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a,b)->freqMap.get(a) - freqMap.get(b)
        );

        for(int key : freqMap.keySet()){
            minHeap.offer(key);

            if(minHeap.size()>k){
                minHeap.poll();
            }
        }

        int[] result=new int[k];

        for(int i=0;i<k;i++){
            result[i]=minHeap.poll();
        }

        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna