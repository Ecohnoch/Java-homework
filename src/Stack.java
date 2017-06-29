public class Stack {
	
	private SingleLinkedList list = new SingleLinkedList();
	
	public boolean empty() {
		return list.getSize()==0;
	}
	
	public int size() {
		return list.getSize();
	}
	
	public int pop() {
		if(list.getSize() == 0)
			return -1;
		list.size--;
		Node top = list.head;
		if(list.size == 0){
			list.head = list.tail = null;
			int retVal = top.data;
			top = null;
			return retVal;
		}
		for(int i = 0; i < list.size - 1; i++){
			top = top.next;
		}
		int retVal = top.next.data;
		top.next = null;
		list.tail = top; 
		return retVal;
	}
	
	public void push(int data) {  
		list.add(data);
		
	}
	
	public Stack clone() {
		Stack s = new Stack();
		for(int i=0;i<list.getSize();i++) {
			s.list.add(list.get(i));
		}
		return s;
	}
	
	public static void main(String[] args) {
		Stack s1 = new Stack();
		s1.push(1);
		s1.push(2);
		System.out.println(s1.pop());
		s1.push(3);
		System.out.println(s1.pop());
		System.out.println(s1.pop());		
		
		Stack s2 = s1.clone();
		Stack s2 = s1.clone();
		System.out.println(s1.size());
		
	}
}
