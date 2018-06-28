package chapter15;


public class E39_DynamicsProxyMixin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object mixin = MyDynamacisProxyMixinGenerator.newInstance(
				new Object[] {new BasicImp(), new TimeStampedImp(), new SearilNumberedImp(),new CreateAuthorImp("xiaolian")}, 
				new Class<?>[] {Basic.class, TimeStamped.class, SerialNumbered.class, CreateAuthor.class});
		CreateAuthor c = (CreateAuthor) mixin;
		System.out.println(c.getCreatedAuthor());
	}

}
