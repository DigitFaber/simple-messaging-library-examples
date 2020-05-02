# Simple Messaging Library examples 

#### Examples for [Simple Messaging Library](https://github.com/DigitFaber/simple-messaging-library).

Examples are available for:
   * Plain Java projects  
   * Spring Boot projects

## Examples
###### Plain Java
To run and see how it works for plain Java example just run the `main()` method in the `ExampleApplication` class. And that's it!

###### Spring Boot
First of all you have to run Spring Boot application (directly by `main()` method from `ExampleApplication` or by Spring Boot run configuration in your IDE).
Then you can call up one of the four endpoints to see how it works:
   * [Single synchronous subscriber execution](http://localhost:8080/synchronous/) 
   * [Single asynchronous subscriber execution](http://localhost:8080/asynchronous/) 
   * [Multi synchronous subscriber executions](http://localhost:8080/synchronous/10/500) 
   * [Multi asynchronous subscriber executions](http://localhost:8080/asynchronous/10/500) 
   
The last two have two path variables each:
   * First: the number of executions of the subscriber's listener method (`10` in example above)
   * Second: "processing time" of execution of each subscriber's listener method (`500` in example above) 
   
You can play around with these values to see how much the library can handle, but remember that we all have limited resources :wink:

Enjoy!