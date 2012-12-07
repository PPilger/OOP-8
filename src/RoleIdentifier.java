public class RoleIdentifier implements Identifier<Tractor, Object> {
	@Override
	public boolean equals(Tractor obj1, Object obj2) {
		return obj2 == null || obj1.getRole().getClass() == obj2;
	}
}
