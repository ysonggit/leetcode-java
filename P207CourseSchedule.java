public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        if(n==0) return true;
        // pre_courses.get(i) means the prerequisite course with label i
        HashMap<Integer, ArrayList<Integer>> pre_courses = new HashMap<Integer, ArrayList<Integer>>();
        // observed a fact: node is labeled from 0 to n-1  
        // key: use indegree[i] to track the indegrees : indegree[i]=j means node i has j incoming edges
        int indegree[] = new int [numCourses]; // length MUST BE numCourse NOT n!
        for(int[] pair : prerequisites){
            int course = pair[0], pre = pair[1];
            if(!pre_courses.containsKey(pre)){ // mistake 2
                ArrayList<Integer> courses = new ArrayList<Integer>();
                pre_courses.put(pre, courses);
            }
            pre_courses.get(pre).add(course);
            indegree[course]++;
        }
        Queue<Integer> courses_without_pre = new LinkedList<Integer>();
        for(int i=0; i<numCourses; i++){ 
            if(indegree[i]==0) courses_without_pre.offer(i);
        }
        while(!courses_without_pre.isEmpty()){
            Integer cur = courses_without_pre.poll();
            // for each m with edge e from cur->m
            // remove edge e
             if(pre_courses.containsKey(cur)){ // mistake 3
                for(Integer m : pre_courses.get(cur)){
                    indegree[m]--;
                    if(indegree[m]==0) courses_without_pre.offer(m);
                }
            }
        }
        for(int i=0; i<numCourses; i++){
            if(indegree[i]!=0) return false; //has cycle
        }
        return true;
    }
}
