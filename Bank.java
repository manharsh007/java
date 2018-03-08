package com.nt.Naresh_blogic;
import com.nt.Exception_Nareshit.*;

interface Bank{
void deposit(double amount) throws InvalidAmountException;
double withdraw(double amount) throws InvalidAmountException,InvalidSufficientException;
void balanceEnquiry();

}