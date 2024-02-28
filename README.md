This is my solution to the given task.
Although the task was about distances between points, since every point can be seen as a vector,
I decided to handle them on that way, so I made a vector class.

Fields:
The class has one field, a list of real numbers, the coordinates of the vector.

Methods:
1) I've implemented the two basic operators of vector spaces: vector addition and multiplication by a scalar.
2) Also implemented lenght and a distance function.
3) As the main method, I implemented a function which gets a list of vectors as a parameter and return with another list of them
with two elements. These two elements have the minimal distance in the original list.

Comments: 
1) In that case where the minimal distance is not between just two vectors of the list
(for example if the points make an equilateral triangle), it still returns back with only two vectors.
2) I've also made FileHandler class. The main reason was that I wanted to keep the main function "clean".
3) And I've also created a test file with some tests, one test for each method from the vector class.
