# OVERVIEW
Kaprekar constant, or 6174, is a constant that arises when we take a 4-digit integer, form the largest and smallest numbers from its digits, and then subtract these two numbers. Continuing with this process of forming and subtracting, we will always arrive at the number 6174.

Take a 4-digit number like 3215. Rearranging to form the largest and smallest with these digits, we get 5321 and1235. Now, subtract them: 5321-1235 = 4086. Continue with the process of rearranging and subtracting:
```    
    8640−0468 = 8172
    8721−1278 = 7443
    7443−3447 = 3996
    9963−3699 = 6264
    6642−2466 = 4176
    7641−1467 = 6174
```
We stop here since we will only get into a loop and keep getting 6174.

Also, if we divide 6174 with the sum of its digits,
$$\frac{6174} {6 + 1 + 7 + 4} = 343$$

This process fails for numbers made of 4 repeating integers (e.g. 7777). 
The most number of steps possible is 7 (e.g. 6432). 
This is also possible for three-digit numbers (giving 495), and for 5 digit numbers we find repeating patterns instead of a single convergent integer value.


# IMPLEMENTED
- Check for 4 repeating integers
- 0-padding for subtractions resulting in fewer than 4 digits (i.e. `5000 -> 5000 - 5 = 0995`)

# NOT YET IMPLEMENTED
- Support for 3-digit numbers
- Support for 5-digit numbers