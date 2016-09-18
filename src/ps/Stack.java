package ps;

import java.util.EmptyStackException;

public class Stack {
	private Object[] elements=new Object[10];
	private int size=0;
	public void push(Object e){
		ensureCapacity();
		elements[size++]=e;
	}
	public Object pop(){
		if(size==0) throw new EmptyStackException();
		return elements[--size];
	}
	private void ensureCapacity(){
		if(elements.length==size){
			Object[] oldElements=elements;
			elements=new Object[2*elements.length+1];
			System.arraycopy(oldElements, 0, elements, 0, size);
		}
	}

}



//
//上面的原理应该很简单，假如堆栈加了10个元素，然后全部弹出来，虽然堆栈是空的，
//没有我们要的东西，但是这是个对象是无法回收的，因为数组中对堆栈元素的引用依然存在，
//也就是数组对象持有了堆栈中元素的引用，但是这些对象实际上已经没用了，却无法回收。
//这个才符合了内存泄露的两个条件：无用，无法回收。 
//下面是对堆栈的改进，消除了内存泄漏的问题。 

//class MNode<T>  
//{  
//   private T value = null;  
//   private MNode<T> next;  
//   public MNode(T value)  
//   {  
//      this.value = value;  
//      next = null;  
//   }  
//   public T getValue() {  
//      return value;  
//   }  
//   public void setValue(T value) {  
//      this.value = value;  
//   }  
//   public MNode<T> getNext() {  
//      return next;  
//   }  
//   public void setNext(MNode<T> first) {  
//      this.next = first;  
//   }  
//}  
//public class MyBetterLinkedStack<T> {  
//   private MNode<T> first;  
//   private int size;  
//   public MyBetterLinkedStack()  
//   {  
//      this.first = null;  
//      this.size = 0;  
//   }  
//   @SuppressWarnings("unchecked")  
//   public <T> boolean  push(T t)  
//   {  
//      if(t==null)  
//         throw new RuntimeException("不能传入空值");  
//      MNode newNode = new MNode<T>(t);  
//      newNode.setNext(first);  
//      first = newNode;  
//      size++;  
//      return true;  
//   }  
//   
//   @SuppressWarnings("unchecked")  
//   public <T> T pop()  
//   {  
//      if(size==0)  
//      return null;  
//      MNode r = first;  
//      first = first.getNext();  
//      size--;  
//      T result = (T) r.getValue();  
//      r = null;  
//      return result;  
//       
//   }  
//   public int getSize()  
//   {  
//      return this.size;  
//   }  
//   public boolean isEmpty()  
//   {  
//      return size == 0;  
//   }  
//   /** 
//    * @param args 
//    */  
//   public static void main(String[] args) {  
//      // TODO Auto-generatedmethod stub  
//   
//      MyBetterLinkedStack mbls = new MyBetterLinkedStack();  
//      mbls.push("haha");  
//      mbls.push("hehe");  
//      System.out.println(mbls.getSize());  
//      System.out.println(mbls.pop());  
//      System.out.println(mbls.pop());  
//   }  
//} 

//内存泄露的另外一种情况：当一个对象被存储进HashSet(HashSet是基于HashMap的)集合中以后，就不能修改
//这个对象中的那些参与计算哈希值的字段了，否则，对象修改后的哈希值与最初存储进HashSet集合中时的哈希值就不同了，在这种情况下，即使在
//contains方法使用该对象的当前引用作为的参数去HashSet集合中检索对象，也将返回找不到对象的
//结果，这也会导致无法从HashSet集合中单独删除当前对象，造成内存泄露。 
