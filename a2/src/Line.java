//1.  编写点类（Point类），属性成员有x,y，都是double数据类型。需要为Point类编写构造函数。
//    编写直线类（Line类），需要提供两点确定一条直线的函数功能。
//	如果两点重合，可以返回异常或者返回null引用来解决这个问题。
//	直线类的数据成员和函数成员请自行设计。

package a2;

public class Line {
	public Point p1, p2;

	public Line() {
		super();
	}

	public Line(Point p1, Point p2) {
		super();
		this.p1 = p1;
		this.p2 = p2;
	}

	public void getLine(Point p1, Point p2) {
		if((p1.x == p2.x) && (p1.y == p2.y)){
			 throw new IllegalArgumentException("两点不能重合");
		}
//		(y-y1)/(y2-y1)=(x-x1)/(x2-x1)
		if(p2.x == p1.x){
			System.out.println("y = " + String.valueOf(p1.x));
			return;
		}
		double k = (p2.y - p1.y) / (p2.x - p1.x);
		double b = p1.y - k * p1.x;
		String out = "y = " + String.valueOf(k) + "x + " + String.valueOf(b);
		System.out.println(out);
	}
	
	public static void main(String[] args) {
		Point p1 = new Point(0, 1);
		Point p2 = new Point(1, 0);
		Line l = new Line();
		l.getLine(p1, p2);
	}
}
