import math

def calculate_polar():
    x = float(input("X :"))
    y = float(input("Y :"))
    
    length = math.sqrt(x*x+y*y)
    radian = math.atan(y/x)
    degrees = math.degrees(radian)
    
    print("r = {}".format(length))
    print("theta = {}".format(radian))
    print("degrees = {}".format(degrees))
