public class Solution1 {
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

public class Solution2 {
    // Tarjan's algorithm
    public boolean dfs(Map<Integer, ArrayList<Integer>> pre_posts, 
            boolean [] marked, boolean [] visited, int cur){
        if(marked[cur]) return true; 
        if(visited[cur]) return false; // NOT a DAG
        visited[cur] = true;
        // visit each post of cur
        if(pre_posts.containsKey(cur)){
            for(int next : pre_posts.get(cur)){
                if(!dfs(pre_posts, marked, visited, next)) return false;
            }
        }
        marked[cur] = true;
        visited[cur] = false;
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // construct graph
        Map<Integer, ArrayList<Integer>> pre_posts = new HashMap<Integer, ArrayList<Integer>>();
        for(int[] pair : prerequisites){
            int pre = pair[1], post = pair[0];
            if(!pre_posts.containsKey(pre)) pre_posts.put(pre, new ArrayList<Integer>());
            pre_posts.get(pre).add(post);
        }
        boolean [] marked = new boolean[numCourses];
        boolean [] visited= new boolean[numCourses];
        for(int i=0; i<numCourses; i++){
            if(!dfs(pre_posts, marked, visited, i)) return false;
        }
        return true;
    }
}
