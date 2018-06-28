package chapter15;

interface CreateAuthor{
	String getCreatedAuthor();
}

class CreateAuthorImp implements CreateAuthor{
	private String name;
	
	
	public CreateAuthorImp(String name) {
		super();
		this.name = name;
	}


	@Override
	public String getCreatedAuthor() {
		return name;
	}
	
}

public class E37_Mixin extends Mixins implements CreateAuthor{
	private CreateAuthor author = new CreateAuthorImp("xiaolian");
	@Override
	public String getCreatedAuthor() {
		return author.getCreatedAuthor();
	}
	
	public static void main(String[] args) {
		E37_Mixin m= new E37_Mixin();
		m.get();
		m.getCreatedAuthor();
		m.getSearialNumber();
		m.getTimeStamp();
	}

}
