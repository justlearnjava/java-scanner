/*
 *    Copyright 2020 Just Learn Java
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.example.scanner;

import java.util.Scanner;

public class AreaCalculatorScanner {

  // Declare a logger to use for error message(s)
  private static final System.Logger logger = System.getLogger(AreaCalculatorScanner.class.getName());

  public static void main(final String[] args) {
    // Create the scanner to read from the keyboard
    Scanner scanner = new Scanner(System.in);

    // Use Sytem.out.println() to ask the user for their choice
    System.out.println("Shapes");
    System.out.println("\t1: Circle");
    System.out.println("\t2: Square");
    System.out.println("Please enter your choice: ");

    // If hasNextInt() then proceed, else log an error
    if (scanner.hasNextInt()) {
      // Get the user's choice of shape
      int shapeNumber = scanner.nextInt();
      if (shapeNumber == 1) {
        // If shapeNumber is 1, then ask for the radius, compute and print out the area
        System.out.println("You chose Circle. Please enter radius: ");
        if (scanner.hasNextDouble()) {
          double radius = scanner.nextDouble();
          double area = Math.PI * radius * radius; // A = pi * radius^2
          System.out.println("The area of a circle of radius " + radius + " is: " + area);
        } else {
          logger.log(System.Logger.Level.ERROR,"Error: expected double as next value but got '" + scanner.next() + "'");
          System.exit(1);
        }
      } else if (shapeNumber == 2) {
        // If shapeNumber is 2, then ask for the side length, compute and print out the area
        System.out.println("You chose Square. Please enter side length: ");
        if (scanner.hasNextDouble()) {
          double sideLength = scanner.nextDouble();
          double area = sideLength * sideLength; // A = s^2
          System.out.println("The area of a square whose sides are of length " + sideLength + " is: " + area);
        } else {
          logger.log(System.Logger.Level.ERROR,"Error: expected double as next value but got '" + scanner.next() + "'");
          System.exit(1);
        }
      } else {
        // If not 1 or 2, display an error and exit.
        System.out.println("Not a valid choice: " + shapeNumber + ". Program terminated.");
        System.exit(1);
      }
    } else {
      logger.log(System.Logger.Level.ERROR,"Error: expected int as next value but got '" + scanner.next() + "'");
      System.exit(1);
    }
  }
}
