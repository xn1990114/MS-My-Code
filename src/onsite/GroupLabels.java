package onsite;
import java.util.*;
/*
 * 微软面经提供给大家，onsite一共四轮，前三轮都是原题medium的难度，就不赘述了。楼主个人跪在了第四题。
 * 题目是这样的：给定输入List<List<Integer>>, 和List<Label>，要求把所有有共同element的label都合并成一类。
Eg： 
A : 1, 2, 3
B:  4, 5.
C:  1, 4.
D: 7, 8
E: 8, 9.
F: 0
则应该输出 {A, B, C}, {D, E}. {F}.
 */
public class GroupLabels {
	public List<List<Character>> groupdLabels(List<List<Integer>> ids,List<Character> labels){
		Map<Integer,Set<Character>> map=new HashMap<Integer,Set<Character>>();
		Map<Character,Set<Integer>> cToId=new HashMap<Character,Set<Integer>>();
		List<List<Character>> res=new ArrayList<List<Character>>();
		for(int i=0;i<ids.size();i++){
			List<Integer> list=ids.get(i);
			char l=labels.get(i);
			cToId.put(l, new HashSet<Integer>(list));
			for(int num:list){
				if(!map.containsKey(num)){
					map.put(num, new HashSet<Character>());
				}
				map.get(num).add(l);
			}
		}
		Set<Character> visited=new HashSet<Character>();
		for(int i=0;i<labels.size();i++){
			char ch=labels.get(i);
			if(visited.contains(ch)){
				continue;
			}
			visited.add(ch);
			List<Character> currRes=new ArrayList<Character>();
			Set<Integer> visitedids=new HashSet<Integer>();
			Queue<Integer> qu=new LinkedList<Integer>(cToId.get(ch));
			visitedids.addAll(cToId.get(ch));
			currRes.add(ch);
			while(!qu.isEmpty()){
				int size=qu.size();
				for(int j=0;j<size;j++){
					int curr=qu.poll();
					for(char child:map.get(curr)){
						if(!visited.contains(child)){
							visited.add(child);
							currRes.add(child);
							for(int id:cToId.get(child)){
								if(!visitedids.contains(id)){
									visitedids.add(id);
									qu.offer(id);
								}
							}
						}
					}
				}
			}
			res.add(currRes);
		}
		return res;
	}
	public void display(List<List<Character>> list){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<list.size();i++){
			List<Character> l=list.get(i);
			sb.append('{');
			for(char ch:l){
				sb.append(ch);
				sb.append(',');
			}
			sb.append('}');
		}
		System.out.println(sb.toString());
	}
}
