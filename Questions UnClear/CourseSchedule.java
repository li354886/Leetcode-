public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Set> posts = new ArrayList<Set>();
        for (int i = 0; i < numCourses; i++) {
            posts.add(new HashSet<Integer>());
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            posts.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int[] preNums = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            Set set = posts.get(i);
            Iterator<Integer> it = set.iterator();
            while (it.hasNext()) {
                preNums[it.next()]++;
            }
        }
        
        for (int i = 0; i < numCourses; i++) {
            int j = 0;
            for ( ; j < numCourses; j++) {
                if (preNums[j] == 0) {
                    break;
                }
            }
            
            if (j == numCourses) {
                return false;
            }
            
            preNums[j] = -1;
            
            Set set = posts.get(j);
            Iterator<Integer> it = set.iterator();
            while (it.hasNext()) {
                preNums[it.next()]--;
            }
        }
        return true;
    }
}