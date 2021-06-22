#first line of input is verticies a,b,c
#2nd line is start and end you want to find. a,c
#Following lines are two verticies and weight a,b,3
import sys

with open(sys.argv[1]) as f:
   # do something with the file
   input = f.read()
   input = input.replace(' ', '')

inarray = input.split("\n")

vertices = inarray[0] #The first row = verticies
goal = inarray[1] #@nd row is the start and end of what we want to find.
routes = inarray[2:] #All of the routes
graph = {}
distances = {}
previous = {}
for i in vertices.split(","):
    graph[i] = {}
    previous[i] = ''
    distances[i] = 999999999
for i in routes:
    current = i.split(',')
    if len(current) == 3:
        graph[current[0]][current[1]] = int(current[2])
        graph[current[1]][current[0]] = int(current[2])
#The above two for loops set up the distances and previous and routes.
distances[goal[0]] = 0
current = goal[0]
#print(graph[current])

while len(graph) != 0:
    for route in graph[current]:
        if not route in graph:
            current = current #Do nothing because that route has already been found.
        elif distances[route] > (distances[current] + graph[current][route]): #If that route already has a distance then
            previous[route] = current
            distances[route] = distances[current] + graph[current][route] #Checks if the new distance is lower and sets
    graph.pop(current) #Removes the vertex from the graph.
    for x in vertices.split(','): #This for loop gets the first candidate for the next vertex check
        if x in graph:
            current = x
            break
    for i in vertices.split(','): #This for loop finds the BEST candidate for the next vertex. (Lowest current value).
        if (i in graph) and distances[i] < distances[current]:
            current = i

#The following creates the route ('way') BACKWARDS.
current = goal[2]
way = str(current)
while (current != goal[0]):
    way = way + " ," + previous[current]
    current = previous[current]

#Display
print(distances[goal[2]])
print(way[::-1])
