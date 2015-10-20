class MedianFinder {

    // Count and max and min heap;
    // Assumption for simplicity: 
    // maxHeap should be one more element than minHeap when odd count
    // maxHeap should be equal to minHeap when even count;

    int count = 0;
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11, new Comparator<Integer>()
    {
        public int compare(Integer a, Integer b)
        {
            return b - a;
        }
    });

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (maxHeap.isEmpty())
        {
            // if maxHeap is empty, simply add to it, given assumption;
            maxHeap.add(num);
        }
        else
        {

            int topMaxHeap = maxHeap.peek();
            if (num <= topMaxHeap)
            {
                // if number is smaller than top of max heap, it should be added to max heap
                // so after that we could "move" the top of maxHeap to minHeap
                maxHeap.add(num);
            }
            else
            {
                // The opposite case
                minHeap.add(num);    
            }

            // Whenever maxHeap has 2 more elements than min, we need to "move" the top
            // to min to maintain our assumption;
            if (maxHeap.size() > minHeap.size() + 1)
            {
                minHeap.add(maxHeap.poll());
            }
            else if (maxHeap.size() < minHeap.size())
            {
                // Also to maintain the assumption
                maxHeap.add(minHeap.poll());
            }

        }
        // Don't forget this
        count ++;
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (count % 2 == 0)
        {
            // whenever have even number, the size of max and min heaps equals;
            // just return the average of the two tops;
            double mid = ((double)maxHeap.peek() + (double)minHeap.peek()) / 2;
            return mid;
        }
        else
        {
            // whenever we have odd count, simply return the maxHeap, for it has one more,
            // which is just the median;
            return (double)maxHeap.peek();
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();