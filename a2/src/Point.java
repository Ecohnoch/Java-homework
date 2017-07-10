//1.  编写点类（Point类），属性成员有x,y，都是double数据类型。需要为Point类编写构造函数。
//    编写直线类（Line类），需要提供两点确定一条直线的函数功能。
//	如果两点重合，可以返回异常或者返回null引用来解决这个问题。
//	直线类的数据成员和函数成员请自行设计。

package a2;

public class Point {
	public double x;
	public double y;

// constructor
	public Point(){
		super();
	}
	
	public Point(double xx, double yy){
		super();
		this.x = xx;
		this.y = yy;
	}
	
}
