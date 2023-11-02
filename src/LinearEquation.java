public class LinearEquation {
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    public LinearEquation() {
        this.x1 = 0;
        this.x2 = 0;
        this.y1 = 0;
        this.y2 = 0;
    }
    public void setCoords(int newX1, int newY1, int newX2, int newY2) {
        x1 = newX1;
        y1 = newY1;
        x2 = newX2;
        y2 = newY2;
    }
    private double format(double num) {
        num = Math.round(num * 100) / 100.0;;
        return num;
    }




    public double distance() {
        return format(Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1),2)));
    }
    public String slopeFraction(){
        if ((y2-y1) % (x2 -x1) == 0) {
            return slopeDecimal() + "";
        } else {
            if (Integer.signum(y2 - y1) == -1 && Integer.signum(x2 - x1) == -1) {
                return (y2 - y1) / -1 + "/" + (x2 - x1) / -1;
            } else if (Integer.signum(x2 - x1) == -1) {
                return (y2 - y1) * -1 + "/" + (x2 - x1) / -1;
            } else {
                return (y2 - y1) + "/" + (x2 - x1);
            }
        }
    }
    public double slopeDecimal() {
        return format((y2 - y1) / (double)(x2 - x1));
    }
    public double yIntercept() {
        double intercept = y2 - slopeDecimal() * x2;
        return format(intercept);
    }
    public String equation() {
        if (slopeDecimal() == 0) {
            return "y = " + yIntercept();
        }
        if (yIntercept() == 0) {
            if(slopeDecimal() == 0) {
                return "y = 0";
            } else if (slopeDecimal() == 1) {
                    return "y = x ";
            } else if (slopeDecimal() == -1) {
                return "y = -x ";
            } else {
                return "y = " + slopeFraction() + "x";
            }
        } else if (slopeDecimal() == 1) {
            if (Integer.signum((int)yIntercept()) == -1) {
                return "y = x " + yIntercept();
            } else {
                return "y = x + " + yIntercept();
            }
        } else if (slopeDecimal() == -1) {
            if (Integer.signum((int)yIntercept()) == -1) {
                return "y = -x " + yIntercept();
            } else {
                return "y = -x + " + yIntercept();
            }
        } else if ((y2-y1) % (x2-x1) != 0){
            if (Integer.signum((int)yIntercept()) == -1) {
                return "y = " + slopeFraction() + "x " + yIntercept();
            } else {
                return "y = " + slopeFraction() + "x + " + yIntercept();
            }
        } else {
            if (Integer.signum((int)yIntercept()) == -1) {
                return "y = " + slopeDecimal() + "x " + yIntercept();
            } else {
                return "y = " + slopeDecimal() + "x + " + yIntercept();
            }
        }
    }
    public String coordinateForX(double x) {
        if (x1 == x2) {
            return "";
        } else if(y1 == y2) {
            return "";
        } else {
            return "(" + x + ", " + (slopeDecimal() * x + yIntercept()) + ")";
        }
    }
    public String lineInfo() {
        if (x1 == x2) {
            return "These points are on a vertical line: x = " + x1;
        } else  {
            return "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")" +
                    "\nThe equation of the line between these points is: " + equation() +
                    "\nThe slope of this line is: " + slopeDecimal() +
                    "\nThe y-intercept of this line is: " + yIntercept() +
                    "\nThe distance between these points is: " + distance();
        }
    }
}
