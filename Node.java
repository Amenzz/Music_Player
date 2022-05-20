public class Node {

	String filePath ;
	Node next , prev ;

	public Node (Node prev ,Node next , String filePath) {
		this.prev =prev;
		this.next =next;
		this.filePath=filePath ;
	}

	public Node (String filePath){
		this(null, null, filePath);
	}
}