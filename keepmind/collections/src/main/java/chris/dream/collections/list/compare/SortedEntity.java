package chris.dream.collections.list.compare;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class SortedEntity implements Comparable<SortedEntity>{
	private int id;

	private String name;

	private String value;

	public SortedEntity(int id, String name, String value) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public int compareTo(SortedEntity o) {
		if(this.id > o.id) {
			return 1;
		} else if(this.id < o.id) {
			return -1;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		List<SortedEntity> entities = new ArrayList<>();
		entities.add(new SortedEntity(1, "k1", "v1"));
		entities.add(new SortedEntity(2, "k2", "v2"));
		entities.add(new SortedEntity(3, "k3", "v3"));

		entities.sort(new Comparator<SortedEntity>() {

			@Override
			public int compare(SortedEntity o1, SortedEntity o2) {
				return o1.compareTo(o2);
			}
		});
		
		System.out.println(JSON.toJSONString(entities));
		
	}
	
}
