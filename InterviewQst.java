
import java.util.*;
import java.util.Map.Entry;
public class InterviewQst {

	public static void main(String[] args) {
		int node = 10;
		int[] front = new int[] {1,1,2,3,7};
		int[] to = new int[] {2,3,4,5,8};
		System.out.println(connectedSum(node,front,to));

	}

	public static int connectedSum(int node,int[] front,int[] to) {
		int sum = 0;
		HashMap<Integer,List<Integer>> list = new HashMap<>();
		int[] visited = new int[node];
		for(int i = 0 ; i < node ; i++) {
			visited[i] = 0;
		}
		
		System.out.println();

		for(int i = 0 ; i < front.length ; i++) {
			//System.out.println("Front[i]  -> " + front[i]);
			System.out.println("Front[i]  -> " + front[i] + "   " +"To[i]  -> " + to[i]);
			
			if(visited[front[i] - 1] == 0 && visited[to[i] - 1] == 0) {
				list.put(front[i], new ArrayList<>());
				list.get(front[i]).add(to[i]);
				visited[front[i] - 1] = 1;
				visited[to[i] - 1] = 1;
			}else if(visited[front[i] - 1] == 0) {
				if(visited[to[i] - 1] == 1) {
					if(list.get(to[i]) != null) {
					list.get(to[i]).add(front[i]);
					}else {
						int key = searchInValues(list,to[i]);
						list.get(key).add(front[i]);
					}
				}

				visited[front[i] - 1] = 1;
			}else if(visited[to[i] - 1] == 0) {
				if(visited[front[i] - 1] == 1) {
					
					 if(list.get(front[i]) != null) {
					  list.get(front[i]).add(to[i]);
					 }else {
						 int key = searchInValues(list, front[i]);
						 list.get(key).add(to[i]);
					 }
					
				}
				visited[to[i] - 1] = 1;
			}
			
			for(int j = 0 ; j < visited.length ; j++) {
				System.out.print(visited[j] + " ");
			}
			
			System.out.println();
		}

		System.out.println();
		
		for(Entry<Integer, List<Integer>> ee : list.entrySet()) {

			List<Integer> values = ee.getValue();
			System.out.println(values.size());
			double sqrt = Math.sqrt(values.size() + 1);

			int ciel = (int)Math.ceil(sqrt);

			sum += ciel;
		}


		for(int i = 0 ; i < visited.length ; i++) {
			if(visited[i] == 0) {
				int sqrt = (int)Math.sqrt(1);
				int ciel = (int)Math.ceil(sqrt);
				sum += ciel;
			}
		}
		System.out.println();

		return sum;

	}
	
	public static int searchInValues(HashMap<Integer,List<Integer>> list,int val) {
		for(Entry<Integer, List<Integer>> ee : list.entrySet()) {
			List<Integer> values = ee.getValue();
			if(values.contains(val)) {
				return ee.getKey();
			}
			
		}
		
		return 0;
	}

}
