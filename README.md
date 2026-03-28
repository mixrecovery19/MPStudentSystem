Example of Bachelor Of I.T. OOP Study
Bachelor of Information Technology
BIT235 Object Oriented Programming, 2026 Semester 1 Page 1 of 23
Object oriented programming -
From procedural thinking to object
thinking
Contents
Learning goals ................................................................................................................................................... 2
Why we need object-oriented programming.............................................................................................. 2
From variables to objects................................................................................................................................ 2
What is a class and an object.................................................................................................................... 2
Another example........................................................................................................................................... 3
Exercise 1....................................................................................................................................................... 3
Adding behaviour with methods ................................................................................................................... 4
Calling the method....................................................................................................................................... 4
Constructors ....................................................................................................................................................... 4
Exercise 2...................................................................................................................................................... 4
Overloading ........................................................................................................................................................ 6
Constructor overloading ............................................................................................................................. 6
Method overloading..................................................................................................................................... 6
Exercise 3...................................................................................................................................................... 7
Encapsulation ..................................................................................................................................................... 8
Exercise 4...................................................................................................................................................... 9
Getters and Setters ...................................................................................................................................... 9
this. .....................................................................................................................................................................10
Exercise 5....................................................................................................................................................11
Inheritance.........................................................................................................................................................11
Exercise 6....................................................................................................................................................11
Method overriding ..........................................................................................................................................13
@Override....................................................................................................................................................14
Exercise 7....................................................................................................................................................14
Subclass – another example. ...................................................................................................................15
Intermediate classes - review...................................................................................................................15
Polymorphism...................................................................................................................................................16
Exercise 8....................................................................................................................................................18
Polymorphism – common implementations .........................................................................................18
Diversion – static vs non-static ...............................................................................................................20
Exercise 9. ............................................................................................................................................22
Separate files for each class .........................................................................................................................22
Summary of key ideas ....................................................................................................................................23
Conclusion.........................................................................................................................................................23
Bachelor of Information Technology
BIT235 Object Oriented Programming, 2026 Semester 1 Page 2 of 23
Learning goals
By the end of this paper, students should be able to
• Explain why object-oriented programming is used
• Create classes and objects in java
• Use constructors to initialise objects
• Apply constructor and method overloading
• Apply inheritance and method overriding
• Describe polymorphism using simple examples
Why we need object-oriented programming
So far, programs have used variables, if statements, and loops. This works for small tasks.
As programs grow, code becomes harder to manage, data becomes scattered, and reuse
becomes difficult. Object-oriented programming solves this by grouping related data and
behaviour together into objects. This makes programs easier to organise, reuse, and maintain.
To understand this, compare two situations.
• In a school system, a student has a name and age.
• In a zoo system, an animal has a species and age. In both cases, we are modelling realworld things. Object-oriented programming allows us to represent these clearly.
From variables to objects
In procedural programming, we store related data in separate variables.
Example (zoo idea using variables)
public class MainApp {
public static void main(String[] args) {
String species = "Dog";
int age = 5;
}
}
In object-oriented programming, we group this into a class.
What is a class and an object
A class is a blueprint. An object is a real instance created from that blueprint.
Bachelor of Information Technology
BIT235 Object Oriented Programming, 2026 Semester 1 Page 3 of 23
Example (zoo model)
public class MainApp {
public static void main(String[] args) {
Animal a1 = new Animal();
a1.species = "Dog";
a1.age = 5;
System.out.println(a1.species + " is " + a1.age + " years old");
}
}
class Animal {
 String species;
 int age;
}
Another example
In a school example, we would create a Student class instead. The idea is identical. Only the
context changes.
public class MainApp {
public static void main(String[] args) {
Student newbie = new Student();
newbie.id = 1234599;
newbie.givenName = "Mary";
newbie.familyName = "Smith";
newbie.phone = 404115113;
System.out.println("Student ID: " + newbie.id);
System.out.println("Name: " + newbie.givenName + " " +
newbie.familyName);
System.out.println("Phone: " + newbie.phone);
}
}
class Student {
int id;
String givenName;
String familyName;
int phone;
}
Exercise 1.
Your tasks:
• Create a class called Animal
• Add fields species and ages
• In main(), create one Animal object
• Set species to "Cat", age to 2.
• Print the values using System.out.println
Bachelor of Information Technology
BIT235 Object Oriented Programming, 2026 Semester 1 Page 4 of 23
Adding behaviour with methods
Objects can perform actions using methods. Example:
class Animal {
String species;
int age;
void makeSound() {
System.out.println("Animal noise!");
}
}
Calling the method
Animal a1 = new Animal();
a1.species = "Dog";
a1.age = 5;
a1.makeSound();
In a student example, the method might be displayDetails().
Constructors
A constructor is a special method used to initialise an object. Key characteristics:
• It has the same name as its class
• It does not have a return type (not even void).
• It can have parameters
Example
class Animal {
String species;
int age;

