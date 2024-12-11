package accounts;

import java.util.Objects;

public class Owner {
	
	String name;
	int age;

	public Owner() {
		// TODO Auto-generated constructor stub
	}
	public Owner(String ownerData) {
		ownerData = this.name + this.age;
	}
	public Owner(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Owner other = (Owner) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Owner [name=" + name + ", age=" + age + "]";
	}
}
