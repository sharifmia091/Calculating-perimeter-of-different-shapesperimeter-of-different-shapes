import edu.duke.*;
import java.io.File;

public class test {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int numPoints=0;
        for (Point currPt: s.getPoints()){
            numPoints+=1;
        }

        return numPoints;
    }
    
    public double getAverageLength(Shape s){
        double avgLength=0;
        avgLength = getPerimeter(s)/getNumPoints(s);
        return avgLength;
    }
    
    public double getLargestSide(Shape s){
        double largest =0;
        Point prevPt = s.getLastPoint();
        for (Point currPt: s.getPoints()){
            double currDist=prevPt.distance(currPt);
            if (currDist> largest){
                largest=currDist;
                prevPt=currPt;
            }
        }
        return largest;
    }
    
    public double getLargestX(Shape s){
        double largestX=0.0;
  
        for (Point currPt: s.getPoints()){
            double currPtX = currPt.getX();
            if (currPtX> largestX){
                largestX=currPtX;
   
            }
        }
        return largestX;
        
    }
    
    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr= new DirectoryResource();
        double largestPerim =0;
        FileResource largestFile = null;
        for (File f: dr.selectedFiles()){
            FileResource file = new FileResource(f); 
            Shape shape = new Shape(file);
            double perim = getPerimeter(shape);
            if (perim> largestPerim ){
                largestPerim=perim;
            }
        }
        return largestPerim;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        DirectoryResource dr= new DirectoryResource();
        double largestPerim =0.0;
        File largestFile = null;
        
        
        for (File f: dr.selectedFiles()){
            FileResource file = new FileResource(f); 
            Shape shape = new Shape(file);
            double perim = getPerimeter(shape);
            if (perim> largestPerim ){
                largestPerim=perim;
                largestFile= f;
            }
            
        }

        return largestFile.getName();
    }
 

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int point = getNumPoints(s);
        double avgLength=getAverageLength(s);
        double largestSide=getLargestSide(s);
        double largestX=getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("numPoints = " + point);
        System.out.println("avgLength = " + avgLength);
        System.out.println("largestSide = " + largestSide);
        System.out.println("largestX = " + largestX);
    }
    
      public void testPerimeterMultipleFiles() {
        // Put code here
        double largest = getLargestPerimeterMultipleFiles();
        System.out.println(" Largest perimeter is " + largest);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String largestFile = getFileWithLargestPerimeter();
        System.out.println("Largest perimeter file is " + largestFile );
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    
  
    public static void main (String[] args) {
        test pr = new test();
        pr.testPerimeter();
    }
}
