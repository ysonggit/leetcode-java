public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses==0) return new int[0];
        int fuck [] = new int [numCourses];
        for(int i=0; i<numCourses; i++){
            fuck[i] = i;
        }
        if(prerequisites.length==0) return fuck;
        //  means course i is a prerequisite course for courses in pre_posts.get(i) 
        HashMap<Integer, ArrayList<Integer>> pre_posts = new HashMap<Integer, ArrayList<Integer>>();
        int indegree[] = new int [numCourses]; // indegree[i] = j means course i has j prerequisites
        for(int [] pair : prerequisites){
            int pre = pair[1], post = pair[0];
            indegree[post]++;
            if(!pre_posts.containsKey(pre)){
                ArrayList<Integer> posts = new ArrayList<Integer>();
                pre_posts.put(pre, posts);
            }
            pre_posts.get(pre).add(post);
        }
        Queue<Integer> courses_without_pre = new LinkedList<Integer>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0) courses_without_pre.offer(i);
        }
        int count = 0;
        while(!courses_without_pre.isEmpty()){
            int pre = courses_without_pre.poll();
            fuck[count] = pre;
            if(pre_posts.containsKey(pre)){ // mistake: map may not have this key! null point exception
                for(Integer post: pre_posts.get(pre)){
                    indegree[post]--;
                    if(indegree[post]==0) {
                        courses_without_pre.offer(post);
                    }
                }
            }
            count++;
        }
        for(int i=0; i<numCourses; i++){
            if(indegree[i]>0) return new int[0]; // has a cycle
        }
        return fuck;
    }
}
