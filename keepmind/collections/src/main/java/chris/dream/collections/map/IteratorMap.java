package chris.dream.collections.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/**
 * @Description 迭代
 * @author Chris
 * @date 2018年8月10日 上午9:20:14
 */
public class IteratorMap {
	
	public static void main(String[] args) {
		Map<String, Object> persons = new HashMap<>();
		
		persons.put("张三", 21);
		persons.put("李四", 22);
		persons.put("王五", 23);
		persons.put("赵六", 24);
		
		System.out.println("使用JDK8 forEach：");
		forEach(persons);
		
		System.out.println("使用map的entryset迭代器：");
		iteratorByEntrySet(persons);
	}
	
	public static void forEach(Map<String, Object> map) {
		map.forEach((name, age) -> {
			System.out.println(name + " " + age);
		});
	}
	
	public static void iteratorByEntrySet(Map<String, Object> map) {
		Iterator<Map.Entry<String, Object>> ite = map.entrySet().iterator();
		while(ite.hasNext()) {
			Map.Entry<String, Object> entry = ite.next();
			System.out.println(entry.getKey() + " " + entry.getValue());
            ite.remove();
		}

        System.out.println(map);
	}

}
