package shapes;

public class Triangle implements Shape{
//ak implementujem ApplicationContextAware tak si mozem ulozit context ako premennu pri vytvoreni noveho objektu sa automaticky zavola setter
    //dalsi je BeanNameAware ktory zavola setter mena beanu (string)
    private Point pointA;
    private Point pointB;
    private Point pointC;

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    public void draw(){
        System.out.println("Point A = "+ pointA.getX() + ", "+pointA.getY());
        System.out.println("Point B = "+ pointB.getX() + ", "+pointB.getY());
        System.out.println("Point C = "+ pointC.getX() + ", "+pointC.getY());

    }


//
//    private List<Point> points;
//
//    public List<Point> getPoints() {
//        return points;
//    }
//
//    public void setPoints(List<Point> points) {
//        this.points = points;
//    }
//
//    public void draw(){
//        for(Point point: points){
//            System.out.println("Point = "+ point.getX() + ", "+point.getY());
//        }}
}