 Animal(String species, int age) {
 this.species = species;
 this.age = age;
 }
void makeSound() {
System.out.println("Animal noise!");
}
}
public static void main(String[] args) {
Animal a1 = new Animal("Dog", 5);
a1.makeSound();
}
Exercise 2.
Bachelor of Information Technology
BIT235 Object Oriented Programming, 2026 Semester 1 Page 5 of 23
Start a new project called “MP Student System” and
• Create 2 files within – MainDriver.java and Students.java.
• Paste into each file the code from above in the “Another example”
section.
• Add a constructor to the class
• The constructor should set the instance variables thus:
o id to 1111111
o givenName to "”
o familyName to "”
o phone to 0
• Create 2 Student objects:
• For the 2nd object, set the id, givenName, familyName and phone to your
own details.
• Use .toString() to display the values in the object’s instance variables e.g.,
s.toString();
Bachelor of Information Technology
BIT235 Object Oriented Programming, 2026 Semester 1 Page 6 of 23
Overloading
Constructor overloading
A class can have multiple constructors with different parameter lists.
Example
class Animal {
String species;
int age;
Animal() {
species = "Unknown";
age = 0;
}
Animal(String species) {
this.species = species;
this.age = 0;
}
Animal(String species, int age) {
this.species = species;
this.age = age;
}
void makeSound() {
System.out.println(species + " makes a sound");
}
}
What happens when using new
public static void main(String[] args) {
Animal a1 = new Animal();
Animal a2 = new Animal("Dog");
Animal a3 = new Animal("Rabbit", 3);
System.out.println("Animal 1: " + a1.species + ", Age: " + a1.age);
System.out.println("Animal 2: " + a2.species + ", Age: " + a2.age);
System.out.println("Animal 3: " + a3.species + ", Age: " + a3.age);
a1.makeSound();
a2.makeSound();
a3.makeSound();
Key idea: Different constructors allow flexible ways to create objects.
Method overloading
We shouldn’t really call a Constructor a “method”. It is a special type of method.
We can overload not only Constructors, but any method. Method overloading allows multiple
methods with the same name, as long as their parameter lists are different.
Bachelor of Information Technology
BIT235 Object Oriented Programming, 2026 Semester 1 Page 7 of 23
Example. In class Animal {
void feed() {
System.out.println("Feeding animal");
}
void feed(String food) {
System.out.println("Feeding animal with " + food);
}
void feed(String food, int amount) {
System.out.println("Feeding " + amount + " units of " + food);
}
When a method is called, the Java compiler looks at:
• the number of arguments
• the type of arguments
• the order of arguments
public static void main(String[] args) {
Animal a = new Animal();
a.feed();
a.feed("grass");
a.feed("meat", 3);
}
What happens for each call:
• a.feed(); Java finds a method with no parameters → calls feed()
• a.feed("grass"); Java sees one String argument → calls feed(String food)
• a.feed("meat", 3); Java sees String and int → calls feed(String food, int
amount)
Exercise 3.
Continuing with the called “MP Student System”
• Add a second constructor that accepts 2 ints and 2 Strings and
initialises the object’s instance variables with those values.
• Create a 3rd object that uses that 2nd constructor (the objects you
created in Exercise 2 should continue to use the constructor with no
parameters).
• Display the id and familyName of all 3 objects.
Bachelor of Information Technology
BIT235 Object Oriented Programming, 2026 Semester 1 Page 8 of 23
Encapsulation
Encapsulation protects data by making fields private and controlling access. Example:
class Animal {
String species;
private int age;
public int getAge() {
return age;
}
public void setAge(int age) {
if (age >= 0) {
this.age = age;
}
}
Explanation. age has been set private. This means it cannot be accessed directly from outside
its class:
public static void main(String[] args) {
Animal a = new Animal();
a.species = "Dog"; \\ species is still package-private (default)
a.age=5 ; \\This is an error. age is private
We now can only access age through Animal’s public methods
public static void main(String[] args) {
Animal a = new Animal();
a.species = "Dog";
a.setAge(5);
System.out.println(a.getAge());
}
Why this is good:
1. Prevents invalid data. If age was public, someone could write this which would be
invalid data:
a.age = -10;
With private, we can stop this by writing validation code in our method.
public void setAge(int age) {
if (age >= 0 && age <= 250) {
this.age = age;
}
}
2. Controls how data is used. All changes to the data must go through methods. This
allows you to control what happens when values are set or retrieved.
Bachelor of Information Technology
BIT235 Object Oriented Programming, 2026 Semester 1 Page 9 of 23
3. Protects internal structure. Other code cannot directly access or change the internal
variables. This reduces bugs and makes the class safer to use.
4. Improves maintainability. You can change how the data is stored internally without
breaking other code. For example, you could later store age differently, and only update
the getter/setter methods.
5. Supports teamwork and predictability. Other programmers only need to understand
the public methods, not the internal details. This makes the code easier to use and
more consistent across a team.
This is a good example of how OOP helps you write better code. It supports code that is easier
to debug, extend, read, and reuse.
While encapsulation can be achieved in procedural programming, OOP makes it much easier by
naturally guiding you to organise data and behaviour together and control access to that data.
Exercise 4.
Getters and Setters
In the previous section, we used private to protect a single field (age). In practice, we should
treat all instance variables this way.
That means:
• make fields private
• provide controlled access using methods
By convention, these methods are called getters and setters.
Naming convention
• getter: getFieldName()
• setter: setFieldName()
Continuing with the “MP Student System”
• Give the id a private modifier (private int id);
• Create a getId() and setId() method. setId() should be a void method
that accepts and int. getId() should be an int method that has no
parameters.
• Correct the code in MainApp so that it no longer gives you compile
time errors.
• Display the Id of all 3 objects.
Bachelor of Information Technology
BIT235 Object Oriented Programming, 2026 Semester 1 Page 10 of 23
Example:
class Animal {
private String species;
private int age;
public String getSpecies() {
return species;
}
public void setSpecies(String s) {
species = s;
}
public int getAge() {
return age;
}
public void setAge(int a) {
if (a >= 0) {
age = a;
}
}
Why this is the standard approach
• Consistency: All fields are accessed in the same way, making code easier to understand.
• Control: You can validate or restrict values before storing them.
• Flexibility: You can change how the data is stored internally without affecting other
code.
Key idea: Instance variables should generally be private, and accessed through getter and
setter methods to maintain control, consistency, and flexibility in your program
this.
Using this helps make your code clearer. It’s used to explicitly refer to the object’s instance
variable.
For example, the first example here is preferred:
public int getAge() {
return this.age; //better
}
public int getAge() {
return age; //ok, but less clear
}
Note: Both versions are correct. Using this is a style choice that improves readability, especially
in larger classes.
The use of this becomes more important when method parameters have the same name as
instance variables.
public void setAge(int age) {
if (age >= 0) {
this.age = age;
}
}
Bachelor of Information Technology
BIT235 Object Oriented Programming, 2026 Semester 1 Page 11 of 23
It is better to give the instance variable and the parameter variable the same name because
• It makes it clear to you and your programming team that the purpose of the parameter is to
affect the Animals "age" field, not just working with an Animal class’s local variable.
• The purpose of the method is clearer.
• Other programmers (and you) can immediately understand the purpose of the method.
• Code hints and auto-complete in IDEs are clearer because a more meaningful name like age
is provided instead of something vague like a:
Exercise 5.
Inheritance
Inheritance allows one class to reuse another. Example
class Animal {
void eat() {
System.out.println("Animal eats");
}
}
class Dog extends Animal {
}
class Rabbit extends Animal {
}
This means Dog is an Animal, Rabbit is an Animal.
public static void main(String[] args) {
Animal a1 = new Dog();
Animal a2 = new Rabbit();
a1.eat();
a2.eat();
}
Exercise 6.
Continuing with the “MP Student System”
• Apply the Encapsulation principle to all instance variables. That is:
o Set all fields private
o Create getters and setters for each
• Ensure that only valid ids and phone numbers are entered
o An id must start with 1 and be followed by 6 numbers
o A phone number must allow for Australian mobile numbers
(ignoring spaces) e.g. 0444 114 111
• Use the “.this” keyword where suitable
Bachelor of Information Technology
BIT235 Object Oriented Programming, 2026 Semester 1 Page 12 of 23
Continuing with the “MP Student System”, we need to manage
international and domestic students”
• Create 2 new classes – DomesticStudent and
InternationalStudent – and that both extend Student.
• You can place the code within the Student.java file or create 2
new files named DomesticStudent and InternationalStudent
• Give each class 1 instance variable
o state for DomesticStudent. It should hold Strings, like
VIC, NSW.
o country for International Students
• Create one InternationalStudent and one DomesticStudent
object in main()
• Display all details for all objects using toString()
Bachelor of Information Technology
BIT235 Object Oriented Programming, 2026 Semester 1 Page 13 of 23
Method overriding
We can model behaviour more clearly using diet categories. In this example the children
(Herbivore, Carnivore, and Omnivore) have methods that match name (and parameter) list as
that of the parent (Animal). The child method is used be default – that is, the inheriting object’s
method overrides the inherited method’s.
Example:
class Animal {
void eat() {
System.out.println("Animal eats");
}
}
class Herbivore extends Animal {
void eat() {
System.out.println("Eats plants");
}
}
class Carnivore extends Animal {
void eat() {
System.out.println("Eats meat");
}
}
class Omnivore extends Animal {
void eat() {
System.out.println("Eats both plants and meat");
}
}
class Dog extends Omnivore {
}
class Rabbit extends Herbivore {
}
How to use them
public static void main(String[] args) {
// Basic inheritance (no overriding yet)
Animal a1 = new Dog();
Animal a2 = new Rabbit();
a1.eat(); // Animal eats
a2.eat(); // Animal eats
// Using diet-based subclasses (overriding)
Animal h = new Herbivore();
Animal c = new Carnivore();
Animal o = new Omnivore();
h.eat(); // Eats plants
c.eat(); // Eats meat
o.eat(); // Eats both plants and meat
}
Bachelor of Information Technology
BIT235 Object Oriented Programming, 2026 Semester 1 Page 14 of 23
@Override
This is an improvement on the above code:
class Carnivore extends Animal {
@Override
void eat() {
System.out.println("Eats meat");
}
}
The @ symbol is used for annotations. It’s useful here for 2 reasons:
• It makes it clear to the programmer that the method is intended to override a method
from the parent class.
• It helps the compiler detect errors. If the method name is misspelled or the parameter
list does not match the parent class method, the compiler will generate an error.:
It is recommended that you use @Override even though it isn’t a requirement. Without
@Override, the code may still compile, but the method might not actually override anything,
which can lead to subtle bugs.
Exercise 7.
Continuing with the “MP Student System”
• Add a method in Student called calculateFees()
• In Student, make it return a default value (e.g. 1000)
• Override this method in:
o InternationalStudent (return a higher fee, e.g. 5000)
o DomesticStudent (return a lower fee, e.g. 1500)
• Call calculateFees() for each object and print the result
Bachelor of Information Technology
BIT235 Object Oriented Programming, 2026 Semester 1 Page 15 of 23
Subclass – another example.
A subclass can change the behaviour of a superclass, when the superclass method is
overridden:
class Animal {
void makeSound() {
System.out.println("Some sound");
}
}
class Herbivore extends Animal {
}
class Carnivore extends Animal {
}
class Omnivore extends Animal {
}
class Dog extends Omnivore {
@Override
void makeSound() {
System.out.println("Bark");
}
}
class Cat extends Carnivore {
@Override
void makeSound() {
System.out.println("Meow");
}
}
class Rabbit extends Herbivore {
@Override
void makeSound() {
System.out.println("Soft squeak");
}
}
public static void main(String[] args) {
Dog a1 = new Dog();
Rabbit a2 = new Rabbit();
a1.makeSound(); // Which noise?
a2.makeSound(); // Which noise?
}
Intermediate classes - review
In the above code, a Dog is an Omnivore which is an Animal.
Why 3 levels – intermediate classes?
We use classes such as Herbivore and Carnivore (or Omnivore) to make our code more reusable
and easier to maintain.
Bachelor of Information Technology
BIT235 Object Oriented Programming, 2026 Semester 1 Page 16 of 23
Earlier, we defined these classes and overrode the Animal class eat() method so that each
type has its own behaviour. For example, a Herbivore eats plants and a Carnivore eats meat.
This avoids repeating the same code in multiple animal classes.
Using these intermediate classes improves our design because:
• A Dog class can inherit behaviour from Carnivore, instead of needing its own eat()
method
• Common behaviour is written once and reused across multiple classes
• The class structure better reflects real-world relationships (for example, a dog is a
carnivore, not just an animal)
Key idea: Overriding keeps the same method name but changes behaviour depending on the
class.
Both of these instantiations would be valid in the above code and produce the same result, but
they are different – the first can give you more flexibility.
Polymorphism
Three are 3 ways to create a Dog object
Dog a1 = new Dog();
Omnivore a1 = new Dog();
Animal a1 = new Dog();
Which way is best?
It depends on what you need. Each option has trade-offs.
• Dog a1 = new Dog()
o The good: It allows you to use methods that are in the Dog class even if they
aren’t in the Omnivore or Animal class.
o The limitation: It is very specific. The variable can only refer to Dog objects. See
below for discussion – how it’s missing out on Polymorphism option.
• Animal a1 = new Dog()
o The good: It’s the most flexible in terms of Polymorphism (see below)
o The limitation: The a1 object can’t access methods that are unique to the Dog
and Omnivore class. It is restricted to only accessing Animal behaviours.
• Omnivore a1 = new Dog()
o The good and bad: it’s somewhat specific, somewhat flexible.
o The good and bad: It allows you to use methods that are in the Omnivore and
Animal classes. That is, the a1 object can’t access Dog specific behaviours.
This structure is not very common, but it’s good to use as a way to demonstrate polymorphism.
We’ll show some more commonplace examples after. This code creates an Array of Animal
objects. The first animal element, for example, holds a dog object (and you’ll recall that a Dog
is a type of Animal because it extends Animal)
Animal[] animals = { new Dog(), new Cat(), new Rabbit() };
Bachelor of Information Technology
BIT235 Object Oriented Programming, 2026 Semester 1 Page 17 of 23
Let’s see how polymorphism flexibility can be realised:
public static void main(String[] args) {
Animal[] animals = { new Dog(), new Cat(), new Rabbit() };
for (Animal a : animals) {
a.makeSound();
}
}
class Animal {
void makeSound() {
System.out.println("A noise");
}
}
class Herbivore extends Animal {
@Override
void makeSound() {
System.out.println("Munching");
}
}
class Carnivore extends Animal {
@Override
void makeSound() {
System.out.println("Roar");
}
}
class Omnivore extends Animal {
@Override
void makeSound() {
System.out.println("Grunt");
}
}
class Dog extends Omnivore {
}
class Rabbit extends Herbivore {
@Override
void makeSound() {
System.out.println("Soft squeak");
}
}
class Cat extends Carnivore {
@Override
void makeSound() {
System.out.println("Meow");
}
 String emotion() {
return "Purr";
}
}
What this technique gives us.
More restricted/limited method access. Each
object is the very general Animal, not Dog, Cat,
Rabbit, nor even Omnivore, Carnivore, or
Herbivore. So, each object can use only Animal
methods. You can consider this too restrictive
or nicely generalised, depending on your
purpose. The Cat object, for example, cannot
access emotion(). To say with more clarity, this
would be an error:
Animal c = new Cat();
System.out.print(c.emotion());
However, Cat, & Rabbit do access Cat and Dog
makeSound() methods. This is because Animal
has that method and the local methods
@Override it.
Dog doesn’t have a makeSound() method, but
Omnivore does, and so the dog object produces
the Omnivore’s grunt sound
That is, Cat, Rabbit, & Dog @Override the
Animal makeSound() method, so those
behaviours are called.
Polymorphism: There is flexibility here. It
wasn’t necessary to create separate variables or
code for each animal. And yet each Animal gets
its own unique behaviour. One type, many
forms. So:
• Cat calls its own makeSound()
• Rabbit calls its own makeSound()
• Dog calls Omnivore’s makeSound()
Key idea:
• The reference type (Animal) controls what
methods you can call.
• The object type (Omnivore, Cat, Rabbit)
controls which version of the method runs.
Bachelor of Information Technology
BIT235 Object Oriented Programming, 2026 Semester 1 Page 18 of 23
Exercise 8.
Polymorphism – common implementations
Here are 3 more realistic, common patterns.
Continuing with the “MP Student System”
• Create a Student array that stores a mix of Student,
InternationalStudent, and DomesticStudent objects
• Loop through the array and:
o Call toString()
o Call calculateFees()
• Observe how different objects produce different results. That is you
have created “One type, many forms.”
Bachelor of Information Technology
BIT235 Object Oriented Programming, 2026 Semester 1 Page 19 of 23
Common example 1 – method parameters
Instead of writing separate methods for each type, you write one method that works for all
Animals.
public class MainApp {
public static void main(String[] args) {
ZooKeeper keeper = new ZooKeeper();
keeper.makeItSpeak(new Dog());
keeper.makeItSpeak(new Cat());
keeper.makeItSpeak(new Rabbit());
}
}
class ZooKeeper {
void makeItSpeak(Animal a) {
a.makeSound();
}
}
class Animal {
void makeSound() {
System.out.println("Some animal sound");
}
}
class Dog extends Animal {
@Override
void makeSound() {
System.out.println("Bark");
}
}
class Cat extends Animal {
@Override
void makeSound() {
System.out.println("Meow");
}
}
class Rabbit extends Animal {
@Override
void makeSound() {
System.out.println("Soft squeak");
}
}
Why this is realistic:
• You write the method once, it works for any Animal
• New animal types work automatically without changing the method
The ZooKeeper class has
one method that receives
Animal objects – any types
of Animal.
We pass in different objects
(Dog, Cat, Rabbit), but the
same method call works for
all of them.
Java decides at runtime
which makeSound() method
to run based on the actual
object.
Key idea: One method,
many object types, each
with its own behaviour.
Again, One type, many
forms. 
Bachelor of Information Technology
BIT235 Object Oriented Programming, 2026 Semester 1 Page 20 of 23
Common Example 2 – processing input
Imagine your program receives different animals from user input, a file, or a database.
public static void main(String[] args) {
Animal a;
String dataBaseRead = "cat"; // imagine this value came at
runtime from a database read
if (dataBaseRead.equals("dog")) {
a = new Dog();
} else if (dataBaseRead.equals("cat")) {
a = new Cat();
} else {
a = new Rabbit();
}
a.makeSound();
}
Why this is realistic
• The program doesn’t know the exact type at compile time
• It still works correctly. Behaviour changes automatically
• We don’t always know the exact object type, but polymorphism lets the program still
work.
• Again, “one type, many forms”.
Common example 3 – Simple zoo action
public class MainApp {
public static void main(String[] args) {
hearAnimal(new Dog());
hearAnimal(new Rabbit());
}
public static void hearAnimal(Animal a) {
a.makeSound();
}
}
Explanation:
• hearAnimal accepts any Animal
• We pass in different objects (Dog, Rabbit)
• The same method is used, but different behaviour occurs
• Again, “one type, many forms”.
Diversion – static vs non-static
• This method is placed in MainDriver because we are creating a simple project, but
normally it wouldn’t. Normally MainDriver would only:
• Start the program
• Create objects
In a larger program, we would move this method into another class, for example:
Bachelor of Information Technology
BIT235 Object Oriented Programming, 2026 Semester 1 Page 21 of 23
StudentManager
StudentService
StudentPrinter
That class would be responsible for working with Student object. You could make it
static or not. Here is how the code would look if
static
public class StudentManager {
public static void printStudentDetails(Student s) {
System.out.println(s.toString());
System.out.println("Fees: " + s.calculateFees());
}
}
public static void main(String[] args) {
Student s1 = new Student();
InternationalStudent s2 = new InternationalStudent(...);
DomesticStudent s3 = new DomesticStudent(...);
StudentManager.printStudentDetails(s1);
StudentManager.printStudentDetails(s2);
StudentManager.printStudentDetails(s3);
}
Not static
public class StudentManager {
public void printStudentDetails(Student s) {
System.out.println(s.toString());
System.out.println("Fees: " + s.calculateFees());
}
}
public static void main(String[] args) {
Student s1 = new Student();
InternationalStudent s2 = new InternationalStudent(...);
DomesticStudent s3 = new DomesticStudent(...);
StudentManager sm = new StudentManager();
sm.printStudentDetails(s1);
sm.printStudentDetails(s2);
sm.printStudentDetails(s3);
}
Discussion
So, you can see that the sm object is created just so that we have a vehicle for
accessing the non-static method. It might seem like the static approach is always
better. In small programs, it often is.
In the above code, it’s probably better to use a static method, for similar reasons to why
to folk at Oracle keep the System.out.printlin() and Math.random() methods static:
• We don’t need to store data in System, Math, or StudentManager objects. We
just want to use the class methods.
• It’s handy that we don’t have to create, for example, a System object first before
using the println method e.g. System s = new System(); s.println(“Hello world!”);
Bachelor of Information Technology
BIT235 Object Oriented Programming, 2026 Semester 1 Page 22 of 23
You might argue that just about everything you’ve written would be more easily written
as a static method, but remember, we are writing short programs. In short programs,
OOP code can indeed seem like overkill. It’s large programs where the OOP structure
comes into its own, where organisation, reuse, and structure matter.
Exercise 9.
Separate files for each class
In real-world Java programs, each class is typically placed in its own file


In a large project, classes will be in their own files, organised within packages inside a project
or workspace.
This structure improves organisation, readability, and teamwork by keeping related classes
grouped while allowing each class to be developed and maintained independently.
Continuing with the “MP Student System”
• In the MainDriver class, create the method (which will need to be
static because MainDriver is a static context):
void printStudentDetails(Student s)
• Inside the method:
o Call s.toString()
o Call s.calculateFees()
• In main(), pass to printStudentDetails:
o A Student
o An InternationalStudent
o A DomesticStudent
• Why does the correct calculateFees() method run for each object?
Bachelor of Information Technology
BIT235 Object Oriented Programming, 2026 Semester 1 Page 23 of 23
Summary of key ideas
✓ A class is a blueprint, and an object is an instance.
✓ Constructors initialise objects and can be overloaded.
✓ Methods define behaviour and can also be overloaded.
✓ Encapsulation protects data.
✓ Inheritance allows code reuse.
✓ Overriding changes behaviour.
✓ Polymorphism allows flexible code.
✓ Interfaces define required behaviour.
Conclusion
This handout shows you how to move from procedural thinking to object-oriented design. It
helps you understand how overloading, inheritance, and polymorphism work together to model
real-world systems such as a zoo or a school management system.
