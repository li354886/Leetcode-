public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Course[] courses = new Course[numCourses];
        for (int i = 0; i < courses.length; i++) {
            courses[i] = new Course();
        }
        for (int[] edge : prerequisites) {
            Course in = courses[edge[0]];
            Course out = courses[edge[1]];
            if (!out.outNeighbours.contains(in)) {
                in.inDegree++;
                out.outNeighbours.add(in);
            }
        }
        Queue<Course> zeroInDegree = new LinkedList<Course>();
        for (Course course : courses) {
            if (course.inDegree == 0) {
                zeroInDegree.offer(course);
            }
        }
        while (!zeroInDegree.isEmpty()) {
            Course course = zeroInDegree.poll();
            for (Course outNeighbour : course.outNeighbours) {
                outNeighbour.inDegree--;
                if (outNeighbour.inDegree == 0) {
                    zeroInDegree.offer(outNeighbour);
                }
            }
            course.outNeighbours.clear();
        }
        for (Course course : courses) {
            if (course.inDegree > 0) {
                return false;
            }
        }
        return true;
    }
    
    class Course {
        int inDegree;
        Set<Course> outNeighbours;
        Course() {
            this.outNeighbours = new HashSet<>();
        }
    }
}