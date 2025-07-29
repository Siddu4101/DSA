package org.example.dsa.questions;

public class StarPattern {
    public static void main(String[] args) {
        squarePattern(5);
        System.out.println();
        increasingTriangleLeftAlignedPattern(5);
        System.out.println();
        decreasingTriangleLeftAlignedPattern(5);
        System.out.println();
        increasingTriangleRightAlignedPattern(5);
        System.out.println();
        decreasingTriangleRightAlignedPattern(5);
        System.out.println();
        centerTriangleIncreasing(5);
        System.out.println();
        centerTriangleDecreasing(5);
        System.out.println();
        createDiamondPattern(5);

    }
    /*

    square pattern
    * * * * *
    * * * * *
    * * * * *
    * * * * *
    * * * * *

    * */


    static void squarePattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

   /*

    increasing triangle left pattern
    *
    * *
    * * *
    * * * *
    * * * * *

     */

    static void increasingTriangleLeftAlignedPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

     /*

    decreasing triangle left pattern
      * * * * *
      * * * *
      * * *
      * *
      *

     */

    static void decreasingTriangleLeftAlignedPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n; j >= i; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    /*

    increasing triangle right pattern
            *
          * *
        * * *
      * * * *
    * * * * *

     */

    static void increasingTriangleRightAlignedPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n; j >= i; j--) {
                System.out.print("  ");/*2 space needed as we are printing the 2 characters int he second loop*/
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

 /*

    increasing triangle right pattern
         * * * * *
           * * * *
             * * *
               * *
                 *

     */

    static void decreasingTriangleRightAlignedPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("  ");/*2 space needed as we are printing the 2 characters int he second loop*/
            }
            for (int k = n; k >= i; k--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }


   /*

   center triangle
        *
       * *
      * * *
     * * * *
    * * * * *

   * */

    static void centerTriangleIncreasing(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n; j >= i; j--) {
                System.out.print(" ");/*only one space as we are printing center triangle */
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

     /*

   center triangle
     * * * * *
      * * * *
       * * *
        * *
         *

   * */

    static void centerTriangleDecreasing(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" "); /*only one space as we are printing center triangle */
            }
            for (int k = n; k >= i; k--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    /*

    diamond

        *
       * *
      * * *
     * * * *
    * * * * *
     * * * *
      * * *
       * *
        *
    * */

    static void createDiamondPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n; j >= i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 1; i <= n - 1; i++) { //run the second/bottom triangle one less row (as it is already printed in above one)
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int k = n - 1; k >= i; k--) {
                System.out.print(" *"); /*and print the space first here as it needs to align a 1 less row*/
            }
            System.out.println();
        }
    }
}
