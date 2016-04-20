package witdisk;

import java.util.LinkedList;
import java.util.List;

public class TestTree<T> {

	T data;
	TestTree<T> parent;
	List<TestTree<T>> children;

	public TestTree(T data) {
	   this.data     = data;
	   this.children = new LinkedList<TestTree<T>>();
	}

	public TestTree<T> addChild(T child) {
	   TestTree<T> childNode = new TestTree<T>(child);
	   childNode.parent = this;
	   this.children.add(childNode);
	   return childNode;
	}

	// other features ...
}

